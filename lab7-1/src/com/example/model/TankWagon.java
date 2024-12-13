package com.example.model;

/**
 * Представляет цистерну для перевозки жидкостей.
 */
public class TankWagon extends Wagon {
    private int capacity;

    /**
     * Получает вместимость цистерны.
     *
     * @return вместимость цистерны.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Устанавливает вместимость цистерны.
     */
    public void setCapacity() {
        this.capacity = capacity;
    }

    /**
     * Конструктор для создания объекта цистерны для жидкостей.
     *
     * @param cargoName название жидкости.
     * @param capacity вместимость цистерны.
     */
    public TankWagon(String cargoName, int capacity) {
        super(cargoName);
        this.capacity = capacity;
    }

    /**
     * Возвращает строковое представление цистерны для жидкостей.
     *
     * @return строковое представление цистерны с её названием и вместимостью.
     */
    public String toString() {
        return "Цистерна для жидкостей" + "\t" + super.toString() + "\t" + capacity + " л";
    }
}
