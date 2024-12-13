import java.awt.*;
import javax.swing.*;

/**
 * Класс, представляющий компонент для отображения гонки.
 */
class RaceComponent extends JPanel {
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;
    private static Color color = Color.GRAY;
    private static Racer[] players = new Racer[3];

    /**
     * Возвращает текущий цвет фона компонента.
     *
     * @return Цвет фона компонента.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Добавляет игроков в массив players.
     *
     * @param a Первый игрок.
     * @param b Второй игрок.
     * @param c Третий игрок.
     */
    public static void add(Racer a, Racer b, Racer c) {
        players[0] = a;
        players[1] = b;
        players[2] = c;
    }

    /**
     * Переопределяет метод paintComponent для рисования игроков на компоненте.
     *
     * @param g Объект Graphics для рисования.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Racer b : players) {
            if (b != null) {
                g2.setPaint(b.getColor());
                g2.fill(b.getShape());
                if (b.getX() >= DEFAULT_WIDTH) {
                    this.setBackground(b.getColor());
                    color = b.getColor();
                    g2.fill(b.getShape());
                }
            }
        }
    }

    /**
     * Возвращает предпочтительный размер компонента.
     *
     * @return Предпочтительный размер компонента.
     */
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
