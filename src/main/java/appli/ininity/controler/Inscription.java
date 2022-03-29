package appli.ininity.controler;

import BDD.BDD;
import appli.ininity.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.User;

import java.sql.SQLException;

public class Inscription {

    @FXML
    private TextField email;

    @FXML
    private Label errormessage;

    @FXML
    private TextField mot_de_passe;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField confirmemotdepasse;

    @FXML
    void OnClicksinscrir(ActionEvent event) throws SQLException {
        if(prenom.getText().isEmpty()||nom.getText().isEmpty()||mot_de_passe.getText().isEmpty()||email.getText().isEmpty()){
            errormessage.setText("Un champ est non renseignement");
        }else {
            if (!confirmemotdepasse.equals(mot_de_passe)) {
                errormessage.setText("Les mot de passe ne sont pas identique ");
                confirmemotdepasse.setStyle("-fx-text-box-border: red;");
                mot_de_passe.setStyle("-fx-text-box-border: red;");
            }else {
                BDD Bdd = new BDD();
                User user = new User(email.getText(),mot_de_passe.getText(),nom.getText(),prenom.getText());
                user.inscrire(Bdd);
                errormessage.setStyle("-fx-text-fill: green");
                errormessage.setText("félicitations de nous sommes à présent collaborateurs");
                HelloApplication.changeScene("");
            }
        }

    }

    @FXML
    void OnclickRetour(ActionEvent event) {
        HelloApplication.changeScene("accueill");
    }


}
