package com.example.model;


import com.example.controller.Controller;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Этот класс представляет базу данных грузовых вагонов (вагонов) и предоставляет методы для
 * манипулирования составом поезда, включая загрузку, сохранение, добавление, изменение и удаление
 * грузовых вагонов. Также ведётся логирование операций, выполняемых с составом поезда.
 */
public class TrainDataBase {

    /** Список, представляющий состав поезда, который хранит объекты типа {@link Wagon}. */
    public ArrayList<Wagon> trainList = new ArrayList<Wagon>();

    /** Система логирования, которая отслеживает действия, выполняемые с составом поезда. */
    public Logging logging;

    // HashMap для хранения продуктов, ключом будет ID продукта
    private HashMap<Integer, Product> productMap = new HashMap<>();

    /** Настройки приложения */
    private InitialSettings initialSettings;


    /**
     * Конструктор класса TrainDataBase.
     *
     * @param initialSettings Настройки приложения.
     */
    public TrainDataBase(InitialSettings initialSettings) {
        this.initialSettings = initialSettings;
        // Инициализация logging будет происходить позже, когда у нас будет конкретный пользователь
    }

    // Метод для заполнения состава случайными продуктами
    public void FillWithRandomProducts(int count) {
        for (int i = 0; i < count; i++) {
            Product randomProduct = RandomProduct.generate(); // Генерируем случайный продукт
            trainList.add(Train.generatorVan(randomProduct)); // Добавляем вагон с продуктом в состав
            productMap.put(randomProduct.getId(), randomProduct); // Добавляем продукт в карту
        }
        // Логирование будет происходить, если у текущего пользователя включено логирование
        if (logging != null) {
            logging.AddANote(count + " случайных продуктов добавлено в состав");
        }
    }

    /**
     * Метод для инициализации логирования для конкретного пользователя.
     * Этот метод должен быть вызван после аутентификации пользователя.
     *
     * @param user Аутентифицированный пользователь
     */
    public void initializeLogging(InitialSettings.User user) {
        this.logging = new Logging(user);
    }


