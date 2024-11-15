package com.example.model;

/**
 * Класс Car представляет автомобиль и является наследником класса Product.
 * Хранит информацию о количестве автомобилей.
 */
public class Car extends Product {

    /** Количество автомобилей. */
    private int quantity;

    /**
     * Возвращает количество автомобилей.
     *
     * @return количество автомобилей.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Устанавливает количество автомобилей.
     *
     * @param quantity количество автомобилей.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Конструктор для создания экземпляра автомобиля.
     *
     * @param typeNumber тип продукта (должен быть 4 для автомобилей).
     * @param name       название автомобиля.
     * @param quantity   количество автомобилей.
     */
    public Car(int typeNumber, String name, int quantity) {
        super(typeNumber, name);
        this.typeNumber = 4;
        this.quantity = quantity;
    }

    /**
     * Возвращает строковое представление объекта автомобиля.
     *
     * @return строка, содержащая тип продукта, его название и количество.
     */
    @Override
    public String toString() {
        return "Автомобиль" + "\t" + super.toString() + "\t" + quantity + " шт.";
    }
}
