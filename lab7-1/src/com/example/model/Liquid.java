package com.example.model;

/**
 * Представляет жидкость, которая является типом продукта.
 */
public class Liquid extends Product {
    private int volume;

    /**
     * Получает объём жидкости.
     *
     * @return объём жидкости.
     */
    public int getQuantity() {
        return volume;
    }

    /**
     * Устанавливает объём жидкости.
     */
    public void setQuantity() {
        this.volume = volume;
    }

    /**
     * Конструктор для создания объекта жидкости.
     *
     * @param typeNumber номер типа жидкости.
     * @param name название жидкости.
     * @param volume объём жидкости.
     */
    public Liquid(int typeNumber, String name, int volume) {
        super(typeNumber, name);
        this.typeNumber = 1;
        this.volume = volume;
    }

    /**
     * Возвращает строковое представление жидкости.
     *
     * @return строковое представление жидкости с её названием и объёмом.
     */
    public String toString() {
        return "Жидкость" + "\t" + super.toString() + "\t" + volume + " л";
    }
}
