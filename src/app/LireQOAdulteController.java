package app;

import app.data.questions.QO;
import app.mvc.Controlleur;
import app.util.enumerations.ECategoriesQOAdulte;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LireQOAdulteController {

	Controlleur controlleur;
	Contexte contexte;
	private String[] CategoriesAdulte = ECategoriesQOAdulte.getAllStrings();
	
    @FXML
    private ChoiceBox<String> categorieBox;

    @FXML
    private TextArea enonceArea;

    @FXML
    private Text erreurText;
    
    @FXML
    private void initialize() { 
    	controlleur = Controlleur.getInstance();
    	categorieBox.getItems().addAll(CategoriesAdulte);
    	erreurText.setVisible(false);
    	contexte = Contexte.getInstance();
    }

    @FXML
    private void HandleAjouterQuestionButtonAction(ActionEvent event) {
    	String enonce = enonceArea.getText();
        String categorieStr = categorieBox.getValue();

        if (enonce == null || enonce.isEmpty() || categorieStr == null) {
            erreurText.setText("Tous les champs sont obligatoires.");
            erreurText.setVisible(true);
            return;
        }

        ECategoriesQOAdulte categorie = ECategoriesQOAdulte.getCategorieFromString(categorieStr);
        QO question = new QO(enonce, categorie);
        contexte.addQuestion(question);

        // Retourner vers creation anamnese
        Main.changerScene(EScenes.LIRE_ANAMNESE);
    }

    @FXML
    private void HandleQuitterButtonAction(MouseEvent event) {
    	Main.changerScene(EScenes.LIRE_ANAMNESE);
    }
}
