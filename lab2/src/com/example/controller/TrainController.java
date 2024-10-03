package com.example.controller;


import com.example.model.*;
import java.util.ArrayList;
import java.util.List;


public class TrainController {
    private Train train;
    private Warehouse warehouse;

    public TrainController() {
        this.warehouse = new Warehouse();
        this.train = new Train();
        initializeWarehouse();
        initializeTrain();
    }

    private void initializeWarehouse() {
        warehouse.addProduct(new Liquid("Нефть"));
        warehouse.addProduct(new Liquid("Дизель"));
        warehouse.addProduct(new Liquid("Мазут"));
        warehouse.addProduct(new Bulk("Зерно"));
        warehouse.addProduct(new Bulk("Уголь"));
        warehouse.addProduct(new Bulk("Песок"));
        warehouse.addProduct(new Container("Контейнер"));
        warehouse.addProduct(new Car("Мерседес"));
    }

    private void initializeTrain() {
        train.addWagon(new ContainerWagon());
        train.addWagon(new TankWagon());
        train.addWagon(new BulkWagon());
        train.addWagon(new CarWagon());
    }

    public void loadTrain() {
        List<Product> productsCopy = new ArrayList<>(warehouse.getProducts());
        for (Product product : productsCopy) {
            Product loadedProduct = train.loadProduct(product);
            if (loadedProduct != null) {
                warehouse.removeProduct(loadedProduct);
            }
        }
    }

    public Train getTrain() {
        return train;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
}


