package app;

import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ConnexionController {

	Controlleur controlleur;
	
    @FXML
    private TextField emailField;

    @FXML
    private PasswordField motDePasseField;

    @FXML
    private Button connexionButton;
    
    @FXML
    private Button inscriptionButton;
    
    @FXML
    private Text erreurText;

    @FXML
    private void initialize() {
    	controlleur = Controlleur.getInstance();
    	erreurText.setVisible(false);
    	handleConnexionButtonAction();
    }
    
    @FXML 
    private void handleConnexionButtonAction() {
        String email = emailField.getText();
        String motDePasse = motDePasseField.getText();
        
        int etat = controlleur.connexion(email, motDePasse);
        switch (etat) {
        	case 0 : // Cas champs vides
        		erreurText.setText("Tous les champs sont obligatoires.");
	        	erreurText.setVisible(true);
	        	break;
        	case 1 : // Cas compte inexistant
	        	erreurText.setText("Compte inexistant, veuillez vous inscrire.");
	        	erreurText.setVisible(true);
	        	break;
        	case 2 : // Cas mot de passe errone
	        	erreurText.setText("Mot de passe erroné, veuillez réessayer.");
	        	erreurText.setVisible(true);
	        	break;
	        case 3 : // Connexion reussie
	        	Main.changerScene(EScenes.AGENDA);
	        	break;
	        default :
        }
    }
    
    @FXML
    private void handleInscriptionButtonAction() { Main.changerScene(EScenes.INSCRIPTION); }
}
