package snake.game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel {

    Snake snake = new Snake();

    Board() {
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);

        g.fillRect(snake.getX(), snake.getY(), 20, 20);
    }
}
