package Model;

import java.util.HashMap;

public class Joueur {

    private int nombreVies;
    private final HashMap<String,String> lettresUtilisees;

    /**
     * Constructeur
     */
    public Joueur(){

        // instance de lettreUtilisees
        lettresUtilisees = new HashMap<>();
        nombreVies = 7;
    }

    /**
     * Méthode public nouvelle partie
     */

    public void nouvellePartie(){
        nombreVies = 7;
        lettresUtilisees.clear();
    }

    /**
     * Si le joueur est pendu
     * @return
     */
    public boolean isPendu(){
        return nombreVies <= 0;
    }

    /**
     * Vérifie si la lettre a déjà été utilisé
     * @param lettre
     * @return
     */
    public boolean lettreDejaUtilisee(String lettre){
        return lettresUtilisees.containsKey(lettre);
    }

    /**
     * Ajoute la lettre à la liste des lettres déjà utilisés
     * @param Lettre
     */
    public void addLettreUtilisee(String Lettre){

    }

    /**
     * Joueur perd une vie
     */
    public void perdUneVie(){
        nombreVies --;
        System.out.println ("Il vous reste " + nombreVies + " vie");
    }


    public int getNombreVies () {
        return nombreVies;
    }
}
