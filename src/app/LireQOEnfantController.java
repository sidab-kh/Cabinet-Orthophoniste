package app;

import app.data.questions.QO;
import app.mvc.Controlleur;
import app.util.enumerations.ECategoriesQOEnfant;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LireQOEnfantController {

	Controlleur controlleur;
	Contexte contexte;
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
    	erreurText.setVisible(false);
    	contexte = Contexte.getInstance();
    }

    @FXML
    private void handleAjouterQuestionButtonAction(ActionEvent event) {
    	String enonce = enonceArea.getText();
        String categorieStr = categorieBox.getValue();

        if (enonce == null || enonce.isEmpty() || categorieStr == null) {
            erreurText.setText("Tous les champs sont obligatoires.");
            erreurText.setVisible(true);
            return;
        }

        ECategoriesQOEnfant categorie = ECategoriesQOEnfant.getCategorieFromString(categorieStr);
        QO question = new QO(enonce, categorie);
        contexte.addQuestion(question);

        // Retourner vers creation anamnese
        Main.changerScene(EScenes.LIRE_ANAMNESE);
    }

    @FXML
    private void handleQuitterButtonAction(MouseEvent event) { Main.changerScene(EScenes.LIRE_ANAMNESE); }
}