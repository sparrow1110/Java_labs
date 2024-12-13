import java.awt.*;
import javax.swing.*;

/**
 * Основной класс приложения, содержащий метод main.
 */
public class Race {
    /**
     * Точка входа в приложение.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new RaceFrame();
                frame.setTitle("Гонки");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
