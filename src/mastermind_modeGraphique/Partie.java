/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_modeGraphique;

import static java.util.Arrays.compare;
import java.util.Scanner;

/**
 *
 * @author scottfullagar
 */
public class Partie {
    
    //choix difficulté partie --> + ou - de coups pour trouver la combS
    public int Options() {
        int coups = 0;
        System.out.println("Choisissez un mode :\n1. Niveau facile\n2. Niveau moyen \n3. Niveau difficile");
        Scanner sc = new Scanner(System.in);
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
    }
    
    public void debuterPartie() {
        
        System.out.println("Bienvenue dans le MasterMind de Scotty & Lélé :) ");
        //on génère une combinaison secrete
        Combinaison cs = new Combinaison();
        cs.combinaisonSecrete();
        
        int nbCoups = Options(); //choix difficulté du niveau
        
        for (int i = 0; i < nbCoups; i++) {
            int coupsRestant = nbCoups;
            coupsRestant--;
            System.out.println("Vous disposez de "+coupsRestant+" coups. ");
            Combinaison cc = new Combinaison();
            cc.combinaisonChoisie(); //demande une combinaison au player
            
            Combinaison compare = new Combinaison();
            int[] nbok = compare.Comparaison(cs.combSecret, cc.combChoisie); //.Comparaison(Combinaison[] combS , Combinaison[] combC);
            
            Combinaison etregagnant = new Combinaison();
            boolean gagner = etregagnant.Gagner(nbok);
            
            if (gagner == true) {
                System.out.println("Vous avez deviné le code secret !!! ");
            }
            else {
                System.out.println("Retentez votre chance");
            }
           
        }
        
    }
    
}
