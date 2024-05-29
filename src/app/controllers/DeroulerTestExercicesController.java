package app.controllers;

import java.util.List;
import java.util.Map;

import app.Contexte;
import app.Main;
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

/**
 * Contrôleur de la page de déroulement des tests d'exercices.
 */
public class DeroulerTestExercicesController {
    
    /** Instance du contexte de l'application. */
    private Contexte contexte;
    
    /** Test d'exercices en cours. */
    private TestExercices test;
    
    /** Liste des exercices du test. */
    private List<Exercice> exercices;
    
    /** Exercice en cours. */
    private Exercice exercice;
    
    /** Compte rendu des scores des exercices. */
    private Map<Integer, Float> compteRendu;
    
    /** Indice de l'exercice en cours. */
    private int indiceExercice = 0;
    
    /** Texte affichant les erreurs. */
    @FXML
    private Text erreurText;
    
    /** Texte affichant le nom du test. */
    @FXML
    private Text nomTestText;
    
    /** Texte affichant le numéro de l'exercice en cours. */
    @FXML
    private Text numeroExerciceText;
    
    /** Zone d'affichage de l'énoncé de l'exercice. */
    @FXML
    private TextArea enonceArea;
    
    /** Zone d'affichage des observations cliniques. */
    @FXML
    private TextArea observationArea;
    
    /** Zone d'affichage des scores précédents. */
    @FXML
    private TextArea scoresArea;
    
    /** Champ de saisie du score. */
    @FXML
    private TextField scoreField;
    
    /** Bouton pour passer à l'exercice suivant ou terminer le test. */
    @FXML
    private Button nextButton;
    
    /** Méthode d'initialisation du contrôleur. */
    @FXML
    private void initialize() {
        contexte = Contexte.getInstance();
        erreurText.setVisible(false);
        test = (TestExercices) contexte.getBo().getEpreuvesCliniques().get(contexte.getIndiceEpreuve()).getTest();
        exercices = test.getExercices();
        compteRendu = test.getCompteRendu();
        exercice = exercices.get(0);
        nomTestText.setText("Test exercices : " + test.getNom());
        setNumeroExerciceText(0);
        afficherScoresPrecedents();
        enonceArea.setText(exercice.getConsigne() + "\nMatériel :\n");
        for (EMateriel materiel : exercice.getMateriel()) {
            enonceArea.appendText("   - " + materiel.getString() + "\n");
        }
    }
    
    /** Action effectuée lors du clic sur le bouton pour passer à l'exercice suivant. */
    @FXML
    private void handleProchainExerciceButtonAction(ActionEvent event) {
        try {
            int score = Integer.parseInt(scoreField.getText());
            if (score < 1 || score > 10) {
                erreurText.setText("Le score doit être une valeur entière entre 1 et 10.");
                erreurText.setVisible(true);
                return;
            }
            exercice.setScore(score);
            indiceExercice++;
            // Fin des exercices
            if (indiceExercice == exercices.size()) {
                // Évaluation du test
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
                    entry.setValue((float) (sommeScores / nb));
                }
                test.calculerScoreTotal();
                contexte.getBo().getEpreuvesCliniques().get(contexte.getIndiceEpreuve())
                        .setObservationClinique(observationArea.getText());
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
            if (indiceExercice == exercices.size() - 1) {
                nextButton.setText("Terminer le test");
            }
            // Mise à jour des champs pour le prochain exercice
            exercice = exercices.get(indiceExercice);
            setNumeroExerciceText(indiceExercice);
            afficherScoresPrecedents();
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
    
    /** Affiche les scores des exercices précédents. */
    private void afficherScoresPrecedents() {
        scoresArea.clear();
        for (int i = 0; i < indiceExercice; i++) {
            scoresArea.appendText("Exercice " + (i + 1) + ": " + exercices.get(i).getScore() + "/10\n");
        }
    }
    
    /** Définit le texte affichant le numéro de l'exercice en cours. */
    private void setNumeroExerciceText(int i) {
        numeroExerciceText.setText("Exercice " + (i + 1) + "/" + exercices.size());
    }
    
    /** Action effectuée lors du clic sur le bouton pour quitter. */
    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
        contexte.clear();
        Main.changerScene(EScenes.TALKTRACK);
    }
}
