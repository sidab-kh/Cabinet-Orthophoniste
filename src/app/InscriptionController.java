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
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField adresseField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField telephoneField;

    @FXML
    private PasswordField motDePasseField;

    @FXML
    private Button inscriptionButton;

    @FXML
    private Button connexionButton;

    @FXML
    private Text inscriptionText;
    
    @FXML
    private void initialize() { controlleur = Controlleur.getInstance(); }

    @FXML // Lire les informations
    private void handleInscriptionButtonAction() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String adresse = adresseField.getText();
        String email = emailField.getText();
        String telephone = telephoneField.getText();
        String motDePasse = motDePasseField.getText();
        controlleur.inscription(new Orthophoniste(nom, prenom, adresse, email, motDePasse,  telephone));
        Main.changerScene(EScenes.AGENDA);
    }

    @FXML // Aller a la page de connexion
    private void handleConnexionButtonAction() { Main.changerScene(EScenes.CONNEXION); }
}