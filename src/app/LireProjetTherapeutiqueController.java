package app;

import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LireProjetTherapeutiqueController {

	Controlleur controlleur;
	
    @FXML
    private Text erreurText;

    @FXML
    private TextArea projetTherapeutiqueArea;
    
    @FXML
    private void initialize() {
    	controlleur = Controlleur.getInstance();
    	erreurText.setVisible(false);
    }

    @FXML // Ajouter le projet therapeutique au bilan orthophonique courant
    private void handleAjouterProjetTherapeutiqueButtonAction(ActionEvent event) {
    	String projetTherapeutique = projetTherapeutiqueArea.getText();
    	if (projetTherapeutique.isEmpty()) {
    		erreurText.setText("Le projet thérapeutique ne peut être vide.");
    		erreurText.setVisible(true);
    	} else {
    		// Contexte.BOCourant.setProjetTherapeutique(projetTherapeutique);
    	}
    }

    @FXML // Retourner a l'agenda
    private void handleQuitterButtonAction(MouseEvent event) { Main.changerScene(EScenes.AGENDA); }
}
