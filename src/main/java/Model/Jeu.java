package Model;

import java.util.HashMap;
import java.util.Random;

public class Jeu {
    private String [] mesMots;
    private int motCourant;
    // HasMap est une collection ( un peu comme un tableau sauf que c'est dynamique
    // première élément c'est une clé, le deuxième le type d'élément).
    private HashMap<String, String> lettresTrouvees;
    private int nbrLettresTrouvees;

    /**
     * Constructeur
     */

    public Jeu() {
        // Instance
        lettresTrouvees = new HashMap<>();
        initMots();
    }

    /**
     * Méthode d'initialisation de la liste des mots
     */

    private void initMots(){
        mesMots = new String[12];
        mesMots[0] = "web";
        mesMots[1] = "developper";
        mesMots[2] = "initialiser";
        mesMots[3] = "javascript";
        mesMots[4] = "declarer";
        mesMots[5] = "editeur";
        mesMots[6] = "ordinateur";
        mesMots[7] = "formation";
        mesMots[8] = "language";
        mesMots[9] = "polymorphisme";
        mesMots[10] = "encapsulation";
        mesMots[11] = "programmation";
    }



    /**
     * Création d'une nouvelle partie
     */
    public void nouvellePartie(){
        // reset des valeurs
        nbrLettresTrouvees = 0;
        lettresTrouvees.clear();
        // Tirage au sort du mot courant
        Random r = new Random ();
        motCourant = r.nextInt(mesMots.length - 1);


    }

    /**
     * Retourne le mot courant
     * @return
     */
    public String getMotCourant () {
        return mesMots[motCourant];
    }

    /**
     * Retourne vrai si le mot est trouvé sinon return faux
     * @return
     */
    public boolean isMotTrouve () {
        return mesMots[motCourant].length() == nbrLettresTrouvees;
    }

    /**
     *
     * @param lettre ( la lettre a chercher )
     * @return true si la lettre a déjà été trouvé
     */
    public boolean isLettresTrouvee(String lettre){
       // containsKey fait référence à la clé dont le mappage est censé être vérifié ( renvoi true si match )
        return lettresTrouvees.containsKey (lettre);
    }


    /**
     * Cherche la lettre dans le mot mystère
     * @param lettre
     * @return
     */
    public boolean chercheLettre(String lettre){
        int nombreOccurence = 0, index = 0;
        String m = mesMots[motCourant];
        while(true){
            index = m.toUpperCase().indexOf(lettre.toUpperCase(), index);
            if(index != -1){
                nombreOccurence++;
                index++;
            }
            else {
                break;
            }
        }
        // On ajoute le nb d'occurence à nombre de lettre trouvées
        // On ajoute la lettre trouvées à notre tableau (HashMap) de letrre
        if(nombreOccurence > 0){
            nbrLettresTrouvees += nombreOccurence;
            lettresTrouvees.put(lettre, lettre);
            return true;
        }
        return false;

    }

}
