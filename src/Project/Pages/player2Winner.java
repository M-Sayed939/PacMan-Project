package Project.Pages;

public class player2Winner extends javax.swing.JFrame {


    public player2Winner() {
        initComponents();
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(635, 556));
        setResizable(false);
        setTitle("Pac-Man Game");
        getContentPane().setLayout(null);

        jButton2.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jButton2.setText("Change Map");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(40, 430, 260, 60);

        jButton1.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(450, 430, 130, 60);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Hobo Std", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Player 2 Wins :0");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 0, 470, 110);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/Assets/pacman-fortnite.gif"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(889, 400));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-20, -40, 640, 600);

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new HomePage().setVisible(true);

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new ChooseMap_Mult().setVisible(true);        }


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Project.Pages.player2Winner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration
}
