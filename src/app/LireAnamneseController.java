package app;

import java.util.List;
import app.data.bilans.Anamnese;
import app.data.questions.QO;
import app.mvc.Controlleur;
import app.mvc.SceneData;
import app.util.enumerations.EScenes;
import app.util.enumerations.ETypesPatients;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LireAnamneseController {

	Controlleur controlleur;
	SceneData donneesScene;
	
    @FXML
    private ToggleGroup Patient;

    @FXML
    private RadioButton adulteButton;

    @FXML
    private RadioButton enfantButton;

    @FXML
    private Text erreurText;

    @FXML
    private TextField intituleField;

    @FXML
    private TextArea questionsArea;

    @FXML
    private void initialize() {
    	controlleur = Controlleur.getInstance();
    	erreurText.setVisible(false);
    	if ( (donneesScene = controlleur.getSceneData()) == null ) {
    		donneesScene = controlleur.addSceneData(false, null);
    	} else {
    		intituleField.setText(donneesScene.getIntituleField());
    		if (donneesScene.isAdulteButton())
    			adulteButton.setSelected(true);
    	}
    	updateQuestionsArea();
    }
    
    @FXML
    void handleAjouterQuestionButtonAction() {
    	donneesScene.setIntituleField(intituleField.getText());
    	if (adulteButton.isSelected()) {
    		donneesScene.setAdulteButton(true);
            Main.changerScene(EScenes.LIRE_QO_ADULTE);
        } else if (enfantButton.isSelected()) {
        	donneesScene.setAdulteButton(false);
            Main.changerScene(EScenes.LIRE_QO_ENFANT);
        }
    }

    @FXML
    void handleCreerAnamneseButtonAction(ActionEvent event) {
        String nomAnamnese = intituleField.getText();
        List<QO> questions = donneesScene.getQuestions();
        ETypesPatients typeAnamnese = adulteButton.isSelected() ? ETypesPatients.ADULTE : ETypesPatients.ENFANT;

        // Vérifer si le nom de l'anamnese est vide
        if (nomAnamnese == null || nomAnamnese.trim().isEmpty()) {
            erreurText.setText("Le nom de l'anamnèse est obligatoire.");
            erreurText.setVisible(true);
            return;
        }

        // Vérifier si il n'y a pas de questions
        if (questions.isEmpty()) {
            erreurText.setText("Vous devez ajouter au moins une question.");
            erreurText.setVisible(true);
            return;
        }

        // Créer et ajouter l'anamnese
        Anamnese anamnese = new Anamnese(nomAnamnese, questions, typeAnamnese);
        controlleur.getServiceOrthophoniste().ajouterAnamnese(anamnese);

        // Effacer les questions et redirection vers le menu anamnese
        donneesScene.clearQuestions();
        controlleur.clearSceneData();
        Main.changerScene(EScenes.ANAMNESES);
    }


    @FXML
    void handleQuitterButtonAction(MouseEvent event) { Main.changerScene(EScenes.ANAMNESES); }

    @FXML
    void handleTypePatientButtonAction(ActionEvent event) {
    	intituleField.clear();
    	questionsArea.clear();
    	donneesScene.clearQuestions();
    }
    
    private void updateQuestionsArea() {
        List<QO> questions = donneesScene.getQuestions();
        StringBuilder questionsText = new StringBuilder();
        for (QO question : questions) {
            questionsText.append("- " + question.getEnonce() + " ?").append("\n");
        }
        questionsArea.setText(questionsText.toString());
    }
}