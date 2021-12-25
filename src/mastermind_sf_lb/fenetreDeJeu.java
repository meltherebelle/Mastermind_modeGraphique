/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mastermind_sf_lb;

/**
 *
 * @author leaburriat
 */
public class fenetreDeJeu extends javax.swing.JFrame {

    /**
     * Creates new form fenetreDeJeu
     */
    public fenetreDeJeu() {
        initComponents();

        panneau_grille.setVisible(false);
        panneau_infos.setVisible(false);

        for (int i = 0; i < 12; i--) { //12 lignes
            for (int j = 0; j < 4; j--) { //4 colonnes
                CelluleGraphique cellGraph = new CelluleGraphique();
                panneau_grille.add(cellGraph);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneau_grille = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panneau_message = new javax.swing.JPanel();
        lbl_message = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        panneau_couleurs = new javax.swing.JPanel();
        lbl_palette_couleurs = new javax.swing.JLabel();
        lbl_palette_couleurs1 = new javax.swing.JLabel();
        btn_rouge = new javax.swing.JButton();
        btn_vert = new javax.swing.JButton();
        btn_jaune = new javax.swing.JButton();
        btn_bleu = new javax.swing.JButton();
        btn_orange = new javax.swing.JButton();
        btn_magenta = new javax.swing.JButton();
        panneau_infos = new javax.swing.JPanel();
        lbl_infos_partie = new javax.swing.JLabel();
        lbl_nbCoul = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textarea_CoulOK = new javax.swing.JTextArea();
        lbl_nbCoulPlacmt = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textarea_CoulPlacmtOK = new javax.swing.JTextArea();
        btn_demarrer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneau_grille.setBackground(new java.awt.Color(204, 204, 204));
        panneau_grille.setLayout(new java.awt.GridLayout(12, 4));
        getContentPane().add(panneau_grille, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 580, 520));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MasterMind");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 550, 80));

        panneau_message.setBackground(new java.awt.Color(153, 153, 153));

        lbl_message.setText("Messages :");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(3);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout panneau_messageLayout = new javax.swing.GroupLayout(panneau_message);
        panneau_message.setLayout(panneau_messageLayout);
        panneau_messageLayout.setHorizontalGroup(
            panneau_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneau_messageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneau_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panneau_messageLayout.createSequentialGroup()
                        .addComponent(lbl_message)
                        .addGap(0, 319, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panneau_messageLayout.setVerticalGroup(
            panneau_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneau_messageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_message)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(panneau_message, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 400, 150));

        panneau_couleurs.setBackground(new java.awt.Color(153, 153, 153));
        panneau_couleurs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_palette_couleurs.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_palette_couleurs.setText("   Palette de couleurs :");
        panneau_couleurs.add(lbl_palette_couleurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 70));
        panneau_couleurs.add(lbl_palette_couleurs1, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 0, 133, 70));

        btn_rouge.setText("Rouge");
        btn_rouge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rougeActionPerformed(evt);
            }
        });
        panneau_couleurs.add(btn_rouge, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 71, 130, 100));

        btn_vert.setText("Vert");
        panneau_couleurs.add(btn_vert, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 140, 100));

        btn_jaune.setText("Jaune");
        panneau_couleurs.add(btn_jaune, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 133, 100));

        btn_bleu.setText("Bleu");
        panneau_couleurs.add(btn_bleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 173, 127, 101));

        btn_orange.setText("Orange");
        btn_orange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_orangeActionPerformed(evt);
            }
        });
        panneau_couleurs.add(btn_orange, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 127, 107));

        btn_magenta.setText("Magenta");
        btn_magenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_magentaActionPerformed(evt);
            }
        });
        panneau_couleurs.add(btn_magenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 130, 107));

        getContentPane().add(panneau_couleurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 400, 280));

        panneau_infos.setBackground(new java.awt.Color(153, 153, 153));
        panneau_infos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_infos_partie.setText("Infos partie :");
        panneau_infos.add(lbl_infos_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 73));

        lbl_nbCoul.setText("nombre de bonnes couleurs :");
        panneau_infos.add(lbl_nbCoul, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 200, 73));

        textarea_CoulOK.setColumns(2);
        textarea_CoulOK.setRows(1);
        textarea_CoulOK.setTabSize(1);
        jScrollPane2.setViewportView(textarea_CoulOK);

        panneau_infos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 110, 50));

        lbl_nbCoulPlacmt.setText("nombre de couleurs bien placées :");
        panneau_infos.add(lbl_nbCoulPlacmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 230, 73));

        textarea_CoulPlacmtOK.setColumns(2);
        textarea_CoulPlacmtOK.setRows(1);
        jScrollPane3.setViewportView(textarea_CoulPlacmtOK);

        panneau_infos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 110, 50));

        getContentPane().add(panneau_infos, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 400, 190));

        btn_demarrer.setText("Démarrer partie");
        btn_demarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_demarrerActionPerformed(evt);
            }
        });
        getContentPane().add(btn_demarrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 130, 40));

        setBounds(0, 0, 1030, 693);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_rougeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rougeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_rougeActionPerformed

    private void btn_orangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_orangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_orangeActionPerformed

    private void btn_magentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_magentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_magentaActionPerformed

    private void btn_demarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_demarrerActionPerformed
        panneau_grille.setVisible(true);
        panneau_infos.setVisible(true);
        btn_demarrer.setVisible(false);
    }//GEN-LAST:event_btn_demarrerActionPerformed

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
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetreDeJeu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bleu;
    private javax.swing.JButton btn_demarrer;
    private javax.swing.JButton btn_jaune;
    private javax.swing.JButton btn_magenta;
    private javax.swing.JButton btn_orange;
    private javax.swing.JButton btn_rouge;
    private javax.swing.JButton btn_vert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbl_infos_partie;
    private javax.swing.JLabel lbl_message;
    private javax.swing.JLabel lbl_nbCoul;
    private javax.swing.JLabel lbl_nbCoulPlacmt;
    private javax.swing.JLabel lbl_palette_couleurs;
    private javax.swing.JLabel lbl_palette_couleurs1;
    private javax.swing.JPanel panneau_couleurs;
    private javax.swing.JPanel panneau_grille;
    private javax.swing.JPanel panneau_infos;
    private javax.swing.JPanel panneau_message;
    private javax.swing.JTextArea textarea_CoulOK;
    private javax.swing.JTextArea textarea_CoulPlacmtOK;
    // End of variables declaration//GEN-END:variables
}
