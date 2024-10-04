package com.example.model;

/**
 * Класс для автомобилей.
 */
public class Car extends Product {
    /**
     * Конструктор для создания автомобиля.
     * @param name Название автомобиля.
     * @param weight Вес автомобиля.
     */
    public Car(String name, double weight) {
        super(name, weight);
    }
}