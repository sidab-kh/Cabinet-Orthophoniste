package app;

import java.util.ArrayList;

import app.data.bilans.EpreuveClinique;
import app.data.tests.Test;
import app.data.tests.TestExercices;
import app.data.tests.TestQuestionnaire;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class DeroulerEpreuvesCliniquesController {

	private Contexte contexte;
	ArrayList<EpreuveClinique> epreuves;
	Test test;
	int indiceEpreuve;
	
    @FXML
    private Text epreuveText, intituleTestText, typeTestText;
    
    @FXML
    private TextArea testsArea;
	
    @FXML
    private void initialize() {
    	contexte = Contexte.getInstance();
    	epreuves = (ArrayList<EpreuveClinique>) contexte.getBo().getEpreuvesCliniques();
    	indiceEpreuve = contexte.getIndiceEpreuve();
    	test = epreuves.get(indiceEpreuve).getTest();
    	setEpreuveText(indiceEpreuve);
    	intituleTestText.setText(test.getNom());
    	if (test instanceof TestQuestionnaire)
    		typeTestText.setText("Questionnaire");
    	else
    		typeTestText.setText("Exercice");
    	afficherTestsScores();
    }

	@FXML
    private void handleCommencerTestButtonAction(ActionEvent event) {
    	if (test instanceof TestQuestionnaire)
    		Main.changerScene(EScenes.DEROULER_TEST_QUESTIONNAIRE);
    	else
    		Main.changerScene(EScenes.DEROULER_TEST_EXERCICES);
    }

    private void setEpreuveText(int i) {
		epreuveText.setText("Épreuve " + (i+1) + "/" + epreuves.size());
	}
    
    private void afficherTestsScores() {
    	testsArea.clear();
    	for (int i = 0; i < epreuves.size(); i++) {
			Test test = epreuves.get(i).getTest();
			int baremeTotal;
			if (test instanceof TestQuestionnaire)
				baremeTotal = ((TestQuestionnaire) test).getQuestions().size() * 10;
	    	else
	    		baremeTotal = ((TestExercices) test).getCompteRendu().size() * 10;
			if (i < indiceEpreuve) {
				testsArea.appendText((i+1) + ") " + test.getNom() + "/  score : " + test.getScoreTotal()
						+ "/" + baremeTotal + "\n");
			} else {
				testsArea.appendText((i+1) + ") " + test.getNom() + "\n");
			}			
		}
	}
    
    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
    	contexte.clear();
    	Main.changerScene(EScenes.TALKTRACK);
    }
}
