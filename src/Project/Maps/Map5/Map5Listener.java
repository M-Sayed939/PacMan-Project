package Project.Maps.Map5;

import Project.AnimListener;
import Project.Directions;
import Project.Eating;
import Project.Pacman;
import Project.texture.TextureReader;
import Project.*;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import javax.sound.sampled.Clip;

import static Project.Utils.*;
import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.lang.Math.*;
import static java.lang.Math.toRadians;

public class Map5Listener extends AnimListener {

    Pacman pacman = new Pacman();
    ArrayList<Eating> eating = new ArrayList<>();

    ArrayList<Ghosts> ghosts = new ArrayList<>();
    static int GHOSTS_SIZE = 4;
    Clip eatingSound, losingSound, winningSound;
    static final int MAX_X = 350;
    static final int MAX_Y = 260;

    String textureNames[] = {"Map.jpg","pacman.png","up.gif","down.gif","right.gif","left.gif","ghost.gif","food.png","food2.png"};
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];

    int[][] map = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    int row = map.length;
    int col = map[0].length;
    int animIndexForPacman = 1;
    int animIndexForFood = 7;

    public void init(GLAutoDrawable gld) {

        GL gl = gld.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        gl.glGenTextures(textureNames.length, textures, 0);

        {
            for (int i = 0; i < textureNames.length; i++) {
                try {
                    texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i], true);
                    gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);

//                mipmapsFromPNG(gl, new GLU(), texture[i]);
                    new GLU().gluBuild2DMipmaps(
                            GL.GL_TEXTURE_2D,
                            GL.GL_RGBA, // Internal Texel Format,
                            texture[i].getWidth(), texture[i].getHeight(),
                            GL.GL_RGBA, // External format from image,
                            GL.GL_UNSIGNED_BYTE,
                            texture[i].getPixels() // Imagedata
                    );
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(0, MAX_X, MAX_Y, 0, 0, 1.0);

        fillEating();

        addGhostsToArray();
        for (Ghosts g : ghosts) {
            g.randMove();
        }
    }

    private void addGhostsToArray() {
        for (int i = 0; i < GHOSTS_SIZE; i++) {
            ghosts.add(new Ghosts());
        }
    }

    private void fillEating() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 1) { // eat
                    eating.add(new Eating(j, i));
                }
            }
        }
    }

    @Override
    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        gl.glPushMatrix();
        int move = 10;
        gl.glTranslated(move, move, 0);
        {
            drawBackground(gl);
        }
        gl.glPopMatrix();

