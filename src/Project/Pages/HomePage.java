package Project.Pages;

import Project.Core.Utils;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {
    public static Clip voice;


    public HomePage() {
        initComponents();
        setLocationRelativeTo(null);
        if (voice == null ) voice = Utils.playMusic("src/Project/Assets/wiki_home.wav", false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        exit = new JButton();
        play = new JButton();
        play1 = new JButton();
        jLabel2 = new JLabel();
        jButton1 = new JButton();


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 350));
        setResizable(false);
        setTitle("Pac-Man Game");
        getContentPane().setLayout(null);
        getContentPane().setLayout(null);


        exit.setFont(new java.awt.Font("Hobo Std", 0, 24)); // NOI18N
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(110, 250, 150, 40);

        play.setFont(new java.awt.Font("Hobo Std", 0, 24)); // NOI18N
        play.setText("Help");
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        getContentPane().add(play);
        play.setBounds(210, 30, 130, 40);

        play1.setFont(new java.awt.Font("Hobo Std", 0, 24)); // NOI18N
        play1.setText("Play");
        play1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        play1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play1ActionPerformed(evt);
            }
        });
        getContentPane().add(play1);
        play1.setBounds(80, 190, 210, 50);

        jButton1.setFont(new java.awt.Font("Hobo Std", 0, 24)); // NOI18N
        jButton1.setText("Users");
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 30, 130, 40);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });


        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/Assets/giffas_pacman.gif"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -120, 770, 540);

        pack();
    }// </editor-fold>

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void playActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new HelpPage().setVisible(true);

    }

    private void play1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new PlayerChoose().setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new Users().setVisible(true);
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton play;
    private javax.swing.JButton play1;
    private javax.swing.JButton jButton1;
    // End of variables declaration
}


