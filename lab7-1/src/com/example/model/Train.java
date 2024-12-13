package com.example.model;


import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Представляет поезд с потокобезопасной коллекцией вагонов и возможностью параллельной загрузки товаров.
 * Использует пул потоков для одновременной обработки различных типов грузов.
 */
public class Train {
    /** Потокобезопасная очередь вагонов. */
    private final ConcurrentLinkedQueue<Wagon> list = new ConcurrentLinkedQueue<>();

    /** Размер пула потоков, основанный на количестве доступных процессоров. */
    private final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors();

    /**
     * Добавляет вагон в состав поезда потокобезопасным способом.
     *
     * @param van вагон для добавления в состав
     */
    public void appendVan(Wagon van) {
        list.add(van);
    }

    /**
     * Возвращает текущее количество вагонов в составе.
     *
     * @return количество вагонов
     */
    public int getLength() {
        return list.size();
    }

    /**
     * Получает вагон по указанному индексу.
     * Создает временную копию списка для безопасного доступа по индексу.
     *
     * @param i индекс вагона
     * @return вагон на указанной позиции
     */
    public Wagon getVan(int i) {
        return new ArrayList<>(list).get(i);
    }

    /**
     * Возвращает список всех вагонов в виде ArrayList.
     *
     * @return новый ArrayList, содержащий все вагоны
     */
    public ArrayList<Wagon> getList() {
        return new ArrayList<>(list);
    }

    /**
     * Заменяет текущий список вагонов новым списком.
     *
     * @param newList новый список вагонов
     */
    public void setList(ArrayList<Wagon> newList) {
        list.clear();
        list.addAll(newList);
    }

    /**
     * Выполняет параллельную загрузку товаров в вагоны.
     * Создает пул потоков и распределяет задачи загрузки между ними.
     *
     * @return полностью загруженный состав поезда
     * @throws RuntimeException если произошла ошибка при загрузке товаров
     */
    public static Train loadingOfGoods() {
        Train train = new Train();
        ExecutorService executor = Executors.newFixedThreadPool(train.THREAD_POOL_SIZE);
        CompletionService<Void> completionService = new ExecutorCompletionService<>(executor);

        // Создаем задачи для каждого продукта
        for (Product product : Warehouse.getProducts()) {
            completionService.submit(new LoadingThread(train, product));
        }

        // Ожидаем завершения всех задач
        try {
            for (int i = 0; i < Warehouse.getProducts().length; i++) {
                completionService.take().get();
            }
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Ошибка при загрузке товаров", e);
        } finally {
            executor.shutdown();
        }

        return train;
    }
}