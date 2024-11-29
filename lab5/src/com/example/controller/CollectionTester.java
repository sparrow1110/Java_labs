package com.example.controller;

import com.example.model.Product;
import com.example.util.Logger;
import com.example.util.RandomProductGenerator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Класс для тестирования операций с коллекциями.
 */
public class CollectionTester {
    private static Logger logger;

    /**
     * Конструктор для создания тестера коллекций.
     * @param logger Логгер для записи логов.
     */
    public CollectionTester(Logger logger) {
        this.logger = logger;
    }

    /**
     * Тестирует операции с ArrayList.
     * @param size Размер коллекции.
     */
    public static ArrayList<Long> testArrayListOperations(int size) {
        List<Product> products = new ArrayList<>();
        RandomProductGenerator generator = new RandomProductGenerator();

        ArrayList<Long> res = new ArrayList<>(4);
        long startTime = System.nanoTime();
        long addTotalTime = 0;
        long removeTotalTime = 0;
        int addCount = 0;
        int removeCount = 0;

        try {
            logger.log("ArrayListLog.txt", "Start program: " + java.time.LocalDateTime.now());
            logger.log("ArrayListLog.txt", "ArrayList");

            for (int i = 0; i < size; i++) {
                Product product = generator.generateRandomProduct();
                long addStartTime = System.nanoTime();
                products.add(product);
                long addEndTime = System.nanoTime();
                long addTime = addEndTime - addStartTime;
                addTotalTime += addTime;
                addCount++;
                //logger.log("ArrayListLog.txt", "add, ID = " + i + ", " + addTime);
            }

            res.add(addTotalTime);
            res.add(addTotalTime / size);

            int removeCountTarget = size / 10;
            Random random = new Random();
            for (int i = 0; i < removeCountTarget; i++) {
                int index = random.nextInt(size);
                long removeStartTime = System.nanoTime();
                products.remove(index);
                long removeEndTime = System.nanoTime();
                long removeTime = removeEndTime - removeStartTime;
                removeTotalTime += removeTime;
                removeCount++;
                size--;
                //logger.log("ArrayListLog.txt", "remove, ID = " + index + ", " + removeTime);
            }

            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            res.add(removeTotalTime);
            res.add(removeTotalTime / removeCountTarget);

            logger.log("ArrayListLog.txt", "addTotalCount = " + addCount);
            logger.log("ArrayListLog.txt", "addTotalTime = " + addTotalTime);
            logger.log("ArrayListLog.txt", "addMedianTime = " + (addTotalTime / addCount));
            logger.log("ArrayListLog.txt", "removeTotalCount = " + removeCount);
            logger.log("ArrayListLog.txt", "removeTotalTime = " + removeTotalTime);
            logger.log("ArrayListLog.txt", "removeMedianTime = " + (removeTotalTime / removeCount));
            logger.log("ArrayListLog.txt", "Finish program: " + java.time.LocalDateTime.now());
            logger.log("ArrayListLog.txt", "Total time: " + totalTime + " ns");
        } catch (Exception e) {
            logger.log("ArrayListLog.txt", "Error: " + e.getMessage());
        }
        return res;
    }

    /**
     * Тестирует операции с LinkedList.
     * @param size Размер коллекции.
     */
    public static ArrayList<Long> testLinkedListOperations(int size) {
        List<Product> products = new LinkedList<>();
        RandomProductGenerator generator = new RandomProductGenerator();
        ArrayList<Long> res = new ArrayList<>(4);

        long startTime = System.nanoTime();
        long addTotalTime = 0;
        long removeTotalTime = 0;
        int addCount = 0;
        int removeCount = 0;

        try {
            logger.log("LinkedListLog.txt", "Start program: " + java.time.LocalDateTime.now());
            logger.log("LinkedListLog.txt", "LinkedList");

            for (int i = 0; i < size; i++) {
                Product product = generator.generateRandomProduct();
                long addStartTime = System.nanoTime();
                products.add(product);
                long addEndTime = System.nanoTime();
                long addTime = addEndTime - addStartTime;
                addTotalTime += addTime;
                addCount++;
                //logger.log("LinkedListLog.txt", "add, ID = " + i + ", " + addTime);
            }

            res.add(addTotalTime);
            res.add(addTotalTime / size);

            int removeCountTarget = size / 10;
            Random random = new Random();
            for (int i = 0; i < removeCountTarget; i++) {
                int index = random.nextInt(size);
                long removeStartTime = System.nanoTime();
                products.remove(index);
                long removeEndTime = System.nanoTime();
                long removeTime = removeEndTime - removeStartTime;
                removeTotalTime += removeTime;
                removeCount++;
                size--;
                //logger.log("LinkedListLog.txt", "remove, ID = " + index + ", " + removeTime);
            }

            res.add(removeTotalTime);
            res.add(removeTotalTime / removeCountTarget);
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;

            logger.log("LinkedListLog.txt", "addTotalCount = " + addCount);
            logger.log("LinkedListLog.txt", "addTotalTime = " + addTotalTime);
            logger.log("LinkedListLog.txt", "addMedianTime = " + (addTotalTime / addCount));
            logger.log("LinkedListLog.txt", "removeTotalCount = " + removeCount);
            logger.log("LinkedListLog.txt", "removeTotalTime = " + removeTotalTime);
            logger.log("LinkedListLog.txt", "removeMedianTime = " + (removeTotalTime / removeCount));
            logger.log("LinkedListLog.txt", "Finish program: " + java.time.LocalDateTime.now());
            logger.log("LinkedListLog.txt", "Total time: " + totalTime + " ns");
        } catch (Exception e) {
            logger.log("LinkedListLog.txt", "Error: " + e.getMessage());
        }
        return res;
    }
}

