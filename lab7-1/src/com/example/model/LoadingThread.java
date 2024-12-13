package com.example.model;


import java.util.concurrent.Callable;

/**
 * Задача для асинхронной загрузки определенного типа товара в поезд.
 * Реализует интерфейс Callable для выполнения в пуле потоков.
 */
public class LoadingThread implements Callable<Void> {
    /** Поезд, в который производится загрузка. */
    private final Train train;

    /** Продукт, который необходимо загрузить. */
    private final Product product;

    /**
     * Создает новую задачу загрузки.
     *
     * @param train поезд для загрузки
     * @param product продукт для загрузки
     */
    public LoadingThread(Train train, Product product) {
        this.train = train;
        this.product = product;
    }

    /**
     * Выполняет загрузку товара в соответствующие вагоны.
     *
     * @return null после завершения загрузки
     */
    @Override
    public Void call() {
        switch (product.getTypeNumber()) {
            case 1: // Для жидкостей
                loadLiquid((Liquid) product);
                break;
            case 2: // Для сыпучих грузов
                loadBulkCargo((Bulk) product);
                break;
            case 3: // Для контейнеров
                loadContainer((Container) product);
                break;
            case 4: // Для автомобилей
                loadCar((Car) product);
                break;
        }
        return null;
    }

    /**
     * Загружает жидкий груз в цистерны.
     *
     * @param liquid жидкий груз для загрузки
     */
    private void loadLiquid(Liquid liquid) {
        int capacity = 1000;
        int count = (int) Math.ceil(liquid.getQuantity() / (double) capacity);
        for (int i = 0; i < count; i++) {
            train.appendVan(new TankWagon(liquid.getName(), capacity));
        }
    }

    /**
     * Загружает сыпучий груз в специальные вагоны.
     *
     * @param bulkCargo сыпучий груз для загрузки
     */
    private void loadBulkCargo(Bulk bulkCargo) {
        int capacity = 1000;
        int count = (int) Math.ceil(bulkCargo.getQuantity() / (double) capacity);
        for (int i = 0; i < count; i++) {
            train.appendVan(new BulkWagon(bulkCargo.getName(), capacity));
        }
    }

    /**
     * Загружает контейнеры на платформы.
     *
     * @param container контейнеры для загрузки
     */
    private void loadContainer(Container container) {
        int capacity = 2;
        int count = (int) Math.ceil(container.getQuantity() / (double) capacity);
        for (int i = 0; i < count; i++) {
            train.appendVan(new ContainerWagon(container.getName(), capacity));
        }
    }

    /**
     * Загружает автомобили на специальные платформы.
     *
     * @param car автомобили для загрузки
     */
    private void loadCar(Car car) {
        int capacity = 2;
        int count = (int) Math.ceil(car.getQuantity() / (double) capacity);
        for (int i = 0; i < count; i++) {
            train.appendVan(new CarWagon(car.getName(), capacity));
        }
    }
}