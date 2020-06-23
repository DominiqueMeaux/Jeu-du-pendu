package org.dom;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Clavier extends GridPane {

    private final static String[] alphabet = new String[]{
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
            "N",
            "O",
            "P",
            "Q",
            "R",
            "S",
            "T",
            "U",
            "V",
            "W",
            "X",
            "Y",
            "Z",
    };

    private final ArrayList<Touche> mesTouches;

    public Clavier (Pendu pendu, Saisie saisie) {
        // Appel du constructeur de la class parente
        super();
        // Instance du tableau
        mesTouches = new ArrayList<>();
        int column = 0, row = 0;
        // Espace entre les élément de la grille et l'éspace horizontal
        setHgap (10);
        setVgap (10);
        setPadding (new Insets (20, 0, 0, 0));
        for(String a : alphabet){
            if (column > 5){
                column = 0;
                row++;
            }
            mesTouches.add(new Touche(a, pendu, saisie));
            add (mesTouches.get (mesTouches.size() -1), column, row);
            column++;
        }
    }


    /**
     * Réinitialisation des touches du clavier en cas de nouvelle partie
     */
    public void resetTouches() {
        for (Touche t: mesTouches){
            t.setDisable(false);
        }
    }
}
