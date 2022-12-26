package Project.Maps.Map3;

import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class Map3Multi extends JFrame {
    GLCanvas glcanvas;
    Map3MultiListener listener = new Map3MultiListener();
    static FPSAnimator animator;


    public Map3Multi() {
        super("Map3Multi");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        glcanvas.setSize(800, 459);
        animator = new FPSAnimator(glcanvas, 12);

        add(glcanvas, BorderLayout.CENTER);
        setSize(800, 459);
        requestFocus();
        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true);

        listener.frame = this;
    }

    public static void main(String[] args) {
        new Map3Multi();
        animator.start();
    }
}

