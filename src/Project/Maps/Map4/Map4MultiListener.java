
package Project.Maps.Map4;

import Project.Core.AnimListener;
import Project.Core.texture.TextureReader;
import Project.Maps.Map2.Map2;
import Project.Models.Directions;
import Project.Models.Eating;
import Project.Models.Ghost;
import Project.Models.Pacman;
import Project.Pages.GameOver;
import Project.Pages.Player1Winner;
import Project.Pages.Player2Winner;
import Project.Pages.WinnerPage;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLException;
import javax.media.opengl.glu.GLU;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

import static Project.Core.Utils.*;
import static Project.Maps.Map4.Map4Listener.userName;
import static java.awt.event.KeyEvent.*;
import static java.lang.Math.*;

public class Map4MultiListener extends AnimListener {

    Pacman pacman = new Pacman();
    Pacman pacman2 = new Pacman();
    public static String userName1 = "";
    public static String userName2 = "";

    JFrame frame = null;
    Clip eatingSound, losingSound, winningSound;

    int cntFood;
    int cntFood2;
//    int cntLives = 3;

    int time;
    Timer timer = new Timer(1000, e -> {
        time++;
    });

    ArrayList<Eating> eating = new ArrayList<>();
    static final int MAX_X = 240;
    static final int MAX_Y = 250;

    ArrayList<Ghost> ghosts = new ArrayList<>();
    static int GHOSTS_SIZE = 4;

    int animIndexForPacman = 1;
    int animIndexForPacman2 = 1;
    //int animIndexForFood = 1;

    String[] textureNames = {
            "map4.jpg", // 0
            "pacman.png", // 1
            "up.gif", // 2
            "down.gif", // 3
            "right.gif", // 4
            "left.gif", // 5
            "ghost.gif", // 6
            "food.png", // 7
            "food2.png", // 8
    };
    TextureReader.Texture[] texture = new TextureReader.Texture[textureNames.length];
    int[] textures = new int[textureNames.length];

