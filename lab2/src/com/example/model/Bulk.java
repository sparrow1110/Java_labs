package com.example.model;

/**
 * Класс для сыпучих грузов.
 */
public class Bulk extends Product {
    /**
     * Конструктор для создания сыпучего груза.
     * @param name Название сыпучего груза.
     * @param weight Вес сыпучего груза.
     */
    public Bulk(String name, double weight) {
        super(name, weight);
    }
}