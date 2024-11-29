package com.example.model;

/**
 * Класс для вагона для сыпучих грузов.
 */
public class BulkWagon extends Wagon {
    /**
     * Конструктор для создания вагона для сыпучих грузов.
     * @param capacity Грузоподъемность вагона.
     */
    public BulkWagon(double capacity) {
        super("Цистерна для сыпучих грузов", capacity);
    }

    /**
     * Проверяет, может ли вагон загрузить данный продукт.
     * @param product Продукт для загрузки.
     * @return true, если вагон может загрузить продукт, иначе false.
     */
    @Override
    public boolean canLoad(Product product) {
        return product instanceof Bulk;
    }
}
