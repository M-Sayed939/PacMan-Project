package Project.Maps.Map2;

import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class Map2Multi extends JFrame {
    GLCanvas glcanvas;
    Map22Listener listener = new Map22Listener();
    static FPSAnimator animator;

    public Map2Multi() {
        super("Map 2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        animator = new FPSAnimator(glcanvas, 25);

        listener.frame = this;

        add(glcanvas, BorderLayout.CENTER);
        setSize(800, 800);
        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
    }

    public static void main(String[] args) {
        new Map2Multi();
        animator.start();
    }


}
