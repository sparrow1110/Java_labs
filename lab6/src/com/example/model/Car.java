package com.example.model;

/**
 * Представляет автомобиль, который является типом продукта.
 */
public class Car extends Product {
    private int quantity;

    /**
     * Получает количество автомобилей.
     *
     * @return количество автомобилей.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Устанавливает количество автомобилей.
     */
    public void setQuantity() {
        this.quantity = quantity;
    }

    /**
     * Конструктор для создания объекта автомобиля.
     *
     * @param typeNumber номер типа автомобиля.
     * @param name название автомобиля.
     * @param quantity количество автомобилей.
     */
    public Car(int typeNumber, String name, int quantity) {
        super(typeNumber, name);
        this.typeNumber = 4;
        this.quantity = quantity;
    }

    /**
     * Возвращает строковое представление автомобиля.
     *
     * @return строковое представление автомобиля с его названием и количеством.
     */
    public String toString() {
        return "Автомобиль" + "\t" + super.toString() + "\t" + quantity + " шт.";
    }
}
