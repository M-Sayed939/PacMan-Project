package Project;

import java.awt.*;
import javax.swing.JFrame;


public class ChooseMap extends javax.swing.JFrame {


    public ChooseMap() {
        initComponents();
        setLocationRelativeTo(null);

        setFocusable(true);
        requestFocus();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(715,520));
        setResizable(false);
        setTitle("Pac-Man Game");
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jButton1.setText("Map 2");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(260, 270, 170, 49);

        jButton2.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jButton2.setText("Map 3");
        getContentPane().add(jButton2);
        jButton2.setBounds(480, 270, 170, 49);

        jButton3.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jButton3.setText("Map 1");
        getContentPane().add(jButton3);
        jButton3.setBounds(50, 270, 170, 49);

        jLabel2.setFont(new java.awt.Font("Hobo Std", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Choose map");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 180, 280, 58);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/Assets/Mapp.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-120, 0, 840, 640);

        pack();
    }// </editor-fold>


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseMap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration
}
