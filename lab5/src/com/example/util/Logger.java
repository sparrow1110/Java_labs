package com.example.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для логирования операций.
 */
public class Logger {
    private int errorCount;
    private List<String> errors;

    /**
     * Конструктор для создания логгера.
     */
    public Logger() {
        this.errorCount = 0;
        this.errors = new ArrayList<>();
    }

    /**
     * Записывает сообщение в лог-файл.
     * @param logFilePath Путь к лог-файлу.
     * @param message Сообщение для записи.
     */
    public void log(String logFilePath, String message) {
        try (FileWriter fileWriter = new FileWriter(logFilePath, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(message);
        } catch (IOException e) {
            logError(e.getMessage());
        }
    }

    /**
     * Записывает сообщение об ошибке.
     * @param message Сообщение об ошибке.
     */
    private void logError(String message) {
        System.err.println("Error: " + message);
        errors.add(message);
        errorCount++;
    }

    /**
     * Возвращает количество ошибок.
     * @return Количество ошибок.
     */
    public int getErrorCount() {
        return errorCount;
    }

    /**
     * Возвращает список ошибок.
     * @return Список ошибок.
     */
    public List<String> getErrors() {
        return errors;
    }
}
