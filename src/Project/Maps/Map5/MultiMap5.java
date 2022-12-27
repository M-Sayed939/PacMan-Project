package Project.Maps.Map5;


import Project.Maps.Map5.Map5Listener;
import Project.Pages.HomePage;
import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class MultiMap5 extends JFrame {
    GLCanvas glcanvas;
    MultiMap5Listener listener = new MultiMap5Listener();
    static FPSAnimator animator;

    public MultiMap5() {
        super("MultiMap 5");
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        glcanvas.setSize(800, 800);
        animator = new FPSAnimator(glcanvas, 12);

        listener.frame = this; // For closing

        add(glcanvas, BorderLayout.CENTER);
        setSize(700, 700);
        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
    }

    @Override
    public void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);

        if (e.getID() == WindowEvent.WINDOW_CLOSING) {

            new HomePage().setVisible(true);
            HomePage.voice.start();
        }
    }

    public static void main(String[] args) {
        new MultiMap5();
        animator.start();
    }


}
