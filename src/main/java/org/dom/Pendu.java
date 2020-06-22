package org.dom;


import Model.Partie;
import javafx.scene.Parent;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;



public class Pendu extends Parent {

    private final StackPane pane;


    // Constructeur
    public Pendu () {
        pane = new StackPane();
        // Taille
        pane.setPrefSize (400, 350);
        // Positionnement
        pane.setTranslateX (0);
        pane.setTranslateY (0);
        getChildren().add(pane);
        // Appel de la fonction dessine
        dessine();
    }

    /**
     * Rectangle noir
     */
    public void dessine(){
        pane.getChildren().clear();

        // Déssiner un fond
        Rectangle rectangle;
        rectangle = new Rectangle(380, 380);

        // Couleur et bordure
        rectangle.setFill(Color.BLACK);
        rectangle.setArcWidth(30);
        rectangle.setArcHeight(30);

        // Effet de reflexion
        Reflection reflex = new Reflection();
        reflex.setFraction (0.25);
        reflex.setBottomOpacity (0);
        reflex.setTopOpacity (0.5);
        rectangle.setEffect (reflex);
        pane.getChildren().add(rectangle);
        dessinePotence ();
        dessinPendu();
    }


    /**
     * La Potence
     */
    private void dessinePotence(){

        // Poteau vertical
        Line l1 = new Line(0,20,0,318);
        l1.setStrokeWidth (4);
        l1.setStroke (Color.WHITE);
        l1.setTranslateX (-60);

        // Poteau horizontal
        Line l2 = new Line(0,0,120,0);
        l2.setStrokeWidth (4);
        l2.setStroke (Color.WHITE);
        l2.setTranslateY (-150);

        // Traverse
        Line l3 = new Line(0,0,58,-58);
        l3.setStrokeWidth (4);
        l3.setStroke (Color.WHITE);
        l3.setTranslateX (-30);
        l3.setTranslateY (-120);

        //Pied
        Line l4 = new Line(0,0,100,0);
        l4.setStrokeWidth (4);
        l4.setStroke (Color.WHITE);
        l4.setTranslateX (-60);
        l4.setTranslateY (150);

        // Ajout de l1 au pane
        pane.getChildren().addAll(l1, l2, l3, l4);

    }


    /**
     * Le pendu
     */
    private void dessinPendu(){
        // Dynamique en fonction du nombre de vie
        int nbrVie = Partie.getInstance ().getMonJoueur ().getNombreVies ();
        // Dessin de la corde
        if(nbrVie < 7){
            Line l = new Line(0,20,0,50);
            l.setStrokeWidth (4);
            l.setStroke (Color.WHITE);
            l.setTranslateX (40);
            l.setTranslateY (-131);
            pane.getChildren().add(l);
        }

        // Dessin de la tête
        if(nbrVie < 6){
            Circle c = new Circle(20);
            c.setStrokeWidth (4);
            c.setStroke (Color.WHITE);
            c.setTranslateX (40);
            c.setTranslateY (-93);
            pane.getChildren().add(c);
        }

        // Dessin du corp
        if(nbrVie < 5){
            Line l = new Line(0,0,0,50);
            l.setStrokeWidth (4);
            l.setStroke (Color.WHITE);
            l.setTranslateX (40);
            l.setTranslateY (-44);
            pane.getChildren().add(l);
        }

        // Dessin du bras gauche ( par rapport à l'écran )
        if(nbrVie < 4){
            Line l = new Line(10,0,60,-40);
            l.setStrokeWidth (4);
            l.setStroke (Color.WHITE);
            l.setTranslateX (15);
            l.setTranslateY (-44);
            pane.getChildren().add(l);
        }

        // Dessin du bras gauche ( par rapport à l'écran )
        if(nbrVie < 3){
            Line l = new Line(10,-40,60,0);
            l.setStrokeWidth (4);
            l.setStroke (Color.WHITE);
            l.setTranslateX (65);
            l.setTranslateY (-44);
            pane.getChildren().add(l);
        }

        // Dessin de la jambe gauche
        if(nbrVie < 2){
            Line l = new Line(10,0,30,-80);
            l.setStrokeWidth (4);
            l.setStroke (Color.WHITE);
            l.setTranslateX (30);
            l.setTranslateY (25);
            pane.getChildren().add(l);
        }

        // Dessin de la jambe droite
        if(nbrVie < 1){
            Line l = new Line(10,-80,30,0);
            l.setStrokeWidth (4);
            l.setStroke (Color.WHITE);
            l.setTranslateX (51);
            l.setTranslateY (25);
            pane.getChildren().add(l);
        }

    }

}
