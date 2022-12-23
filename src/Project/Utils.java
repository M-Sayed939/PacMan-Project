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

    public static void drawRect(GL gl, double x, double y, int w, int h, float r, float g, float b) {
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

}
