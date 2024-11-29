package com.example.view;

import com.example.controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Построение графиков
 */
public class Component extends JComponent {
    ArrayList<Long> dataA10 = new ArrayList<>();
    ArrayList<Long> dataA100 = new ArrayList<>();
    ArrayList<Long> dataA1000 = new ArrayList<>();
    ArrayList<Long> dataA10000 = new ArrayList<>();
    ArrayList<Long> dataA100000 = new ArrayList<>();

    ArrayList<Long> dataL10 = new ArrayList<>();
    ArrayList<Long> dataL100 = new ArrayList<>();
    ArrayList<Long> dataL1000 = new ArrayList<>();
    ArrayList<Long> dataL10000 = new ArrayList<>();
    ArrayList<Long> dataL100000 = new ArrayList<>();

    public Component() {
        try {
            dataA10 = Main.controllerComponentList(10);
            dataA100 = Main.controllerComponentList(100);
            dataA1000 = Main.controllerComponentList(1000);
            dataA10000 = Main.controllerComponentList(10000);
            dataA100000 = Main.controllerComponentList(100000);

            dataL10 = Main.controllerComponentLinkedList(10);
            dataL100 = Main.controllerComponentLinkedList(100);
            dataL1000 = Main.controllerComponentLinkedList(1000);
            dataL10000 = Main.controllerComponentLinkedList(10000);
            dataL100000 = Main.controllerComponentLinkedList(100000);
        } catch (IOException e) {
            e.printStackTrace();
            // Вы можете также вывести сообщение об ошибке или завершить выполнение программы
        }
    }

