package Project.Maps.Map2;

import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class Map2 extends JFrame {
    GLCanvas glcanvas;
    Map2Listener listener = new Map2Listener();
    static FPSAnimator animator;

    public Map2() {
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
        new Map2();
        animator.start();
    }


}
