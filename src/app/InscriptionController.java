package app;

import app.mvc.Controlleur;
import app.mvc.Orthophoniste;
import app.util.enumerations.EScenes;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class InscriptionController {

	Controlleur controlleur;
	
    @FXML
    private TextField nomField, prenomField, adresseField, emailField, telephoneField;

    @FXML
    private PasswordField motDePasseField;

    @FXML
    private Button inscriptionButton, connexionButton;
    
    @FXML
    private Text erreurText;
    
    @FXML
    private void initialize() {
    	controlleur = Controlleur.getInstance();
    	erreurText.setVisible(false);
    }

    @FXML // Lire les informations
    private void handleInscriptionButtonAction() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String adresse = adresseField.getText();
        String email = emailField.getText();
        String telephone = telephoneField.getText();
        String motDePasse = motDePasseField.getText();
        String messageErreur = "";

        if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || email.isEmpty() || telephone.isEmpty() || motDePasse.isEmpty()) {
            messageErreur = "Tous les champs sont obligatoires.";
        } else if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            messageErreur = "Adresse email invalide.";
        } else if (!telephone.matches("\\d{10}")) {
            messageErreur = "Numéro de téléphone invalide. Doit contenir 10 chiffres.";
        } else if (motDePasse.length() < 8) {
            messageErreur = "Le mot de passe doit contenir au moins 8 caractères.";
        }
        
        if (!messageErreur.isEmpty()) {
            erreurText.setText(messageErreur);
            erreurText.setVisible(true);
        } else {
            controlleur.inscription(new Orthophoniste(nom, prenom, adresse, email, motDePasse,  telephone));
            Main.changerScene(EScenes.AGENDA);
        }
    }

    @FXML // Aller a la page de connexion
    private void handleConnexionButtonAction() { Main.changerScene(EScenes.CONNEXION); }
}