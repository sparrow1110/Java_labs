package com.example.model;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Представляет склад с потокобезопасным хранением продуктов.
 * Использует concurrent коллекции для безопасного доступа из разных потоков.
 */
public class Warehouse {
    /** Потокобезопасная карта для хранения продуктов. */
    private static final ConcurrentHashMap<String, Product> productMap = new ConcurrentHashMap<>();

    /** Атомарная ссылка на массив продуктов для потокобезопасного обновления. */
    private static final AtomicReference<Product[]> productsRef = new AtomicReference<>();

    /**
     * Статический блок инициализации продуктов.
     * Выполняется один раз при загрузке класса.
     */
    static {
        initializeProducts();
    }

    /**
     * Инициализирует склад начальным набором продуктов.
     * Заполняет ConcurrentHashMap и устанавливает начальный массив продуктов.
     */
    private static void initializeProducts() {
        productMap.put("oil", new Liquid(1, "Нефть", 1000));
        productMap.put("diesel", new Liquid(1, "Дизельное топливо", 2000));
        productMap.put("fuelOil", new Liquid(1, "Мазут", 4000));
        productMap.put("seed", new Bulk(2, "Зерно", 3000));
        productMap.put("coal", new Bulk(2, "Уголь", 1000));
        productMap.put("sand", new Bulk(2, "Песок", 5000));
        productMap.put("containers", new Container(3, "Специальные контейнеры", 4));
        productMap.put("cars", new Car(4, "ВАЗ-2107", 2));

        Product[] products = {
                productMap.get("oil"),
                productMap.get("diesel"),
                productMap.get("fuelOil"),
                productMap.get("seed"),
                productMap.get("coal"),
                productMap.get("sand"),
                productMap.get("containers"),
                productMap.get("cars")
        };

        productsRef.set(products);
    }

    /**
     * Возвращает массив всех продуктов на складе.
     *
     * @return текущий массив продуктов
     */
    public static Product[] getProducts() {
        return productsRef.get();
    }

    /**
     * Устанавливает новый массив продуктов атомарным образом.
     *
     * @param products новый массив продуктов
     */
    public static void setProducts(Product[] products) {
        productsRef.set(products);
    }
}
