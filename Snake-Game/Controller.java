package snake.game;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Controller extends JPanel implements KeyListener {

    // ~60 fps
    int delay = 15;
    boolean upTyped = false;
    boolean downTyped = false;
    boolean leftTyped = false;
    boolean rightTyped = false;

    GameRules game = new GameRules();

    public Controller() {
        addKeyListener(this);
        setFocusable(true);
        Timer timer = new Timer(delay, (ActionEvent e) -> {
            game.runGame();
        });
        timer.start();
    }

    private void SnakeMove(boolean keyPress) {
        upTyped = false;
        downTyped = false;
        leftTyped = false;
        rightTyped = false;
        keyPress = true;
        System.out.println("Tecla pressioanda..");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            SnakeMove(upTyped);
            // upPressed = true;

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            SnakeMove(downTyped);
            // downPressed = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            SnakeMove(leftTyped);
            // leftPressed = true;

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            SnakeMove(rightTyped);
            // rightPressed = true;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
