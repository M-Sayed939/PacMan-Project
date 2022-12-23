package Project.Maps.Map5;



import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class Map5 extends JFrame {
    GLCanvas glcanvas;
    Map5Listener listener = new Map5Listener();
    static FPSAnimator animator;

    public Map5() {
        super("Map 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        glcanvas.setSize(400, 400);
        animator = new FPSAnimator(glcanvas, 12);

        add(glcanvas, BorderLayout.CENTER);
        setSize(400, 400);
        requestFocus();
        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Map5();
        animator.start();
    }


}
