package app;

import java.util.Iterator;
import java.util.List;

import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class TestsController {

	Controlleur controlleur;
	
    @FXML
    private TextArea testsArea;

    @FXML
    private void initialize() {
    	controlleur = Controlleur.getInstance();
    	afficherTests();
    }
    
    @FXML // Aller vers la page profil
    private void goToProfil() { Main.changerScene(EScenes.PROFIL); }
    
    @FXML // Aller vers la page agenda
    private void goToAgenda() { Main.changerScene(EScenes.AGENDA); }
    
    @FXML // Aller vers la page des patients
    private void goToPatients() { Main.changerScene(EScenes.PATIENTS); }
    
    @FXML // Aller vers la page des anamneses
    private void goToAnamneses() { Main.changerScene(EScenes.ANAMNESES); }
    
    @FXML // Aller vers la page d'aide
    private void goToAide() { Main.changerScene(EScenes.AIDE); }

    @FXML
    private void handleAjouterTestButtonAction(ActionEvent event) {
    	
    }
    
    @FXML // Afficher les tests
    private void afficherTests() {
    	// Transformer les tests en une liste de chaines
    	List<String> testsEnChaine = controlleur.testsToString();
    	Iterator<String> iterator = testsEnChaine.iterator();
    	// Remplir le TextArea
    	while (iterator.hasNext()) { testsArea.appendText(iterator.next() + "\n"); }
    }
}
