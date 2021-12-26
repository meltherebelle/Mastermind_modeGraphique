package mastermind_modeGraphique;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leaburriat
 */

//extension avec des propriétés graphiques - héritage de JButton
public class CelluleGraphique extends JButton {
    
    //télécharger image blanche=vide --> //ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/vide.png"));
    /*ImageIcon img_bleu = new javax.swing.ImageIcon(getClass().getResource("/images/bleu.png"));
    ImageIcon img_jaune = new javax.swing.ImageIcon(getClass().getResource("/images/jaune.png"));
    ImageIcon img_rouge = new javax.swing.ImageIcon(getClass().getResource("/images/rouge.png"));
    ImageIcon img_magenta = new javax.swing.ImageIcon(getClass().getResource("/images/magenta.png"));
    ImageIcon img_vert = new javax.swing.ImageIcon(getClass().getResource("/images/vert.png"));
    ImageIcon img_orange = new javax.swing.ImageIcon(getClass().getResource("/images/orange.png"));*/

    public CelluleGraphique(String couleur) {
        //on affecte la couleur à la cellule
        affecterCouleur(couleur);
    }
    
    //permet de changer la couleur de cellule graphique
    public void affecterCouleur(String couleur) {
        String colorToAffect = couleur;
        
    }

    //cette fonction permet de dessiner la cellule graphique
    /*@Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        if (CelluleAssocie.presenceTrouNoir() == true) {
            setIcon(img_trouNoir);
        } else if (CelluleAssocie.presenceDesintegrateur() == true) {
            setIcon(img_desint);
        } else {
            String couleur_jeton = CelluleAssocie.lireCouleurDuJeton();
            switch (couleur_jeton) {
                case "vide":
                    setIcon(img_vide);
                    break;
                case "Rouge":
                    setIcon(img_jetonRouge);
                    break;
                case "Jaune":
                    setIcon(img_jetonJaune);
                    break;
            }
        }
    }*/

}

