package com.example.model;

/**
 * Класс для вагона для автомобилей.
 */
public class CarWagon extends Wagon {
    /**
     * Конструктор для создания вагона для автомобилей.
     * @param capacity Грузоподъемность вагона.
     */
    public CarWagon(double capacity) {
        super("Автомобильная платформа", capacity);
    }

    /**
     * Проверяет, может ли вагон загрузить данный продукт.
     * @param product Продукт для загрузки.
     * @return true, если вагон может загрузить продукт, иначе false.
     */
    @Override
    public boolean canLoad(Product product) {
        return product instanceof Car;
    }
}