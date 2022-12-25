package Project.Pages;

import java.awt.*;
import javax.swing.*;

public class PlayerChoose  extends JFrame {


        public PlayerChoose() {
            initComponents();
            setLocationRelativeTo(null);
        }


        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

            play2 = new JButton();
            play = new JButton();
            play1 = new JButton();
            jLabel1 = new JLabel();

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setMinimumSize(new Dimension(700,520));
            setResizable(false);
            setTitle("Pac-Man Game");
            getContentPane().setLayout(null);

            play2.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
            play2.setText("Back");
            play2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    play2ActionPerformed(evt);
                }
            });
            getContentPane().add(play2);
            play2.setBounds(280, 420, 160, 50);

            play.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
            play.setText("Multi-Player");
            play.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    playActionPerformed(evt);
                }
            });
            getContentPane().add(play);
            play.setBounds(420, 330, 240, 50);


            play1.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
            play1.setText("Single-Player");
            play1.setCursor(new java.awt.Cursor(DEFAULT_CURSOR));
            play1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    play1ActionPerformed(evt);
                }
            });
            getContentPane().add(play1);
            play1.setBounds(40, 330, 260, 50);

            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/Assets/Pacman-Cubic-Thumb01.jpg"))); // NOI18N
            jLabel1.setText("jLabel1");
            getContentPane().add(jLabel1);
            jLabel1.setBounds(-350, -100, 1100, 690);

            pack();
        }// </editor-fold>

        private void play2ActionPerformed(java.awt.event.ActionEvent evt) {
            this.dispose();
            new HomePage().setVisible(true);
        }

        private void playActionPerformed(java.awt.event.ActionEvent evt) {
            this.dispose();
            new User_Name2().setVisible(true);

        }

        private void play1ActionPerformed(java.awt.event.ActionEvent evt) {
            this.dispose();
            new User_Name().setVisible(true);
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
                java.util.logging.Logger.getLogger(PlayerChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(PlayerChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(PlayerChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(PlayerChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new PlayerChoose().setVisible(true);
                }
            });
        }

        // Variables declaration - do not modify
        private javax.swing.JButton play2;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JButton play;
        private javax.swing.JButton play1;
        // End of variables declaration
    }


