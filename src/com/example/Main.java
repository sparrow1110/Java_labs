package com.example;
/**
 * Главный класс программы, который управляет взаимодействием между моделью и представлением.
 */
public class Main {
    /**
     * Точка входа в программу.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        UnitConverter model = new UnitConverter();
        UnitConverterView view = new UnitConverterView();

        try {
            double[] input = view.getUserInput();
            double[][] results = model.convertAll(input[0], input[1]);
            view.displayResults(results);
        } catch (IllegalArgumentException e) {
            view.displayError(e.getMessage());
        }
    }
}
