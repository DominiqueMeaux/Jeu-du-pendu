package org.dom;

import Model.Partie;
import Model.ResultatJoue;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class Touche extends Button {

    private final String valeur;
    private final Pendu pendu;
    private final Saisie saisie;


    public Touche (String valeur, Pendu pendu, Saisie saisie) {
        super (valeur);
        this.pendu = pendu;
        this.saisie = saisie;
        this.valeur = valeur;
        setPrefSize (20, 20);
        setStyle ("-fx-background-color: "
                + "linear-gradient(#020b02, #3a3a3a),"
                + "linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),"
                + "linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),"
                + "linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);"
                + "-fx-background-insets: 0,1,4,5,6;"
                + "-fx-background-radius: 9,8,5,4,3;"
                + "-fx-padding: 15 20 15 20;"
                + "-fx-font-family: \"Helvetica\";"
                + "-fx-font-size: 15px;"
                + "-fx-font-weight: bold;"
                + "-fx-text-fill: white;"
                + "-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1));"
        );
        setCursor (Cursor.HAND);

        //setOnAction (new EventHandler<ActionEvent>(){
           // @Override
          //  public void handle (ActionEvent event) {

           // }

          //  public void Handle(ActionEvent event) {
             //   System.out.println (".handle() "+ valeur);
           // }
      //  });
        
        // Fonction Lambda
        setOnAction((event)->{
            System.out.println ("org.dom.Touche.<init>() "+ valeur);
            ResultatJoue result;
            result = Partie.getInstance ().joue (valeur);
            switch(result){
                case LettreTrouvee:
                    saisie.afficherMotMystere ();
                    break;
                case JoueurPerd:
                    pendu.dessine();
                    break;

            }
            if(Partie.getInstance ().getMonJeu ().isMotTrouve ()){
                System.out.println ("Bravo, vous avez gagné !");
                if(new BoxDialogue("Fin de partie",  "Vous avez trouvé le mot mystère : " + Partie.getInstance ().getMonJeu ().getMotCourant (),
                         "Voulez-vous rejouer ?").isOk ()){
                    Partie.getInstance().nouvellePartie ();
                    saisie.afficherMotMystere ();
                    pendu.dessine ();
                    saisie.getClavier ().resetTouches ();

                }
                else {
                    System.exit (0);
                }
            }
            else if (Partie.getInstance ().getMonJoueur ().isPendu ()){
                System.out.println ("Vous avez perdu !");
                if(new BoxDialogue("Fin de partie",  "Vous n'avez pas trouvé le mot mystère :  " + Partie.getInstance ().getMonJeu ().getMotCourant (),
                        "Voulez-vous rejouer ?").isOk ()){
                    Partie.getInstance().nouvellePartie ();
                    saisie.afficherMotMystere ();
                    pendu.dessine ();
                    saisie.getClavier ().resetTouches ();

                }
                else {
                    System.exit (0);
                }
            }
            else {
                setDisable (true);
            }
        });
    }


}
