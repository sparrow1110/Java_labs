package com.example.model;

/**
 * Представляет склад, который хранит различные продукты.
 */
public class Warehouse {
    private static Liquid oil = new Liquid(1, "Нефть", 1000);
    private static Liquid diesel = new Liquid(1, "Дизельное топливо", 2000);
    private static Liquid fuelOil = new Liquid(1, "Мазут", 4000);
    private static Bulk seed = new Bulk(2, "Зерно", 3000);
    private static Bulk coal = new Bulk(2, "Уголь", 1000);
    private static Bulk sand = new Bulk(2, "Песок", 5000);
    private static Container containers = new Container(3, "Специальные контейнеры", 4);
    private static Car cars = new Car(4, "ВАЗ-2107", 2);
    private static Product[] products = new Product[]{oil, diesel, fuelOil, seed, coal, sand, containers, cars};

    /**
     * Получает список всех продуктов на складе.
     *
     * @return массив продуктов.
     */
    public static Product[] getProducts() {
        return products;
    }

    /**
     * Устанавливает список продуктов на складе.
     *
     * @param products массив продуктов, который нужно установить.
     */
    public static void setProducts(Product[] products) {
        Warehouse.products = products;
    }
}

