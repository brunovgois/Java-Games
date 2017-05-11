package snake.game;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main{
    public static void main(String[] args) {
     EventQueue.invokeLater(() -> {
            JFrame frame = new GameView();
            frame.setVisible(true);
             });
   
    }
    
}
