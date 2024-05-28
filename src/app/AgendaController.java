package app;

import java.util.Iterator;
import java.util.List;

import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class AgendaController {

    Controlleur controlleur;

    @FXML
    private TextArea agendaArea;

    @FXML
    public void initialize() {
    	controlleur = Controlleur.getInstance();
    	afficherAgenda();
    }

    @FXML // Aller vers la page profil
    private void goToProfil() { Main.changerScene(EScenes.PROFIL); }
    
    @FXML // Aller vers la page des patients
    private void goToPatients() { Main.changerScene(EScenes.PATIENTS); }
    
    @FXML // Aller vers la pages des tests
    private void goToTests() { Main.changerScene(EScenes.TESTS); }
    
    @FXML // Aller vers la page des anamneses
    private void goToAnamneses() { Main.changerScene(EScenes.ANAMNESES); }
    
    @FXML // Aller vers la page d'aide
    private void goToAide() { Main.changerScene(EScenes.AIDE); }

    @FXML // Lire une nouvelle consultation
    private void goToLireConsultation() { Main.changerScene(EScenes.LIRE_CONSULTATION); }

    @FXML // Lire une nouvelle seance de suivi
    private void goToLireSeanceSuivi() { Main.changerScene(EScenes.LIRE_SEANCE_SUIVI); }

    @FXML // Lire un nouvel atelier
    private void goToLireAtelier() { Main.changerScene(EScenes.LIRE_ATELIER); }
    
    @FXML // Afficher l'agenda
    private void afficherAgenda() {
    	// Transformer l'agenda en une liste de chaines
    	List<String> rendezVousEnChaine = controlleur.agendaToString();
    	Iterator<String> iterator = rendezVousEnChaine.iterator();
    	// Remplir le TextArea
    	while (iterator.hasNext()) { agendaArea.appendText("- " + iterator.next() + "\n"); }
    }
    
    @FXML
    private void goToTalkTrack() {
    	Main.changerScene(EScenes.TALKTRACK);
    }
}
