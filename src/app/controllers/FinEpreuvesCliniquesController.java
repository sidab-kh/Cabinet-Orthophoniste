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

/**
 * Contrôleur pour la fin des épreuves cliniques.
 * Cette classe gère l'affichage des scores des tests et les transitions vers d'autres scènes.
 */
public class FinEpreuvesCliniquesController {

    private Contexte contexte;
    private ArrayList<EpreuveClinique> epreuves;

    @FXML
    private TextArea scoresArea;

    /**
     * Initialise le contrôleur.
     * Récupère l'instance du contexte et les épreuves cliniques, puis affiche les scores des tests.
     */
    @FXML
    private void initialize() {  
        contexte = Contexte.getInstance();
        epreuves = (ArrayList<EpreuveClinique>) contexte.getBo().getEpreuvesCliniques();
        afficherTestsScores();
    }

    /**
     * Affiche les scores des tests dans le champ de texte.
     * Calcule le barème total en fonction du type de test (questionnaire ou exercices).
     */
    private void afficherTestsScores() {
        for (int i = 0; i < epreuves.size(); i++) {
            Test test = epreuves.get(i).getTest();
            int baremeTotal;
            if (test instanceof TestQuestionnaire)
                baremeTotal = ((TestQuestionnaire) test).getQuestions().size() * 10;
            else
                baremeTotal = ((TestExercices) test).getCompteRendu().size() * 10;
            scoresArea.appendText((i + 1) + ") " + test.getNom() + " / score : " + test.getScoreTotal()
                    + "/" + baremeTotal + "\n");
        }
    }

    /**
     * Gère l'action du bouton "Prochaine Étape".
     * Change la scène pour établir le diagnostic.
     *
     * @param event l'événement de l'action
     */
    @FXML
    private void handleProchaineEtapeButtonAction(ActionEvent event) {
        Main.changerScene(EScenes.ETABLIR_DIAGNOSTIC);
    }

    /**
     * Gère l'action du bouton "Quitter".
     * Efface le contexte et change la scène vers l'accueil.
     *
     * @param event l'événement de la souris
     */
    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
        contexte.clear();
        Main.changerScene(EScenes.TALKTRACK);
    }
}