package com.example.model;

/**
 * Базовый класс для вагонов.
 */
public abstract class Wagon {
    protected String type;
    protected double capacity;
    private boolean isLoaded;

    /**
     * Конструктор для создания вагона.
     * @param type Тип вагона.
     * @param capacity Грузоподъемность вагона.
     */
    public Wagon(String type, double capacity) {
        this.type = type;
        this.capacity = capacity;
        this.isLoaded = false;
    }

    /**
     * Возвращает тип вагона.
     * @return Тип вагона.
     */
    public String getType() {
        return type;
    }

    /**
     * Возвращает грузоподъемность вагона.
     * @return Грузоподъемность вагона.
     */
    public double getCapacity() {
        return capacity;
    }

    /**
     * Возвращает, загружен ли вагон.
     * @return true, если вагон загружен, иначе false.
     */
    public boolean isLoaded() {
        return isLoaded;
    }

    /**
     * Устанавливает флаг, указывающий, загружен ли вагон.
     * @param loaded true, если вагон загружен, иначе false.
     */
    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    /**
     * Проверяет, может ли вагон загрузить данный продукт.
     * @param product Продукт для загрузки.
     * @return true, если вагон может загрузить продукт, иначе false.
     */
    public abstract boolean canLoad(Product product);
}
