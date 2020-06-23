package org.dom;


import Model.Partie;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{
            Partie.getInstance().nouvellePartie ();
            // Panel, Layout
            Group root = new Group();
            // Création d'une nouvelle scène
            Scene scene = new Scene(root, 820,400, Color.AZURE);
            Pendu pendu = new Pendu();

            Saisie saisie = new Saisie(pendu);
            root.getChildren().addAll(pendu, saisie);

            primaryStage.setTitle("Le jeu du Pendu");
            primaryStage.setScene(scene);
            primaryStage.setResizable (false);
            primaryStage.show();
        }



    }

