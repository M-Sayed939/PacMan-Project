package Project.Maps.Map4;

import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class Map4Multi extends JFrame {
    GLCanvas glcanvas;
    Map4MultiListener listener = new Map4MultiListener();
    static FPSAnimator animator;

    public Map4Multi() {
        super("Map4Multi");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        glcanvas.setSize(800, 800);
        animator = new FPSAnimator(glcanvas, 12);

        add(glcanvas, BorderLayout.CENTER);
        setSize(800, 800);
        requestFocus();
        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Map4Multi();
        animator.start();
    }


}
