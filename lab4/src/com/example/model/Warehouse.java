package com.example.model;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс {@code Warehouse} представляет склад, который хранит список продуктов
 * как в виде массива, так и в виде хэш-таблицы.
 */
public class Warehouse {

    public static ArrayList<Product> productList = new ArrayList<>();
    public static HashMap<Integer, Product> productHashMap = new HashMap<>();

    /**
     * Получает список продуктов на складе.
     *
     * @return Список продуктов.
     */
    public ArrayList<Product> getProductList() {
        return productList;
    }

    /**
     * Устанавливает новый список продуктов на складе.
     *
     * @param productList Новый список продуктов.
     */
    public void setProductList(ArrayList<Product> productList) {
        Warehouse.productList = productList;
    }

    /**
     * Получает хэш-таблицу продуктов на складе.
     *
     * @return Хэш-таблица продуктов.
     */
    public HashMap<Integer, Product> getProductHashMap() {
        return productHashMap;
    }

    /**
     * Устанавливает новую хэш-таблицу продуктов на складе.
     *
     * @param productHashMap Новая хэш-таблица продуктов.
     */
    public void setProductHashMap(HashMap<Integer, Product> productHashMap) {
        Warehouse.productHashMap = productHashMap;
    }

    /**
     * Добавляет продукт в список продуктов на складе.
     *
     * @param product Продукт для добавления.
     */
    public static void appendList(Product product) {
        productList.add(product);
    }

    /**
     * Добавляет продукт в хэш-таблицу продуктов на складе.
     *
     * @param i       Ключ для добавления.
     * @param product Продукт для добавления.
     */
    public static void appendHashMap(Integer i, Product product) {
        productHashMap.put(i, product);
    }

    /**
     * Генерирует случайный список продуктов на складе.
     *
     * @param n Количество продуктов для генерации.
     * @return Новый объект {@code Warehouse} с заполненным списком продуктов.
     */
    public static Warehouse randomList(int n) {
        Warehouse warehouse = new Warehouse();
        while (n > 0) {
            appendList(RandomProduct.generate());
            n--;
        }
        return warehouse;
    }

    /**
     * Генерирует случайную хэш-таблицу продуктов на складе.
     *
     * @param n Количество продуктов для генерации.
     * @return Новый объект {@code Warehouse} с заполненной хэш-таблицей продуктов.
     */
    public static Warehouse randomHashMap(int n) {
        Warehouse warehouse = new Warehouse();
        for (int i = 0; i < n; i++) {
            appendHashMap(i, RandomProduct.generate());
        }
        return warehouse;
    }
}

