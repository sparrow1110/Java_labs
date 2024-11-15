package com.example.model;

import java.util.Random;

/**
 * Класс RandomProduct генерирует случайные продукты для различных категорий:
 * жидкость, сыпучий груз, контейнер и автомобиль.
 */
public class RandomProduct {

    /** Названия жидкостей. */
    public static String[] liquidNames = {"Нефть", "Дизельное топливо", "Мазут"};

    /** Названия сыпучих грузов. */
    public static String[] bulkCargoNames = {"Зерно", "Уголь", "Песок"};

    /** Названия контейнеров. */
    public static String[] containerNames = {"Специальные контейнеры"};

    /** Названия автомобилей. */
    public static String[] carNames = {"ВАЗ-2107"};

    /**
     * Генерирует случайное число от 0 до max-1.
     *
     * @param max максимальное значение (не включая).
     * @return случайное число.
     */
    public static int randomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    /**
     * Возвращает случайное название из массива названий.
     *
     * @param names массив названий.
     * @return случайное название.
     */
    public static String randomName(String[] names) {
        int i = randomNumber(names.length);
        return names[i];
    }

    /**
     * Генерирует случайный продукт на основе типа:
     * жидкость, сыпучий груз, контейнер или автомобиль.
     *
     * @return сгенерированный продукт.
     */
    public static Product generate() {
        Product product = null;
        int maxTypeNumber = 4;
        int typeNumber = randomNumber(maxTypeNumber) + 1;
        switch (typeNumber) {
            case (1):
                Product liquid = new Liquid(typeNumber, randomName(liquidNames), (randomNumber(10) + 1) * 1000);
                product = liquid;
                break;
            case (2):
                Product bulkCargo = new Bulk(typeNumber, randomName(bulkCargoNames), (randomNumber(10) + 1) * 1000);
                product = bulkCargo;
                break;
            case (3):
                Product container = new Container(typeNumber, randomName(containerNames), (randomNumber(10) + 1));
                product = container;
                break;
            case (4):
                Product car = new Car(typeNumber, randomName(carNames), (randomNumber(10) + 1));
                product = car;
                break;
            default:
                break;
        }
        return product;
    }
}

