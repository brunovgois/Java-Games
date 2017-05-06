package br.com.uniceub.PongGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Controller extends JPanel implements KeyListener {

    private boolean gameMenu = true;
    private boolean gameRunning = false;
    private boolean gameOver = false;

    private int ballX = 100;
    private int ballY = 100;
    private final int diameter = 20;

    private int ballXSpeed = 4;
    private int ballYSpeed = 3;
    private int pontuacaoX = 0;
    private int pontuacaoY = 0;
    // TODO deixar valores dinamicos
    private final int paddle1X = 5;
    private int paddle1Y = 190;

    private final int paddle2X = 464;
    private int paddle2Y = 190;

    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean wPressed = false;
    private boolean sPressed = false;

    private final int paddleHeight = 60;
    private final int paddleWidth = 10;
    private final int paddleSpeed = ballYSpeed * 2;
    // ~60 fps
    int delay = 15;

    
    public Controller() { //talvez nao seja muito bom chamar esses metodos no construtor
        setBackground(Color.BLACK);

        addKeyListener(this);
        setFocusable(true);
        Timer timer = new Timer(delay, (ActionEvent e) -> {
            RunGame();
        });
        timer.start();
    }

    public void RunGame() {

        if (gameRunning) {
            if (wPressed && paddle1Y > 4) { // paddle limitado pelo tamanho da tela
                paddle1Y = paddle1Y - paddleSpeed;

            } else if (sPressed && paddle1Y < 398) {
                paddle1Y = paddle1Y + paddleSpeed;
            }

            if (upPressed && paddle2Y > 4) {
                paddle2Y = paddle2Y - paddleSpeed;

            } else if (downPressed && paddle2Y < 398) {
                paddle2Y = paddle2Y + paddleSpeed;
            }

            if (ballY < 1 || ballY > 439) { // bola bateu na parede de cima/baixo
                ballYSpeed = -1 * ballYSpeed;
            }

            if (ballX > 450) { // bola esta perto da parede da direita
                if (ballY > paddle2Y - 4 && ballY < (paddle2Y + paddleHeight) + 4) { //bateu no paddle
                    ballXSpeed = -1 * ballXSpeed;
                } else {
                    pontuacaoX++;
                    ballX = 100;
                    ballY = 100;
                    ballXSpeed = 4;
                    ballYSpeed = 3;
                }
            }
            if (ballX < 10) { // bola esta perto da parede da esquerda
                if (ballY > paddle1Y - 4 && ballY < (paddle1Y + paddleHeight) + 4) {
                    ballXSpeed = -1 * ballXSpeed;
                } else {
                    pontuacaoY++;
                    ballX = 300;
                    ballY = 100;
                    ballXSpeed = -4;
                    ballYSpeed = 3;
                }
            }
            if (pontuacaoX >= 3) {
                System.out.println("Player one Wins");
                gameRunning = false;
                gameOver = true;
            }
            if (pontuacaoY >= 3) {
                System.out.println("Player two Wins");
                gameRunning = false;
                gameOver = true;
            }
            // posicao da bola sempre mudando
            ballX += ballXSpeed;
            ballY += ballYSpeed;
            repaint();

        }
    }

    // TODO  mudar paintComponent para GameView(usando get/set)
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(Color.WHITE);

        if (gameMenu) {
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 50));
            g.drawString("Pong", 165, 100);

            g.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
            g.drawString("PRESS SPACE TO PLAY", 150, 300);

            g.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
            g.drawString("Player one: Press W and S", 150, 380);
            g.drawString("Player two: Press UP and DOWN", 150, 410);
        }

        else if (gameRunning) {

            g.fillOval(ballX, ballY, diameter, diameter);
            g.fillRect(paddle1X, paddle1Y, paddleWidth, paddleHeight);
            g.fillRect(paddle2X, paddle2Y, paddleWidth, paddleHeight);

            String pontX = "0" + pontuacaoX; //transforma pontuacaoX (int) em String
            String pontY = "0" + pontuacaoY;

            g.drawString(pontX, (getWidth() / 2) - 25, 10);
            g.drawString(pontY, (getWidth() / 2) + 10, 10);
            g.drawLine(getWidth() / 2, 0, getWidth() / 2, 500);
        } else if (gameOver) {
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 50));
            g.drawString("GAME OVER", 100, 100);

            if (pontuacaoX >= 3) {
                g.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
                g.drawString("Player One Wins", 130, 300);
            } else if (pontuacaoY >= 3) {
                g.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
                g.drawString("Player Two Wins", 130, 300);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!gameRunning && gameMenu && e.getKeyCode() == KeyEvent.VK_SPACE) {
            gameMenu = false;
            gameRunning = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            wPressed = true;

        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            sPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            wPressed = false;

        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            sPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}