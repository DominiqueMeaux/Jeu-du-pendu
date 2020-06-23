package org.dom;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;


    public class BoxDialogue extends Alert{

        private final Optional<ButtonType> result;
        public BoxDialogue (String titre, String entete, String message) {
            super (AlertType.CONFIRMATION);
            setTitle (titre);
            setHeaderText (entete);
            setContentText (message);
            result = showAndWait ();

        }


        /**
         *
         * @return un boolean
         */
        public boolean isOk() {
            return result.get().equals (ButtonType.OK);
        }

    }

