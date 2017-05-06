package br.com.uniceub.PongGame;

import java.awt.EventQueue;


public class Main {

    public static void main(String[] args) {
    	
    	 EventQueue.invokeLater(() -> {
             new GameView();
             });

    }

}