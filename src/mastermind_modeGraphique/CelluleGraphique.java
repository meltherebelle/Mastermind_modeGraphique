package mastermind_modeGraphique;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

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
    
    //toutes les couleurs de combinaisons pour nos cellules graphiques
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/vide.png"));
    ImageIcon img_bleu = new javax.swing.ImageIcon(getClass().getResource("/images/bleu.png"));
    ImageIcon img_jaune = new javax.swing.ImageIcon(getClass().getResource("/images/jaune.png"));
    ImageIcon img_rouge = new javax.swing.ImageIcon(getClass().getResource("/images/rouge.png"));
    ImageIcon img_magenta = new javax.swing.ImageIcon(getClass().getResource("/images/magenta.png"));
    ImageIcon img_vert = new javax.swing.ImageIcon(getClass().getResource("/images/vert.png"));
    ImageIcon img_orange = new javax.swing.ImageIcon(getClass().getResource("/images/orange.png"));

    public CelluleGraphique(int x, int y, String couleur) {
        //on affecte la couleur à la cellule
        affecterCouleur(couleur);
    }
    
    //permet de changer la couleur de cellule graphique
    public String affecterCouleur(String couleur) {
        String colorToAffect = couleur;
        return couleur;
    }

    //cette fonction permet de dessiner la cellule graphique
    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        setIcon(img_vide); //on initialise la grille en cases vides = blanc
        //String color = //il faut récupérer la couleur cliquée dans cette variable pour ensuite faire des switch case
        
        /*
        switch (color) {
            case "rouge" :
                setIcon(img_rouge);
                break;
        }*/
        
    }
}


