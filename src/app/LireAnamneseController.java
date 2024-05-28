package app;

import java.util.List;
import app.data.bilans.Anamnese;
import app.data.questions.QO;
import app.mvc.Controlleur;
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
	Contexte contexte;
	
    @FXML
    private ToggleGroup Patient;

    @FXML
    private RadioButton adulteButton, enfantButton;

    @FXML
    private Text erreurText;

    @FXML
    private TextField intituleField;

    @FXML
    private TextArea questionsArea;

    @FXML
    private void initialize() {
    	controlleur = Controlleur.getInstance();
    	contexte = Contexte.getInstance();
    	intituleField.setText(contexte.getIntituleField());
    	adulteButton.setSelected(contexte.isAdulteButton());
    	erreurText.setVisible(false);
    	updateQuestionsArea();
    }
    
    @FXML
    private void handleAjouterQuestionButtonAction() {
    	contexte.setIntituleField(intituleField.getText());
    	if (adulteButton.isSelected()) {
    		contexte.setAdulteButton(true);
            Main.changerScene(EScenes.LIRE_QO_ADULTE);
        } else if (enfantButton.isSelected()) {
        	contexte.setAdulteButton(false);
            Main.changerScene(EScenes.LIRE_QO_ENFANT);
        }
    }

    @FXML
    private void handleCreerAnamneseButtonAction(ActionEvent event) {
        String nomAnamnese = intituleField.getText();
        List<QO> questions = contexte.getQuestions();
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

        // Effacement du contexte et redirection vers le menu anamnese
        contexte.clear();
        Main.changerScene(EScenes.ANAMNESES);
    }

    @FXML
    private void handleQuitterButtonAction(MouseEvent event) { Main.changerScene(EScenes.ANAMNESES); }

    @FXML
    private void handleTypePatientButtonAction(ActionEvent event) {
    	intituleField.clear();
    	questionsArea.clear();
    	contexte.clearQuestions();
    }
    
    private void updateQuestionsArea() {
        List<QO> questions = contexte.getQuestions();
        if (questions == null) return;
        StringBuilder questionsText = new StringBuilder();
        for (QO question : questions) {
            questionsText.append("- " + question.getEnonce() + " ?").append("\n");
        }
        questionsArea.setText(questionsText.toString());
    }
}