package com.example.model;


import java.io.File;
import java.util.Properties;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс InitialSettings загружает начальные настройки приложения из файла "initialSettings.txt".
 * Настройки включают информацию о пользователях, включая имя пользователя, пароль, права администратора,
 * включение логирования и автотестов.
 */
public class InitialSettings {

    /** Список пользователей. */
    public List<User> users;

    /**
     * Внутренний класс, представляющий пользователя.
     */
    public static class User {
        public String userName;
        public String password;
        public Boolean root;
        public Boolean log;
        public Boolean autotests;

        public User(String userName, String password, Boolean root, Boolean log, Boolean autotests) {
            this.userName = userName;
            this.password = password;
            this.root = root;
            this.log = log;
            this.autotests = autotests;
        }
    }

    /**
     * Конструктор класса InitialSettings загружает настройки из файла "initialSettings.txt".
     * Если какой-либо параметр не найден, используется значение по умолчанию (false для логирования и автотестов).
     *
     * @throws IOException если файл настроек не может быть прочитан.
     */
    public InitialSettings() throws IOException {
        users = new ArrayList<>();
        Properties props = new Properties();
        props.load(new FileInputStream(new File("initialSettings.txt")));

        int userCount = 0;
        while (true) {
            String userName = props.getProperty("userName" + userCount);
            if (userName == null) {
                break;
            }
            String password = props.getProperty("password" + userCount);
            Boolean root = Boolean.valueOf(props.getProperty("root" + userCount, "false"));
            Boolean log = Boolean.valueOf(props.getProperty("log" + userCount, "false"));
            Boolean autotests = Boolean.valueOf(props.getProperty("autotest" + userCount, "false"));

            users.add(new User(userName, password, root, log, autotests));
            userCount++;
        }
    }

    /**
     * Проверяет, существует ли пользователь с заданным именем и паролем.
     *
     * @param userName имя пользователя
     * @param password пароль пользователя
     * @return объект User, если пользователь найден, иначе null
     */
    public User authenticateUser(String userName, String password) {
        for (User user : users) {
            if (user.userName.equals(userName) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }
}