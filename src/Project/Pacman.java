package Project;


import static Project.Utils.*;

public class Pacman {
    public int step = 10;
    public static final int R = 3;
    public double x = 5, y = 5;
    public int ii = 0, jj = 0;

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

    public void reset(){
        direction = Directions.IDEAL;
    }
}
