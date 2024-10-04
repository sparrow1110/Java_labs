package com.example.model;

/**
 * Класс для вагона для контейнеров.
 */
public class ContainerWagon extends Wagon {
    /**
     * Конструктор для создания вагона для контейнеров.
     *
     * @param capacity Грузоподъемность вагона.
     */
    public ContainerWagon(double capacity) {
        super("Платформа для контейнеров", capacity);
    }

    /**
     * Проверяет, может ли вагон загрузить данный продукт.
     *
     * @param product Продукт для загрузки.
     * @return true, если вагон может загрузить продукт, иначе false.
     */
    @Override
    public boolean canLoad(Product product) {
        return product instanceof Container;
    }
}