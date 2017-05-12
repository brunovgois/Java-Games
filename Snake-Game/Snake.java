package snake.game;

public class Snake {

    private int x = 50;
    private int y = 100;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Snake() {
    }

}