    /**
     * Построение графиков
     * @param g the <code>Graphics</code> object to protect
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        double scaleX = width / 1920.0;
        double scaleY = height / 1080.0;

        g2.scale(scaleX, scaleY);

        // Рамки
        Rectangle2D border1 = new Rectangle2D.Double(5, 20, 950, 970);
        Rectangle2D border2 = new Rectangle2D.Double(965, 20, 950, 970);
        g2.draw(border1);
        g2.draw(border2);

        // Названия
        g2.drawString("Total Time", 430, 35);
        g2.drawString("Median Time", 430 + 955, 35);

        // Оси
        Line2D oY1 = new Line2D.Double(60, 30, 60, 950);
        Line2D oX1 = new Line2D.Double(60, 950, 900, 950);
        Line2D oY2 = new Line2D.Double(1020, 30, 1020, 950);
        Line2D oX2 = new Line2D.Double(1020, 950, 1860, 950);

        g2.draw(oX1);
        g2.drawString("Count", 870, 935);
        g2.draw(oY1);
        g2.drawString("Time, ms", 7, 40);
        g2.draw(oX2);
        g2.drawString("Count", 1830, 935);
        g2.draw(oY2);
        g2.drawString("Time, ns", 967, 40);

        // Метки на осях
        Line2D numberOfElements10 = new Line2D.Double(60 + 160, 945, 60 + 160, 955);
        Line2D numberOfElements100 = new Line2D.Double(60 + 160 * 2, 945, 60 + 160 * 2, 955);
        Line2D numberOfElements1000 = new Line2D.Double(60 + 160 * 3, 945, 60 + 160 * 3, 955);
        Line2D numberOfElements10000 = new Line2D.Double(60 + 160 * 4, 945, 60 + 160 * 4, 955);
        Line2D numberOfElements100000 = new Line2D.Double(60 + 160 * 5, 945, 60 + 160 * 5, 955);
        g2.draw(numberOfElements10);
        g2.drawString("10", 60 + 160 - 5, 965);
        g2.draw(numberOfElements100);
        g2.drawString("100", 60 + 160 * 2 - 5, 965);
        g2.draw(numberOfElements1000);
        g2.drawString("1000", 60 + 160 * 3 - 5, 965);
        g2.draw(numberOfElements10000);
        g2.drawString("10000", 60 + 160 * 4 - 5, 965);
        g2.draw(numberOfElements100000);
        g2.drawString("100000", 60 + 160 * 5 - 5, 965);

        Line2D number1OfElements10 = new Line2D.Double(1020 + 160, 945, 1020 + 160, 955);
        Line2D number1OfElements100 = new Line2D.Double(1020 + 160 * 2, 945, 1020 + 160 * 2, 955);
        Line2D number1OfElements1000 = new Line2D.Double(1020 + 160 * 3, 945, 1020 + 160 * 3, 955);
        Line2D number1OfElements10000 = new Line2D.Double(1020 + 160 * 4, 945, 1020 + 160 * 4, 955);
        Line2D number1OfElements100000 = new Line2D.Double(1020 + 160 * 5, 945, 1020 + 160 * 5, 955);
        g2.draw(number1OfElements10);
        g2.drawString("10", 1020 + 160 - 5, 965);
        g2.draw(number1OfElements100);
        g2.drawString("100", 1020 + 160 * 2 - 5, 965);
        g2.draw(number1OfElements1000);
        g2.drawString("1000", 1020 + 160 * 3 - 5, 965);
        g2.draw(number1OfElements10000);
        g2.drawString("10000", 1020 + 160 * 4 - 5, 965);
        g2.draw(number1OfElements100000);
        g2.drawString("100000", 1020 + 160 * 5 - 5, 965);

        Line2D time1 = new Line2D.Double(55, 950 - Math.log10(10000) * 90 - 3, 65, 950 - Math.log10(10000) * 90 - 3);
        Line2D time2 = new Line2D.Double(55, 950 - Math.log10(100000) * 90 - 3, 65, 950 - Math.log10(100000) * 90 - 3);
        Line2D time3 = new Line2D.Double(55, 950 - Math.log10(1000000) * 90 - 3, 65, 950 - Math.log10(1000000) * 90 - 3);
        Line2D time4 = new Line2D.Double(55, 950 - Math.log10(10000000) * 90 - 3, 65, 950 - Math.log10(10000000) * 90 - 3);
        Line2D time5 = new Line2D.Double(55, 950 - Math.log10(100000000) * 90 - 3, 65, 950 - Math.log10(100000000) * 90 - 3);
        Line2D time6 = new Line2D.Double(55, 950 - Math.log10(1000000000) * 90 - 3, 65, 950 - Math.log10(1000000000) * 90 - 3);
        //Line2D time7 = new Line2D.Double(55, 950 - 90 * 7, 65, 950 - 90 * 7);
        //Line2D time8 = new Line2D.Double(55, 950 - 90 * 8, 65, 950 - 90 * 8);
        //Line2D time9 = new Line2D.Double(55, 950 - 90 * 9, 65, 950 - 90 * 9);
        //Line2D time10 = new Line2D.Double(55, 950 - 90 * 10, 65, 950 - 90 * 10);

        g2.draw(time1);
        g2.drawString("0.01", 55 + 10, (int) (950 - Math.log10(10000) * 90 - 3));
        g2.draw(time2);
        g2.drawString("0.1", 55 + 10, (int) (950 - Math.log10(100000) * 90 - 3));
        g2.draw(time3);
        g2.drawString("1", 55 + 10, (int) (950 - Math.log10(1000000) * 90 - 3));
        g2.draw(time4);
        g2.drawString("10", 55 + 10, (int) (950 - Math.log10(10000000) * 90 - 3));
        g2.draw(time5);
        g2.drawString("100", 55 + 10, (int) (950 - Math.log10(100000000) * 90 - 3));
        g2.draw(time6);
        g2.drawString("1000", 55 + 10, (int) (950 - Math.log10(1000000000) * 90 - 3));

        //g2.draw(time7);
        //g2.drawString("210", 55 + 10, 950 - 90 * 7 + 5);
        //g2.draw(time8);
        //g2.drawString("240", 55 + 10, 950 - 90 * 8 + 5);
        //g2.draw(time9);
        //g2.drawString("270", 55 + 10, 950 - 90 * 9 + 5);
        //g2.draw(time10);
        //g2.drawString("300", 55 + 10, 950 - 90 * 10 + 5);

        Line2D time01 = new Line2D.Double(1015, 950 - Math.log10(100) * 90, 1025, 950 - Math.log10(100) * 90);
        Line2D time02 = new Line2D.Double(1015, 950 - Math.log10(1000) * 90, 1025, 950 - Math.log10(1000) * 90);
        Line2D time03 = new Line2D.Double(1015, 950 - Math.log10(10000) * 90, 1025, 950 - Math.log10(10000) * 90);
        Line2D time04 = new Line2D.Double(1015, 950 - Math.log10(100000) * 90, 1025, 950 - Math.log10(100000) * 90);
        Line2D time05 = new Line2D.Double(1015, 950 - Math.log10(1000000) * 90, 1025, 950 - Math.log10(1000000) * 90);
        //Line2D time06 = new Line2D.Double(1015, 950 - 90 * 6, 1025, 950 - 90 * 6);
        //Line2D time07 = new Line2D.Double(1015, 950 - 90 * 7, 1025, 950 - 90 * 7);
        //Line2D time08 = new Line2D.Double(1015, 950 - 90 * 8, 1025, 950 - 90 * 8);
        //Line2D time09 = new Line2D.Double(1015, 950 - 90 * 9, 1025, 950 - 90 * 9);
        //Line2D time010 = new Line2D.Double(1015, 950 - 90 * 10, 1025, 950 - 90 * 10);
        g2.draw(time01);
        g2.drawString("100", 1015 + 10, (int) (950 - Math.log10(100) * 90));
        g2.draw(time02);
        g2.drawString("1000", 1015 + 10, (int)(950 - Math.log10(1000) * 90));
        g2.draw(time03);
        g2.drawString("10000", 1015 + 10, (int) (950 - Math.log10(10000) * 90));
        g2.draw(time04);
        g2.drawString("100000", 1015 + 10, (int) (950 - Math.log10(100000) * 90));
        g2.draw(time05);
        g2.drawString("1000000", 1015 + 10, (int)(950 - Math.log10(1000000) * 90));
        //g2.draw(time06);
        //g2.drawString("18000", 1015 + 10, 950 - 90 * 6);
        //g2.draw(time07);
        //g2.drawString("21000", 1015 + 10, 950 - 90 * 7);
        //g2.draw(time08);
        //g2.drawString("24000", 1015 + 10, 950 - 90 * 8);
        //g2.draw(time09);
        //g2.drawString("27000", 1015 + 10, 950 - 90 * 9);
        //g2.draw(time010);
        //g2.drawString("30000", 1015 + 10, 950 - 90 * 10);


        // Точки
        Ellipse2D ArrAddTotal10 = new Ellipse2D.Double(numberOfElements10.getX1() - 3, 950 - Math.log10(dataA10.get(0)) * 90 - 3, 6, 6);
        Ellipse2D ArrRemTotal10 = new Ellipse2D.Double(numberOfElements10.getX1() - 3, 950 - Math.log10(dataA10.get(2)) * 90 - 3, 6, 6);
        Ellipse2D ArrAddMedian10 = new Ellipse2D.Double(number1OfElements10.getX1() - 3, 950 - Math.log10(dataA10.get(1)) * 90 - 3, 6, 6);
        Ellipse2D ArrRemMedian10 = new Ellipse2D.Double(number1OfElements10.getX1() - 3, 950 - Math.log10(dataA10.get(3)) * 90 - 3, 6, 6);

        Ellipse2D ArrAddTotal100 = new Ellipse2D.Double(numberOfElements100.getX1() - 3, 950 - Math.log10(dataA100.get(0)) * 90 - 3, 6, 6);
        Ellipse2D ArrRemTotal100 = new Ellipse2D.Double(numberOfElements100.getX1() - 3, 950 - Math.log10(dataA100.get(2)) * 90 - 3, 6, 6);
        Ellipse2D ArrAddMedian100 = new Ellipse2D.Double(number1OfElements100.getX1() - 3, 950 - Math.log10(dataA100.get(1)) * 90 - 3, 6, 6);
        Ellipse2D ArrRemMedian100 = new Ellipse2D.Double(number1OfElements100.getX1() - 3, 950 - Math.log10(dataA100.get(3)) * 90 - 3, 6, 6);

        Ellipse2D ArrAddTotal1000 = new Ellipse2D.Double(numberOfElements1000.getX1() - 3, 950 - Math.log10(dataA1000.get(0)) * 90 - 3, 6, 6);
        Ellipse2D ArrRemTotal1000 = new Ellipse2D.Double(numberOfElements1000.getX1() - 3, 950 - Math.log10(dataA1000.get(2)) * 90 - 3, 6, 6);
        Ellipse2D ArrAddMedian1000 = new Ellipse2D.Double(number1OfElements1000.getX1() - 3, 950 - Math.log10(dataA1000.get(1)) * 90 - 3, 6, 6);
        Ellipse2D ArrRemMedian1000 = new Ellipse2D.Double(number1OfElements1000.getX1() - 3, 950 - Math.log10(dataA1000.get(3)) * 90 - 3, 6, 6);

        System.out.println(Math.log10(dataA1000.get(2)));
        System.out.println(dataA1000.get(2));
        Ellipse2D ArrAddTotal10000 = new Ellipse2D.Double(numberOfElements10000.getX1() - 3, 950 - Math.log10(dataA10000.get(0)) * 90 - 3, 6, 6);
        Ellipse2D ArrRemTotal10000 = new Ellipse2D.Double(numberOfElements10000.getX1() - 3, 950 - Math.log10(dataA10000.get(2)) * 90 - 3, 6, 6);
        Ellipse2D ArrAddMedian10000 = new Ellipse2D.Double(number1OfElements10000.getX1() - 3, 950 - Math.log10(dataA10000.get(1)) * 90 - 3, 6, 6);
        Ellipse2D ArrRemMedian10000 = new Ellipse2D.Double(number1OfElements10000.getX1() - 3, 950 - Math.log10(dataA10000.get(3)) * 90 - 3, 6, 6);

        Ellipse2D ArrAddTotal100000 = new Ellipse2D.Double(numberOfElements100000.getX1() - 3, 950 - Math.log10(dataA100000.get(0)) * 90 - 3, 6, 6);
        Ellipse2D ArrRemTotal100000 = new Ellipse2D.Double(numberOfElements100000.getX1() - 3, 950 - Math.log10(dataA100000.get(2)) * 90 - 3, 6, 6);
        Ellipse2D ArrAddMedian100000 = new Ellipse2D.Double(number1OfElements100000.getX1() - 3, 950 - Math.log10(dataA100000.get(1)) * 90 - 3, 6, 6);
        Ellipse2D ArrRemMedian100000 = new Ellipse2D.Double(number1OfElements100000.getX1() - 3, 950 - Math.log10(dataA100000.get(3)) * 90 - 3, 6, 6);

        Ellipse2D LinkedAddTotal10 = new Ellipse2D.Double(numberOfElements10.getX1() - 3, 950 - Math.log10(dataL10.get(0)) * 90 - 3, 6, 6);
        Ellipse2D LinkedRemTotal10 = new Ellipse2D.Double(numberOfElements10.getX1() - 3, 950 - Math.log10(dataL10.get(2)) * 90 - 3, 6, 6);
        Ellipse2D LinkedAddMedian10 = new Ellipse2D.Double(number1OfElements10.getX1() - 3, 950 - Math.log10(dataL10.get(1)) * 90 - 3, 6, 6);
        Ellipse2D LinkedRemMedian10 = new Ellipse2D.Double(number1OfElements10.getX1() - 3, 950 - Math.log10(dataL10.get(3)) * 90 - 3, 6, 6);

        Ellipse2D LinkedAddTotal100 = new Ellipse2D.Double(numberOfElements100.getX1() - 3, 950 - Math.log10(dataL100.get(0)) * 90 - 3, 6, 6);
        Ellipse2D LinkedRemTotal100 = new Ellipse2D.Double(numberOfElements100.getX1() - 3, 950 - Math.log10(dataL100.get(2)) * 90 - 3, 6, 6);
        Ellipse2D LinkedAddMedian100 = new Ellipse2D.Double(number1OfElements100.getX1() - 3, 950 - Math.log10(dataL100.get(1)) * 90 - 3, 6, 6);
        Ellipse2D LinkedRemMedian100 = new Ellipse2D.Double(number1OfElements100.getX1() - 3, 950 - Math.log10(dataL100.get(3)) * 90 - 3, 6, 6);

        Ellipse2D LinkedAddTotal1000 = new Ellipse2D.Double(numberOfElements1000.getX1() - 3, 950 - Math.log10(dataL1000.get(0)) * 90 - 3, 6, 6);
        Ellipse2D LinkedRemTotal1000 = new Ellipse2D.Double(numberOfElements1000.getX1() - 3, 950 - Math.log10(dataL1000.get(2)) * 90 - 3, 6, 6);
        Ellipse2D LinkedAddMedian1000 = new Ellipse2D.Double(number1OfElements1000.getX1() - 3, 950 - Math.log10(dataL1000.get(1)) * 90 - 3, 6, 6);
        Ellipse2D LinkedRemMedian1000 = new Ellipse2D.Double(number1OfElements1000.getX1() - 3, 950 - Math.log10(dataL1000.get(3)) * 90 - 3, 6, 6);

        Ellipse2D LinkedAddTotal10000 = new Ellipse2D.Double(numberOfElements10000.getX1() - 3, 950 - Math.log10(dataL10000.get(0)) * 90 - 3, 6, 6);
        Ellipse2D LinkedRemTotal10000 = new Ellipse2D.Double(numberOfElements10000.getX1() - 3, 950 - Math.log10(dataL10000.get(2)) * 90 - 3, 6, 6);
        Ellipse2D LinkedAddMedian10000 = new Ellipse2D.Double(number1OfElements10000.getX1() - 3, 950 - Math.log10(dataL10000.get(1)) * 90 - 3, 6, 6);
        Ellipse2D LinkedRemMedian10000 = new Ellipse2D.Double(number1OfElements10000.getX1() - 3, 950 - Math.log10(dataL10000.get(3)) * 90 - 3, 6, 6);

        Ellipse2D LinkedAddTotal100000 = new Ellipse2D.Double(numberOfElements100000.getX1() - 3, 950 - Math.log10(dataL100000.get(0)) * 90 - 3, 6, 6);
        Ellipse2D LinkedRemTotal100000 = new Ellipse2D.Double(numberOfElements100000.getX1() - 3, 950 - Math.log10(dataL100000.get(2)) * 90 - 3, 6, 6);
        Ellipse2D LinkedAddMedian100000 = new Ellipse2D.Double(number1OfElements100000.getX1() - 3, 950 - Math.log10(dataL100000.get(1)) * 90 - 3, 6, 6);
        Ellipse2D LinkedRemMedian100000 = new Ellipse2D.Double(number1OfElements100000.getX1() - 3, 950 - Math.log10(dataL100000.get(3)) * 90 - 3, 6, 6);

        // Рисуем точки и линии
        g2.setColor(Color.RED);
        g2.drawString("- ArrAddTotal", 860, 35);
        g2.draw(ArrAddTotal10);
        g2.draw(new Line2D.Double(ArrAddTotal10.getCenterX(), ArrAddTotal10.getCenterY(), ArrAddTotal100.getCenterX(), ArrAddTotal100.getCenterY()));
        g2.draw(ArrAddTotal100);
        g2.draw(new Line2D.Double(ArrAddTotal100.getCenterX(), ArrAddTotal100.getCenterY(), ArrAddTotal1000.getCenterX(), ArrAddTotal1000.getCenterY()));
        g2.draw(ArrAddTotal1000);
        g2.draw(new Line2D.Double(ArrAddTotal1000.getCenterX(), ArrAddTotal1000.getCenterY(), ArrAddTotal10000.getCenterX(), ArrAddTotal10000.getCenterY()));
        g2.draw(ArrAddTotal10000);
        g2.draw(new Line2D.Double(ArrAddTotal10000.getCenterX(), ArrAddTotal10000.getCenterY(), ArrAddTotal100000.getCenterX(), ArrAddTotal100000.getCenterY()));
        g2.draw(ArrAddTotal100000);

        g2.drawString("- ArrAddMedian", 1810, 35);
        g2.draw(ArrAddMedian10);
        g2.draw(new Line2D.Double(ArrAddMedian10.getCenterX(), ArrAddMedian10.getCenterY(), ArrAddMedian100.getCenterX(), ArrAddMedian100.getCenterY()));
        g2.draw(ArrAddMedian100);
        g2.draw(new Line2D.Double(ArrAddMedian100.getCenterX(), ArrAddMedian100.getCenterY(), ArrAddMedian1000.getCenterX(), ArrAddMedian1000.getCenterY()));
        g2.draw(ArrAddMedian1000);
        g2.draw(new Line2D.Double(ArrAddMedian1000.getCenterX(), ArrAddMedian1000.getCenterY(), ArrAddMedian10000.getCenterX(), ArrAddMedian10000.getCenterY()));
        g2.draw(ArrAddMedian10000);
        g2.draw(new Line2D.Double(ArrAddMedian10000.getCenterX(), ArrAddMedian10000.getCenterY(), ArrAddMedian100000.getCenterX(), ArrAddMedian100000.getCenterY()));
        g2.draw(ArrAddMedian100000);

        g2.setColor(Color.BLUE);
        g2.drawString("- ArrRemTotal", 860, 45);
        g2.draw(ArrRemTotal10);
        g2.draw(new Line2D.Double(ArrRemTotal10.getCenterX(), ArrRemTotal10.getCenterY(), ArrRemTotal100.getCenterX(), ArrRemTotal100.getCenterY()));
        g2.draw(ArrRemTotal100);
        g2.draw(new Line2D.Double(ArrRemTotal100.getCenterX(), ArrRemTotal100.getCenterY(), ArrRemTotal1000.getCenterX(), ArrRemTotal1000.getCenterY()));
        g2.draw(ArrRemTotal1000);
        g2.draw(new Line2D.Double(ArrRemTotal1000.getCenterX(), ArrRemTotal1000.getCenterY(), ArrRemTotal10000.getCenterX(), ArrRemTotal10000.getCenterY()));
        g2.draw(ArrRemTotal10000);
        g2.draw(new Line2D.Double(ArrRemTotal10000.getCenterX(), ArrRemTotal10000.getCenterY(), ArrRemTotal100000.getCenterX(), ArrRemTotal100000.getCenterY()));
        g2.draw(ArrRemTotal100000);

        g2.drawString("- ArrRemMedian", 1810, 45);
        g2.draw(ArrRemMedian10);
        g2.draw(new Line2D.Double(ArrRemMedian10.getCenterX(), ArrRemMedian10.getCenterY(), ArrRemMedian100.getCenterX(), ArrRemMedian100.getCenterY()));
        g2.draw(ArrRemMedian100);
        g2.draw(new Line2D.Double(ArrRemMedian100.getCenterX(), ArrRemMedian100.getCenterY(), ArrRemMedian1000.getCenterX(), ArrRemMedian1000.getCenterY()));
        g2.draw(ArrRemMedian1000);
        g2.draw(new Line2D.Double(ArrRemMedian1000.getCenterX(), ArrRemMedian1000.getCenterY(), ArrRemMedian10000.getCenterX(), ArrRemMedian10000.getCenterY()));
        g2.draw(ArrRemMedian10000);
        g2.draw(new Line2D.Double(ArrRemMedian10000.getCenterX(), ArrRemMedian10000.getCenterY(), ArrRemMedian100000.getCenterX(), ArrRemMedian100000.getCenterY()));
        g2.draw(ArrRemMedian100000);

        g2.setColor(Color.MAGENTA);
        g2.drawString("- LinkedAddTotal", 860, 55);
        g2.draw(LinkedAddTotal10);
        g2.draw(new Line2D.Double(LinkedAddTotal10.getCenterX(), LinkedAddTotal10.getCenterY(), LinkedAddTotal100.getCenterX(), LinkedAddTotal100.getCenterY()));
        g2.draw(LinkedAddTotal100);
        g2.draw(new Line2D.Double(LinkedAddTotal100.getCenterX(), LinkedAddTotal100.getCenterY(), LinkedAddTotal1000.getCenterX(), LinkedAddTotal1000.getCenterY()));
        g2.draw(LinkedAddTotal1000);
        g2.draw(new Line2D.Double(LinkedAddTotal1000.getCenterX(), LinkedAddTotal1000.getCenterY(), LinkedAddTotal10000.getCenterX(), LinkedAddTotal10000.getCenterY()));
        g2.draw(LinkedAddTotal10000);
        g2.draw(new Line2D.Double(LinkedAddTotal10000.getCenterX(), LinkedAddTotal10000.getCenterY(), LinkedAddTotal100000.getCenterX(), LinkedAddTotal100000.getCenterY()));
        g2.draw(LinkedAddTotal100000);

        g2.drawString("- LinkedAddMedian", 1810, 55);
        g2.draw(LinkedAddMedian10);
        g2.draw(new Line2D.Double(LinkedAddMedian10.getCenterX(), LinkedAddMedian10.getCenterY(), LinkedAddMedian100.getCenterX(), LinkedAddMedian100.getCenterY()));
        g2.draw(LinkedAddMedian100);
        g2.draw(new Line2D.Double(LinkedAddMedian100.getCenterX(), LinkedAddMedian100.getCenterY(), LinkedAddMedian1000.getCenterX(), LinkedAddMedian1000.getCenterY()));
        g2.draw(LinkedAddMedian1000);
        g2.draw(new Line2D.Double(LinkedAddMedian1000.getCenterX(), LinkedAddMedian1000.getCenterY(), LinkedAddMedian10000.getCenterX(), LinkedAddMedian10000.getCenterY()));
        g2.draw(LinkedAddMedian10000);
        g2.draw(new Line2D.Double(LinkedAddMedian10000.getCenterX(), LinkedAddMedian10000.getCenterY(), LinkedAddMedian100000.getCenterX(), LinkedAddMedian100000.getCenterY()));
        g2.draw(LinkedAddMedian100000);

        g2.setColor(Color.BLACK);
        g2.drawString("- LinkedRemTotal", 860, 65);
        g2.draw(LinkedRemTotal10);
        g2.draw(new Line2D.Double(LinkedRemTotal10.getCenterX(), LinkedRemTotal10.getCenterY(), LinkedRemTotal100.getCenterX(), LinkedRemTotal100.getCenterY()));
        g2.draw(LinkedRemTotal100);
        g2.draw(new Line2D.Double(LinkedRemTotal100.getCenterX(), LinkedRemTotal100.getCenterY(), LinkedRemTotal1000.getCenterX(), LinkedRemTotal1000.getCenterY()));
        g2.draw(LinkedRemTotal1000);
        g2.draw(new Line2D.Double(LinkedRemTotal1000.getCenterX(), LinkedRemTotal1000.getCenterY(), LinkedRemTotal10000.getCenterX(), LinkedRemTotal10000.getCenterY()));
        g2.draw(LinkedRemTotal10000);
        g2.draw(new Line2D.Double(LinkedRemTotal10000.getCenterX(), LinkedRemTotal10000.getCenterY(), LinkedRemTotal100000.getCenterX(), LinkedRemTotal100000.getCenterY()));
        g2.draw(LinkedRemTotal100000);

        g2.drawString("- LinkedRemMedian", 1810, 65);
        g2.draw(LinkedRemMedian10);
        g2.draw(new Line2D.Double(LinkedRemMedian10.getCenterX(), LinkedRemMedian10.getCenterY(), LinkedRemMedian100.getCenterX(), LinkedRemMedian100.getCenterY()));
        g2.draw(LinkedRemMedian100);
        g2.draw(new Line2D.Double(LinkedRemMedian100.getCenterX(), LinkedRemMedian100.getCenterY(), LinkedRemMedian1000.getCenterX(), LinkedRemMedian1000.getCenterY()));
        g2.draw(LinkedRemMedian1000);
        g2.draw(new Line2D.Double(LinkedRemMedian1000.getCenterX(), LinkedRemMedian1000.getCenterY(), LinkedRemMedian10000.getCenterX(), LinkedRemMedian10000.getCenterY()));
        g2.draw(LinkedRemMedian10000);
        g2.draw(new Line2D.Double(LinkedRemMedian10000.getCenterX(), LinkedRemMedian10000.getCenterY(), LinkedRemMedian100000.getCenterX(), LinkedRemMedian100000.getCenterY()));
        g2.draw(LinkedRemMedian100000);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1920, 1080);
    }
}

