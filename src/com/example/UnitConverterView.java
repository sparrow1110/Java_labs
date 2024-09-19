package com.example;
import java.util.Scanner;

/**
 * Класс для взаимодействия с пользователем и отображения результатов.
 */
public class UnitConverterView {
    private Scanner scanner;

    /**
     * Конструктор класса UnitConverterView.
     */
    public UnitConverterView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Отображает результаты перевода величин.
     *
     * @param results двумерный массив, где первый элемент содержит футы и дюймы, а второй элемент — аршины и вершки
     */
    public void displayResults(double[][] results) {
        System.out.println("Результат в английских величинах:\nФуты: " + (int)results[0][0] + "\nДюймы: " + (int)results[0][1] + "\n");
        System.out.println("Результат в старорусских величинах:\nАршины: " + (int)results[1][0] + "\nВершки: " + (int)results[1][1]);
    }

    /**
     * Отображает сообщение об ошибке.
     *
     * @param errorMessage сообщение об ошибке
     */
    public void displayError(String errorMessage) {
        System.out.println("Ошибка: " + errorMessage);
    }

    /**
     * Запрашивает у пользователя ввод метров и сантиметров.
     *
     * @return массив, содержащий метры и сантиметры
     * @throws IllegalArgumentException если ввод не является числовым значением
     */
    public double[] getUserInput() {
        try {
            System.out.print("Введите метры: ");
            double meters = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите сантиметры: ");
            double centimeters = Double.parseDouble(scanner.nextLine());
            return new double[]{meters, centimeters};
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный ввод. Пожалуйста, введите числовые значения.");
        }
    }
}
