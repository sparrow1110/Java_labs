package com.example.model;

/**
 * Базовый класс для продукции.
 */
public abstract class Product {
    protected String name;
    protected double weight;

    /**
     * Конструктор для создания продукта.
     *
     * @param name Название продукта.
     * @param weight Вес продукта.
     */
    public Product(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Возвращает название продукта.
     *
     * @return Название продукта.
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает вес продукта.
     *
     * @return Вес продукта.
     */
    public double getWeight() {
        return weight;
    }
}
