package com.example;

import com.example.controller.TrainController;
import com.example.view.TrainView;


public class Main {
    public static void main(String[] args) {
        // Создаем контроллер
        TrainController controller = new TrainController();

        // Загружаем состав
        controller.loadTrain();

        // Отображаем состав и склад
        TrainView view = new TrainView();
        view.displayTrain(controller.getTrain());
        view.displayWarehouse(controller.getWarehouse());
    }
}

