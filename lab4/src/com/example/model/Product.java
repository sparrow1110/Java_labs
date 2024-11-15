package com.example.model;


/**
 * Абстрактный класс Product представляет базовый продукт.
 * Хранит основную информацию о типе и названии продукта.
 */
public abstract class Product {

    /** Идентификатор продукта. */
    private static int idCounter = 0; // Статический счетчик для генерации уникальных ID
    private final int id; // Идентификатор продукта

    /** Название продукта. */
    private String name;

    /** Тип продукта, указывающий на категорию (например, 1 — жидкость). */
    int typeNumber;

    /**
     * Возвращает идентификатор продукта.
     *
     * @return идентификатор продукта.
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает название продукта.
     *
     * @return название продукта.
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает тип продукта.
     *
     * @return тип продукта.
     */
    public int getTypeNumber() {
        return typeNumber;
    }

    /**
     * Устанавливает название продукта.
     *
     * @param name название продукта.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Устанавливает тип продукта.
     *
     * @param typeNumber тип продукта.
     */
    public void setTypeNumber(int typeNumber) {
        this.typeNumber = typeNumber;
    }

    /**
     * Конструктор для создания объекта Product.
     *
     * @param typeNumber тип продукта.
     * @param name       название продукта.
     */
    protected Product(int typeNumber, String name) {
        this.typeNumber = typeNumber;
        this.name = name;
        this.id = ++idCounter; // Увеличиваем счетчик и присваиваем уникальный ID
    }

    /**
     * Возвращает строковое представление объекта Product.
     *
     * @return строка, содержащая название продукта.
     */
    @Override
    public String toString() {
        return name;
    }
}
