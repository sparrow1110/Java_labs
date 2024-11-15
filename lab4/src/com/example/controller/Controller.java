package com.example.controller;


import com.example.model.InitialSettings;
import com.example.model.Menu;
import com.example.model.ProductLog;
import com.example.model.TrainDataBase;
import com.example.view.View;

import java.io.IOException;

/**
 * Класс {@code Controller} служит связующим звеном между пользовательским интерфейсом и основной логикой приложения.
 * Он обрабатывает ввод пользователя, валидирует его и инициирует действия в модели.
 */
public class Controller {



    /**
     * Основной метод контроллера, который инициализирует настройки и отображает меню.
     * Обрабатывает {@link IOException} в случае ошибок ввода/вывода.
     */
    public static void controllerMain() {
        try {
            InitialSettings initialSettings = new InitialSettings();

            // Создание базы данных
            TrainDataBase trainDataBase = new TrainDataBase(initialSettings);

            // Проверяем, есть ли пользователи с включенными автотестами
            boolean autotestsEnabled = initialSettings.users.stream().anyMatch(user -> user.autotests);

            // Если автотесты включены хотя бы у одного пользователя, заполняем состав случайными продуктами
            if (autotestsEnabled) {
                int productCount = 10; // Количество случайных продуктов
                trainDataBase.FillWithRandomProducts(productCount); // Заполняем 10 случайными продуктами
                ProductLog.arrayListLog(productCount); // Логируем операции с ArrayList
                Controller.controllerPrintMessage("Состав заполнен случайными продуктами для автотестов.");
            }

            // Отображение меню
            Menu.menu(trainDataBase); // Передаем базу данных в меню
        } catch (IOException e) {
            View.viewMessage(e.getMessage());
        }
    }



    /**
     * Отображает сообщение пользователю.
     *
     * @param message Сообщение для отображения.
     */
    public static void controllerPrintMessage(String message) {
        View.viewMessage(message);
    }

    /**
     * Запрашивает у пользователя целочисленный ввод, отображая сообщение.
     * Если ввод не является допустимым целым числом, повторно запрашивает ввод до получения валидного значения.
     *
     * @param message Сообщение для отображения перед запросом ввода.
     * @return Проверенное целочисленное значение, введенное пользователем.
     */
    public static int controllerGetInt(String message) {
        View.viewMessage(message);
        int number;
        while (true) {
            try {
                number = Integer.parseInt(View.viewInput());
            } catch (Exception e) {
                View.viewMessage("Ошибка ввода. Попробуйте ещё раз: ");
                continue;
            }
            break;
        }
        return number;
    }

    /**
     * Запрашивает у пользователя строковый ввод, отображая сообщение.
     *
     * @param message Сообщение для отображения перед запросом ввода.
     * @return Строковый ввод от пользователя.
     */
    public static String controllerGetString(String message) {
        return View.viewGetString(message);
    }

    /**
     * Запрашивает у пользователя выбор типа сыпучего груза из доступных вариантов.
     * Если выбор неверный, пользователю предлагается попробовать снова.
     *
     * @param message Сообщение для отображения перед показом вариантов.
     * @return {@link com.example.model.enums.NameBulk} выбранный пользователем.
     */
    public static com.example.model.enums.NameBulk controllerGetNameBulkCargos(String message) {
        View.viewMessage(message);
        View.viewMessage("Зерно - 1, Уголь - 2, Песок - 3");
        while (true) {
            String arg = View.viewGetString("");
            switch (arg) {
                case "1":
                    return com.example.model.enums.NameBulk.SEED;
                case "2":
                    return com.example.model.enums.NameBulk.COAL;
                case "3":
                    return com.example.model.enums.NameBulk.SAND;
                default:
                    View.viewMessage("Ошибка ввода. Попробуйте ещё раз: ");
            }
        }
    }

    /**
     * Запрашивает у пользователя выбор типа автомобиля из доступных вариантов.
     * Если выбор неверный, пользователю предлагается попробовать снова.
     *
     * @param message Сообщение для отображения перед показом вариантов.
     * @return {@link com.example.model.enums.NameCars} выбранный пользователем.
     */
    public static com.example.model.enums.NameCars controllerGetNameCars(String message) {
        View.viewMessage(message);
        View.viewMessage("Toyota Mark II - 1, BMW X5 - 2");
        while (true) {
            String arg = View.viewGetString("");
            switch (arg) {
                case "1":
                    return com.example.model.enums.NameCars.TOYOTA;
                case "2":
                    return com.example.model.enums.NameCars.BMW;
                default:
                    View.viewMessage("Ошибка ввода. Попробуйте ещё раз: ");
            }
        }
    }

    /**
     * Запрашивает у пользователя выбор типа контейнера из доступных вариантов.
     * Если выбор неверный, пользователю предлагается попробовать снова.
     *
     * @param message Сообщение для отображения перед показом вариантов.
     * @return {@link com.example.model.enums.NameContainers} выбранный пользователем.
     */
    public static com.example.model.enums.NameContainers controllerGetNameContainers(String message) {
        View.viewMessage(message);
        View.viewMessage("Стандартный - 1, Специальный - 2");
        while (true) {
            String arg = View.viewGetString("");
            switch (arg) {
                case "1":
                    return com.example.model.enums.NameContainers.STANDARD;
                case "2":
                    return com.example.model.enums.NameContainers.SPECIAL;
                default:
                    View.viewMessage("Ошибка ввода. Попробуйте ещё раз: ");
            }
        }
    }

    /**
     * Запрашивает у пользователя выбор типа жидкости из доступных вариантов.
     * Если выбор неверный, пользователю предлагается попробовать снова.
     *
     * @param message Сообщение для отображения перед показом вариантов.
     * @return {@link com.example.model.enums.NameLiquids} выбранный пользователем.
     */
    public static com.example.model.enums.NameLiquids controllerGetNameLiquids(String message) {
        View.viewMessage(message);
        View.viewMessage("Нефть - 1, Дизель - 2, Мазут - 3");
        while (true) {
            String arg = View.viewGetString("");
            switch (arg) {
                case "1":
                    return com.example.model.enums.NameLiquids.OIL;
                case "2":
                    return com.example.model.enums.NameLiquids.DIESEL;
                case "3":
                    return com.example.model.enums.NameLiquids.FUEL_OIL;
                default:
                    View.viewMessage("Ошибка ввода. Попробуйте ещё раз: ");
            }
        }
    }
}
