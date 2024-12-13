import java.awt.*;
import javax.swing.*;

/**
 * Класс, реализующий задачу гонки, которая выполняется в отдельном потоке.
 */
class RaceRunnable implements Runnable {
    private Racer player1, player2, player3;
    private Component component;
    private RaceFrame frame;
    public static final int DELAY = 5;

    /**
     * Конструктор класса RaceRunnable.
     *
     * @param aComponent Компонент, на котором происходит гонка.
     * @param aPlayer1 Первый игрок.
     * @param aPlayer2 Второй игрок.
     * @param aPlayer3 Третий игрок.
     */
    public RaceRunnable(Component aComponent, Racer aPlayer1, Racer aPlayer2, Racer aPlayer3) {
        component = aComponent;
        player1 = aPlayer1;
        player2 = aPlayer2;
        player3 = aPlayer3;
        frame = (RaceFrame)SwingUtilities.getWindowAncestor(aComponent);
    }

    /**
     * Метод, выполняющий основной цикл гонки.
     */
    public void run() {
        try {
            while(frame.isRaceRunning() &&
                    (player1.getX() < component.getBounds().getWidth()) &&
                    (player2.getX() < component.getBounds().getWidth()) &&
                    (player3.getX() < component.getBounds().getWidth())) {

                player1.move(component.getBounds(), 3);
                player2.move(component.getBounds(), 3);
                player3.move(component.getBounds(), 3);
                component.repaint();
                Thread.sleep(DELAY);
            }

            if (frame.isRaceRunning()) { // Проверяем, что гонка не была остановлена принудительно
                SwingUtilities.invokeLater(() -> {
                    if (player1.getX() >= component.getBounds().getWidth()) {
                        JOptionPane.showMessageDialog(null, "Победил первый!", "Result",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    if (player2.getX() >= component.getBounds().getWidth()) {
                        JOptionPane.showMessageDialog(null, "Победил второй!", "Result",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    if (player3.getX() >= component.getBounds().getWidth()) {
                        JOptionPane.showMessageDialog(null, "Победил третий!", "Result",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                });
            }
        }
        catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
