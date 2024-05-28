package app;

import java.util.ArrayList;

import app.data.bilans.BilanOrthophonique;
import app.data.questions.QO;
import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class DeroulerAnamneseController {
	
	Controlleur controlleur;
	Contexte contexte;
	BilanOrthophonique bo;
	ArrayList<QO> questions;
	int indiceQuestion = 0;
	
    @FXML
    private Text erreurText, intituleAnamneseText, questionText, categorieText;

    @FXML
    private TextArea reponseArea, enonceArea;
    
    @FXML
    private Button nextButton;

    @FXML
    private void initialize() { 
    	controlleur = Controlleur.getInstance();    	
    	contexte = Contexte.getInstance();
    	erreurText.setVisible(false);
    	bo = contexte.getBo();
    	questions = (ArrayList<QO>) bo.getAnamnese().getQuestions();   	
    	intituleAnamneseText.setText("Nom de l'anamnèse : " + bo.getAnamnese().getNomAnamnese());
    	setQuestionText(0);
    	enonceArea.setText(questions.get(0).getEnonce());
    	categorieText.setText(questions.get(0).getCategorie().getString());
    }

	@FXML
    private void handleProchaineQuestionButtonAction(ActionEvent event) {
		String reponse = reponseArea.getText();
		if (reponse.isEmpty() || reponse == null) {
        	// Champ vide
            erreurText.setText("Veuillez entrer une réponse.");
            erreurText.setVisible(true);
            return;
        }
		questions.get(indiceQuestion++).repondre(reponse);
		// Fin des questions
		if (indiceQuestion == questions.size()) {
			Main.changerScene(EScenes.CREER_EPREUVES_CLINIQUES);
			return;
		}
		// La derniere question
		if (indiceQuestion == questions.size()-1) {
			nextButton.setText("Terminer l'anamnèse");
		}
		// Mise a jour des champs pour la prochaine question
		setQuestionText(indiceQuestion);
    	enonceArea.setText(questions.get(indiceQuestion).getEnonce());
    	categorieText.setText(questions.get(indiceQuestion).getCategorie().getString());
    	reponseArea.clear();
    	erreurText.setVisible(false);
	}
	
	private void setQuestionText(int i) {
		questionText.setText("Question " + (i+1) + "/" + questions.size());
	}

    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
    	contexte.clear();
    	Main.changerScene(EScenes.TALKTRACK);
    }
}
