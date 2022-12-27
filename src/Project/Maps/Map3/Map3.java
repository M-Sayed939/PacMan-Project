package Project.Maps.Map3;

import Project.Maps.Map3.Map3;
import Project.Maps.Map3.Map3Listener;
import Project.Pages.HomePage;
import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Map3 extends JFrame {

    GLCanvas glcanvas;
    Map3Listener listener = new Map3Listener();
    static FPSAnimator animator;

    public Map3() {
        super("Map 3");

        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        glcanvas.setSize(800, 459);
        animator = new FPSAnimator(glcanvas, 12);

        add(glcanvas, BorderLayout.CENTER);
        setSize(800, 459);
        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();

        listener.frame = this;
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
        new Map3();
        animator.start();
    }

}
