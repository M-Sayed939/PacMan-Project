package Project.Maps.Map4;

import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class Map4 extends JFrame {
    GLCanvas glcanvas;
    Map4Listener listener = new Map4Listener();
    static FPSAnimator animator;

    public Map4() {
        super("Map 4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        glcanvas.setSize(800, 800);
        animator = new FPSAnimator(glcanvas, 12);
        listener.frame = this; // For closing

        add(glcanvas, BorderLayout.CENTER);
        setSize(800, 800);
        requestFocus();
        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Map4();
        animator.start();
    }


}
