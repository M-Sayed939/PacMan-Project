package Project.Models;


import static Project.Core.Utils.*;

public class Pacman {
    public int step = 10;
    public static final int R = 10;
    public double x = 15, y = 15;
    public int ii = trX(x), jj = trY(y);

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
        x = y = 15;
        ii = jj = trX(x);
    }
}
