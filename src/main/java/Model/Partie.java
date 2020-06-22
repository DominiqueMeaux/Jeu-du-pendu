package Model;

/**
 * @pattern: Singleton
 */


public class Partie {

    private static Model.Partie instance = null; // Instance unique
    private final Jeu monJeu;
    private final Joueur monJoueur;


    /**
     * Constructeur
     * Création des instances monJeu et monJoueur
     */
    private Partie() {
        monJeu = new Jeu();
        monJoueur = new Joueur();
        monJeu.nouvellePartie ();
        monJoueur.nouvellePartie ();
    }

    /**
     * Creation d'une instance si n'existe pas return instance
     * @return une partie
     */
    public static Model.Partie getInstance() {
        if(instance == null){
            instance = new Model.Partie ();
        }
        return instance;
    }

    public Jeu getMonJeu () {
        return monJeu;
    }

    public Joueur getMonJoueur () {
        return monJoueur;
    }


    /**
     * Créer une nouvelle partie
     */
    public void nouvellePartie(){
        monJeu.nouvellePartie();
        monJoueur.nouvellePartie ();
        System.out.println (monJeu.getMotCourant ());
    }


    /**
     * Méthode partie finie
     * Retourne vrai si le mot est trouvé ou si le joueur est pendu
     * @return trus si partie finie
     */
    public boolean isFinish(){
        if(monJeu.isMotTrouve()){
            return true;
        }
        if(monJoueur.isPendu ()){
            return true;
        }
        return false;
    }



    public Model.ResultatJoue joue(String lettre){
        if(!monJoueur.lettreDejaUtilisee (lettre)){
            monJoueur.addLettreUtilisee (lettre);
            if(monJeu.chercheLettre (lettre)){
                return Model.ResultatJoue.LettreTrouvee;
            }
            else{
                monJoueur.perdUneVie ();
                return Model.ResultatJoue.JoueurPerd;
            }
        }
        return Model.ResultatJoue.LettreUtilisee;
    }



}
