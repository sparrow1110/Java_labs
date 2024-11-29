package com.example.model;

/**
 * Представляет платформу для перевозки контейнеров.
 */
public class ContainerWagon extends Wagon {
    private int capacity;

    /**
     * Получает вместимость платформы для контейнеров.
     *
     * @return вместимость платформы.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Устанавливает вместимость платформы для контейнеров.
     */
    public void setCapacity() {
        this.capacity = capacity;
    }

    /**
     * Конструктор для создания объекта платформы для контейнеров.
     *
     * @param cargoName название груза.
     * @param capacity вместимость платформы.
     */
    public ContainerWagon(String cargoName, int capacity) {
        super(cargoName);
        this.capacity = capacity;
    }

    /**
     * Возвращает строковое представление платформы для контейнеров.
     *
     * @return строковое представление платформы с её названием и вместимостью.
     */
    public String toString() {
        return "Платформа для контейнеров" + "\t" + super.toString() + "\t" + capacity + " шт.";
    }
}
