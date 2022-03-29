package appli.ininity.controler;

import appli.ininity.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Accueil {
    @FXML
    void Onclickidentifier(ActionEvent event) {
        HelloApplication.changeScene("connexion",new Connexion());
    }

    @FXML
    void Onclicksinscrire(ActionEvent event) {
        HelloApplication.changeScene("inscription",new Inscription());
    }
}