package app.controllers;

import java.util.ArrayList;

import app.Contexte;
import app.Main;
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

/**
 * Contrôleur de la page de déroulement de l'anamnèse.
 */
public class DeroulerAnamneseController {

    /** Instance du contrôleur principal de l'application. */
    Controlleur controlleur;

    /** Instance du contexte de l'application. */
    Contexte contexte;

    /** Bilan orthophonique en cours de création. */
    BilanOrthophonique bo;

    /** Liste des questions de l'anamnèse. */
    ArrayList<QO> questions;

    /** Indice de la question en cours. */
    int indiceQuestion = 0;

    /** Message d'erreur. */
    @FXML
    private Text erreurText;

    /** Texte d'intitulé de l'anamnèse. */
    @FXML
    private Text intituleAnamneseText;

    /** Texte de la question. */
    @FXML
    private Text questionText;

    /** Texte de la catégorie de la question. */
    @FXML
    private Text categorieText;

    /** Zone de saisie de la réponse. */
    @FXML
    private TextArea reponseArea;

    /** Zone d'affichage de l'énoncé de la question. */
    @FXML
    private TextArea enonceArea;

    /** Bouton pour passer à la prochaine question. */
    @FXML
    private Button nextButton;

    /** Méthode d'initialisation du contrôleur. */
    @FXML
    private void initialize() {
        controlleur = Controlleur.getInstance();
        contexte = Contexte.getInstance();
        erreurText.setVisible(false);
        bo = contexte.getBo();
        questions = (ArrayList<QO>) bo.getAnamnese().getQuestions();
        intituleAnamneseText.setText("Intitulé de l'anamnèse : " + bo.getAnamnese().getNomAnamnese());
        setQuestionText(0);
        enonceArea.setText(questions.get(0).getEnonce());
        categorieText.setText("Catégorie : " + questions.get(0).getCategorie().getString());
        if (1 == questions.size()) {
            nextButton.setText("Terminer l'anamnèse");
        }
    }

    /** Action effectuée lors du clic sur le bouton pour passer à la prochaine question. */
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
        // La dernière question
        if (indiceQuestion == questions.size() - 1) {
            nextButton.setText("Terminer l'anamnèse");
        }
        // Mise à jour des champs pour la prochaine question
        setQuestionText(indiceQuestion);
        enonceArea.setText(questions.get(indiceQuestion).getEnonce());
        categorieText.setText(questions.get(indiceQuestion).getCategorie().getString());
        reponseArea.clear();
        erreurText.setVisible(false);
    }

    /** Action effectuée lors du clic sur le bouton pour quitter. */
    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
        contexte.clear();
        Main.changerScene(EScenes.TALKTRACK);
    }

    /** Définit le texte de la question. */
    private void setQuestionText(int i) {
        questionText.setText("Question " + (i + 1) + "/" + questions.size());
    }
}