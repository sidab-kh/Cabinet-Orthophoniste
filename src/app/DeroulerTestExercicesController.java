package app;

import java.util.List;
import java.util.Map;

import app.data.tests.Exercice;
import app.data.tests.TestExercices;
import app.util.enumerations.EMateriel;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class DeroulerTestExercicesController {
	
	private Contexte contexte;
	private TestExercices test;
	private List<Exercice> exercices;
	private Exercice exercice;
	private Map<Integer, Float> compteRendu;
	int indiceExercice = 0;
	
    @FXML
    private Text erreurText, nomTestText, numeroExerciceText;

    @FXML
    private TextArea enonceArea, observationArea, scoresArea;

    @FXML
    private TextField scoreField;
    
    @FXML
    private Button nextButton;
    
    @FXML
    private void initialize() {  	
    	contexte = Contexte.getInstance();
    	erreurText.setVisible(false);
    	test = (TestExercices) contexte.getBo().getEpreuvesCliniques().get(contexte.getIndiceEpreuve()).getTest();
    	exercices = test.getExercices();
		compteRendu = test.getCompteRendu();
		exercice = exercices.get(0);
		nomTestText.setText("Test exercices : " + test.getNom());
    	setnumeroExerciceText(0);
    	afficherScoresPrecedants();
    	enonceArea.setText(exercice.getConsigne() + "\nMatériels :\n");
    	for (EMateriel materiel : exercice.getMateriel()) {
    		enonceArea.appendText("   - " + materiel.getString() + "\n");
		}
    }

	@FXML
    private void handleProchainExerciceButtonAction(ActionEvent event) {
		try {
			int score = Integer.parseInt(scoreField.getText());
			if (score < 1 || score > 10) {
				erreurText.setText("Le score doit etre une valeur entiere entre 1 et 10.");
				erreurText.setVisible(true);
	            return;
	    	}			
			exercice.setScore(score);
			indiceExercice++;
			// Fin des exercices
			if (indiceExercice == exercices.size()) {
				// Evaluation du test
				for (Map.Entry<Integer, Float> entry : compteRendu.entrySet()) {
					Integer hash = entry.getKey();
					int sommeScores = 0;
					int nb = 0;
					for (Exercice exercice : exercices) {
						if (hash.equals(exercice.hashCode())) {
							sommeScores += exercice.getScore();
							nb++;
						}
					}
					entry.setValue((float) (sommeScores/nb));
				}
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
			// Le dernier exercice
			if (indiceExercice == exercices.size()-1) {
				nextButton.setText("Terminer le test");
			}
			// Mise a jour des champs pour le prochain exercice
			exercice = exercices.get(indiceExercice);
			setnumeroExerciceText(indiceExercice);
	    	afficherScoresPrecedants();
	    	scoreField.clear();
	    	enonceArea.setText(exercice.getConsigne() + "\nMatériels :\n");
	    	for (EMateriel materiel : exercice.getMateriel()) {
	    		enonceArea.appendText("   - " + materiel.getString() + "\n");
			}
		} catch (NumberFormatException e) {
			erreurText.setText("Veuillez insérer un score valide.");
        	erreurText.setVisible(true);
            return;
		}
    }
	
	private void afficherScoresPrecedants() {
		scoresArea.clear();
    	for (int i = 0; i < indiceExercice; i++) {
    		scoresArea.appendText("Exercice " + (i+1) + ": " + exercices.get(i).getScore() + "/10\n");
		}
	}

	private void setnumeroExerciceText(int i) {
    	numeroExerciceText.setText("Exercice " + (i+1) + "/" + exercices.size());
	}
	
    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
    	contexte.clear();
    	Main.changerScene(EScenes.TALKTRACK);
    }
}
