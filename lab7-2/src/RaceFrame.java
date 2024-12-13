import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Класс, представляющий основное окно приложения.
 */
class RaceFrame extends JFrame {
    private RaceComponent comp;
    private volatile boolean isRunning;
    private Thread currentRaceThread;

    /**
     * Конструктор класса RaceFrame.
     */
    public RaceFrame() {
        comp = new RaceComponent();
        comp.setBackground(comp.getColor());
        add(comp, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Старт", new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                startRace();
            }
        });

        addButton(buttonPanel, "Закрыть", new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                stopRace();
                System.exit(0);
            }
        });

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Добавляет кнопку с заданным заголовком и слушателем событий в контейнер.
     *
     * @param c Контейнер.
     * @param title Заголовок кнопки.
     * @param listener Слушатель событий.
     */
    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * Запускает гонку.
     */
    public void startRace() {
        // Останавливаем предыдущий поток, если он существует
        stopRace();

        Racer racer1 = new Racer(0, 20);
        Racer racer2 = new Racer(0, 80);
        Racer racer3 = new Racer(0, 140);
        RaceComponent.add(racer1, racer2, racer3);

        isRunning = true;
        currentRaceThread = new Thread(new RaceRunnable(comp, racer1, racer2, racer3));
        currentRaceThread.start();
    }

    /**
     * Останавливает гонку.
     */
    public void stopRace() {
        if (currentRaceThread != null && currentRaceThread.isAlive()) {
            isRunning = false;
            try {
                currentRaceThread.join(1000); // Ждем завершения потока максимум 1 секунду
            } catch (InterruptedException e) {
                currentRaceThread.interrupt();
            }
        }
    }

    /**
     * Возвращает текущее состояние гонки.
     *
     * @return true, если гонка запущена, иначе false.
     */
    public boolean isRaceRunning() {
        return isRunning;
    }
}
