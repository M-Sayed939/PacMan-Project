package Project.Models;

import java.util.Random;

import static Project.Core.Utils.trX;
import static Project.Core.Utils.trY;

public class Ghost {
    Random random = new Random();
    public int step = 10;
    public static final int R = 10;
    public double x = 250, y = 250;
    public int ii = trX(x), jj = trY(y);

    public Directions direction = Directions.IDEAL;

    public Ghost() {
    }

    public Ghost(double x, double y) {
        this.x = x;
        this.y = y;
        ii = trX(x);
        jj = trY(y);
    }

    public void randMove() {
        int sw = random.nextInt(4);
        switch (sw) {
            case 0 -> {
                direction = Directions.UP;
            }
            case 1 -> {
                direction = Directions.RIGHT;

            }
            case 2 -> {
                direction = Directions.DOWN;
            }
            case 3 -> {
                direction = Directions.LEFT;
            }
        }
    }

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
