package com.example.model;


/**
 * Представляет вагон для перевозки сыпучих грузов.
 */
public class BulkWagon extends Wagon {
    private int capacity;

    /**
     * Получает вместимость вагона для сыпучих грузов.
     *
     * @return вместимость вагона.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Устанавливает вместимость вагона для сыпучих грузов.
     */
    public void setCapacity() {
        this.capacity = capacity;
    }

    /**
     * Конструктор для создания объекта вагона для сыпучих грузов.
     *
     * @param cargoName название груза.
     * @param capacity вместимость вагона.
     */
    public BulkWagon(String cargoName, int capacity) {
        super(cargoName);
        this.capacity = capacity;
    }

    /**
     * Возвращает строковое представление вагона для сыпучих грузов.
     *
     * @return строковое представление вагона с его названием и вместимостью.
     */
    public String toString() {
        return "Вагон для сыпучих грузов" + "\t" + super.toString() + "\t" + capacity + " кг";
    }
}
