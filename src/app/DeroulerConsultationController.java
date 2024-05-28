package app;

import java.util.ArrayList;
import app.data.bilans.Anamnese;
import app.data.bilans.BilanOrthophonique;
import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import app.util.enumerations.ETypesPatients;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class DeroulerConsultationController {

	Controlleur controlleur;
	Contexte contexte;
	ArrayList<Anamnese> anamneses;
	
    @FXML
    private TextArea anamnesesArea;

    @FXML
    private TextField codeAnamneseArea;

    @FXML
    private Text erreurText, nomPrenomText;
    
    @FXML
    private void initialize() { 
    	controlleur = Controlleur.getInstance();    	
    	contexte = Contexte.getInstance();
    	erreurText.setVisible(false);
    	anamneses = (ArrayList<Anamnese>) controlleur.getServiceOrthophoniste().getAnamneses();
    	afficherAnamneses();
    }

    @FXML
    private void handleConfirmerAnamneseButtonAction(ActionEvent event) {
    	String codeAnamnese = codeAnamneseArea.getText();
        if (codeAnamnese.isEmpty() || codeAnamnese == null) {
        	// Champ vide
            erreurText.setText("Entrez un dossier.");
            erreurText.setVisible(true);
            return;
        }
        try {
            int codeAnamneseInt = Integer.parseInt(codeAnamnese);
            if (codeAnamneseInt < 0 || codeAnamneseInt >= anamneses.size()) {
            	erreurText.setText("Anamnèse inexistante.");
            	erreurText.setVisible(true);
            	return;
            }
            Anamnese copyAnamnese = controlleur.copierAnamnese(anamneses.get(codeAnamneseInt));
    		BilanOrthophonique bo = new BilanOrthophonique(copyAnamnese);
        	contexte.setBo(bo);
            Main.changerScene(EScenes.DEROULER_ANAMNESE);
        } catch (NumberFormatException e) {
        	erreurText.setText("Code anamnèse invalide.");
        	erreurText.setVisible(true);
        }
    }
    
    @FXML // Afficher les anamneses
    private void afficherAnamneses() {
    	ETypesPatients typePatient = ((app.data.rendezvous.Consultation)contexte.getRendezVous()).getPatient().getType();
    	for (int i = 0; i < anamneses.size(); i++) {
    		Anamnese anamnese = anamneses.get(i);
    		if (anamnese.getTypeAnamnese().equals(typePatient))
    			anamnesesArea.appendText(i + anamnese.getChaine() + "\n");
		}
    }
    
    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
    	Main.changerScene(EScenes.TALKTRACK);
    	contexte.clear();
    }
}
