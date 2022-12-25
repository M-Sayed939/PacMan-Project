package Project;


import static Project.Utils.*;

public class Pacman {
    public static final int r = 10;
    public int step = 10;
    public int ii = 1, jj = 1;
    public double x = 15, y = 15;

    public Directions direction = Directions.IDEAL;

    public void moveUP() {
        direction = Directions.UP;
        y -= step;
        jj = trY(y);
    }

    public void moveDown() {
        direction = Directions.DOWN;
        y += step;
        jj = trY(y);
    }

    public void moveRight() {
        direction = Directions.RIGHT;
        x += step;
        ii = trX(x);
    }

    public void moveLeft() {
        direction = Directions.LEFT;
        x -= step;
        ii = trX(x);
    }

    public void reset() {
        direction = Directions.IDEAL;
    }
}
