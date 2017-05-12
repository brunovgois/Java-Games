package snake.game;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class Controller extends Board implements KeyListener {

    // ~60 fps
    int delay = 15;
    boolean upPressed = false;
    boolean downPressed = false;
    boolean leftPressed = false;
    boolean rightPressed = false;
    int snakeSpeedX = 2, snakeSpeedY = 2;

    Snake snake = new Snake();

    public Controller() {
        addKeyListener(this);
        setFocusable(true);
        Timer timer = new Timer(delay, (ActionEvent e) -> {
            gameRun();
        });
        timer.start();

    }

    void gameRun() {

        snake.setX(snake.getX() + snakeSpeedX);
        snake.setY(snake.getY() + snakeSpeedY);

        System.out.println("X/Y = " + snake.getX() + "/" + snake.getY()); // debug
        super.repaint(); // problema de heranca, paint() deve ser feito no JPanel ou JFrame?
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
