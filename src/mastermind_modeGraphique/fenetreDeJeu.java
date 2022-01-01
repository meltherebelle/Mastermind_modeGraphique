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
public class fenetreDeJeu extends javax.swing.JFrame {

    /**
     * Creates new form fenetreDeJeu
     */
    CelluleGraphique grilleCouleurs[][] = new CelluleGraphique[12][4];
    int[] compteurs = initialiserCmpt();
    int X = compteurs[0];
    int Y = compteurs[1]; //on commence à -1 car au premier clique on rajoute +1 pour que ce soit sur la case 0 et non 1
    int cpt = compteurs[2];
    int cptCmbC = compteurs[3];

    public String combChoisie[] = new String[4];

    int[] nbok; // declaration de nbok

    String[] combSecret = debuterPartie(); //on récupère la combS générée en debut de partie pour la comparer par la suite

    public fenetreDeJeu() {
        initComponents();

        zone_mess.setText("Bienvenue dans le Mastermind !\n• Choissisez un niveau\n• Cliquez sur Démarrer partie");
        lbl_niveauChoix.setVisible(false);
        panneau_grille.setVisible(false);
        panneau_infos.setVisible(false);
        panneau_couleurs.setVisible(false);

        //creation d'une matrice 12 x 4 contenant des cellules Graphiques
        for (int line = 0; line < 12; line++) {
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
                        System.out.println("Vous avez cliqué sur le bouton de coordonnées " + cellGraph);
                    }

                });
            }
        }
    }

    public int[] initialiserCmpt() {
        int[] compteurs = new int[4];

        compteurs[0] = 0; //int X = 0; // en lien avec le nb de click pour colorier a la suite dans l'orde les cases
        compteurs[1] = -1; //int Y = -1; //on commence à -1 car au premier clique on rajoute +1 pour que ce soit sur la case 0 et non 1
        compteurs[2] = 0; //int cpt = 0; //compteur nb couleurs cliquées
        compteurs[3] = -1; //int cptCmbC = -1; //compteur indice pour remplir liste combChoisie

        return compteurs;
    }

    public int Options() {

        //mess_options.setText("Choisissez un mode : facile / moyen / difficile");
        System.out.println("Choisissez un mode :\n1. Niveau facile\n2. Niveau moyen \n3. Niveau difficile");

        String choix = "facile"; //si jamais ca marche pas

        //choix = lbl_choixNiv.getText();
        System.out.println("Niveau choisi : " + choix);

        int nbcoups = 0;

        if (choix == "facile") {
            nbcoups = 12;
        }

        if (choix == "moyen") {
            nbcoups = 6;
        }

        if (choix == "difficile") {
            nbcoups = 3;
        }

        System.out.println("Vous disposez de " + nbcoups + " coups");

        return nbcoups;
    }

    public void viderGrille() {

        for (int line = 0; line < 12; line++) {

            for (int column = 0; column < 4; column++) {

                grilleCouleurs[line][column].affecterCouleur("vide");

            }

        }

        System.out.println("Grille vidée");

    }

    public String[] debuterPartie() { //on va renvoyer la combS générée en début de partie pour ne pas avoir à la regénérer

        if (X != 0) {
            //on rafraichie la grille
            //viderGrille(); //beug sur ordi lea
        }

        //on initialise les compteurs
        initialiserCmpt();

        //on génère une combinaison secrete
        Combinaison cs = new Combinaison();
        String[] combSecret = cs.combinaisonSecrete(); //on recup la combS dans une variable pour ensuite l'afficher

        repaint();

        return combSecret;

    }

    int nbCoups = Options();

    public void Jeu() {

        lbl_combSecrete.setText("Pour vous faciliter la tâche...\nLa combinaison secrete tirée est : " + Arrays.toString(combSecret));
        boolean finDePartie = false; //pour break des que partie finie (perdue ou gagnée)

        if (cpt == 4) { //fait l'action tous les 4 clics

            cpt = 0; //on repart à 0 clic pour la prochaine comb
            cptCmbC = -1; //indice reinitialisé pour pas out of bound
            X += 1; //on passe à la ligne d'apres (prochaine comb)
            Y = -1; //on repart de la colonne 0 (ca +1 des qu'on clique)

            Combinaison compare = new Combinaison(); //on détermine les nb coul & coul + placement OK
            nbok = compare.Comparaison(combSecret, combChoisie); //on récupère le résultat de la comparaison dans un tableau

            //Affichage résultats des comparaisons
            textarea_CoulOK.setText(nbok[0] + "");
            textarea_CoulPlacmtOK.setText(nbok[1] + "");

            //on verifie si c'est une combinaison gagnante
            Combinaison etregagnant = new Combinaison();
            boolean gagner = etregagnant.Gagner(nbok);
            System.out.println("gagnant :" + gagner);
            //zone_mess.setText("gagnant : "+gagner+ "");

            if (gagner == true) {
                zone_mess.setText("Vous avez deviné le code secret !!! \n Appuyer sur DEMARRER pour recommencer ");// la condition marche mais ca veut pas afficher dans zone_mess
                //btn_rouge.setEnabled(false); // ON POURRAIT DISABLE LA PALETTE DE COULEUR SAUF DEMMARER COMME CA ON PEUT REJOUER
                btn_demarrer.setVisible(true); // PROBLEME creation de combSecret dans code et non dans fonction 
                finDePartie = true;
            }

            if ((X == nbCoups) && (gagner == false)) { //perdu
                zone_mess.setText("You're a L O S E R ... :( ");
                finDePartie = true;
            }
            if (finDePartie == false) {
                zone_mess.setText("Retentez votre chance\nVeuillez choisir une prochaine combinaison de couleurs\nen cliquant sur la palette ci-dessous ;)");
            }

        }

        repaint();

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
        lbl_nbCoulPlacmt = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textarea_CoulPlacmtOK = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        textarea_CoulOK = new javax.swing.JTextArea();
        lbl_nbCoul1 = new javax.swing.JLabel();
        btn_demarrer = new javax.swing.JButton();
        panneau_combSecrete = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lbl_combSecrete = new javax.swing.JTextArea();
        panneau_options = new javax.swing.JPanel();
        lbl_options = new javax.swing.JLabel();
        btn_moyen = new javax.swing.JButton();
        btn_difficile = new javax.swing.JButton();
        btn_facile = new javax.swing.JButton();
        lbl_niveauChoix = new javax.swing.JLabel();
        lbl_choixNiv = new javax.swing.JLabel();

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
        panneau_couleurs.add(btn_rouge, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 80, 130, 100));

        btn_vert.setBackground(new java.awt.Color(0, 255, 102));
        btn_vert.setText("Vert");
        btn_vert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vertActionPerformed(evt);
            }
        });
        panneau_couleurs.add(btn_vert, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 80, 130, 100));

        btn_jaune.setBackground(new java.awt.Color(255, 255, 0));
        btn_jaune.setText("Jaune");
        btn_jaune.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jauneActionPerformed(evt);
            }
        });
        panneau_couleurs.add(btn_jaune, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 80, 130, 100));

        btn_bleu.setBackground(new java.awt.Color(0, 51, 255));
        btn_bleu.setText("Bleu");
        btn_bleu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bleuActionPerformed(evt);
            }
        });
        panneau_couleurs.add(btn_bleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 180, 130, 100));

        btn_orange.setBackground(new java.awt.Color(255, 153, 0));
        btn_orange.setText("Orange");
        btn_orange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_orangeActionPerformed(evt);
            }
        });
        panneau_couleurs.add(btn_orange, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 180, 130, 100));

        btn_magenta.setBackground(new java.awt.Color(255, 0, 204));
        btn_magenta.setText("Magenta");
        btn_magenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_magentaActionPerformed(evt);
            }
        });
        panneau_couleurs.add(btn_magenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 180, 130, 100));

        getContentPane().add(panneau_couleurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 400, 280));

        panneau_infos.setBackground(new java.awt.Color(153, 153, 153));
        panneau_infos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_infos_partie.setText("Infos partie :");
        panneau_infos.add(lbl_infos_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 73));

        lbl_nbCoul.setText("nombre de bonnes couleurs :");
        panneau_infos.add(lbl_nbCoul, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 200, 73));

        lbl_nbCoulPlacmt.setText("nombre de couleurs bien placées :");
        panneau_infos.add(lbl_nbCoulPlacmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 230, 73));

        textarea_CoulPlacmtOK.setColumns(2);
        textarea_CoulPlacmtOK.setRows(1);
        jScrollPane3.setViewportView(textarea_CoulPlacmtOK);

        panneau_infos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 120, 50));

        textarea_CoulOK.setColumns(2);
        textarea_CoulOK.setRows(1);
        textarea_CoulOK.setTabSize(1);
        jScrollPane5.setViewportView(textarea_CoulOK);

        panneau_infos.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 120, 50));

        lbl_nbCoul1.setText("nombre de bonnes couleurs :");
        panneau_infos.add(lbl_nbCoul1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 200, 73));

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
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panneau_combSecrete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 580, 60));

        panneau_options.setBackground(new java.awt.Color(153, 153, 153));

        lbl_options.setText("Options :");

        btn_moyen.setBackground(new java.awt.Color(255, 204, 51));
        btn_moyen.setText("Moyen");
        btn_moyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moyenActionPerformed(evt);
            }
        });

        btn_difficile.setBackground(new java.awt.Color(204, 0, 0));
        btn_difficile.setText("Difficile");
        btn_difficile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_difficileActionPerformed(evt);
            }
        });

        btn_facile.setBackground(new java.awt.Color(204, 255, 204));
        btn_facile.setText("Facile");
        btn_facile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_facileActionPerformed(evt);
            }
        });

        lbl_niveauChoix.setText("Niveau Choisi :");

        lbl_choixNiv.setText(" ");

        javax.swing.GroupLayout panneau_optionsLayout = new javax.swing.GroupLayout(panneau_options);
        panneau_options.setLayout(panneau_optionsLayout);
        panneau_optionsLayout.setHorizontalGroup(
            panneau_optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneau_optionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneau_optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_options)
                    .addGroup(panneau_optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panneau_optionsLayout.createSequentialGroup()
                            .addGroup(panneau_optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_niveauChoix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_choixNiv, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneau_optionsLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panneau_optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btn_difficile, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_moyen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_facile, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panneau_optionsLayout.setVerticalGroup(
            panneau_optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneau_optionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_options)
                .addGap(134, 134, 134)
                .addComponent(btn_facile, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_moyen, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_difficile, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(lbl_niveauChoix)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_choixNiv)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        getContentPane().add(panneau_options, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 180, 620));

        setBounds(0, 0, 1227, 684);
    }// </editor-fold>//GEN-END:initComponents


    private void btn_rougeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rougeActionPerformed
        // TODO add your handling code here:
        cpt += 1; //nb de clic +1 pour Jeu()
        cptCmbC += 1; // compteur pour chaque cellule de combChoisie
        Y += 1;
        zone_mess.setText("Vous avez clique sur le bouton rouge\nOn en est à Y : " + Y + " et X :" + X + "\n cpt = " + cpt + " cptCombC = " + cptCmbC);

        grilleCouleurs[X][Y].affecterCouleur("rouge");
        combChoisie[cptCmbC] = "Rouge"; // rentre rouge dans colonne pour ensuite comparer

        repaint();
        Jeu();
    }//GEN-LAST:event_btn_rougeActionPerformed

    private void btn_orangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_orangeActionPerformed
        // TODO add your handling code here:
        cpt += 1; //nb de clic +1 pour Jeu()
        cptCmbC += 1; // compteur pour chaque cellule de combChoisie
        Y += 1;
        zone_mess.setText("Vous avez clique sur le bouton orange\nOn en est à Y : " + Y + " et X :" + X + "\n cpt = " + cpt + " cptCombC = " + cptCmbC);

        grilleCouleurs[X][Y].affecterCouleur("orange");

        combChoisie[cptCmbC] = "Orange"; // rentre orange dans colonne pour ensuite comparer

        repaint();
        Jeu();
    }//GEN-LAST:event_btn_orangeActionPerformed

    private void btn_magentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_magentaActionPerformed
        // TODO add your handling code here:
        cpt += 1; //nb de clic +1 pour Jeu()
        cptCmbC += 1; // compteur pour chaque cellule de combChoisie
        Y += 1;
        zone_mess.setText("Vous avez clique sur le bouton magenta\nOn en est à Y : " + Y + " et X :" + X + "\n cpt = " + cpt + " cptCombC = " + cptCmbC);

        grilleCouleurs[X][Y].affecterCouleur("magenta");
        combChoisie[cptCmbC] = "Magenta"; // rentre magenta dans colonne pour ensuite comparer

        repaint();
        Jeu();
    }//GEN-LAST:event_btn_magentaActionPerformed

    private void btn_demarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_demarrerActionPerformed
        panneau_grille.repaint(); //on vide la grille pour commencer une nouvelle partie
        panneau_grille.setVisible(true);
        panneau_infos.setVisible(true);
        panneau_couleurs.setVisible(true);
        btn_demarrer.setVisible(false);
        debuterPartie();
    }//GEN-LAST:event_btn_demarrerActionPerformed

    private void btn_vertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vertActionPerformed
        // TODO add your handling code here:
        cpt += 1; //nb de clic +1 pour Jeu()
        cptCmbC += 1; // compteur pour chaque cellule de combChoisie
        Y += 1;
        zone_mess.setText("Vous avez clique sur le bouton vert\nOn en est à Y : " + Y + " et X :" + X + "\n cpt = " + cpt + " cptCombC = " + cptCmbC);

        grilleCouleurs[X][Y].affecterCouleur("vert");
        combChoisie[cptCmbC] = "Vert"; // rentre magenta dans colonne pour ensuite comparer

        repaint();
        Jeu();
    }//GEN-LAST:event_btn_vertActionPerformed

    private void btn_jauneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jauneActionPerformed
        // TODO add your handling code here:
        cpt += 1; //nb de clic +1 pour Jeu()
        cptCmbC += 1; // compteur pour chaque cellule de combChoisie
        Y += 1;
        zone_mess.setText("Vous avez clique sur le bouton jaune\nOn en est à Y : " + Y + " et X :" + X + "\n cpt = " + cpt + " cptCombC = " + cptCmbC);

        grilleCouleurs[X][Y].affecterCouleur("jaune");
        combChoisie[cptCmbC] = "Jaune"; // rentre magenta dans colonne pour ensuite comparer

        repaint();
        Jeu();
    }//GEN-LAST:event_btn_jauneActionPerformed

    private void btn_bleuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bleuActionPerformed
        // TODO add your handling code here:
        cpt += 1; //nb de clic +1 pour Jeu()
        cptCmbC += 1; // compteur pour chaque cellule de combChoisie
        Y += 1;
        zone_mess.setText("Vous avez clique sur le bouton bleu\nOn en est à Y : " + Y + " et X :" + X + "\n cpt = " + cpt + " cptCombC = " + cptCmbC);

        grilleCouleurs[X][Y].affecterCouleur("bleu");
        combChoisie[cptCmbC] = "Bleu"; // rentre magenta dans colonne pour ensuite comparer

        repaint();
        Jeu();
    }//GEN-LAST:event_btn_bleuActionPerformed

    private void btn_moyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moyenActionPerformed
        // TODO add your handling code here:
        lbl_niveauChoix.setVisible(true);
        lbl_choixNiv.setText("moyen");
        btn_facile.setVisible(false);
        btn_moyen.setVisible(false);
        btn_difficile.setVisible(false);
        int nbcoups = Options();
    }//GEN-LAST:event_btn_moyenActionPerformed

    private void btn_difficileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_difficileActionPerformed
        // TODO add your handling code here:
        lbl_niveauChoix.setVisible(true);
        lbl_choixNiv.setText("difficile");
        btn_facile.setVisible(false);
        btn_moyen.setVisible(false);
        btn_difficile.setVisible(false);
        int nbcoups = Options();
    }//GEN-LAST:event_btn_difficileActionPerformed

    private void btn_facileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_facileActionPerformed
        // TODO add your handling code here:
        lbl_niveauChoix.setVisible(true);
        lbl_choixNiv.setText("facile");
        btn_facile.setVisible(false);
        btn_moyen.setVisible(false);
        btn_difficile.setVisible(false);
        int nbcoups = Options();
    }//GEN-LAST:event_btn_facileActionPerformed

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
    private javax.swing.JButton btn_difficile;
    private javax.swing.JButton btn_facile;
    private javax.swing.JButton btn_jaune;
    private javax.swing.JButton btn_magenta;
    private javax.swing.JButton btn_moyen;
    private javax.swing.JButton btn_orange;
    private javax.swing.JButton btn_rouge;
    private javax.swing.JButton btn_vert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbl_choixNiv;
    private javax.swing.JTextArea lbl_combSecrete;
    private javax.swing.JLabel lbl_infos_partie;
    private javax.swing.JLabel lbl_message;
    private javax.swing.JLabel lbl_nbCoul;
    private javax.swing.JLabel lbl_nbCoul1;
    private javax.swing.JLabel lbl_nbCoulPlacmt;
    private javax.swing.JLabel lbl_niveauChoix;
    private javax.swing.JLabel lbl_options;
    private javax.swing.JLabel lbl_palette_couleurs;
    private javax.swing.JLabel lbl_palette_couleurs1;
    private javax.swing.JPanel panneau_combSecrete;
    private javax.swing.JPanel panneau_couleurs;
    private javax.swing.JPanel panneau_grille;
    private javax.swing.JPanel panneau_infos;
    private javax.swing.JPanel panneau_message;
    private javax.swing.JPanel panneau_options;
    private javax.swing.JTextArea textarea_CoulOK;
    private javax.swing.JTextArea textarea_CoulPlacmtOK;
    private javax.swing.JTextArea zone_mess;
    // End of variables declaration//GEN-END:variables

}
