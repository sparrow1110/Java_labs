package com.example.view;

import java.util.Scanner;

/**
 * Класс {@code View} отвечает за взаимодействие с пользователем.
 * Он обеспечивает ввод и вывод данных, предоставляя простые методы для работы с консолью.
 */
public class View {
    public static Scanner in = new Scanner(System.in);

    /**
     * Считывает строку, введённую пользователем с консоли.
     *
     * @return Введённая строка.
     */
    public static String viewInput() {
        return in.nextLine();
    }

    /**
     * Отображает сообщение пользователю в консоли.
     *
     * @param message Сообщение для отображения.
     */
    public static void viewMessage(String message) {
        System.out.println(message);
    }

    /**
     * Отображает целое число пользователю в консоли.
     *
     * @param number Целое число для отображения.
     */
    public static void viewNumber(int number) {
        System.out.println(number);
    }

    /**
     * Запрашивает строковый ввод у пользователя, предварительно отображая сообщение.
     *
     * @param message Сообщение для отображения перед запросом ввода.
     * @return Введённая строка.
     */
    public static String viewGetString(String message) {
        System.out.println(message);
        return in.nextLine();
    }
}
