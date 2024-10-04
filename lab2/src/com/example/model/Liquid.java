package com.example.model;

/**
 * Класс для жидкостей.
 */
public class Liquid extends Product {
    /**
     * Конструктор для создания жидкости.
     * @param name Название жидкости.
     * @param weight Вес жидкости.
     */
    public Liquid(String name, double weight) {
        super(name, weight);
    }
}