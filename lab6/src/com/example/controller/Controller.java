package com.example.controller;

import com.example.model.Product;
import com.example.model.Train;
import com.example.model.Warehouse;
import com.example.view.TrainView;
import com.example.model.Wagon;

/**
 * Класс программы, выполняющий роль контроллера.
 */
public class Controller {
    public static void controllerMain() {
        TrainView.viewMessage("Список товаров: \n");
        for (Product product : Warehouse.getProducts()) {
            TrainView.viewMessage(product.toString());
        }
        Train train = Train.loadingOfGoods();
        TrainView.viewMessage("\nСписок вагонов: \n");
        for (Wagon van : train.getList()) {
            TrainView.viewMessage(van.toString());
        }
    }
}
