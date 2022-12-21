package Project;


public class Pacman {
    public int step = 10;
    public static final int R = 5;
    public double x = 5, y = 5;
    public int ii = 0, jj = 0;

    public Directions direction = Directions.IDEAL;

    public void moveUP() {
        direction = Directions.UP;
        y -= step;
        jj--;
    }

    public void moveDown() {
        direction = Directions.DOWN;
        y += step;
        jj++;
    }

    public void moveRight() {
        direction = Directions.RIGHT;
        x += step;
        ii++;
    }

    public void moveLeft() {
        direction = Directions.LEFT;
        x -= step;
        ii--;
    }

    public void reset(){
        direction = Directions.IDEAL;
    }
}