//        drawEating(gl);
//        drawPacman(gl);
//        drawGhost(gl);
//        handelPacmanMove();
//        handelPacmanEating();
////        handelGhostMove();
//        handelLose();
//        handelWinning();
    }

    private void handelLose() {
        for (Ghosts g : ghosts) {
            if (g.ii == pacman.ii && g.jj == pacman.jj) {
                synchronized (this) {
                    try {
                        if (eatingSound != null) eatingSound.stop();
                        losingSound = playMusic("src/Project/Assets/loser.wav", false);
                        wait(3000);
                        System.exit(0); // Show try again Frame
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

        }
    }

//    private void handelGhostMove() {
//        for (Ghosts g : ghosts) {
//            switch (g.direction) {
//                case IDEAL -> {
//                }
//                case UP -> {
//                    if (g.y - g.step < 0 || g.jj - 1 < 0 || map[g.jj - 1][g.ii] == 0) {
//                        g.randMove();
//                        return;
//                    }
//                    g.moveUP();
//                }
//                case DOWN -> {
//                    if (g.y + g.step > MAX_Y || g.jj + 1 >= row || map[g.jj + 1][g.ii] == 0) {
//                        g.randMove();
//                        return;
//                    }
//                    g.moveDown();
//                }
//                case RIGHT -> {
//                    if (g.x + g.step > MAX_X || g.ii + 1 >= col || map[g.jj][g.ii + 1] == 0) {
//                        g.randMove();
//                        return;
//                    }
//                    g.moveRight();
//                }
//                case LEFT -> {
//                    if (g.x - g.step < 0 || g.ii - 1 < 0 || map[g.jj][g.ii - 1] == 0) {
//                        g.randMove();
//                        return;
//                    }
//                    g.moveLeft();
//                }
//            }
//        }
//    }

    private void drawGhost(GL gl) {
        for (Ghosts g : ghosts) {
            DrawSprite(gl, (int) g.x, (int) g.y, 6, textures, 10);
        }
    }

    private void handelWinning() {
        if (eating.isEmpty()) { // Winning
            System.out.println("Win");
            if (eatingSound != null) eatingSound.stop();
            synchronized (this) {
                winningSound = playMusic("src/Project/Assets/pacman-victory.wav", false);
                if (winningSound != null) {
                    try {
                        wait(winningSound.getMicrosecondLength() / 1000);
                        System.exit(1); // Go Winning Frame
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            System.exit(1);
        }
    }

    int cnt;
    private void handelPacmanEating() {

        for (int i = 0; i < eating.size(); i++) {
            if (pacman.ii == eating.get(i).ii && pacman.jj == eating.get(i).jj) {
//                System.out.println(i);
                System.out.println(eating.size());
                if(cnt == 0){
                    eatingSound = playMusic("src/Project/Assets/eating.wav",true);
                }
                cnt++;
                eating.remove(i--);
            }
        }
    }

    private void handelPacmanMove() {
        if (isKeyPressed(VK_UP)) {
            pacman.direction = Directions.UP;
        }
        if (isKeyPressed(VK_DOWN)) {
            pacman.direction = Directions.DOWN;
        }
        if (isKeyPressed(VK_RIGHT)) {
            pacman.direction = Directions.RIGHT;
        }
        if (isKeyPressed(VK_LEFT)) {
            pacman.direction = Directions.LEFT;
        }
        if (!(isKeyPressed(VK_UP) || isKeyPressed(VK_DOWN) || isKeyPressed(VK_RIGHT) || isKeyPressed(VK_LEFT))) {
            pacman.direction = Directions.IDEAL;
        }

        switch (pacman.direction) {
            case IDEAL -> {
            }
            case UP -> {
                if (pacman.y - pacman.step < 0 || pacman.jj - 1 < 0 || map[pacman.jj - 1][pacman.ii] == 0) return;
                pacman.moveUP();
            }
            case DOWN -> {
                if (pacman.y + pacman.step > MAX_Y || pacman.jj + 1 >= row || map[pacman.jj + 1][pacman.ii] == 0)
                    return;
                pacman.moveDown();
            }
            case RIGHT -> {
                if (pacman.x + pacman.step > MAX_X || pacman.ii + 1 >= col || map[pacman.jj][pacman.ii + 1] == 0)
                    return;
                pacman.moveRight();
            }
            case LEFT -> {
                if (pacman.x - pacman.step < 0 || pacman.ii - 1 < 0 || map[pacman.jj][pacman.ii - 1] == 0) return;
                pacman.moveLeft();
            }
        }
    }

    private void drawEating(GL gl) {
        for (Eating e : eating) {
            DrawSprite(gl, (int) e.x, (int) e.y, animIndexForFood,textures,10);
        }
    }

    private void drawPacman(GL gl) {
        changeAnimIndex();
        DrawSprite(gl, (int) pacman.x, (int) pacman.y, animIndexForPacman,textures,10);
    }

//    private void drawCircle(GL gl, int r, Color color, double x, double y) {
//        drawRegularRibs(gl, r, color, x, y);
//    }
//
//    private void drawRegularRibs(GL gl, int r, Color color, double x, double y) {
//        gl.glColor3fv(color.getColorComponents(null), 0);
//        gl.glBegin(GL.GL_POLYGON);
//        int step = 1;
//        for (int i = 0; i < 360; i += step)
//            gl.glVertex2d(x + r * cos(toRadians(i)),
//                    y + r * sin(toRadians(i)));
//
//        gl.glEnd();
//    }

    private void changeAnimIndex() {
        switch (pacman.direction){
            case IDEAL -> {
                animIndexForPacman = 1;
            }
            case UP -> {
                if(animIndexForPacman == 1)
                    animIndexForPacman = 2;
                else if(animIndexForPacman == 2)
                    animIndexForPacman = 1;
            }
            case DOWN -> {
                if(animIndexForPacman == 1)
                    animIndexForPacman = 3;
                else if(animIndexForPacman == 3)
                    animIndexForPacman = 1;
            }
            case RIGHT -> {
                if(animIndexForPacman == 1)
                    animIndexForPacman = 4;
                else if(animIndexForPacman == 4)
                    animIndexForPacman = 1;
            }
            case LEFT -> {
                if(animIndexForPacman == 1)
                    animIndexForPacman = 5;
                else if(animIndexForPacman == 5)
                    animIndexForPacman = 1;
            }
        }
    }

    private void drawBackground(GL gl) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) { // blocks
                    double x = arcTrX(j) - 5, y = arcTrY(i) - 5;

                    drawRect(gl, x, y, 10, 10, 0, 0, 1);

                }
            }
        }
//        DrawSprite(gl, 0, 0, 0, textures, MAX_X - 10);
    }


    public BitSet keyBits = new BitSet(256);

    @Override
    public void keyPressed(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.set(keyCode);
    }

    @Override
    public void keyReleased(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.clear(keyCode);
    }

    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
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
