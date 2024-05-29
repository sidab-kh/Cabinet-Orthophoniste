package app.controllers;

import java.util.ArrayList;

import app.Contexte;
import app.Main;
import app.data.bilans.Anamnese;
import app.data.bilans.BilanOrthophonique;
import app.data.rendezvous.Consultation;
import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import app.util.enumerations.ETypesPatients;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * Contrôleur de la page de déroulement de la consultation.
 */
public class DeroulerConsultationController {

    /** Instance du contrôleur principal de l'application. */
    Controlleur controlleur;

    /** Instance du contexte de l'application. */
    Contexte contexte;

    /** Liste des anamnèses disponibles. */
    ArrayList<Anamnese> anamneses;

    /** Zone d'affichage des anamnèses disponibles. */
    @FXML
    private TextArea anamnesesArea;

    /** Champ de saisie du code de l'anamnèse à sélectionner. */
    @FXML
    private TextField codeAnamneseArea;

    /** Message d'erreur. */
    @FXML
    private Text erreurText;

    /** Texte affichant le nom et prénom du patient de la consultation. */
    @FXML
    private Text nomPrenomText;

    /** Méthode d'initialisation du contrôleur. */
    @FXML
    private void initialize() {
        controlleur = Controlleur.getInstance();
        contexte = Contexte.getInstance();
        erreurText.setVisible(false);
        anamneses = (ArrayList<Anamnese>) controlleur.getServiceOrthophoniste().getAnamneses();
        nomPrenomText.setText(((Consultation)contexte.getRendezVous()).getPatient().getNom() + " " +
        ((Consultation)contexte.getRendezVous()).getPatient().getPrenom());
        afficherAnamneses();
    }

    /** Action effectuée lors de la confirmation de sélection d'une anamnèse. */
    @FXML
    private void handleConfirmerAnamneseButtonAction(ActionEvent event) {
        String codeAnamnese = codeAnamneseArea.getText();
        if (codeAnamnese.isEmpty() || codeAnamnese == null) {
            // Champ vide
            erreurText.setText("Entrez un numéro d'anamnèse.");
            erreurText.setVisible(true);
            return;
        }
        try {
            int codeAnamneseInt = Integer.parseInt(codeAnamnese);
            if (codeAnamneseInt < 0 || codeAnamneseInt >= anamneses.size()) {
                erreurText.setText("Anamnèse inexistante.");
                erreurText.setVisible(true);
                return;
            }
            Anamnese anamnese = anamneses.get(codeAnamneseInt);
            if (!anamnese.getTypeAnamnese().equals(((Consultation) contexte.getRendezVous()).getPatient().getType())) {
                erreurText.setText("Anamnèse inexistante.");
                erreurText.setVisible(true);
                return;
            }
            Anamnese copyAnamnese = controlleur.copierAnamnese(anamnese);
            BilanOrthophonique bo = new BilanOrthophonique(copyAnamnese);
            contexte.setBo(bo);
            Main.changerScene(EScenes.DEROULER_ANAMNESE);
        } catch (NumberFormatException e) {
            erreurText.setText("Code anamnèse invalide.");
            erreurText.setVisible(true);
        }
    }

    /** Affiche les anamnèses disponibles pour le type de patient de la consultation. */
    @FXML
    private void afficherAnamneses() {
        ETypesPatients typePatient = ((Consultation) contexte.getRendezVous()).getPatient().getType();
        for (int i = 0; i < anamneses.size(); i++) {
            Anamnese anamnese = anamneses.get(i);
            if (anamnese.getTypeAnamnese().equals(typePatient))
                anamnesesArea.appendText(i + " " + anamnese.getChaine() + "\n");
        }
    }

    /** Action effectuée lors du clic sur le bouton pour quitter. */
    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
        Main.changerScene(EScenes.TALKTRACK);
        contexte.clear();
    }
}