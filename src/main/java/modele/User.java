package modele;

import BDD.BDD;

import java.sql.*;

public class User {
    private String nom;
    private String prenom;
    private String email;
    private String mot_de_passe;
    private boolean estdmine = false;

    public User(String email, String mot_de_passe) {
        this.email = email;
        this.mot_de_passe = mot_de_passe;
    }

    public User( String email, String mot_de_passe,String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
    }

    public void connexion(BDD Connexion) throws SQLException {


        PreparedStatement maRequete = Connexion.getCnx().prepareStatement("Select * from user where email=? and mot_de_passe=? ");
        maRequete.setString(1,this.email);
        maRequete.setString(2,this.mot_de_passe);

    }

    public void inscrire(BDD Connexion) throws SQLException {



        PreparedStatement maRequeteVerifie = Connexion.getCnx().prepareStatement("Select * from user where email=? and mot_de_passe=? ");
        maRequeteVerifie.setString(1,this.email);
        maRequeteVerifie.setString(2,this.mot_de_passe);

        ResultSet mesResultas = maRequeteVerifie.executeQuery();

        if (mesResultas.next()){
            System.out.println("Un compte existe déjà au nom de : "+this.nom+" "+this.prenom+".");
        }

        else {
            PreparedStatement maRequete = Connexion.getCnx().prepareStatement("Insert into user(nom,prenom,email,mot_de_passe) VALUES (?,?,?,?)");
            maRequete.setString(1,this.nom);
            maRequete.setString(2,this.prenom);
            maRequete.setString(3,this.email);
            maRequete.setString(4,this.mot_de_passe);
            maRequete.executeUpdate();
        }
    }

}
