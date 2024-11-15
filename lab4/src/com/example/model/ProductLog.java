package com.example.model;


import com.example.controller.Controller;


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс ProductLog используется для ведения логов операций добавления и удаления объектов {@link Product}
 * в коллекции типа {@link ArrayList} и {@link HashMap}. Логирование включает информацию о времени выполнения операций.
 * Также класс поддерживает запись ошибок в отдельный лог-файл.
 */
public class ProductLog {

    /** Список для хранения исключений, возникших при работе с файлами. */
    private final static ArrayList<Exception> errList = new ArrayList<>();

    /**
     * Логирует операции добавления и удаления объектов {@link Product} в коллекцию типа {@link ArrayList}.
     * Для каждой операции записываются время выполнения и другие статистические данные.
     *
     * @param n количество продуктов для добавления и удаления.
     */
    public static void arrayListLog(int n) {
        ArrayList<Product> productArrayList = new ArrayList<>();
        long totalTime = 0;
        long startOperation;
        long stopOperation;
        try (FileWriter writer = new FileWriter("LinenLog.txt", true)) {
            writer.write("Start program: %s %s \n".formatted(LocalDate.now(), LocalTime.now()));
            writer.write("ArrayList\n");

            // Добавление продуктов
            for (int i = 0; i < n; i++) {
                Product product = RandomProduct.generate();
                startOperation = System.nanoTime();
                productArrayList.add(product);
                stopOperation = System.nanoTime();
                totalTime += stopOperation - startOperation;
                writer.write("add, ID = %d, %d\n".formatted(i + 1, stopOperation - startOperation));
            }
            writer.write("AddTotalCount = %d\n".formatted(n));
            writer.write("AddTotalTime = %d\n".formatted(totalTime));
            writer.write("AddMedianTime = %d\n".formatted(totalTime / n));

            // Удаление продуктов
            totalTime = 0;
            for (int i = 0; i < n / 10; i++) {
                int id = (int) (Math.random() * (n - n / 10));
                startOperation = System.nanoTime();
                productArrayList.remove(id);
                stopOperation = System.nanoTime();
                totalTime += stopOperation - startOperation;
                writer.write("remove, ID = %d, %d\n".formatted(id + 1, stopOperation - startOperation));
            }
            writer.write("RemoveTotalCount = %d\n".formatted(n / 10));
            writer.write("RemoveTotalTime = %d\n".formatted(totalTime));
            writer.write("RemoveMedianTime = %d\n".formatted(10 * totalTime / n));
            writer.write("Finish program: %s %s \n\n".formatted(LocalDate.now(), LocalTime.now()));
        } catch (IOException exc) {
            errList.add(exc);
            System.out.println("Ошибка открытия файла");
        }
    }

    /**
     * Логирует операции добавления и удаления объектов {@link Product} в коллекцию типа {@link HashMap}.
     * Для каждой операции записываются время выполнения и другие статистические данные.
     *
     * @param n количество продуктов для добавления и удаления.
     */
    public static void hashMapLog(int n) {
        HashMap<Integer, Product> productHashMap = new HashMap<>();
        long totalTime = 0;
        long startOperation;
        long stopOperation;
        try (FileWriter writer = new FileWriter("LinenLog.txt", true)) {
            writer.write("Start program: %s %s \n".formatted(LocalDate.now(), LocalTime.now()));
            writer.write("HashMap\n");

            // Добавление продуктов
            for (int i = 0; i < n; i++) {
                Product product = RandomProduct.generate();
                startOperation = System.nanoTime();
                productHashMap.put(i, product);
                stopOperation = System.nanoTime();
                totalTime += stopOperation - startOperation;
                writer.write("add, ID = %d, %d\n".formatted(i + 1, stopOperation - startOperation));
            }
            writer.write("AddTotalCount = %d\n".formatted(n));
            writer.write("AddTotalTime = %d\n".formatted(totalTime));
            writer.write("AddMedianTime = %d\n".formatted(totalTime / n));

            // Удаление продуктов
            totalTime = 0;
            for (int i = 0; i < n / 10; i++) {
                int id = (int) (Math.random() * (n - n / 10));
                startOperation = System.nanoTime();
                productHashMap.remove(id);
                stopOperation = System.nanoTime();
                totalTime += stopOperation - startOperation;
                writer.write("remove, ID = %d, %d\n".formatted(id + 1, stopOperation - startOperation));
            }
            writer.write("RemoveTotalCount = %d\n".formatted(n / 10));
            writer.write("RemoveTotalTime = %d\n".formatted(totalTime));
            writer.write("RemoveMedianTime = %d\n".formatted(10 * totalTime / n));
            writer.write("Finish program: %s %s \n\n".formatted(LocalDate.now(), LocalTime.now()));
        } catch (IOException exc) {
            errList.add(exc);
            Controller.controllerPrintMessage("Ошибка открытия файла");
        }
    }

    /**
     * Логирует ошибки, возникшие при работе с файлами, в отдельный файл "ErrLog.txt".
     */
    public void errLog() {
        try (FileWriter writer = new FileWriter("ErrLog.txt", true)) {
            for (Exception exc : errList) {
                writer.write(exc.getMessage());
            }
        } catch (IOException exc) {
            errList.add(exc);
            Controller.controllerPrintMessage("Ошибка открытия файла");
        }
    }
}
