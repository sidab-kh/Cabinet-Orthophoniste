package app.controllers;

import java.util.Iterator;
import java.util.List;

import app.Main;
import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * Contrôleur de la page d'agenda.
 */
public class AgendaController {

    /** Instance du contrôleur principal. */
    Controlleur controlleur;

    /** Zone de texte pour afficher l'agenda. */
    @FXML
    private TextArea agendaArea;

    /**
     * Méthode d'initialisation du contrôleur.
     * Appelée après que tous les champs FXML ont été injectés.
     */
    @FXML
    public void initialize() {
        controlleur = Controlleur.getInstance();
        afficherAgenda();
    }

    /**
     * Action lors du clic sur le bouton "Profil".
     * Redirige vers la page du profil.
     */
    @FXML
    private void goToProfil() { Main.changerScene(EScenes.PROFIL); }
    
    /**
     * Action lors du clic sur le bouton "Patients".
     * Redirige vers la page des patients.
     */
    @FXML
    private void goToPatients() { Main.changerScene(EScenes.PATIENTS); }
    
    /**
     * Action lors du clic sur le bouton "Tests".
     * Redirige vers la page des tests.
     */
    @FXML
    private void goToTests() { Main.changerScene(EScenes.TESTS); }
    
    /**
     * Action lors du clic sur le bouton "Anamneses".
     * Redirige vers la page des anamnèses.
     */
    @FXML
    private void goToAnamneses() { Main.changerScene(EScenes.ANAMNESES); }
    
    /**
     * Action lors du clic sur le bouton "Aide".
     * Redirige vers la page d'aide.
     */
    @FXML
    private void goToAide() { Main.changerScene(EScenes.AIDE); }

    /**
     * Action lors du clic sur le bouton "Lire Consultation".
     * Redirige vers la page de lecture de consultation.
     */
    @FXML
    private void goToLireConsultation() { Main.changerScene(EScenes.LIRE_CONSULTATION); }

    /**
     * Action lors du clic sur le bouton "Lire Séance de Suivi".
     * Redirige vers la page de lecture de séance de suivi.
     */
    @FXML
    private void goToLireSeanceSuivi() { Main.changerScene(EScenes.LIRE_SEANCE_SUIVI); }

    /**
     * Action lors du clic sur le bouton "Lire Atelier".
     * Redirige vers la page de lecture d'atelier.
     */
    @FXML
    private void goToLireAtelier() { Main.changerScene(EScenes.LIRE_ATELIER); }
    
    /**
     * Action lors du clic sur le bouton "TalkTrack".
     * Redirige vers la page TalkTrack.
     */
    @FXML
    private void goToTalkTrack() { Main.changerScene(EScenes.TALKTRACK); }

    /**
     * Affiche l'agenda dans la zone de texte.
     */
    @FXML
    private void afficherAgenda() {
        // Transformer l'agenda en une liste de chaînes
        List<String> rendezVousEnChaine = controlleur.agendaToString();
        Iterator<String> iterator = rendezVousEnChaine.iterator();
        // Remplir le TextArea
        while (iterator.hasNext()) {
            agendaArea.appendText("- " + iterator.next() + "\n");
        }
    }
}
