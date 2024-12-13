import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Класс, представляющий игрока в гонке.
 */
class Racer {
    private int x = 0;
    private int y = 0;
    private static final int XSIZE = 50;
    private static final int YSIZE = 50;
    private Color color = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());

    /**
     * Конструктор класса Racer.
     *
     * @param a Начальная координата x.
     * @param b Начальная координата y.
     */
    public Racer(int a, int b) {
        x = a;
        y = b;
    }

    /**
     * Возвращает цвет игрока.
     *
     * @return Цвет игрока.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Перемещает игрока на случайное расстояние.
     *
     * @param bounds Границы компонента.
     * @param c Максимальное расстояние перемещения.
     */
    public void move(Rectangle2D bounds, int c) {
        x += Math.random() * c;
    }

    /**
     * Возвращает форму игрока.
     *
     * @return Форма игрока.
     */
    public Rectangle2D getShape() {
        return new Rectangle2D.Double(x, y, XSIZE, YSIZE);
    }

    /**
     * Возвращает текущую координату x игрока.
     *
     * @return Текущая координата x игрока.
     */
    public int getX() {
        return x + 50;
    }
}
