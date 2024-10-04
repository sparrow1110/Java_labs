package com.example.model;

/**
 * Класс для вагона для жидкостей.
 */
public class TankWagon extends Wagon {
    /**
     * Конструктор для создания вагона для жидкостей.
     *
     * @param capacity Грузоподъемность вагона.
     */
    public TankWagon(double capacity) {
        super("Цистерна для жидкостей", capacity);
    }

    /**
     * Проверяет, может ли вагон загрузить данный продукт.
     *
     * @param product Продукт для загрузки.
     * @return true, если вагон может загрузить продукт, иначе false.
     */
    @Override
    public boolean canLoad(Product product) {
        return product instanceof Liquid;
    }
}