    int[][] map = new int[][]{
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0},
            {0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    int row = map.length;
    int col = map[0].length;

    int highScore = ReadHighScore();

    public static void AddHighScore(int score) {


        try (FileWriter f = new FileWriter("Score.txt", false);
             Scanner input = new Scanner(new File("Score.txt"))) {
            int highScore = input.hasNext() ? input.nextInt() : 0;
            if (score > highScore) highScore = score;
            f.write(highScore + "");
            f.flush();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static int ReadHighScore() {
        try (Scanner input = new Scanner(new File("Score.txt"));) {
            return (input.hasNext()) ? input.nextInt() : 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    boolean pause;

    public void init(GLAutoDrawable gld) {

        GL gl = gld.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        {
            gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
            gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
            gl.glGenTextures(textureNames.length, textures, 0);

            for (int i = 0; i < textureNames.length; i++) {
                try {
                    texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i], true);
                    gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);

                    new GLU().gluBuild2DMipmaps(
                            GL.GL_TEXTURE_2D,
                            GL.GL_RGBA, // Internal Texel Format,
                            texture[i].getWidth(), texture[i].getHeight(),
                            GL.GL_RGBA, // External format from image,
                            GL.GL_UNSIGNED_BYTE,
                            texture[i].getPixels() // Image data
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
        for (Ghost g : ghosts) {
            g.randMove();
        }
        timer.start();
    }

    private void addGhostsToArray() {
        for (int i = 0; i < GHOSTS_SIZE; i++) {
            ghosts.add(new Ghost(200, 200));
        }
    }

    private void fillEating() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 1) {//eat
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
        int move = 3;
        gl.glTranslated(move, move, 0);
        {
            drawBackground(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        double f = 1;
        double d = 3;
        gl.glTranslated(d, d, 1);
        gl.glScaled(f, f, 1);
        {
            drawEating(gl);
            drawPacman(gl);
            drawPacman2(gl);
            drawGhost(gl);
        }
        gl.glPopMatrix();

        handelPacmanMove();
        handelPacman2Move();
        handelPacmanEating();
        handelGhostMove();
        handelLose();
        handelWinning();
        handelPacman2Eating();

        try {
            drawString(gl, 10, MAX_Y-3 , "Score 1: " + cntFood);  // Score
            drawString(gl, 45, MAX_Y-3 , "Score 2: " + cntFood2);  // Score
//            drawString(gl, 45, MAX_Y-3 , "Lives: " + cntLives); // Lives
            drawString(gl, 80, MAX_Y-3 , "Time: " + time); // Time
//            drawString(gl, 110, MAX_Y-3 , "HighScore: " + highScore); // Time
            drawString(gl, 110, MAX_Y-3 , "  P1: " + userName); // User1
            drawString(gl, 180, MAX_Y-3 , "  P2: " + userName2); // User2
        } catch (GLException e) {
            System.out.println(e.getMessage());
        }
        if (cntFood > highScore) {
            AddHighScore(cntFood);
            highScore = ReadHighScore();
        }

    }


    private void handelGhostMove() {
        for (Ghost g : ghosts) {
            switch (g.direction) {
                case IDEAL -> {
                }
                case UP -> {
                    if (g.y - g.step < 0 || g.jj - 1 < 0 || map[g.jj - 1][g.ii] == 0) {
                        g.randMove();
                        return;
                    }
                    g.moveUP();
                }
                case DOWN -> {
                    if (g.y + g.step > MAX_Y || g.jj + 1 >= row || map[g.jj + 1][g.ii] == 0) {
                        g.randMove();
                        return;
                    }
                    g.moveDown();
                }
                case RIGHT -> {
                    if (g.x + g.step > MAX_X || g.ii + 1 >= col || map[g.jj][g.ii + 1] == 0) {
                        g.randMove();
                        return;
                    }
                    g.moveRight();
                }
                case LEFT -> {
                    if (g.x - g.step < 0 || g.ii - 1 < 0 || map[g.jj][g.ii - 1] == 0) {
                        g.randMove();
                        return;
                    }
                    g.moveLeft();
                }
            }
        }
    }

    private void drawGhost(GL gl) {
        for (Ghost g : ghosts) {
            DrawSprite(gl, (int) g.x-5, (int) g.y-5, 6, textures, Ghost.R);
        }
    }


    private void handelWinning() {
        if (eating.isEmpty()) {
            if (cntFood > cntFood2) {
                System.out.println("Player 1 Win");
                frame.dispose();
                new Player1Winner().setVisible(true);
            } else if (cntFood < cntFood2) {
                System.out.println("Player 2 Win");
                frame.dispose();
                new Player2Winner().setVisible(true);
            } else {
                System.out.println("Draw");
                frame.dispose();
                new WinnerPage().setVisible(true);
            }
            if (eatingSound != null) eatingSound.stop();


        }
    }



    private void handelLose() {
        for (Ghost g : ghosts) {
            if (g.ii == pacman.ii && g.jj == pacman.jj) {
                if (eatingSound != null) eatingSound.stop();
                frame.dispose();
                new Player2Winner().setVisible(true);
            } else if (g.ii == pacman2.ii && g.jj == pacman2.jj) {
                if (eatingSound != null) eatingSound.stop();
                frame.dispose();
                new Player1Winner().setVisible(true);
            }
        }
    }

    private void handelPacmanEating() {
        for (int i = 0; i < eating.size(); i++) {
            if (pacman.ii == eating.get(i).ii && pacman.jj == eating.get(i).jj) {
                cntFood++;
                if (eatingSound == null || !eatingSound.isRunning()) {
                    eatingSound = playMusic("src/Project/Assets/pacman-wakawaka.wav", false);
                }
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
            DrawSprite(gl, (int) e.x, (int) e.y, 7, textures, 4);
        }
    }

    private void drawPacman(GL gl) {
        // check Dir for motion
        changeAnimIndex();

        DrawSprite(gl, (int) pacman.x-5, (int) pacman.y-5, animIndexForPacman, textures, Pacman.R);
    }

    private void changeAnimIndex() {
        switch (pacman.direction) {
            case IDEAL -> {
                animIndexForPacman = 1;
            }
            case UP -> { // 2
                if (animIndexForPacman == 1) animIndexForPacman = 2;
                else if (animIndexForPacman == 2) animIndexForPacman = 1;
            }
            case DOWN -> { // 3

                if (animIndexForPacman == 1) animIndexForPacman = 3;
                else if (animIndexForPacman == 3) animIndexForPacman = 1;
            }
            case RIGHT -> { // 4

                if (animIndexForPacman == 1) animIndexForPacman = 4;
                else if (animIndexForPacman == 4) animIndexForPacman = 1;
            }
            case LEFT -> { // 5

                if (animIndexForPacman == 1) animIndexForPacman = 5;
                else if (animIndexForPacman == 5) animIndexForPacman = 1;
            }
        }
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
        DrawSprite(gl, (int) 0.5, (int) 0.5, 0, textures, MAX_X);

    }
    ////////////Player 2///////////////////////
    private void handelPacman2Eating() {

        for (int i = 0; i < eating.size(); i++) {
            if (pacman2.ii == eating.get(i).ii && pacman2.jj == eating.get(i).jj) {
                cntFood2++;
                System.out.println(eating.size());
                if (eatingSound == null || !eatingSound.isRunning()) {
                    eatingSound = playMusic("src/Project/Assets/pacman-wakawaka.wav", false);
                }
                eating.remove(i--);
            }
        }
    }

    private void handelPacman2Move() {
        if (isKeyPressed(VK_W)) {
            pacman2.direction = Directions.UP;
        }
        if (isKeyPressed(VK_S)) {
            pacman2.direction = Directions.DOWN;
        }
        if (isKeyPressed(VK_D)) {
            pacman2.direction = Directions.RIGHT;
        }
        if (isKeyPressed(VK_A)) {
            pacman2.direction = Directions.LEFT;
        }
        if (!(isKeyPressed(VK_W) || isKeyPressed(VK_S) || isKeyPressed(VK_D) || isKeyPressed(VK_A))) {
            pacman2.direction = Directions.IDEAL;
        }

        switch (pacman2.direction) {
            case IDEAL -> {
            }
            case UP -> {
                if (pacman2.y - pacman2.step < 0 || pacman2.jj - 1 < 0 || map[pacman2.jj - 1][pacman2.ii] == 0) return;
                pacman2.moveUP();
            }
            case DOWN -> {
                if (pacman2.y + pacman2.step > MAX_Y || pacman2.jj + 1 >= row || map[pacman2.jj + 1][pacman2.ii] == 0)
                    return;
                pacman2.moveDown();
            }
            case RIGHT -> {
                if (pacman2.x + pacman2.step > MAX_X || pacman2.ii + 1 >= col || map[pacman2.jj][pacman2.ii + 1] == 0)
                    return;
                pacman2.moveRight();
            }
            case LEFT -> {
                if (pacman2.x - pacman2.step < 0 || pacman2.ii - 1 < 0 || map[pacman2.jj][pacman2.ii - 1] == 0) return;
                pacman2.moveLeft();
            }
        }
    }

    private void drawPacman2(GL gl) {
        changeAnim2Index();

        DrawSprite(gl, (int) pacman2.x-5, (int) pacman2.y-5, animIndexForPacman2, textures, Pacman.R);
    }

    private void changeAnim2Index() {
        switch (pacman2.direction) {
            case IDEAL -> {
                animIndexForPacman2 = 1;
            }
            case UP -> { // 2
                if (animIndexForPacman2 == 1) animIndexForPacman2 = 2;
                else if (animIndexForPacman2 == 2) animIndexForPacman2 = 1;
            }
            case DOWN -> { // 3

                if (animIndexForPacman2 == 1) animIndexForPacman2 = 3;
                else if (animIndexForPacman2 == 3) animIndexForPacman2 = 1;
            }
            case RIGHT -> { // 4

                if (animIndexForPacman2 == 1) animIndexForPacman2 = 4;
                else if (animIndexForPacman2 == 4) animIndexForPacman2 = 1;
            }
            case LEFT -> { // 5

                if (animIndexForPacman2 == 1) animIndexForPacman2 = 5;
                else if (animIndexForPacman2 == 5) animIndexForPacman2 = 1;
            }
        }
    }


    public BitSet keyBits = new BitSet(256);

    @Override
    public void keyPressed(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.set(keyCode);
        if (event.getKeyCode() == VK_SPACE) {
            pause = !pause;
            if (!pause) {
                timer.start();
                Map4Multi.animator.start();
            } else {
                timer.stop();
                Map4Multi.animator.stop();
                JOptionPane.showMessageDialog(null, "Enter SpaceBar To Continue", "Attention", JOptionPane.WARNING_MESSAGE);

            }

        }

    }


    @Override
    public void keyReleased(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.clear(keyCode);
        switch (keyCode) {
            case VK_UP, VK_DOWN, VK_RIGHT, VK_LEFT -> pacman.direction = Directions.IDEAL;
            case VK_W, VK_S, VK_D, VK_A -> pacman2.direction = Directions.IDEAL;

        }
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


