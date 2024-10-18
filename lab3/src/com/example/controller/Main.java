package com.example.controller;

import com.example.view.TrainView;
import com.example.model.*;
import com.example.util.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Основной класс программы, выполняющий роль контроллера.
 */
public class Main {
    private Train train;
    private Warehouse warehouse;
    private TrainView view;
    private Logger logger;
    private CollectionTester collectionTester;

    /**
     * Конструктор для создания контроллера.
     */
    public Main() {
        this.warehouse = new Warehouse();
        this.train = new Train();
        this.view = new TrainView();
        this.logger = new Logger();
        this.collectionTester = new CollectionTester(logger);
        initializeWarehouse();
        initializeTrain();
    }

    /**
     * Инициализирует склад продукцией.
     */
    private void initializeWarehouse() {
        warehouse.addProduct(new Liquid("Нефть", 1000));
        warehouse.addProduct(new Liquid("Дизель", 800));
        warehouse.addProduct(new Liquid("Мазут", 1200));
        warehouse.addProduct(new Bulk("Зерно", 500));
        warehouse.addProduct(new Bulk("Уголь", 700));
        warehouse.addProduct(new Bulk("Песок", 400));
        warehouse.addProduct(new Container("Контейнер", 2000));
        warehouse.addProduct(new Car("Мерседес", 1500));
    }

    /**
     * Инициализирует состав вагонами.
     */
    private void initializeTrain() {
        train.addWagon(new ContainerWagon(2000));
        train.addWagon(new TankWagon(1100));
        train.addWagon(new TankWagon(1500));
        train.addWagon(new TankWagon(1000));
        train.addWagon(new BulkWagon(800));
        train.addWagon(new BulkWagon(800));
        train.addWagon(new BulkWagon(800));
        train.addWagon(new CarWagon(1500));
        train.sort_Wagon();
    }

    /**
     * Загружает продукты в вагоны.
     */
    public void loadTrain() {
        List<Product> productsCopy = new ArrayList<>(warehouse.getProducts());
        for (Product product : productsCopy) {
            Product loadedProduct = train.loadProduct(product);
            if (loadedProduct != null) {
                warehouse.removeProduct(loadedProduct);
            }
        }
    }

    /**
     * Возвращает состав поезда.
     * @return Состав поезда.
     */
    public Train getTrain() {
        return train;
    }

    /**
     * Возвращает склад продукции.
     * @return Склад продукции.
     */
    public Warehouse getWarehouse() {
        return warehouse;
    }

    /**
     * Основной метод для запуска программы.
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        Main controller = new Main();
        TrainView view = controller.view;

        view.displayWarehouse(controller.getWarehouse());

        controller.loadTrain();

        view.displayTrain(controller.getTrain());
        view.displayWarehouse(controller.getWarehouse());

        int[] sizes = {10, 100};
        for (int size : sizes) {
            controller.collectionTester.testArrayListOperations(size);
            controller.collectionTester.testLinkedListOperations(size);
        }
    }
}
