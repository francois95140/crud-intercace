package appli.ininity.controler;

import BDD.BDD;
import appli.ininity.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.User;

import java.sql.SQLException;

public class Connexion {

    @FXML
    private TextField email;

    @FXML
    private TextField mot_de_passe;

    @FXML
    private Label errormessage;

    @FXML
    void OnclickRetour(ActionEvent event) {
        HelloApplication.changeScene("accueill");
    }

    @FXML
    void onButtonClick() throws SQLException {
        if(email.getText().isEmpty()){
            errormessage.setText("Email non renseignement");
            email.setStyle("-fx-text-box-border: red;");
        }else {
            errormessage.setText("Mot de passe non renseignement");
            mot_de_passe.setStyle("-fx-text-box-border: red;");

            if (email.getText().isEmpty() && mot_de_passe.getText().isEmpty()) {
                errormessage.setText("Email et Mot de passe non renseignement");
                email.setStyle("-fx-text-box-border: red;");
                mot_de_passe.setStyle("-fx-text-box-border: red;");
            }
        }

        BDD Bdd = new BDD();
        User user = new User(email.getText(),mot_de_passe.getText());
        user.connexion(Bdd);
        HelloApplication.changeScene("tablevue",new Tablevue());

    }
}
