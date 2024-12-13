package com.example.model;

/**
 * Абстрактный класс, представляющий вагон для перевозки продуктов.
 */
public abstract class Wagon {
    private String cargoName;

    /**
     * Конструктор для создания объекта вагона.
     *
     * @param cargoName название груза.
     */
    public Wagon(String cargoName) {
        this.cargoName = cargoName;
    }

    /**
     * Получает название груза.
     *
     * @return название груза.
     */
    public String getCargoName() {
        return cargoName;
    }

    /**
     * Возвращает строковое представление вагона.
     *
     * @return строковое представление вагона.
     */
    public String toString() {
        return "Название груза: " + cargoName;
    }

    /**
     * Абстрактный метод для получения вместимости вагона.
     *
     * @return вместимость вагона.
     */
    public abstract int getCapacity();
}
