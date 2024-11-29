package com.example.model;

import java.util.ArrayList;

/**
 * Представляет поезд, который состоит из нескольких вагонов.
 */
public class Train {
    private ArrayList<Wagon> list = new ArrayList<>();

    /**
     * Добавляет вагон в поезд.
     *
     * @param van вагон, который нужно добавить в поезд.
     */
    public void appendVan(Wagon van) {
        list.add(van);
    }

    /**
     * Получает количество вагонов в поезде.
     *
     * @return длина поезда, то есть количество вагонов.
     */
    public int getLength() {
        return list.size();
    }

    /**
     * Получает вагон по индексу.
     *
     * @param i индекс вагона в списке.
     * @return вагон, находящийся на указанном индексе.
     */
    public Wagon getVan(int i) {
        return list.get(i);
    }

    /**
     * Получает список вагонов.
     *
     * @return список вагонов.
     */
    public ArrayList<Wagon> getList() {
        return list;
    }

    /**
     * Устанавливает список вагонов.
     *
     * @param list список вагонов, который нужно установить.
     */
    public void setList(ArrayList<Wagon> list) {
        this.list = list;
    }

    /**
     * Загрузка товаров в вагоны поезда на основе их типов.
     *
     * @return поезд с загруженными вагонами.
     */
    public static Train loadingOfGoods() {
        Train train = new Train();
        for (Product p : Warehouse.getProducts()) {
            Product product = p;
            switch (product.getTypeNumber()) {
                case 1: // Для жидкостей
                    Liquid liquid = (Liquid) product;
                    int capacity1 = 1000;
                    int N1 = 1 + (int) Math.ceil(liquid.getQuantity() / capacity1);
                    for (int i = 0; i < N1; i++) {
                        TankWagon liquidTank = new TankWagon(liquid.getName(), capacity1);
                        train.appendVan(liquidTank);
                    }
                    break;

                case 2: // Для сыпучих грузов
                    Bulk bulkCargo = (Bulk) product;
                    int capacity2 = 1000;
                    int N2 = 1 + (int) Math.ceil(bulkCargo.getQuantity() / capacity2);
                    for (int i = 0; i < N2; i++) {
                        BulkWagon bulkCargoTank = new BulkWagon(bulkCargo.getName(), capacity2);
                        train.appendVan(bulkCargoTank);
                    }
                    break;

                case 3: // Для контейнеров
                    Container container = (Container) product;
                    int capacity3 = 2;
                    int N3 = 1 + (int) Math.ceil(container.getQuantity() / capacity3);
                    for (int i = 0; i < N3; i++) {
                        ContainerWagon containerPlatform = new ContainerWagon(container.getName(), capacity3);
                        train.appendVan(containerPlatform);
                    }
                    break;

                case 4: // Для автомобилей
                    Car car = (Car) product;
                    int capacity4 = 2;
                    int N4 = 1 + (int) Math.ceil(car.getQuantity() / capacity4);
                    for (int i = 0; i < N4; i++) {
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
}

