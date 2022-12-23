package Project.Pages;

import java.awt.*;
import javax.swing.*;

public class GameOver extends JFrame {

        public GameOver() {
            initComponents();
            setLocationRelativeTo(null);
        }


        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

            jButton1 = new JButton();
            jLabel2 = new JLabel();
            jLabel1 = new JLabel();

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setBackground(Color.WHITE);
            setMinimumSize(new Dimension(420,460));
            setResizable(false);
            setTitle("Pac-Man Game");
            getContentPane().setLayout(null);

            jButton1.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
            jButton1.setText("Try Again");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });
            getContentPane().add(jButton1);
            jButton1.setBounds(50, 350, 320, 60);

            jLabel2.setFont(new java.awt.Font("Hobo Std", 0, 48)); // NOI18N
            jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel2.setText("Game Over :(");
            getContentPane().add(jLabel2);
            jLabel2.setBounds(-50, -10, 530, 110);

            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/Assets/Eafy9jtXYA000RS.jpg"))); // NOI18N
            jLabel1.setMinimumSize(new java.awt.Dimension(889, 400));
            getContentPane().add(jLabel1);
            jLabel1.setBounds(10, 0, 410, 420);

            pack();
        }// </editor-fold>

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
            this.dispose();
            new ChooseMap().setVisible(true);

        }


        public static void main(String args[]) {

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new GameOver().setVisible(true);
                }
            });
        }

        // Variables declaration - do not modify
        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        // End of variables declaration
    }


