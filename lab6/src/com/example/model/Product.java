package com.example.model;

/**
 * Абстрактный класс, представляющий продукт.
 */
public abstract class Product {
    protected String name;
    protected int typeNumber;

    /**
     * Конструктор для создания объекта продукта.
     *
     * @param typeNumber номер типа продукта.
     * @param name название продукта.
     */
    public Product(int typeNumber, String name) {
        this.typeNumber = typeNumber;
        this.name = name;
    }

    /**
     * Получает название продукта.
     *
     * @return название продукта.
     */
    public String getName() {
        return name;
    }

    /**
     * Получает номер типа продукта.
     *
     * @return номер типа продукта.
     */
    public int getTypeNumber() {
        return typeNumber;
    }

    /**
     * Возвращает строковое представление продукта.
     *
     * @return строковое представление продукта.
     */
    public String toString() {
        return "Тип: " + typeNumber + ", Название: " + name;
    }

    /**
     * Абстрактный метод для получения количества продукта.
     *
     * @return количество продукта.
     */
    public abstract int getQuantity();
}
