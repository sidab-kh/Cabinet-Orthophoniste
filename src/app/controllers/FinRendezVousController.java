package app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class FinRendezVousController {

    @FXML
    private Text incationText;
    
    @FXML
    private Button retourMenuButton;
    
    @FXML
    private void initialize() {
    	// if consultation : indicationText.setText("Si vous désirez créer un dossier pour " +
    	// Contexte.getPatientCourant().getPrenom() + ", dirigez-vous au menu Patients.");
    	// retourMenuButton.setText("Aller au menu Patients");
    	
    	// else indicationText.setText("Le bilan orthophonique a ete ajoute au dossier du patient.");
    	// retourMenuButton.setText("Aller vers l'agenda");
    	
    	// indicationText.setVisible(false);
    }

    @FXML
    private void handleRetourAuMenuButtonAction(ActionEvent event) {
    	// if consultation : Main.changerScene(EScenes.PATIENTS);    	
    	
    	// else Main.changerScene(EScenes.AGENDA);
    }
}
