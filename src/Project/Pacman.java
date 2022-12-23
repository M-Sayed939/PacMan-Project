package Project;

public class Pacman {
    public int step = 10;
    public int r = 5;
    public double x = 5, y = 5;

    public Directions direction = Directions.IDEAL;


    public void moveUp(){
        direction = Directions.UP;
        y-=step;
    }
    public void moveDown(){
        direction = Directions.DOWN;
        y+=step;
    }
    public void moveRight(){
        direction = Directions.RIGHT;
        x+=step;
    }
    public void moveLeft(){
        direction = Directions.LEFT;
        x-=step;
    }

    public void reset(){
        direction = Directions.IDEAL;
    }
}
