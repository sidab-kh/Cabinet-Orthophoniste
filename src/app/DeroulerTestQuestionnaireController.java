package app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import app.data.questions.Proposition;
import app.data.questions.QCM;
import app.data.questions.QCU;
import app.data.questions.QO;
import app.data.questions.Question;
import app.data.questions.QuestionAvecPropositions;
import app.data.tests.TestQuestionnaire;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class DeroulerTestQuestionnaireController {
	
	private Contexte contexte;
	private TestQuestionnaire test;
	private ArrayList<Question> questionnaire;
	private Question question;
	List<Proposition> propositions;
	private Map<Question, Integer> compteRendu;
	int indiceQuestion = 0;
	
    @FXML
    private Text erreurText, nomTestField, reponsetext, numeroQuestionText;

    @FXML
    private TextField noteField, observationArea, reponseArea;

    @FXML
    private TextArea enonceArea, scoresArea;

    @FXML
    private Button nextButton;
    
    @FXML
    private void initialize() {  	
    	contexte = Contexte.getInstance();
    	erreurText.setVisible(false);
    	test = (TestQuestionnaire) contexte.getBo().getEpreuvesCliniques().get(contexte.getIndiceEpreuve()).getTest();
    	questionnaire = new ArrayList<Question>(test.getQuestions());
		compteRendu = test.getCompteRendu();
		question = questionnaire.get(0);
		nomTestField.setText("Test questionnaire : " + test.getNom());
    	setnumeroQuestionText(indiceQuestion);
    	afficherScoresPrecedants();
    	afficherEnonce();    	
    }

	@FXML
    private void handleEnregistrerReponseButtonAction(ActionEvent event) {
		// Réponse
		if (question instanceof QO) {
			try {
				int note = Integer.parseInt(noteField.getText());
				if (note < 1 || note > 10) {
					erreurText.setText("La note doit etre une valeur entiere entre 1 et 10.");
					erreurText.setVisible(true);
		            return;
				}
				String reponse = reponseArea.getText();
				if (reponse.isEmpty() || reponse == null) {
		            erreurText.setText("Veuillez entrer une réponse.");
		            erreurText.setVisible(true);
		            return;
		        }
				((QO) question).repondre(reponse);
				compteRendu.put(question, note);
			} catch (NumberFormatException e) {
				erreurText.setText("Veuillez insérer une note valide.");
	        	erreurText.setVisible(true);
	            return;
			}
		} else { // QuestionAvecPropositions
			if (question instanceof QCU) {
				try {
		            int numeroProposition = Integer.parseInt(reponseArea.getText());
		            if (numeroProposition < 0 || numeroProposition >= propositions.size()) {
		            	erreurText.setText("Proposition inexistante. Veuillez entrer un numéro valide.");
		            	erreurText.setVisible(true);
		            	return;
		            }
		            ((QCU) question).repondre(numeroProposition);
		        } catch (NumberFormatException e) {
		        	erreurText.setText("Numéro proposition invalide.");
		        	erreurText.setVisible(true);
		        	return;
		        }
			} else { // QCM
				Set<Integer> reponsesSet = new HashSet<>();
				try {
	                for (String chaineNumero : reponseArea.getText().split("\\s+")) {
	                    int numeroProposition = Integer.parseInt(chaineNumero);
	                    if (numeroProposition < 0 || numeroProposition >= propositions.size()) {
	                    	erreurText.setText("Numéros propositions inexistants.");
	    		        	erreurText.setVisible(true);
	    		        	return;
	                    }
	                    if (!reponsesSet.add(numeroProposition)) {
	                    	erreurText.setText("Numéros propositions répététifs.");
	    		        	erreurText.setVisible(true);
	    		        	return;
	                    }	                    	
	                }
	                ((QCM) question).repondre(reponsesSet);
				} catch (NumberFormatException e) {
		        	erreurText.setText("Numéros propositions invalides.");
		        	erreurText.setVisible(true);
		        	return;
		        }
			}
		
			compteRendu.put(question, ((QuestionAvecPropositions) question).calculerScore());
		}
		
		// Préparations pour la prochaine question
		indiceQuestion++;
		// Fin des questions
		if (indiceQuestion == questionnaire.size()) {			
			test.calculerScoreTotal();
			contexte.getBo().getEpreuvesCliniques().get(contexte.getIndiceEpreuve()).setObservationClinique(observationArea.getText());
			int indiceEpreuve;
			contexte.setIndiceEpreuve((indiceEpreuve = contexte.getIndiceEpreuve() + 1));
			if (indiceEpreuve == contexte.getBo().getEpreuvesCliniques().size()) {
	    		Main.changerScene(EScenes.FIN_EPREUVES_CLINIQUES);
	    		return;
	    	}
			Main.changerScene(EScenes.DEROULER_EPREUVES_CLINIQUES);
			return;
		}
		reponseArea.clear();
		noteField.clear();
		// La derniere question
		if (indiceQuestion == questionnaire.size()-1) {
			nextButton.setText("Terminer le test");
		}
		// Mise a jour des champs pour la prochaine question
		question = questionnaire.get(indiceQuestion);
		setnumeroQuestionText(indiceQuestion);
    	afficherScoresPrecedants();
    	afficherEnonce();
    }	

    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
    	contexte.clear();
    	Main.changerScene(EScenes.TALKTRACK);
    }
    
    private void afficherEnonce() {
    	enonceArea.setText(question.getEnonce() + "\n");
    	if (question instanceof QuestionAvecPropositions) {
    		propositions = ((QuestionAvecPropositions) question).getPropositions();
    		for (int i = 0; i < propositions.size(); i++) {
    			enonceArea.appendText(i + " - " + propositions.get(i).getEnonce() + "\n");
            }
    		noteField.setEditable(false);
    		if (question instanceof QCU) {
    			reponseArea.setPromptText("Veuillez entrer le numéro de la proposition");
    			reponsetext.setText("Réponse unique");
    			numeroQuestionText.setText(numeroQuestionText.getText() + " (QCU)");
    		}
    		else { // QCM
    			reponseArea.setPromptText("Veuillez entrer les numéros des propositions choisies espacés\n(num1 num2 ...)");
    			reponsetext.setText("Réponses multiples");
    			numeroQuestionText.setText(numeroQuestionText.getText() + " (QCM)");
    		}
    	} else { // QO
    		noteField.setEditable(true);
    		reponsetext.setText("Réponse du patient");
    		numeroQuestionText.setText(numeroQuestionText.getText() + " (QO)");
    	}
	}

	private void afficherScoresPrecedants() {
		scoresArea.clear();
    	for (int i = 0; i < indiceQuestion; i++) {
    		scoresArea.appendText("Question " + (i+1) + ": " + compteRendu.get(questionnaire.get(i)) + "/10\n");
		}
	}

	private void setnumeroQuestionText(int i) {
		numeroQuestionText.setText("Question " + (i+1) + "/" + questionnaire.size());
	}
}
