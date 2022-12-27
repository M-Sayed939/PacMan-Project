package Project.Maps.Map2;

import Project.Core.AnimListener;
import Project.Core.texture.TextureReader;
import Project.Models.Directions;
import Project.Models.Eating;
import Project.Models.Ghost;
import Project.Models.Pacman;
import Project.Pages.*;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLException;
import javax.media.opengl.glu.GLU;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;

import static Project.Core.Utils.*;
import static Project.Core.Utils.DrawSprite;
import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_LEFT;

public class Map22Listener extends AnimListener {
    JFrame frame = null;
    Clip EatingSound;
    Pacman pacman = new Pacman();
    Pacman pacman2 = new Pacman();
    public static String userName1 = "";
    public static String userName2 = "";
    int CountFood, Count2Food, HighScore;
    //    int Lives = 3;
    boolean pause = false;
    int time;
    Timer timer = new Timer(1000, e -> {
        time++;
    });
    ArrayList<Project.Models.Eating> Eating = new ArrayList<>();
    ArrayList<Ghost> ghosts = new ArrayList<>();
    static int No_Of_Ghosts = 4;
    public static final int MAX_X = 620;
    public static final int MAX_Y = 265;
    int AnimIndexForPacman = 1;
    int AnimIndexForPacman2 = 1;
    int AnimIndexForFood = 7;
    String[] textureNames = {
            "mapp2.jpg", // 0
            "pacman.png", // 1
            "up.gif", // 2
            "down.gif", // 3
            "right.gif", // 4
            "left.gif", // 5
            "ghost.gif", // 6
            "foodd.png", // 7
    };
    TextureReader.Texture[] texture = new TextureReader.Texture[textureNames.length];
    int[] textures = new int[textureNames.length];
    int[][] Map = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

    };
    int row = Map.length;
    int column = Map[0].length;

    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        /*gl.glClearColor(0, 0, 0, 1f);*/
        {
            gl.glEnable(GL.GL_TEXTURE_2D);
            gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
            gl.glGenTextures(textureNames.length, textures, 0);
            for (int i = 0; i < textureNames.length; i++) {
                try {
                    texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i], true);
                    gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);

                    new GLU().gluBuild2DMipmaps(
                            GL.GL_TEXTURE_2D,
                            GL.GL_RGBA,
                            texture[i].getWidth(), texture[i].getHeight(),
                            GL.GL_RGBA,
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
        startTimer();
    }

    private void addGhostsToArray() {
        for (int i = 0; i < No_Of_Ghosts; i++) {
            ghosts.add(new Ghost());
        }
    }

    private void fillEating() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i % 2 == 0 && j % 3 == 0)
                    if (Map[i][j] == 1) { // eat
                        Eating.add(new Eating(j, i));
                    }
            }
        }
    }

    @Override
    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        gl.glPushMatrix();
        int move = 5;
        gl.glTranslated(8, move, 0);
        gl.glScaled(1, 0.44, 1);
        {
            drawBackground(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslated(8, move, 0);
        gl.glScaled(0.95, 0.93, 1);
        {
            drawEating(gl);
            drawPacman(gl);
            drawGhost(gl);
            drawPacman2(gl);
        }
        gl.glPopMatrix();

        handelPacmanMove();
        handelPacmanEating();
        handelPacman2Move();
        handelPacman2Eating();

        handelGhostMove();
//        System.out.println(Eating.size());

        handelLose();
        try {
            drawString(gl, 8, 8, "P1 Score:" + CountFood + "   P2Score:" + Count2Food + "    Time:" + time + "   Player1:" + userName1 + "    Player2:" + userName2); // Lives Score Time
        } catch (GLException e) {
            System.out.println(e.getMessage());
        }

        handelWinning();

    }

    private void startTimer() {
        timer.start();
    }


    private void handelLose() {
        for (Ghost g : ghosts) {
            if (g.ii == pacman.ii && g.jj == pacman.jj) {
                if (EatingSound != null) EatingSound.stop();
                frame.dispose();
                new Player2Winner().setVisible(true);
            } else if (g.ii == pacman2.ii && g.jj == pacman2.jj) {
                if (EatingSound != null) EatingSound.stop();
                frame.dispose();
                new Player1Winner().setVisible(true);
            }
        }
    }


    private void handelGhostMove() {
        for (Ghost g : ghosts) {
            switch (g.direction) {
                case IDEAL -> {
                }
                case UP -> {
                    if (g.y - g.step < 0 || g.jj - 1 < 0 || Map[g.jj - 1][g.ii] == 0) {
                        g.randMove();
                        return;
                    }
                    g.moveUP();
                }
                case DOWN -> {
                    if (g.y + g.step > MAX_Y || g.jj + 1 >= row || Map[g.jj + 1][g.ii] == 0) {
                        g.randMove();
                        return;
                    }
                    g.moveDown();
                }
                case RIGHT -> {
                    if (g.x + g.step > MAX_X || g.ii + 1 >= column || Map[g.jj][g.ii + 1] == 0) {
                        g.randMove();
                        return;
                    }
                    g.moveRight();
                }
                case LEFT -> {
                    if (g.x - g.step < 0 || g.ii - 1 < 0 || Map[g.jj][g.ii - 1] == 0) {
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
            DrawSprite(gl, (int) g.x, (int) g.y, 6, textures, 15);
        }
    }

    private void handelWinning() {
        if (Eating.isEmpty()) {
            if (CountFood > Count2Food) {
                System.out.println("Player 1 Win");
                frame.dispose();
                new Player1Winner().setVisible(true);
            } else if (CountFood < Count2Food) {
                System.out.println("Player 2 Win");
                frame.dispose();
                new Player2Winner().setVisible(true);
            } else {
                System.out.println("Draw");
                frame.dispose();
                new WinnerPage().setVisible(true);
            }
            if (EatingSound != null) EatingSound.stop();


        }
    }


    private void handelPacmanEating() {

        for (int i = 0; i < Eating.size(); i++) {
            if (pacman.ii == Eating.get(i).ii && pacman.jj == Eating.get(i).jj) {
                CountFood++;
                System.out.println(Eating.size());
                if (EatingSound == null || !EatingSound.isRunning()) {
                    EatingSound = playMusic("src/Project/Assets/pacman-wakawaka.wav", false);
                }
                Eating.remove(i--);
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
                if (pacman.y - pacman.step < 0 || pacman.jj - 1 < 0 || Map[pacman.jj - 1][pacman.ii] == 0) return;
                pacman.moveUP();
            }
            case DOWN -> {
                if (pacman.y + pacman.step > MAX_Y || pacman.jj + 1 >= row || Map[pacman.jj + 1][pacman.ii] == 0)
                    return;
                pacman.moveDown();
            }
            case RIGHT -> {
                if (pacman.x + pacman.step > MAX_X || pacman.ii + 1 >= column || Map[pacman.jj][pacman.ii + 1] == 0)
                    return;
                pacman.moveRight();
            }
            case LEFT -> {
                if (pacman.x - pacman.step < 0 || pacman.ii - 1 < 0 || Map[pacman.jj][pacman.ii - 1] == 0) return;
                pacman.moveLeft();
            }
        }
    }


    private void drawEating(GL gl) {
        for (Eating e : Eating) {
            DrawSprite(gl, (int) e.x, (int) e.y, AnimIndexForFood, textures, 12);
        }
    }

    private void drawPacman(GL gl) {
        changeAnimIndex();

        DrawSprite(gl, (int) pacman.x, (int) pacman.y, AnimIndexForPacman, textures, 15);
    }


    private void changeAnimIndex() {
        switch (pacman.direction) {
            case IDEAL -> {
                AnimIndexForPacman = 1;
            }
            case UP -> { // 2
                if (AnimIndexForPacman == 1) AnimIndexForPacman = 2;
                else if (AnimIndexForPacman == 2) AnimIndexForPacman = 1;
            }
            case DOWN -> { // 3

                if (AnimIndexForPacman == 1) AnimIndexForPacman = 3;
                else if (AnimIndexForPacman == 3) AnimIndexForPacman = 1;
            }
            case RIGHT -> { // 4

                if (AnimIndexForPacman == 1) AnimIndexForPacman = 4;
                else if (AnimIndexForPacman == 4) AnimIndexForPacman = 1;
            }
            case LEFT -> { // 5

                if (AnimIndexForPacman == 1) AnimIndexForPacman = 5;
                else if (AnimIndexForPacman == 5) AnimIndexForPacman = 1;
            }
        }
    }


    private void drawBackground(GL gl) {
        DrawSprite(gl, 0, 0, 0, textures, MAX_X - 10);
    }

    ////////////Player 2///////////////////////
    private void handelPacman2Eating() {

        for (int i = 0; i < Eating.size(); i++) {
            if (pacman2.ii == Eating.get(i).ii && pacman2.jj == Eating.get(i).jj) {
                Count2Food++;
                System.out.println(Eating.size());
                if (EatingSound == null || !EatingSound.isRunning()) {
                    EatingSound = playMusic("src/Project/Assets/pacman-wakawaka.wav", false);
                }
                Eating.remove(i--);
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
                if (pacman2.y - pacman2.step < 0 || pacman2.jj - 1 < 0 || Map[pacman2.jj - 1][pacman2.ii] == 0) return;
                pacman2.moveUP();
            }
            case DOWN -> {
                if (pacman2.y + pacman2.step > MAX_Y || pacman2.jj + 1 >= row || Map[pacman2.jj + 1][pacman2.ii] == 0)
                    return;
                pacman2.moveDown();
            }
            case RIGHT -> {
                if (pacman2.x + pacman2.step > MAX_X || pacman2.ii + 1 >= column || Map[pacman2.jj][pacman2.ii + 1] == 0)
                    return;
                pacman2.moveRight();
            }
            case LEFT -> {
                if (pacman2.x - pacman2.step < 0 || pacman2.ii - 1 < 0 || Map[pacman2.jj][pacman2.ii - 1] == 0) return;
                pacman2.moveLeft();
            }
        }
    }

    private void drawPacman2(GL gl) {
        changeAnim2Index();

        DrawSprite(gl, (int) pacman2.x, (int) pacman2.y, AnimIndexForPacman2, textures, 15);
    }

    private void changeAnim2Index() {
        switch (pacman2.direction) {
            case IDEAL -> {
                AnimIndexForPacman2 = 1;
            }
            case UP -> { // 2
                if (AnimIndexForPacman2 == 1) AnimIndexForPacman2 = 2;
                else if (AnimIndexForPacman2 == 2) AnimIndexForPacman2 = 1;
            }
            case DOWN -> { // 3

                if (AnimIndexForPacman2 == 1) AnimIndexForPacman2 = 3;
                else if (AnimIndexForPacman2 == 3) AnimIndexForPacman2 = 1;
            }
            case RIGHT -> { // 4

                if (AnimIndexForPacman2 == 1) AnimIndexForPacman2 = 4;
                else if (AnimIndexForPacman2 == 4) AnimIndexForPacman2 = 1;
            }
            case LEFT -> { // 5

                if (AnimIndexForPacman2 == 1) AnimIndexForPacman2 = 5;
                else if (AnimIndexForPacman2 == 5) AnimIndexForPacman2 = 1;
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
                Map2.animator.start();
            } else {
                timer.stop();
                Map2.animator.stop();
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

//    public static void main(String[] args) {
//
//        java.awt.EventQueue.invokeLater(() -> new Map22Listener().setVisible(true));
//    }

}


