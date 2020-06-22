package org.dom;


// Vbox dispose ses enfants dans une seule colonne verticale ( si il y a une bordure le contenu sera disposé dans des encars )
import Model.Partie;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Saisie extends VBox {

    private final Pendu monPendu;
    private final Text motMystere;
    private final Clavier clavier;



    public Saisie (Pendu monPendu) {
        super();
        this.monPendu = monPendu;


        // Label du mot mystère
        Text label = new Text("Mot mystere");
        label.setFont (Font.font("Verdana",
                FontWeight.BOLD, FontPosture.REGULAR, 16
                ));
        label.setFill (Color.web ("#346d8e"));

        // Création d'un texte pour l'affichage du mot mystère
        motMystere = new Text();
        motMystere.setFont (Font.font("Verdana",
                FontWeight.BOLD, FontPosture.REGULAR, 18
        ));
        motMystere.setFill (Color.web ("#331a00"));
        clavier = new Clavier(monPendu, this);
        getChildren().addAll(label, motMystere, clavier);
        setTranslateX (410);
        setTranslateY (20);
        afficherMotMystere();
    }


    public void afficherMotMystere(){
        String text = "";
        String mot = Partie.getInstance ().getMonJeu ().getMotCourant ();
        int nbrLettres = Partie.getInstance ().getMonJeu ().getMotCourant ().length ();
        System.out.println ();
        for (int i = 0; i < nbrLettres; i++){
            char c = mot.charAt (i);
            if(! Partie.getInstance ().getMonJeu ().isLettresTrouvee (Character.toString (c).toUpperCase ())){
                text += "_ ";
            }
            else {
                text += Character.toString(c).toUpperCase () + " ";
            }
        }
        motMystere.setText (text);
    }


    public Clavier getClavier() {

        return clavier;
    }
}
