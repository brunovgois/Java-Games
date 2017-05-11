package snake.game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel {

    Board() {
        setBackground(Color.BLACK);
        new Controller();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);

        g.fillRect(100, 50, 20, 20);
    }
}
