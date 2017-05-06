package br.com.uniceub.PongGame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GameView {

    public GameView() {
        initComponents();
    }

    private void initComponents() {

        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        Controller board = new Controller();
        frame.add(board, BorderLayout.CENTER);

        // TODO deixar tamanho janela dinamico, atualmente, jogo n pode mudar de tamanho
        frame.setSize(500, 515);
        frame.setVisible(true);

    }

}
