package com.example.model;


/**
 * Класс Liquid представляет жидкость и является наследником класса Product.
 * Хранит информацию о количестве жидкости в литрах.
 */
public class Liquid extends Product {

    /** Объём жидкости в литрах. */
    private float volume;

    /**
     * Возвращает количество жидкости.
     *
     * @return объём жидкости в литрах.
     */
    public float getQuantity() {
        return volume;
    }

    /**
     * Устанавливает объём жидкости.
     *
     * @param volume объём жидкости в литрах.
     */
    public void setQuantity(float volume) {
        this.volume = volume;
    }

    /**
     * Конструктор для создания объекта Liquid.
     *
     * @param typeNumber тип продукта (должен быть 1 для жидкостей).
     * @param name       название жидкости.
     * @param volume     объём жидкости в литрах.
     */
    public Liquid(int typeNumber, String name, float volume) {
        super(typeNumber, name);
        this.typeNumber = 1;
        this.volume = volume;
    }

    /**
     * Возвращает строковое представление объекта Liquid.
     *
     * @return строка, содержащая тип продукта, название и объём.
     */
    @Override
    public String toString() {
        return "Жидкость" + "\t" + super.toString() + "\t" + volume + " л";
    }
}
