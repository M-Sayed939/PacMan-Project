package Project.Maps.Map3;

import Project.Maps.Map3.Map3;
import Project.Maps.Map3.Map3Listener;
import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class Map3 extends JFrame {

    GLCanvas glcanvas;
    Map3Listener listener = new Map3Listener();
    static FPSAnimator animator;

    public Map3() {
        super("Map 3");
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
        new Map3();
        animator.start();
    }

}
