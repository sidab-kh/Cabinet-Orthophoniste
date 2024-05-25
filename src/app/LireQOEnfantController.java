package app;

import app.mvc.Controlleur;
import app.util.enumerations.ECategoriesQOEnfant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LireQOEnfantController {

	Controlleur controlleur;
	private String[] CategoriesEnfant = ECategoriesQOEnfant.getAllStrings();
	
    @FXML
    private ChoiceBox<String> categorieBox;

    @FXML
    private TextArea enonceArea;

    @FXML
    private Text erreurText;
    
    @FXML
    private void initialize() { 
    	controlleur = Controlleur.getInstance();
    	categorieBox.getItems().addAll(CategoriesEnfant);
    }

    @FXML
    private void HandleAjouterQuestionButtonAction(ActionEvent event) {
    	// String categorie = categorieBox.getValue(); ...
    	// Verifier si champs vides et set le erreurText
    }

    @FXML
    private void HandleQuitterButtonAction(MouseEvent event) {
    	// retour vers anamnese creation anamnese
    }
}