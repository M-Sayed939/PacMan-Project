package Project.Pages;

//import Project.Maps.Map1.Map1;

import Project.Maps.Map1.Map1;
import Project.Maps.Map1.Map1_Multi;
import Project.Maps.Map2.Map2;
import Project.Maps.Map2.Map2Multi;
import Project.Maps.Map3.Map3;
import Project.Maps.Map3.Map3Multi;
import Project.Maps.Map4.Map4;
import Project.Maps.Map4.Map4Multi;
import Project.Maps.Map5.Map5;
import Project.Maps.Map5.MultiMap5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class ChooseMap_Mult extends JFrame {


    public ChooseMap_Mult() {
        initComponents();
        setLocationRelativeTo(null);

        setFocusable(true);
        requestFocus();

        HomePage.voice.stop();

    }

    @Override
    public void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);

        if (e.getID() == WindowEvent.WINDOW_CLOSING) {

            new HomePage().setVisible(true);
            HomePage.voice.start();
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();


        setMinimumSize(new Dimension(715, 550));
        setResizable(false);
        setTitle("Pac-Man Game");
        getContentPane().setLayout(null);

        jButton1.setFont(new Font("Hobo Std", 0, 36)); // NOI18N
        jButton1.setText("Map 2");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        getContentPane().add(jButton1);
        jButton1.setBounds(280, 270, 170, 50);

        jButton2.setFont(new Font("Hobo Std", 0, 36)); // NOI18N
        jButton2.setText("Map 3");
        getContentPane().add(jButton2);
        jButton2.setBounds(500, 270, 160, 50);
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setFont(new Font("Hobo Std", 0, 36)); // NOI18N
        jButton3.setText("Map 1");
        jButton3.addActionListener(this::jButton3ActionPerformed);


        getContentPane().add(jButton3);
        jButton3.setBounds(80, 270, 160, 50);

        jButton4.setFont(new Font("Hobo Std", 0, 36)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(this::jButton4ActionPerformed);
        getContentPane().add(jButton4);
        jButton4.setBounds(280, 450, 180, 50);

        jButton5.setFont(new Font("Hobo Std", 0, 36)); // NOI18N
        jButton5.setText("Map 4");
        jButton5.addActionListener(this::jButton5ActionPerformed);

        getContentPane().add(jButton5);
        jButton5.setBounds(190, 360, 160, 50);

        jButton6.setFont(new Font("Hobo Std", 0, 36)); // NOI18N
        jButton6.setText("Map 5");
        jButton6.addActionListener(this::jButton6ActionPerformed);
        getContentPane().add(jButton6);
        jButton6.setBounds(390, 360, 160, 50);

        jLabel2.setFont(new Font("Hobo Std", 0, 48)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("Choose map Multiplayer");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 180, 600, 58);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/Assets/Mapp.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-100, 0, 840, 640);

        pack();
    }// </editor-fold>

    private void jButton6ActionPerformed(ActionEvent evt) {
        this.dispose();
        MultiMap5.main(null);
    }

    private void jButton5ActionPerformed(ActionEvent evt) {
        this.dispose();
        Map4Multi.main(null);
    }

//    private void jButton3ActionPerformed(ActionEvent evt) {
//        this.dispose();
//        Map1.main(null);
//    }


    private void jButton4ActionPerformed(ActionEvent evt) {
        this.dispose();
        new User_Name2().setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        Map1_Multi.main(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        Map2Multi.main(null);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        Map3Multi.main(null);
    }

//    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
//        this.dispose();
//        Map4.main(null);
//    }
//
//    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
//        this.dispose();
//        Map5.main(null);
//    }


    public static void main(String[] args) {

        EventQueue.invokeLater(() -> new ChooseMap_Mult().setVisible(true));
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration
}
