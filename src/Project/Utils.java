package Project;

import javax.media.opengl.GL;
import java.awt.*;


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

    public static void drawRect(GL gl, int x, int y) {
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glBegin(GL.GL_LINE_LOOP);
        x -= r;
        y -= r;

        gl.glVertex2i(x, y);
        gl.glVertex2i(x + 10, y);
    }

    public static void drawRect(GL gl, double x, double y, int size) {
        gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glBegin(GL_POLYGON);
        x -= r;
        y -= r;

        gl.glVertex2d(x, y);
        gl.glVertex2d(x + size, y);

        gl.glVertex2d(x + size, y + size);
        gl.glVertex2d(x, y + size);

        gl.glEnd();
    }

}
