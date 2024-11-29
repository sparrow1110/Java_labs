package com.example.view;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Создание окна
 */
public class Frame extends JFrame {
    private int width = 1920;
    private int height = 1080;

    public Frame() {
        setTitle("Графики");
        setSize(this.width, this.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);

        Component graphComponent = new Component();
        JScrollPane scrollPane = new JScrollPane(graphComponent);
        this.add(scrollPane);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                repaint();
            }
        });

        setVisible(true);
    }
}