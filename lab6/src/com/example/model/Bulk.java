package com.example.model;

/**
 * Представляет сыпучий груз, который является типом продукта.
 */
public class Bulk extends Product {
    private int weight;

    /**
     * Получает вес сыпучего груза.
     *
     * @return вес груза.
     */
    public int getQuantity() {
        return weight;
    }

    /**
     * Устанавливает вес сыпучего груза.
     */
    public void setQuantity() {
        this.weight = weight;
    }

    /**
     * Конструктор для создания объекта сыпучего груза.
     *
     * @param typeNumber номер типа груза.
     * @param name название груза.
     * @param weight вес груза.
     */
    public Bulk(int typeNumber, String name, int weight) {
        super(typeNumber, name);
        this.typeNumber = 2;
        this.weight = weight;
    }

    /**
     * Возвращает строковое представление сыпучего груза.
     *
     * @return строковое представление сыпучего груза с его названием и весом.
     */
    public String toString() {
        return "Сыпучий груз" + "\t" + super.toString() + "\t" + weight + " кг";
    }
}
