package Project.Maps.Map1;

import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class Map1_Multi extends JFrame {
    GLCanvas glcanvas;
    Map1_MultiListener listener = new Map1_MultiListener();
    static FPSAnimator animator;

    public Map1_Multi() {
        super("Map 1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        animator = new FPSAnimator(glcanvas, 15);

        listener.frame = this; // For closing

        add(glcanvas, BorderLayout.CENTER);
        setSize(800, 800);
        setLocationRelativeTo(this);
        setVisible(true);
        requestFocus();
    }

    public static void main(String[] args) {
        new Map1_Multi();
        animator.start();
    }


}
