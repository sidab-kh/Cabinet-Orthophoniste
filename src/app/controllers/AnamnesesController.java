package app.controllers;

import java.util.Iterator;
import java.util.List;

import app.Main;
import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * Contrôleur de la page des anamnèses.
 */
public class AnamnesesController {
	
    /** Instance du contrôleur principal. */
	Controlleur controlleur;
	
    /** Zone de texte pour afficher les anamnèses. */
    @FXML
    private TextArea anamnesesArea;

    /** Méthode d'initialisation du contrôleur. */
    @FXML
    public void initialize() {
    	controlleur = Controlleur.getInstance();
    	afficherAnamneses();
    }
    
    /** Action lors du clic sur le bouton "Ajouter Anamnèse". */
    @FXML
    private void handleAjouterAnamneseButtonAction(ActionEvent event) { Main.changerScene(EScenes.LIRE_ANAMNESE); }
    
    /** Action lors du clic sur le bouton "Agenda". */
    @FXML
    private void goToAgenda() { Main.changerScene(EScenes.AGENDA); }

    /** Action lors du clic sur le bouton "Profil". */
    @FXML
    private void goToProfil() { Main.changerScene(EScenes.PROFIL); }
    
    /** Action lors du clic sur le bouton "Patients". */
    @FXML
    private void goToPatients() {
        Main.changerScene(EScenes.PATIENTS);
    }
    
    /** Action lors du clic sur le bouton "Tests". */
    @FXML
    private void goToTests() { Main.changerScene(EScenes.TESTS); }
    
    /** Action lors du clic sur le bouton "Aide". */
    @FXML
    private void goToAide() { Main.changerScene(EScenes.AIDE); }
    
    /** Affiche les anamnèses dans la zone de texte. */
    @FXML
    private void afficherAnamneses() {
        // Transformer les anamnèses en une liste de chaînes
        List<String> anamnesesEnTexte = controlleur.AnamnesesToString();
        Iterator<String> iterator = anamnesesEnTexte.iterator();
        // Remplir l'agenda
        while (iterator.hasNext()) {
            anamnesesArea.appendText(iterator.next() + "\n");
        }
    }
}