package com.example.util;

import com.example.model.*;

import java.util.Random;

/**
 * Класс для генерации случайных продуктов.
 */
public class RandomProductGenerator {
    private static final String[] LIQUIDS = {"Нефть", "Дизель", "Мазут"};
    private static final String[] BULKS = {"Зерно", "Уголь", "Песок"};
    private static final String[] CONTAINERS = {"Контейнер"};
    private static final String[] CARS = {"Мерседес", "БМВ", "Ауди"};

    private Random random;

    /**
     * Конструктор для создания генератора случайных продуктов.
     */
    public RandomProductGenerator() {
        this.random = new Random();
    }

    /**
     * Генерирует случайный продукт.
     * @return Случайный продукт.
     */
    public Product generateRandomProduct() {
        int type = random.nextInt(4);
        switch (type) {
            case 0:
                return new Liquid(LIQUIDS[random.nextInt(LIQUIDS.length)], random.nextDouble() * 1000 + 500);
            case 1:
                return new Bulk(BULKS[random.nextInt(BULKS.length)], random.nextDouble() * 500 + 300);
            case 2:
                return new Container(CONTAINERS[random.nextInt(CONTAINERS.length)], random.nextDouble() * 2000 + 1000);
            case 3:
                return new Car(CARS[random.nextInt(CARS.length)], random.nextDouble() * 1500 + 1000);
            default:
                return null;
        }
    }
}
