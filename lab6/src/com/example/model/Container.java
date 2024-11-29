package com.example.model;

/**
 * Представляет контейнер, который является типом продукта.
 */
public class Container extends Product {
    private int quantity;

    /**
     * Получает количество контейнеров.
     *
     * @return количество контейнеров.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Устанавливает количество контейнеров.
     */
    public void setQuantity() {
        this.quantity = quantity;
    }

    /**
     * Конструктор для создания объекта контейнера.
     *
     * @param typeNumber номер типа контейнера.
     * @param name название контейнера.
     * @param quantity количество контейнеров.
     */
    public Container(int typeNumber, String name, int quantity) {
        super(typeNumber, name);
        this.typeNumber = 3;
        this.quantity = quantity;
    }

    /**
     * Возвращает строковое представление контейнера.
     *
     * @return строковое представление контейнера с его названием и количеством.
     */
    public String toString() {
        return "Контейнер " + "\t" + super.toString() + "\t" + quantity + " шт.";
    }
}
