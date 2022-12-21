package Project.Maps.Map4;

import Project.AnimListener;
import Project.Directions;
import Project.Eating;
import Project.Pacman;


import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static Project.Utils.*;
import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.lang.Math.*;
import static java.lang.Math.toRadians;

public class Map4Listener extends AnimListener {

    Pacman pacman = new Pacman();
    ArrayList<Eating> eating = new ArrayList<>();

    int[][] map = new int[][]{
            {1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
            {0, 1, 1, 1, 0, 1, 1, 1, 1, 0},
            {0, 1, 0, 1, 1, 1, 0, 0, 1, 0},
            {0, 1, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
    };

    public void init(GLAutoDrawable gld) {

        GL gl = gld.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(0, 100, 100, 0, 0, 1.0);

        fillEating();
    }

    private void fillEating() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 1) { // eat
                    eating.add(new Eating(i, j));
                }
            }
        }
    }

    @Override
    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);


        drawBackground(gl);
        drawEating(gl);
        drawPacman(gl);

        handelPacmanMove();
        handelPacmanEating();

        handelWinning();

    }

    private void handelWinning() {
        if (eating.isEmpty()){ // Winning
            System.out.println("Win");
            System.exit(0);
        }
    }

    private void handelPacmanEating() {

        for (int i = 0; i < eating.size(); i++) {
            if (pacman.ii == eating.get(i).ii && pacman.jj == eating.get(i).jj) {
                System.out.println(i);
                eating.remove(i--);
            }
        }
    }

    private void handelPacmanMove() {
        switch (pacman.direction) {
            case IDEAL -> {
            }
            case UP -> {
                if (pacman.y - pacman.step < 0 || map[pacman.ii][pacman.jj - 1] == 0) return;
                pacman.moveUP();
            }
            case DOWN -> {
                if (pacman.y + pacman.step > 100 || map[pacman.ii][pacman.jj + 1] == 0) return;
                pacman.moveDown();
            }
            case RIGHT -> {
                if (pacman.x + pacman.step > 100 || map[pacman.ii + 1][pacman.jj] == 0) return;
                pacman.moveRight();
            }
            case LEFT -> {
                if (pacman.x - pacman.step < 0 || map[pacman.ii - 1][pacman.jj] == 0) return;
                pacman.moveLeft();
            }
        }
    }

    private void drawEating(GL gl) {
        for (Eating e : eating) {
            drawCircle(gl, 1, new Color(255, 255, 255), e.x, e.y);
        }
    }

    private void drawPacman(GL gl) {
        drawCircle(gl, Pacman.R, new Color(255, 255, 1), pacman.x, pacman.y);
    }

    private void drawCircle(GL gl, int r, Color color, double x, double y) {
        drawRegularRibs(gl, r, color, x, y);
    }

    private void drawRegularRibs(GL gl, int r, Color color, double x, double y) {
        gl.glColor3fv(color.getColorComponents(null), 0);
        gl.glBegin(GL.GL_POLYGON);
        int step = 1;
        for (int i = 0; i < 360; i += step)
            gl.glVertex2d(x + r * cos(toRadians(i)),
                    y + r * sin(toRadians(i)));

        gl.glEnd();
    }


    private void drawBackground(GL gl) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 0) { // blocks
                    drawRect(gl, arcTrX(i), arcTrY(j));
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_UP -> pacman.direction = Directions.UP;
            case VK_DOWN -> pacman.direction = Directions.DOWN;
            case VK_RIGHT -> pacman.direction = Directions.RIGHT;
            case VK_LEFT -> pacman.direction = Directions.LEFT;
            default -> pacman.direction = Directions.IDEAL;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_UP, VK_DOWN, VK_RIGHT, VK_LEFT -> {
                pacman.reset();
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }
}
