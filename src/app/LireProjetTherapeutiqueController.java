package app;


import app.data.bilans.Diagnostic;
import app.data.rendezvous.Consultation;
import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LireProjetTherapeutiqueController {

	private Contexte contexte;
	
    @FXML
    private Text erreurText;

    @FXML
    private TextField projetTherapeutiqueArea;
    
    @FXML
    private void initialize() {
    	contexte = Contexte.getInstance();
    	erreurText.setVisible(false);
    }

    @FXML // Ajouter le projet therapeutique au bilan orthophonique courant
    private void handleAjouterProjetTherapeutiqueButtonAction(ActionEvent event) {
    	String projetTherapeutique = projetTherapeutiqueArea.getText();
    	
    	if (projetTherapeutique == null || projetTherapeutique.isEmpty()) {
    		erreurText.setText("Le projet thérapeutique ne peut être vide.");
    		erreurText.setVisible(true);
    		return;
    	}
    	
    	contexte.getBo().ajouterProjetTherapeutique(projetTherapeutique);
    	
    	if(contexte.getRendezVous() instanceof Consultation)
    		((Consultation) contexte.getRendezVous()).getPatient().setPremierBo(contexte.getBo());
    	
    	contexte.clear();
    	Main.changerScene(EScenes.AGENDA);
    }

    @FXML // Quitter la consultation
    private void handleQuitterButtonAction(MouseEvent event) { 
    	contexte.clear();
    	Main.changerScene(EScenes.TALKTRACK);
    }
}
