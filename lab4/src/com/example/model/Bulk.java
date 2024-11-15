package com.example.model;


/**
 * Класс BulkCargo представляет сыпучий груз и является наследником класса Product.
 * Хранит информацию о весе сыпучего груза.
 */
public class Bulk extends Product {

    /** Вес сыпучего груза. */
    private float weight;

    /**
     * Возвращает количество сыпучего груза.
     *
     * @return вес сыпучего груза в килограммах.
     */
    public float getQuantity() {
        return weight;
    }

    /**
     * Устанавливает количество сыпучего груза.
     *
     * @param weight вес сыпучего груза в килограммах.
     */
    public void setQuantity(float weight) {
        this.weight = weight;
    }

    /**
     * Конструктор для создания экземпляра сыпучего груза.
     *
     * @param typeNumber тип продукта (должен быть 2 для сыпучих грузов).
     * @param name       название груза.
     * @param weight     вес груза в килограммах.
     */
    public Bulk(int typeNumber, String name, float weight) {
        super(typeNumber, name);
        this.typeNumber = 2;
        this.weight = weight;
    }

    /**
     * Возвращает строковое представление объекта сыпучего груза.
     *
     * @return строка, содержащая тип продукта, его название и вес.
     */
    @Override
    public String toString() {
        return "Сыпучий груз" + "\t" + super.toString() + "\t" + weight + " кг";
    }
}
