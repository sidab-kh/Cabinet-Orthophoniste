package app;

import java.util.Iterator;
import java.util.List;

import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class AgendaController {

    Controlleur controlleur;

    @FXML
    private TextArea agendaArea;

    @FXML
    private Text erreurText;

    @FXML
    public void initialize() {
    	controlleur = Controlleur.getInstance();
    	// Transformer l'agenda en liste de chaines
    	List<String> RendezVousEnTexte = controlleur.AgendaToString();
    	Iterator<String> iterator = RendezVousEnTexte.iterator();
    	// Remplir l'agenda
    	while (iterator.hasNext()) { agendaArea.appendText(iterator.next()); }
    }

    @FXML // Aller vers la page profil
    private void goToProfil() { Main.changerScene(EScenes.PROFIL); }
    
    @FXML // Aller vers la page des patients
    private void goToPatients() { Main.changerScene(EScenes.PATIENTS); }
    
    @FXML // Aller vers la pages des tests
    private void goToTests() { Main.changerScene(EScenes.TESTS); }
    
    @FXML // Aller vers la page des bilans
    private void goToBilans() { Main.changerScene(EScenes.BILANS); }
    
    @FXML // Aller vers la page d'aide
    private void goToAide() { Main.changerScene(EScenes.AIDE); }

    @FXML // Lire une nouvelle consultation
    private void goToLireConsultation() { Main.changerScene(EScenes.LIRE_CONSULTATION); }

    @FXML // Lire une nouvelle seance de suivi
    private void goToLireSeanceSuivi() { Main.changerScene(EScenes.LIRE_SEANCE_SUIVI); }

    @FXML // Lire un nouvel atelier
    private void goToLireAtelier() { Main.changerScene(EScenes.LIRE_ATELIER); }
}
