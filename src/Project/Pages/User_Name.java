package Project.Pages;

import Project.Maps.Map1.Map1Listener;
import Project.Maps.Map2.Map2Listener;
import Project.Maps.Map3.Map3Listener;
import Project.Maps.Map4.Map4Listener;
import Project.Maps.Map5.Map5Listener;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static Project.Core.Utils.SaveUser;

public class User_Name extends JFrame {


    public User_Name() {
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
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
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
                try {
                    jButton2ActionPerformed(evt);
                } catch (IOException e) {
                }
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 360, 220, 40);

        jLabel16.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Enter User Name");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(20, 20, 320, 70);

        jLabel1.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Player 1:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 110, 180, 60);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(170, 100, 200, 60);

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {

        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter your name", "User Name", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            boolean flag = false;
            Scanner input = new Scanner(new File("Users.txt"));
            while (input.hasNext()) {
                String name = jTextField1.getText();
                String name2 = input.nextLine();
                name2 = name2.substring(0, name2.indexOf(' ') == -1 ? name2.length() : name2.indexOf(' '));

                if (name.equals(name2)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                SaveUser(jTextField1.getText() + " ");
                Map1Listener.userName= Map2Listener.userName= Map3Listener.userName= Map4Listener.userName= Map5Listener.userName = jTextField1.getText();

            }
        } catch (IOException e) {
        }
        this.dispose();
        new ChooseMap().setVisible(true);

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
            java.util.logging.Logger.getLogger(User_Name.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Name.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Name.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Name.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Name().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration
}

