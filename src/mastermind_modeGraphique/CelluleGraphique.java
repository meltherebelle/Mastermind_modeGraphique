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
    
    //on met un attribut couleur
    String colorToAffect = "vide";
    int cx;
    int cy;
    
    //toutes les couleurs de combinaisons pour nos cellules graphiques
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/vide.png"));
    ImageIcon img_bleu = new javax.swing.ImageIcon(getClass().getResource("/images/bleu.png"));
    ImageIcon img_jaune = new javax.swing.ImageIcon(getClass().getResource("/images/jaune.png"));
    ImageIcon img_rouge = new javax.swing.ImageIcon(getClass().getResource("/images/rouge.png"));
    ImageIcon img_magenta = new javax.swing.ImageIcon(getClass().getResource("/images/magenta.png"));
    ImageIcon img_vert = new javax.swing.ImageIcon(getClass().getResource("/images/vert.png"));
    ImageIcon img_orange = new javax.swing.ImageIcon(getClass().getResource("/images/orange.png"));

    public CelluleGraphique(int x, int y, String couleur) {
        this.cx=x;
        this.cy=y;
        //on affecte la couleur à la cellule
        affecterCouleur(couleur);
    }
    
    //permet de changer la couleur de cellule graphique
    public String affecterCouleur(String couleur) {
        colorToAffect = couleur; //colorToAffect doit etre un attribu, non pas une variable locale
        return couleur;
    }

    //cette fonction permet de dessiner la cellule graphique
    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        setIcon(img_vide); //on initialise la grille en cases vides = blanc
        //String color = //il faut récupérer la couleur cliquée dans cette variable pour ensuite faire des switch case
        
        switch (colorToAffect) {
            case "rouge" :
                setIcon(img_rouge);
                break;
            case "bleu" :
                setIcon(img_bleu);
                break;
            case "jaune" :
                setIcon(img_jaune);
                break;
            case "vert" :
                setIcon(img_vert);
                break;
            case "magenta" :
                setIcon(img_magenta);
                break;
            case "orange" :
                setIcon(img_orange);
                break; 
        }
        
    }
}


