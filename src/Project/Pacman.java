package Project;



public class Pacman {
    int step = 10;
    int R = 5;
    double x=5,y=5;

    public Directions direction = Directions.Start;
    public void moveUP(){
        direction = Directions.UP;
        y-=step;
    }public void moveDown(){
        direction = Directions.DOWN;
        y+=step;
    }public void moveRight(){
        direction = Directions.RiGHT;
        x+=step;
    }public void moveLeft(){
        direction = Directions.LEFT;
        x-=step;
    }
}
