package com.example.model;

/**
 * Представляет платформу для перевозки автомобилей.
 */
public class CarWagon extends Wagon {
    private int capacity;

    /**
     * Получает вместимость платформы для автомобилей.
     *
     * @return вместимость платформы.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Устанавливает вместимость платформы для автомобилей.
     */
    public void setCapacity() {
        this.capacity = capacity;
    }

    /**
     * Конструктор для создания объекта платформы для автомобилей.
     *
     * @param cargoName название груза.
     * @param capacity вместимость платформы.
     */
    public CarWagon(String cargoName, int capacity) {
        super(cargoName);
        this.capacity = capacity;
    }

    /**
     * Возвращает строковое представление платформы для автомобилей.
     *
     * @return строковое представление платформы с её названием и вместимостью.
     */
    public String toString() {
        return "Платформа для автомобилей" + "\t" + super.toString() + "\t" + capacity + " шт.";
    }
}