    /**
     * Считывает данные о составе поезда из файла с именем "Train.txt".
     * Если возникает исключение во время ввода-вывода, оно регистрируется, и выводится сообщение.
     */
    public void ReadDataBase() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Train.txt"))) {
            trainList = (ArrayList<Wagon>) ois.readObject();
            if (logging != null) {
                System.out.println("ку");
                logging.AddANote("База данных поезда прочитана из файла");
            }
            else {
                System.out.println(logging);
            }
        } catch (Exception ex) {
            if (logging != null) {
                Logging.errList.add(ex);
            }
            Controller.controllerPrintMessage(ex.getMessage());
        }
    }

    /**
     * Сохраняет текущий состав поезда в файл с именем "Train.txt".
     * Если возникает исключение во время ввода-вывода, оно регистрируется, и выводится сообщение.
     */
    public void SaveDataBase() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Train.txt"))) {
            oos.writeObject(trainList);
            if (logging != null) {
                logging.AddANote("База данных поезда сохранена в файл");
            }
        } catch (Exception ex) {
            if (logging != null) {
                Logging.errList.add(ex);
            }
            Controller.controllerPrintMessage(ex.getMessage());
        }
    }

    /**
     * Возвращает строковое представление состава поезда, показывающее все грузовые вагоны.
     *
     * @return строка, содержащая детали всех вагонов в поезде.
     */
    public String ToString() {
        String strBase = "Train: ";
        for (int i = 0; i < trainList.size(); i++) {
            strBase += "\n" + "#" + i + "\t" + trainList.get(i).toString();
        }
        return strBase;
    }

    /**
     * Добавляет новый вагон в состав поезда на основе типа продукта, введённого пользователем.
     * Доступные типы продуктов: Жидкость (1), Сыпучий груз (2), Контейнер (3), и Автомобиль (4).
     * Логирует добавление вагона.
     */
    public void AddObj() {
        String arg = Controller.controllerGetString("Выберите, товар какого типа вы хотите погрузить в состав? (Жидкость - 1, Сыпучий груз - 2, Контейнер - 3, Автомобиль - 4)");
        switch (arg) {
            case "1":
                Liquid liquid = new Liquid(1, Controller.controllerGetNameLiquids("Название товара:").toString(), Controller.controllerGetInt("Объем: "));
                trainList.add(Train.generatorVan(liquid));
                productMap.put(liquid.getId(), liquid); // Добавляем продукт в карту
                logging.AddANote("Добавление вагона в состав");
                break;
            case "2":
                Bulk bulkCargo = new Bulk(2, Controller.controllerGetNameBulkCargos("Название товара:").toString(), Controller.controllerGetInt("Масса: "));
                trainList.add(Train.generatorVan(bulkCargo));
                productMap.put(bulkCargo.getId(), bulkCargo); // Добавляем продукт в карту
                logging.AddANote("Добавление вагона в состав");
                break;
            case "3":
                Container container = new Container(3, Controller.controllerGetNameContainers("Название товара:").toString(), Controller.controllerGetInt("Количество: "));
                trainList.add(Train.generatorVan(container));
                productMap.put(container.getId(), container); // Добавляем продукт в карту
                logging.AddANote("Добавление вагона в состав");
                break;
            case "4":
                Car car = new Car(4, Controller.controllerGetNameCars("Название товара:").toString(), Controller.controllerGetInt("Введите количество: "));
                trainList.add(Train.generatorVan(car));
                productMap.put(car.getId(), car); // Добавляем продукт в карту
                logging.AddANote("Добавление вагона в состав");
                break;
            default:
                Controller.controllerPrintMessage("Ошибка ввода");
        }
    }

    /**
     * Заменяет существующий вагон в составе поезда на основе индекса и типа продукта,
     * введённых пользователем. Логирует замену вагона.
     */
    public void ChangeObj() {
        int ind = Controller.controllerGetInt("Введите номер вагона для замены: ");
        String arg = Controller.controllerGetString("Выберите, товар какого типа вы хотите погрузить в состав? (Жидкость - 1, Сыпучий груз - 2, Контейнер - 3, Автомобиль - 4)");
        switch (arg) {
            case "1":
                Liquid liquid = new Liquid(1, Controller.controllerGetNameLiquids("Название товара:").toString(), Controller.controllerGetInt("Объем: "));
                trainList.set(ind, Train.generatorVan(liquid));
                productMap.put(liquid.getId(), liquid); // Обновляем продукт в карте
                logging.AddANote("Вагон №" + ind + " заменен");
                break;
            case "2":
                Bulk bulkCargo = new Bulk(2, Controller.controllerGetNameBulkCargos("Название товара:").toString(), Controller.controllerGetInt("Масса: "));
                trainList.set(ind, Train.generatorVan(bulkCargo));
                productMap.put(bulkCargo.getId(), bulkCargo); // Обновляем продукт в карте
                logging.AddANote("Вагон №" + ind + " заменен");
                break;
            case "3":
                Container container = new Container(3, Controller.controllerGetNameContainers("Название товара:").toString(), Controller.controllerGetInt("Количество: "));
                trainList.set(ind, Train.generatorVan(container));
                productMap.put(container.getId(), container); // Обновляем продукт в карте
                logging.AddANote("Вагон №" + ind + " заменен");
                break;
            case "4":
                Car car = new Car(4, Controller.controllerGetNameCars("Название товара:").toString(), Controller.controllerGetInt("Введите количество: "));
                trainList.set(ind, Train.generatorVan(car));
                productMap.put(car.getId(), car); // Обновляем продукт в карте
                logging.AddANote("Вагон №" + ind + " заменен");
                break;
            default:
                Controller.controllerPrintMessage("Ошибка ввода");
        }
    }

    /**
     * Удаляет вагон из состава поезда на основе индекса, введённого пользователем.
     * Логирует удаление вагона.
     */
    public void DeleteObj() {
        try {
            int ind = Controller.controllerGetInt("Введите номер вагона для удаления: ");
            trainList.remove(ind);
            logging.AddANote("Вагон №" + ind + " удален из состава");
        } catch (Exception ex) {
            Controller.controllerPrintMessage("Ошибка ввода");
        }
    }

    /**
     * Возвращает список продуктов в составе поезда.
     * @return ArrayList объектов Van, представляющих состав поезда.
     */
    public ArrayList<Wagon> getProductList() {
        return trainList;
    }

    /**
     * Возвращает карту продуктов с их ID в качестве ключей.
     * @return HashMap, содержащий продукты.
     */
    public HashMap<Integer, Product> getProductMap() {
        return productMap;
    }

    /**
     * Возвращает общее количество продуктов в составе поезда.
     * @return размер trainList.
     */
    public int getProductCount() {
        return trainList.size();
    }

}
