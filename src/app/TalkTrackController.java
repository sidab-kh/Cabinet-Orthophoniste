package app;

import app.data.rendezvous.RendezVous;
import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class TalkTrackController {

	Controlleur controlleur;
	Contexte contexte;
	
    @FXML
    private Text erreurText;

    @FXML
    private void initialize() {
    	controlleur = Controlleur.getInstance();
    	contexte = Contexte.getInstance();
    	erreurText.setVisible(false);
    }
    
    @FXML
    void handleCommencerSeanceButtonAction(ActionEvent event) {
    	RendezVous rdv = controlleur.getRendezVousActuel();
    	if (rdv == null) {
    		erreurText.setText("Vous n'avez pas de consultation en ce moment");
    		erreurText.setVisible(true);
    		return;
    	}
    	contexte.setRendezVous(rdv);
		switch (rdv.getType()) {
			case CONSULTATION:
				Main.changerScene(EScenes.DEROULER_CONSULTATION);
	        	break;
	        case SEANCE_SUIVI:
	        	Main.changerScene(EScenes.DEROULER_SEANCE_SUIVI);
	        	break;	
			case ATELIER:
				Main.changerScene(EScenes.DEROULER_ATELIER);
	        	break;				
			default:
				break;
		}    	
    }
    
    @FXML
    private void handleQuitterButtonAction(MouseEvent event) { Main.changerScene(EScenes.AGENDA); }
}
