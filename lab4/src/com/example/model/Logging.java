package com.example.model;


import com.example.controller.Controller;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Logging {

    public final static ArrayList<Exception> errList = new ArrayList<>();

    private InitialSettings.User user;

    private boolean debugging;

    public Logging(InitialSettings.User user) {
        this.user = user;
        this.debugging = user.log;
    }


    public void AddANote(String message) {
        System.out.println(debugging);
        if (debugging) {
            try (FileWriter writer = new FileWriter("Log.txt", true)) {
                writer.write(LocalDate.now().toString() + " " + LocalTime.now().toString() + " " + message + "\n");
            } catch (IOException exc) {
                errList.add(exc);
                Controller.controllerPrintMessage("Ошибка открытия файла");
            }
        }
    }

    public void ToggleDebugging() {
        if (debugging) {
            AddANote("Отладка выключена");
        }
        debugging = !debugging;
        System.out.println(1);
        System.out.println(debugging);
        if (debugging) {
            AddANote("Отладка включена");
        }
    }
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