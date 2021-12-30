/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mastermind_modeGraphique;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JButton;
/**
 *
 * @author 
 */
public class fenetreDeJeu extends javax.swing.JFrame  {

    /**
     * Creates new form fenetreDeJeu
     */
    CelluleGraphique grilleCouleurs[][] = new CelluleGraphique[12][4];
    public fenetreDeJeu() {
        initComponents();

        panneau_grille.setVisible(false);
        panneau_infos.setVisible(false);
        
        //creation d'une matrice 12 x 4 contenant des cellules Graphiques
        
        
        for (int line = 0; line <12; line++) {
            for (int column = 0; column < 4; column++) {
                String color = "vide"; //on initialise les cellules Graphiques sans couleur
                CelluleGraphique cellGraph = new CelluleGraphique(line, column, color);
                grilleCouleurs[line][column] = cellGraph; //stockes chaque référence a la cellulegraphique dans le tableau grilleCouleurs
                cellGraph.affecterCouleur(color);
                panneau_grille.add(cellGraph);
                //ajout du code qui permet de trouver le bouton cliqué et d'affecter la couleur corresp.
                cellGraph.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cellGraph.affecterCouleur("rouge");
                        System.out.println("Vous avez cliqué sur le bouton de coordonnées "+cellGraph);
                    }
                    
                });
            }
        }
    }
    
    
    /*public int Options() {
        int coups = 0;
        //afficher mess
        
        //System.out.println("Choisissez un mode :\n1. Niveau facile\n2. Niveau moyen \n3. Niveau difficile");
        
        //creer 3 boutons de niveau difficulté à la place du scanner
        //Scanner sc = new Scanner(System.in);
        int choixniveau = sc.nextInt();
        if (choixniveau == 1) {
            coups = 12;//partie de base (facile)
        }
        else if (choixniveau == 2) {
            coups = 9; //partie niveau moyen
        }
        else if (choixniveau == 3) {
            coups = 5; //partie niveau difficile
        }
        return coups;
    }*/
    
    
 public
            String combSecret[] = new String[4];
    public void debuterPartie() {

        
        zone_mess.setText("Bienvenue dans le MasterMind de Scotty & Lélé :\nUne combinaison secrète a été tirée.\nVeuillez choisir une combinaison de couleurs\nen cliquant sur la palette ci-dessous ;)");
        
        //on génère une combinaison secrete
        //Combinaison cs = new Combinaison();
        //String[] combSecret = cs.combinaisonSecrete(); //on recup la combS dans une variable pour ensuite l'afficher
        //lbl_combSecrete.setText("La combinaison secrete tirée est : "+ Arrays.toString(combSecret));
        
        /* !!!!!
        //int nbCoups = Options(); //choix difficulté du niveau
        int nbCoups = 10; //pour l'instant
        
        for (int i = 0; i < nbCoups; i++) {
            
            zone_mess.setText(zone_mess.getText()+"\nSaissisez votre combinaison de 4 couleurs en cliquant ci dessous");
            
            int coupsRestant = nbCoups;
            
            coupsRestant--;
            //zone_mess.setText("Vous disposez de "+coupsRestant+" coups. ");
            //System.out.println("Vous disposez de "+coupsRestant+" coups. ");
            
            //nouvelle comb choisie
            Combinaison cc = new Combinaison();
            cc.combinaisonChoisie(); //demande une combinaison au player
            
            //on détermine les nb coul & coul + placement OK
            Combinaison compare = new Combinaison();
            int[] nbok = compare.Comparaison(cs.combSecret, cc.combChoisie); //.Comparaison(Combinaison[] combS , Combinaison[] combC);
            
            //on verifie si c'est une combinaison gagnante
            Combinaison etregagnant = new Combinaison();
            boolean gagner = etregagnant.Gagner(nbok);
            
            if (gagner == true) {
                //zone_mess.setText("Vous avez deviné le code secret !!! ");
                System.out.println("Vous avez deviné le code secret !!! ");
            }
            else {
                //zone_mess.setText("Retentez votre chance");
                System.out.println("Retentez votre chance");
            }
           
        }*/
         
        
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
        zone_mess = new javax.swing.JTextArea();
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
        panneau_combSecrete = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lbl_combSecrete = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneau_grille.setBackground(new java.awt.Color(204, 204, 204));
        panneau_grille.setLayout(new java.awt.GridLayout(12, 4));
        getContentPane().add(panneau_grille, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 580, 500));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MasterMind");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 550, 30));

        panneau_message.setBackground(new java.awt.Color(153, 153, 153));

        lbl_message.setText("Messages :");

        zone_mess.setColumns(20);
        zone_mess.setRows(3);
        jScrollPane1.setViewportView(zone_mess);

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

        btn_rouge.setBackground(new java.awt.Color(255, 0, 0));
        btn_rouge.setText("Rouge");
        btn_rouge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rougeActionPerformed(evt);
            }
        });
        panneau_couleurs.add(btn_rouge, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 71, 130, 100));

        btn_vert.setBackground(new java.awt.Color(0, 255, 102));
        btn_vert.setText("Vert");
        btn_vert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vertActionPerformed(evt);
            }
        });
        panneau_couleurs.add(btn_vert, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 140, 100));

        btn_jaune.setBackground(new java.awt.Color(255, 255, 0));
        btn_jaune.setText("Jaune");
        btn_jaune.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jauneActionPerformed(evt);
            }
        });
        panneau_couleurs.add(btn_jaune, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 133, 100));

        btn_bleu.setBackground(new java.awt.Color(0, 51, 255));
        btn_bleu.setText("Bleu");
        btn_bleu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bleuActionPerformed(evt);
            }
        });
        panneau_couleurs.add(btn_bleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 173, 127, 101));

        btn_orange.setBackground(new java.awt.Color(255, 153, 0));
        btn_orange.setText("Orange");
        btn_orange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_orangeActionPerformed(evt);
            }
        });
        panneau_couleurs.add(btn_orange, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 127, 107));

        btn_magenta.setBackground(new java.awt.Color(255, 0, 204));
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

        panneau_infos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 140, 50));

        lbl_nbCoulPlacmt.setText("nombre de couleurs bien placées :");
        panneau_infos.add(lbl_nbCoulPlacmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 230, 73));

        textarea_CoulPlacmtOK.setColumns(2);
        textarea_CoulPlacmtOK.setRows(1);
        jScrollPane3.setViewportView(textarea_CoulPlacmtOK);

        panneau_infos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 140, 50));

        getContentPane().add(panneau_infos, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 400, 190));

        btn_demarrer.setText("Démarrer partie");
        btn_demarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_demarrerActionPerformed(evt);
            }
        });
        getContentPane().add(btn_demarrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 130, 40));

        panneau_combSecrete.setBackground(new java.awt.Color(153, 204, 255));
        panneau_combSecrete.setForeground(new java.awt.Color(153, 204, 255));

        lbl_combSecrete.setColumns(20);
        lbl_combSecrete.setRows(5);
        jScrollPane4.setViewportView(lbl_combSecrete);

        javax.swing.GroupLayout panneau_combSecreteLayout = new javax.swing.GroupLayout(panneau_combSecrete);
        panneau_combSecrete.setLayout(panneau_combSecreteLayout);
        panneau_combSecreteLayout.setHorizontalGroup(
            panneau_combSecreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneau_combSecreteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panneau_combSecreteLayout.setVerticalGroup(
            panneau_combSecreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneau_combSecreteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panneau_combSecrete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 580, 60));

        setBounds(0, 0, 1030, 693);
    }// </editor-fold>//GEN-END:initComponents
    int X = -1; // en lien avec le nb de click pour colorier a la suite dans l'orde les cases
    int Y = -1;
    
    public
            String combChoisie[] = new String[4];
    
    /*public String[] combinaisonSecrete() {

        //creation tableau contenant les 6 couleurs possibles
        String TabCouleur[] = new String[6];
        TabCouleur[0] = "Rouge";
        TabCouleur[1] = "Jaune";
        TabCouleur[2] = "Vert";
        TabCouleur[3] = "Bleu";
        TabCouleur[4] = "Orange";
        TabCouleur[5] = "Magenta";

        //tirage aléatoire des couleurs contenues dans le code
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            int c = rand.nextInt(5);
            combSecret[i] = TabCouleur[c];
            //on devra aussi trouver un moyen d'--> affecterCouleur(TabCouleur[c]); à la cellule graphique
        }
        return combSecret;
    } */
    int cpt = 0;
    int cptCmbC = -1;
    public void Jeu(){
            cptCmbC = 0;
            Combinaison cs = new Combinaison();
            String[] combSecret = cs.combinaisonSecrete(); //on recup la combS dans une variable pour ensuite l'afficher
            lbl_combSecrete.setText("La combinaison secrete tirée est : "+ Arrays.toString(combSecret));
        //while(cpt%4 == 0){ // fais l'action tout les 4 clics
        if(cpt%4==0){ //fais l'action tout les 4 clics
            //on détermine les nb coul & coul + placement OK
            Combinaison compare = new Combinaison();
            
            
            int[] nbok = compare.Comparaison(combSecret, combChoisie);
            
            //Test affichage coparaisons
            textarea_CoulOK.setText("nb bonne couleurs: "+ nbok[0]);
            textarea_CoulPlacmtOK.setText("nb bon placement"+ nbok[1]);
            
            //on verifie si c'est une combinaison gagnante
            Combinaison etregagnant = new Combinaison();         
            boolean gagner = etregagnant.Gagner(nbok);
            
            if (gagner == true) {
                zone_mess.setText("Vous avez deviné le code secret !!! ");
                
            }
            else {
                zone_mess.setText("Retentez votre chance");
                
            }
            
        }
        
    }
    
    /*int [] NB_OK = new int[2];
    public int[] Comparaison(String[] combS, String[] combC) {

        int nbCoul_OK = 0;
        int nbCoul_PlacmtOK = 0;
        //permet de checker le placement & couleur
        boolean[] BoolC = new boolean [4];
        boolean[] BoolS = new boolean [4];
        
        //comparaison des couleurs + placement
        for (int i = 0; i < 4 ; i++) {
            //on regarde d'abord si les deux tableaux ne sont pas déjà checké
            if ( (BoolC[i] != true) && (BoolS[i] != true) ) {
                //si il ne sont pas encore checké on compare la combC et combS
                if (combS[i].equals(combC[i])) {
                    //on check les tableaux de booleans
                    BoolC[i] = true;
                    BoolS[i] = true;
                    nbCoul_PlacmtOK += 1;
                }
            }  
        }
        
        //si pas checké on regarde si la couleur choisie de la case que l'on regarde est identique à une des couleurs du secret / sinon on ne vérifie pas
        //comparaison des couleurs
        for (int i = 0; i < 4; i ++) {
            //on regarde si bolC n'est pas déjà checké
            if ( (BoolC[i] != true) && (BoolC[i] != true) ) {
                //si pas encore checké on regarde si la couleur[i] de combC correspond à une des couleurs de combS
                for (int j = 0; j < 4; j++) {
                    if (combC[i].equals(combS[j])) {
                        //on check le tableau des booleans
                        BoolC[i] = true;
                        BoolS[i] = true;
                        nbCoul_OK += 1;
                        break;
                    }
                }
            }
        }
       
        //int [] NB_OK = new int[2];
        NB_OK[0] = nbCoul_OK;
        NB_OK[1] = nbCoul_PlacmtOK;
        //int[] arrayNB_OK = new int[] {nbCoul_OK, nbCoul_PlacmtOK};
        //System.out.println("nb de couleurs OK : "+arrayNB_OK[0] + ", nb de coul+placement OK : "+ arrayNB_OK[1]);
        return NB_OK;
    }
    */

    private void btn_rougeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rougeActionPerformed
        // TODO add your handling code here:
        cpt += 1; //nb de clic +1 pour Jeu()
        cptCmbC +=1; // compteur pour chaque cellule de combChoisie
        X += 1;
        Y += 1;
        X = X/4; //division entiere pour nb ligne
        Y = Y%4; // modulo pour nb colonne
        zone_mess.setText("Y"+Y+"X"+X); // Y n'augmente pas ???
       
        //zone_mess.setText("Vous avez clique sur le bouton rouge");
        
        grilleCouleurs[X][Y].affecterCouleur("rouge");
        repaint();
        combChoisie[cptCmbC]="rouge"; // rentre rouge dans colonne pour ensuite comparer
        //zone_mess.setText(combChoisie[1]);// la couleur se mets bien
        
        //comment faire l'affectation / récupération de la ligne et col à colorier
        //stocker un x et un y global qui dit l'endroit du jeu où on en est
    }//GEN-LAST:event_btn_rougeActionPerformed

    private void btn_orangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_orangeActionPerformed
        // TODO add your handling code here:
        zone_mess.setText("Vous avez clique sur le bouton orange");
        //grilleCouleurs[1][2].affecterCouleur("orange");
        //grilleCouleurs[1][1].setBackground(Color.orange);
        Jeu();
    }//GEN-LAST:event_btn_orangeActionPerformed

    private void btn_magentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_magentaActionPerformed
        // TODO add your handling code here:
        zone_mess.setText("Vous avez clique sur le bouton magenta");
        //TEST POUR COMPARER LES COMBINAISONS
        //Comparaison(combSecret,combChoisie); // test si ca compare
        //textarea_CoulOK.setText("nb de bonne couleurs: "+NB_OK[0]);
        //textarea_CoulPlacmtOK.setText("nn de bon placement"+NB_OK[1]);
        //grilleCouleurs[1][1].setBackground(Color.pink);
    }//GEN-LAST:event_btn_magentaActionPerformed

    private void btn_demarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_demarrerActionPerformed
        panneau_grille.repaint(); //on vide la grille pour commencer une nouvelle partie
        panneau_grille.setVisible(true);
        panneau_infos.setVisible(true);
        btn_demarrer.setVisible(false);
        debuterPartie();
    }//GEN-LAST:event_btn_demarrerActionPerformed

    private void btn_vertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vertActionPerformed
        // TODO add your handling code here:
        zone_mess.setText("Vous avez clique sur le bouton vert");
        
        //grilleCouleurs[1][1].setBackground(Color.green);
    }//GEN-LAST:event_btn_vertActionPerformed

    private void btn_jauneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jauneActionPerformed
        // TODO add your handling code here:
        zone_mess.setText("Vous avez clique sur le bouton jaune");
        //grilleCouleurs[1][1].setBackground(Color.yellow);
    }//GEN-LAST:event_btn_jauneActionPerformed

    private void btn_bleuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bleuActionPerformed
        // TODO add your handling code here:
        zone_mess.setText("Vous avez clique sur le bouton bleu");
        //grilleCouleurs[1][1].setBackground(Color.blue);
    }//GEN-LAST:event_btn_bleuActionPerformed

    //public void affecterCouleurGrille(int a,int b){
        //grilleCouleurs[a][b].
    //}
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea lbl_combSecrete;
    private javax.swing.JLabel lbl_infos_partie;
    private javax.swing.JLabel lbl_message;
    private javax.swing.JLabel lbl_nbCoul;
    private javax.swing.JLabel lbl_nbCoulPlacmt;
    private javax.swing.JLabel lbl_palette_couleurs;
    private javax.swing.JLabel lbl_palette_couleurs1;
    private javax.swing.JPanel panneau_combSecrete;
    private javax.swing.JPanel panneau_couleurs;
    private javax.swing.JPanel panneau_grille;
    private javax.swing.JPanel panneau_infos;
    private javax.swing.JPanel panneau_message;
    private javax.swing.JTextArea textarea_CoulOK;
    private javax.swing.JTextArea textarea_CoulPlacmtOK;
    private javax.swing.JTextArea zone_mess;
    // End of variables declaration//GEN-END:variables

}
