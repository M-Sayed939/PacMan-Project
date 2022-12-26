package Project.Core;

import com.sun.opengl.util.GLUT;

import javax.media.opengl.GL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;


import static java.lang.Math.*;
import static java.lang.Math.toRadians;
import static javax.media.opengl.GL.*;

public class Utils {
    static int r = 5;

    public static int trX(double x) {
        return (int) ((x + r) / 10) - 1;
    }

    public static int trY(double y) {
        return (int) ((y + r) / 10) - 1;
    }

    public static double arcTrX(int i) {
        return (i + 1) * 10.0 - r;
    }

    public static double arcTrY(int j) {
        return (j + 1) * 10.0 - r;
    }

    public static void drawRect(GL gl, double x, double y, int w, int h, float r, float g, float b) {
        gl.glClearColor(r,g,b,1);
        gl.glColor3f(r, g, b);
        gl.glBegin(GL_POLYGON);
        x -= r;
        y -= r;

        gl.glVertex2d(x, y);
        gl.glVertex2d(x + w, y);

        gl.glVertex2d(x + w, y + h);
        gl.glVertex2d(x, y + h);

        gl.glEnd();
    }

    public static void drawRegularRibs(GL gl, int r, Color color, double x, double y) {
        gl.glColor3fv(color.getColorComponents(null), 0);
        gl.glBegin(GL.GL_POLYGON);
        int step = 1;
        for (int i = 0; i < 360; i += step)
            gl.glVertex2d(x + r * cos(toRadians(i)),
                    y + r * sin(toRadians(i)));

        gl.glEnd();
    }

    public static void drawCircle(GL gl, int r, Color color, double x, double y) {
        drawRegularRibs(gl, r, color, x, y);
    }

    public static Clip playMusic(String location, boolean loop) {

        try {
            File musicPath = new File(location);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                if (loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
                return clip;
            } else {
                System.out.println("Cant find file");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return null;
    }

    public static void DrawSprite(GL gl, int x, int y, int index, int[] textures, int size) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]); // Turn Blending On

        gl.glPushMatrix();
        gl.glTranslated(-5, -5, 0);
        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(x, y + size, -1.0f);

        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(x + size, y + size, -1.0f);

        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(x + size, y, -1.0f);

        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(x, y, -1.0f);

        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }
    public static void DrawSprite2(GL gl, int x, int y, int index, int[] textures, int w, int h) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]); // Turn Blending On

        gl.glPushMatrix();
        gl.glTranslated(-5, -5, 0);
        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(x, y + h, -1.0f);

        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(x + w, y + h, -1.0f);

        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(x + w, y, -1.0f);

        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(x, y, -1.0f);

        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }

    public static void drawString(GL gl, int x, int y, String s) {
        GLUT glt = new GLUT();
        gl.glRasterPos2i(x, y);
        glt.glutBitmapString(5, s);
    }

}
