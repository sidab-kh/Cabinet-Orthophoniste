package app.controllers;

import java.util.ArrayList;

import app.Contexte;
import app.Main;
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

/**
 * Contrôleur de la page de déroulement des épreuves cliniques.
 */
public class DeroulerEpreuvesCliniquesController {

    /** Instance du contexte de l'application. */
    private Contexte contexte;

    /** Liste des épreuves cliniques. */
    private ArrayList<EpreuveClinique> epreuves;

    /** Test en cours. */
    private Test test;

    /** Indice de l'épreuve en cours. */
    private int indiceEpreuve;

    /** Texte affichant le numéro de l'épreuve en cours. */
    @FXML
    private Text epreuveText;

    /** Texte affichant le nom du test en cours. */
    @FXML
    private Text intituleTestText;

    /** Texte affichant le type du test en cours. */
    @FXML
    private Text typeTestText;

    /** Zone d'affichage des scores des tests. */
    @FXML
    private TextArea testsArea;

    /** Méthode d'initialisation du contrôleur. */
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

    /** Action effectuée lors du clic sur le bouton pour commencer le test. */
    @FXML
    private void handleCommencerTestButtonAction(ActionEvent event) {
        if (test instanceof TestQuestionnaire)
            Main.changerScene(EScenes.DEROULER_TEST_QUESTIONNAIRE);
        else
            Main.changerScene(EScenes.DEROULER_TEST_EXERCICES);
    }

    /** Définit le texte affichant le numéro de l'épreuve en cours. */
    private void setEpreuveText(int i) {
        epreuveText.setText("Épreuve " + (i + 1) + "/" + epreuves.size());
    }

    /** Affiche les scores des tests précédents. */
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
                testsArea.appendText((i + 1) + ") " + test.getNom() + "/  score : " + test.getScoreTotal()
                        + "/" + baremeTotal + "\n");
            } else {
                testsArea.appendText((i + 1) + ") " + test.getNom() + "\n");
            }
        }
    }

    /** Action effectuée lors du clic sur le bouton pour quitter. */
    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
        contexte.clear();
        Main.changerScene(EScenes.TALKTRACK);
    }
}