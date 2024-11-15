package com.example.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс Train представляет поезд, который состоит из различных вагонов, предназначенных для транспортировки различных типов грузов.
 * Он поддерживает хранение вагонов как в списке, так и в хэш-карте.
 */
public class Train {
    // Список вагонов
    static ArrayList<Wagon> list = new ArrayList<>();

    // Хэш-карта вагонов, где ключом является порядковый номер вагона
    static Map<Integer, Wagon> mapTrain = new HashMap<>();

    /**
     * Добавляет вагон в список вагонов.
     *
     * @param van Вагон, который необходимо добавить.
     */
    public void appendVan(Wagon van) {
        list.add(van);
    }

    /**
     * Возвращает список вагонов.
     *
     * @return Список вагонов.
     */
    public static ArrayList<Wagon> getList() {
        return list;
    }

    /**
     * Устанавливает список вагонов.
     *
     * @param list Новый список вагонов.
     */
    public void setList(ArrayList<Wagon> list) {
        this.list = list;
    }

    /**
     * Возвращает хэш-карту вагонов.
     *
     * @return Хэш-карта вагонов.
     */
    public static Map<Integer, Wagon> getMapTrain() {
        return mapTrain;
    }

    /**
     * Устанавливает хэш-карту вагонов.
     *
     * @param mapTrain Новая хэш-карта вагонов.
     */
    public void setMapTrain(Map<Integer, Wagon> mapTrain) {
        this.mapTrain = mapTrain;
    }

    /**
     * Добавляет вагон в хэш-карту вагонов по порядковому номеру.
     *
     * @param i Порядковый номер вагона.
     * @param van Вагон, который необходимо добавить.
     */
    public void appendMap(Integer i, Wagon van) {
        mapTrain.put(i, van);
    }

    /**
     * Загружает груз в поезд, основываясь на продуктах из склада, и создает поезд на основе списка вагонов.
     *
     * @param warehouse Склад, содержащий список продуктов.
     * @return Поезд, загруженный товарами.
     */
    public static Train loadingOfGoodsList(Warehouse warehouse) {
        Train train = new Train();
        for (Product p : warehouse.getProductList()) {
            Product product = p;
            switch (product.getTypeNumber()) {
                case 1: // Для жидкостей
                    Liquid liquid = (Liquid) product;
                    int capacity1 = 1000;
                    int N1 = (int) Math.ceil(liquid.getQuantity() / capacity1);
                    for (int i1 = 0; i1 < N1; i1++) {
                        TankWagon liquidTank = new TankWagon(liquid.getName(), capacity1);
                        train.appendVan(liquidTank);
                    }
                    break;

                case 2: // Для сыпучих грузов
                    Bulk bulkCargo = (Bulk) product;
                    int capacity2 = 1000;
                    int N2 = (int) Math.ceil(bulkCargo.getQuantity() / capacity2);
                    for (int i1 = 0; i1 < N2; i1++) {
                        BulkWagon bulkCargoTank = new BulkWagon(bulkCargo.getName(), capacity2);
                        train.appendVan(bulkCargoTank);
                    }
                    break;

                case 3: // Для контейнеров
                    Container container = (Container) product;
                    int capacity3 = 2;
                    int N3 = (int) Math.ceil(container.getQuantity() / capacity3);
                    for (int i1 = 0; i1 < N3; i1++) {
                        ContainerWagon containerPlatform = new ContainerWagon(container.getName(), capacity3);
                        train.appendVan(containerPlatform);
                    }
                    break;

                case 4: // Для автомобилей
                    Car car = (Car) product;
                    int capacity4 = 2;
                    int N4 = (int) Math.ceil(car.getQuantity() / capacity4);
                    for (int i1 = 0; i1 < N4; i1++) {
                        CarWagon carPlatform = new CarWagon(car.getName(), capacity4);
                        train.appendVan(carPlatform);
                    }
                    break;

                default:
                    break;
            }
        }
        return train;
    }

    /**
     * Загружает груз в поезд, основываясь на продуктах из склада, и создает поезд на основе хэш-карты вагонов.
     *
     * @param warehouse Склад, содержащий список продуктов.
     * @return Поезд, загруженный товарами.
     */
    public static Train loadingOfGoodsMap(Warehouse warehouse) {
        Train train = new Train();
        int i = 0;
        for (Product p : warehouse.getProductList()) {
            switch (p.getTypeNumber()) {
                case 1 -> { // Для жидкостей
                    Liquid liquid = (Liquid) p;
                    int capacity1 = 1000;
                    int N1 = (int) Math.ceil(liquid.getQuantity() / capacity1);
                    for (int i1 = 0; i1 < N1; i1++) {
                        TankWagon liquidTank = new TankWagon(liquid.getName(), capacity1);
                        train.appendMap(i + i1, liquidTank);
                    }
                    i += N1;
                }
                case 2 -> { // Для сыпучих грузов
                    Bulk bulkCargo = (Bulk) p;
                    int capacity2 = 1000;
                    int N2 = (int) Math.ceil(bulkCargo.getQuantity() / capacity2);
                    for (int i1 = 0; i1 < N2; i1++) {
                        BulkWagon bulkCargoTank = new BulkWagon(bulkCargo.getName(), capacity2);
                        train.appendMap(i + i1, bulkCargoTank);
                    }
                    i += N2;
                }
                case 3 -> { // Для контейнеров
                    Container container = (Container) p;
                    int capacity3 = 2;
                    int N3 = (int) Math.ceil(container.getQuantity() / capacity3);
                    for (int i1 = 0; i1 < N3; i1++) {
                        ContainerWagon containerWagon = new ContainerWagon(container.getName(), capacity3);
                        train.appendMap(i + i1, containerWagon);
                    }
                    i += N3;
                }
                case 4 -> { // Для автомобилей
                    Car car = (Car) p;
                    int capacity4 = 2;
                    int N4 = (int) Math.ceil(car.getQuantity() / capacity4);
                    for (int i1 = 0; i1 < N4; i1++) {
                        CarWagon carWagon = new CarWagon(car.getName(), capacity4);
                        train.appendMap(i + i1, carWagon);
                    }
                    i += N4;
                }
                default -> {
                }
            }
        }
        return train;
    }

    /**
     * Генерирует вагон для соответствующего типа продукта.
     *
     * @param product Продукт, для которого необходимо сгенерировать вагон.
     * @return Вагон, соответствующий типу продукта.
     */
    public static Wagon generatorVan(Product product) {
        while (true) {
            switch (product.getTypeNumber()) {
                case 1 -> { // Для жидкостей
                    Liquid liquid = (Liquid) product;
                    return new TankWagon(liquid.getName(), liquid.getQuantity());
                }
                case 2 -> { // Для сыпучих грузов
                    Bulk bulkCargo = (Bulk) product;
                    return new BulkWagon(bulkCargo.getName(), bulkCargo.getQuantity());
                }
                case 3 -> { // Для контейнеров
                    Container container = (Container) product;
                    return new ContainerWagon(container.getName(), container.getQuantity());
                }
                case 4 -> { // Для автомобилей
                    Car car = (Car) product;
                    return new CarWagon(car.getName(), car.getQuantity());
                }
                default -> {
                }
            }
        }
    }
}

