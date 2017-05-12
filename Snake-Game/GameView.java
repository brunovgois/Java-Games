package snake.game;

import javax.swing.JFrame;

public class GameView extends JFrame {

    GameView() {
        setResizable(false);
        pack();
        setSize(500, 500);
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new Controller();
        Board board = new Board();
        add(board);
    }

}
