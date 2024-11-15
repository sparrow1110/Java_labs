package com.example.model;


import com.example.controller.Controller;
import java.io.IOException;

public class Menu {
    private static Logging logging;

    static public void menu(TrainDataBase trainDataBase) {
        try {
            InitialSettings initialSettings = new InitialSettings();

            boolean flag0 = true;
            InitialSettings.User currentUser = null;

            // Запрос логина и пароля у пользователя
            while (flag0) {
                String login = Controller.controllerGetString("Введите имя пользователя: ");
                String password = Controller.controllerGetString("Введите пароль: ");
                currentUser = initialSettings.authenticateUser(login, password);
                if (currentUser == null) {
                    Controller.controllerPrintMessage("Неверное имя пользователя или пароль.");
                } else {
                    trainDataBase.initializeLogging(currentUser);
                    flag0 = false;
                }
            }

            //logging = new Logging(currentUser);
            trainDataBase.logging.AddANote(currentUser.userName + " Начало работы программы");
            Controller.controllerPrintMessage("******* Добро пожаловать - " + currentUser.userName + " *******");

            flag0 = true;

            // Меню для пользователей с правами root
            if (currentUser.root) {
                while (flag0) {
                    String item = Controller.controllerGetString("Введите:" +
                            "\n1 - Чтение объектов из файла" +
                            "\n2 - Запись объектов в файл" +
                            "\n3 - Вывести данные в консоль" +
                            "\n4 - Добавить объект" +
                            "\n5 - Изменить объект" +
                            "\n6 - Удалить объект" +
                            "\n7 - Отладка" +
                            "\n8 - Автотесты" +
                            "\n0 - Выход");
                    switch (item) {
                        case ("1"):
                            trainDataBase.ReadDataBase();
                            trainDataBase.logging.AddANote("Чтение данных");
                            break;
                        case ("2"):
                            trainDataBase.SaveDataBase();
                            trainDataBase.logging.AddANote("Запись данных");
                            break;
                        case ("3"):
                            Controller.controllerPrintMessage(trainDataBase.ToString());
                            break;
                        case ("4"):
                            trainDataBase.AddObj();
                            break;
                        case ("5"):
                            trainDataBase.ChangeObj();
                            break;
                        case ("6"):
                            trainDataBase.DeleteObj();
                            break;
                        case ("7"):
                            trainDataBase.logging.ToggleDebugging();
                            break;
                        case ("8"):
                            int productCount = 10; // Количество случайных продуктов
                            trainDataBase.FillWithRandomProducts(productCount); // Заполняем 10 случайными продуктами
                            ProductLog.arrayListLog(productCount); // Логируем операции с ArrayList
                            Controller.controllerPrintMessage("Состав заполнен случайными продуктами для автотестов.");
                            break;
                        case ("0"):
                            flag0 = false;
                            break;
                        default:
                            Controller.controllerPrintMessage("Ошибка ввода");
                    }
                }
            } else {
                // Меню для пользователей без прав root
                while (flag0) {
                    String item = Controller.controllerGetString("Введите:" +
                            "\n1 - Чтение объектов из файла" +
                            "\n2 - Вывести данные в консоль" +
                            "\n0 - Выход");
                    switch (item) {
                        case ("1"):
                            trainDataBase.ReadDataBase();
                            trainDataBase.logging.AddANote("Чтение данных");
                            break;
                        case ("2"):
                            Controller.controllerPrintMessage(trainDataBase.ToString());
                            break;
                        case ("0"):
                            flag0 = false;
                            break;
                        default:
                            Controller.controllerPrintMessage("Ошибка ввода");
                    }
                }
            }
        } catch (IOException e) {
            Controller.controllerPrintMessage(e.getMessage());
            Logging.errList.add(e);
        }

        if (trainDataBase.logging != null) {
            trainDataBase.logging.AddANote("Завершение работы программы\n");
            trainDataBase.logging.errLog();
        }
    }
}