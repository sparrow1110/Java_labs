package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс склада продукции.
 */
public class Warehouse {
    private List<Product> products;

    /**
     * Конструктор для создания склада.
     */
    public Warehouse() {
        this.products = new ArrayList<>();
    }

    /**
     * Добавляет продукт на склад.
     *
     * @param product Продукт для добавления.
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Удаляет продукт со склада.
     *
     * @param product Продукт для удаления.
     */
    public void removeProduct(Product product) {
        products.remove(product);
    }

    /**
     * Возвращает список продуктов на складе.
     * @return Список продуктов.
     */
    public List<Product> getProducts() {
        return products;
    }
}
