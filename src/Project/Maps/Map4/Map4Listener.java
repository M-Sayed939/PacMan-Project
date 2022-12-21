package Project.Maps.Map4;

import Project.AnimListener;


import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import java.awt.event.KeyEvent;

import static Project.Utils.*;

public class Map4Listener extends AnimListener {
    private static final int MAX_X = 100;
    private static final int MIN_X = 0;
    private static final int MAX_Y = 100;
    private static final int MIN_Y = 0;

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

        gl.glOrtho(MIN_X, MAX_X, MIN_Y, MAX_Y, -1.0, 1.0);
    }

    @Override
    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();

        drawBackground(gl);
    }


    private void drawBackground(GL gl) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 1) {
                    System.out.println((int) arcTrX(i)+" "+ (int) arcTrY(j));
                    drawRect(gl, 1.01, 0.0);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }
}
