package app.controllers;

import app.Main;
import app.mvc.Controlleur;
import app.mvc.Orthophoniste;
import app.util.enumerations.EScenes;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ProfilController {

	Controlleur controlleur;
	
    @FXML
    private Text nomText, prenomText, adresseText, telephoneText,  emailText;
    
    @FXML
    private PasswordField ancienMotDePasseField;
    
    @FXML
    private TextField nouveauMotDePasseField;
    
    @FXML
    private Text erreurText;

    @FXML // Remplir les informations de l'orthophoniste
    public void initialize() {
    	controlleur = Controlleur.getInstance();
    	
    	afficherInformations();
    }
    
    @FXML // Aller vers la page agenda
    private void goToAgenda() { Main.changerScene(EScenes.AGENDA); }
    
    @FXML // Aller vers la page des patients
    private void goToPatients() { Main.changerScene(EScenes.PATIENTS); }
    
    @FXML // Aller vers la pages des tests
    private void goToTests() { Main.changerScene(EScenes.TESTS); }
    
    @FXML // Aller vers la page des anamneses
    private void goToAnamneses() { Main.changerScene(EScenes.ANAMNESES); }
    
    @FXML // Aller vers la page d'aide
    private void goToAide() { Main.changerScene(EScenes.AIDE); }
    
    @FXML // Se deconnecter
    private void seDeconnecter() {
    	controlleur.deconnexion();
    	Main.changerScene(EScenes.CONNEXION);
    }
    
    @FXML // Afficher les informations de l'orthophoniste
    private void afficherInformations() {
    	Orthophoniste orthophoniste = controlleur.getServiceOrthophoniste().getOrthophoniste();
    	erreurText.setVisible(false);
        nomText.setText(orthophoniste.getNom());
        prenomText.setText(orthophoniste.getPrenom());
        adresseText.setText(orthophoniste.getAdresse());
        telephoneText.setText(orthophoniste.getNumeroTelephone());
        emailText.setText(orthophoniste.getEmail());
    }
    
    @FXML // Supprimer le compte de l'orthophoniste de la machine
    private void supprimerCompte() {
    	controlleur.supprimerCompte();
    	Main.changerScene(EScenes.INSCRIPTION);
    }

    @FXML // Changer le mot de passe de l'orthophoniste
    private void changerMotDePasse() {
        String ancienMotDePasse = ancienMotDePasseField.getText();
        String nouveauMotDePasse = nouveauMotDePasseField.getText();

        int resultatModification = controlleur.getServiceOrthophoniste().modifierMotDePasse(ancienMotDePasse, nouveauMotDePasse);
        switch(resultatModification) {
        	case 0 : // Cas reussite
        		erreurText.setFill(Color.BLACK);
        		erreurText.setText("Mot de passe modifié avec succès.");
        		erreurText.setVisible(true);
        		ancienMotDePasseField.clear();
        		nouveauMotDePasseField.clear();
        		break;
        	case 1 : // Cas mot de passe trop court
        		erreurText.setText("Nouveau mot de passe trop court !");
        		erreurText.setVisible(true);
        		break;
        	case 2 : // Cas mot de passe errone
        		erreurText.setText("Mot de passe erroné !");
        		erreurText.setVisible(true);
        		break;
        }
    }
}
