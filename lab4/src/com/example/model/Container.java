package com.example.model;


/**
 * Класс Container представляет контейнеры и является наследником класса Product.
 * Хранит информацию о количестве контейнеров.
 */
public class Container extends Product {

    /** Количество контейнеров. */
    private int quantity;

    /**
     * Возвращает количество контейнеров.
     *
     * @return количество контейнеров.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Устанавливает количество контейнеров.
     *
     * @param quantity количество контейнеров.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Конструктор для создания экземпляра контейнера.
     *
     * @param typeNumber тип продукта (должен быть 3 для контейнеров).
     * @param name       название контейнера.
     * @param quantity   количество контейнеров.
     */
    public Container(int typeNumber, String name, int quantity) {
        super(typeNumber, name);
        this.typeNumber = 3;
        this.quantity = quantity;
    }

    /**
     * Возвращает строковое представление объекта контейнера.
     *
     * @return строка, содержащая тип продукта, его название и количество.
     */
    @Override
    public String toString() {
        return "Контейнер " + "\t" + super.toString() + "\t" + quantity + " шт.";
    }
}

