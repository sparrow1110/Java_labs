package com.example.view;

import com.example.model.Warehouse;
import com.example.model.Train;
import com.example.model.Product;
import com.example.model.Wagon;

public class TrainView {
    public void displayTrain(Train train) {
        System.out.println("Состав поезда: ");
        for (Wagon wagon : train.getWagons()) {
            System.out.println(wagon.getType());
        }
    }

    public void displayWarehouse(Warehouse warehouse) {
        System.out.println("Склад:");
        for (Product product : warehouse.getProducts()) {
            System.out.println(product.getName());
        }
    }
}

