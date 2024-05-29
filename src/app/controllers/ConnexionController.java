package app.controllers;

import app.Main;
import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Contrôleur de la page de connexion.
 */
public class ConnexionController {

    /** Instance du contrôleur principal de l'application. */
    Controlleur controlleur;
    
    /** Champ de saisie de l'email. */
    @FXML
    private TextField emailField;

    /** Champ de saisie du mot de passe. */
    @FXML
    private PasswordField motDePasseField;

    /** Bouton de connexion. */
    @FXML
    private Button connexionButton;
    
    /** Bouton d'inscription. */
    @FXML
    private Button inscriptionButton;
    
    /** Message d'erreur. */
    @FXML
    private Text erreurText;

    /** Méthode d'initialisation du contrôleur. */
    @FXML 
    private void initialize() {
        controlleur = Controlleur.getInstance();
        erreurText.setVisible(false);
    }
    
    /** Action effectuée lors du clic sur le bouton de connexion. */
    @FXML 
    private void handleConnexionButtonAction() {
        String email = emailField.getText();
        String motDePasse = motDePasseField.getText();
        
        int etat = controlleur.connexion(email, motDePasse);
        switch (etat) {
            case 0: // Cas champs vides
                erreurText.setText("Tous les champs sont obligatoires.");
                erreurText.setVisible(true);
                break;
            case 1: // Cas compte inexistant
                erreurText.setText("Compte inexistant, veuillez vous inscrire.");
                erreurText.setVisible(true);
                break;
            case 2: // Cas mot de passe erroné
                erreurText.setText("Mot de passe erroné, veuillez réessayer.");
                erreurText.setVisible(true);
                break;
            case 3: // Connexion réussie
                Main.changerScene(EScenes.AGENDA);
                break;
            default:
        }
    }
    
    /** Action effectuée lors du clic sur le bouton d'inscription. */
    @FXML
    private void handleInscriptionButtonAction() { Main.changerScene(EScenes.INSCRIPTION); }
}