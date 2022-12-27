package Project.Pages;


import Project.Maps.Map1.Map1_MultiListener;
import Project.Maps.Map2.Map22Listener;

import Project.Maps.Map3.Map3MultiListener;

import Project.Maps.Map4.Map4MultiListener;

import Project.Maps.Map5.MultiMap5Listener;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Scanner;

import static Project.Core.Utils.SaveUser;

public class User_Name2 extends javax.swing.JFrame {


    public User_Name2() {
        initComponents();
        setLocationRelativeTo(null);
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
        Instruction = new javax.swing.JLabel();
        UP = new javax.swing.JLabel();
        RIGHT = new javax.swing.JLabel();
        LEFT = new javax.swing.JLabel();
        DOWN = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(700, 452));
        setResizable(false);
        setTitle("Pac-Man Game");
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(470, 360, 220, 40);

        jButton2.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jButton2.setText("Play");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 360, 220, 40);

        Instruction.setFont(new java.awt.Font("Hobo Std", 0, 18)); // NOI18N
        Instruction.setForeground(new java.awt.Color(255, 255, 255));
        Instruction.setText("Instruction For Player 2");
        getContentPane().add(Instruction);
        Instruction.setBounds(400, 50, 230, 40);

        UP.setFont(new java.awt.Font("Hobo Std", 0, 18)); // NOI18N
        UP.setForeground(new java.awt.Color(255, 255, 255));
        UP.setText("Press W for UP");
        getContentPane().add(UP);
        UP.setBounds(400, 110, 230, 30);

        RIGHT.setFont(new java.awt.Font("Hobo Std", 0, 18)); // NOI18N
        RIGHT.setForeground(new java.awt.Color(255, 255, 255));
        RIGHT.setText("Press D for RIGHT");
        getContentPane().add(RIGHT);
        RIGHT.setBounds(400, 200, 230, 23);

        LEFT.setFont(new java.awt.Font("Hobo Std", 0, 18)); // NOI18N
        LEFT.setForeground(new java.awt.Color(255, 255, 255));
        LEFT.setText("Press A for LEFT");
        getContentPane().add(LEFT);
        LEFT.setBounds(400, 250, 230, 23);

        DOWN.setFont(new java.awt.Font("Hobo Std", 0, 18)); // NOI18N
        DOWN.setForeground(new java.awt.Color(255, 255, 255));
        DOWN.setText("Press S for DOWN");
        getContentPane().add(DOWN);
        DOWN.setBounds(400, 150, 230, 40);


        jLabel16.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Enter User Name");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(20, 20, 320, 70);

        jLabel1.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Player 1:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 110, 170, 50);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(170, 230, 200, 60);

        jLabel3.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Player 2:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 240, 170, 70);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(170, 102, 200, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/Assets/blue-pacman-gameboy-old-games-wallpaper-preview.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -80, 870, 580);

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        this.dispose();
        new PlayerChoose().setVisible(true);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTextField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter Player1 Name : ", "user_name", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter Player2 Name : ", "user_name", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            boolean flag = false;
            Scanner input = new Scanner(new File("Users.txt"));
            while (input.hasNext()) {
                String name = jTextField1.getText();
                String name2 = input.nextLine();
                name2 = name2.substring(0, name2.indexOf(' ') == -1 ? name2.length() : name2.indexOf( ' '));

                if (name.equals(name2)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                SaveUser(jTextField2.getText()+ " ");
                SaveUser(jTextField1.getText()+ " ");
                Map1_MultiListener.userName1= Map22Listener.userName1= Map3MultiListener.userName1= Map4MultiListener.userName1= MultiMap5Listener.userName1 = jTextField2.getText();
                Map1_MultiListener.userName2= Map22Listener.userName2= Map3MultiListener.userName2= Map4MultiListener.userName2= MultiMap5Listener.userName2 = jTextField1.getText();
            }
        } catch (IOException e) {
        }

        this.dispose();
        new ChooseMap_Mult().setVisible(true);
    }


    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(User_Name2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Name2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Name2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Name2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Name2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel DOWN;
    private javax.swing.JLabel Instruction;
    private javax.swing.JLabel LEFT;
    private javax.swing.JLabel RIGHT;
    private javax.swing.JLabel UP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration
}


