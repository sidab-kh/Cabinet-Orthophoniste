package app;

import java.util.Iterator;
import java.util.List;

import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class AnamnesesController {
	
	Controlleur controlleur;
	
    @FXML
    private TextArea anamnesesArea;

    @FXML
    public void initialize() {
    	controlleur = Controlleur.getInstance();
    	// Transformer l'agenda en liste de chaines
    	List<String> RendezVousEnTexte = controlleur.AnamnesesToString();
    	Iterator<String> iterator = RendezVousEnTexte.iterator();
    	// Remplir l'agenda
    	while (iterator.hasNext()) { anamnesesArea.appendText(iterator.next() + "\n"); }
    }
    
    @FXML
    void handleAjouterAnamneseButtonAction(ActionEvent event) {
    	Main.changerScene(EScenes.LIRE_ANAMNESE);
    }
    
    @FXML // Aller vers la page agenda
    private void goToAgenda() { Main.changerScene(EScenes.AGENDA); }

    @FXML // Aller vers la page profil
    private void goToProfil() { Main.changerScene(EScenes.PROFIL); }
    
    @FXML // Aller vers la page des patients
    private void goToPatients() { Main.changerScene(EScenes.PATIENTS); }
    
    @FXML // Aller vers la pages des tests
    private void goToTests() { Main.changerScene(EScenes.TESTS); }
    
    @FXML // Aller vers la page d'aide
    private void goToAide() { Main.changerScene(EScenes.AIDE); }
}
