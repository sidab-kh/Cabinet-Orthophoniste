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

public class FinEpreuvesCliniquesController {

	private Contexte contexte;
	private ArrayList<EpreuveClinique> epreuves;
	
    @FXML
    private TextArea scoresArea;

    @FXML
    private void initialize() {  	
    	contexte = Contexte.getInstance();
    	epreuves = (ArrayList<EpreuveClinique>) contexte.getBo().getEpreuvesCliniques();
    	afficherTestsScores();
    }
    
    private void afficherTestsScores() {
    	for (int i = 0; i < epreuves.size(); i++) {
			Test test = epreuves.get(i).getTest();
			int baremeTotal;
			if (test instanceof TestQuestionnaire)
				baremeTotal = ((TestQuestionnaire) test).getQuestions().size() * 10;
	    	else
	    		baremeTotal = ((TestExercices) test).getCompteRendu().size() * 10;
			scoresArea.appendText((i+1) + ") " + test.getNom() + "/  score : " + test.getScoreTotal()
					+ "/" + baremeTotal + "\n");		
		}
	}
	@FXML
    private void handleProchaineEtapeButtonAction(ActionEvent event) {
		
    }

    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
    	contexte.clear();
    	Main.changerScene(EScenes.TALKTRACK);
    }
}
