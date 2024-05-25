package app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import app.data.patients.Patient;
import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import app.util.fabriques.FabriquePatient;
import app.util.fabriques.FabriqueRendezVous;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LireConsultationController {
	
	Controlleur controlleur;
	
    @FXML
    private TextField adresseField;

    @FXML
    private RadioButton adulteButton, enfantButton;

    @FXML
    private TextField dateField;

    @FXML
    private TextField dateNaissanceField;

    @FXML
    private TextField heureField;

    @FXML
    private TextField lieuNaissanceField;

    @FXML
    private TextField nomField;

    @FXML
    private TextField numeroField, numeroMere_diplomeField, niveauEtudes_professionField;

    @FXML
    private TextField prenomField;

    @FXML
    private Text erreurText, erreurText1;
    
    @FXML
    private void initialize() {
    	controlleur = Controlleur.getInstance();
    	erreurText.setVisible(false);
    }
    
    @FXML
    private void handleCreerConsultationButtonAction(ActionEvent event) {
    	boolean dateParsed = false;
    	Patient nouveauPatient;
    	
    	try {
    		LocalDateTime dateEtHeure = LocalDateTime.parse(dateField.getText()+" "+heureField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    		dateParsed = true;
    		
    		if (controlleur.orthophonisteDisponible(dateEtHeure)) {
    			LocalDate dateNaissance = LocalDate.parse(dateNaissanceField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int age = Period.between(dateNaissance, LocalDate.now()).getYears();
                if (age < 18) {
                    if (adulteButton.isSelected()) {
                    	erreurText.setText("La date de naissance de l'adulte est invalide.");
        	        	erreurText.setVisible(true);
        	        	return;
                    }
                    nouveauPatient = FabriquePatient.creerEnfant(nomField.getText(), prenomField.getText(), dateNaissance, lieuNaissanceField.getText(), adresseField.getText(), numeroField.getText(), numeroMere_diplomeField.getText(), niveauEtudes_professionField.getText());                    
                } else {
                	if (enfantButton.isSelected()) {
                    	erreurText.setText("La date de naissance de l'enfant est invalide.");
        	        	erreurText.setVisible(true);
        	        	return;
                    }
                	nouveauPatient = FabriquePatient.creerAdulte(nomField.getText(), prenomField.getText(), dateNaissance, lieuNaissanceField.getText(), adresseField.getText(), numeroField.getText(), numeroMere_diplomeField.getText(), niveauEtudes_professionField.getText());                    
                }
                
                controlleur.confirmerRendezVous(FabriqueRendezVous.creerConsultation(dateEtHeure, nouveauPatient));
                Main.changerScene(EScenes.AGENDA);
    		} else {
            	erreurText1.setText("L'orthophoniste n'est pas disponible à la date et heure indiquée.");
            	erreurText1.setVisible(true);
            	return;
            }
    		
		} catch (DateTimeParseException e) {
			if (!dateParsed) {
				erreurText1.setText("Date ou heure invalide.");
	        	erreurText1.setVisible(true);
			} else {
				erreurText.setText("Date de naissance invalide.");
	        	erreurText.setVisible(true);
			}			
		}
    }
    
    @FXML
    private void handleTypePatientButtonAction(ActionEvent event) {
    	if (enfantButton.isSelected()) {
    		numeroField.setPromptText("Numéro du père");
    		numeroMere_diplomeField.setPromptText("Numéro de la mère");
    		niveauEtudes_professionField.setPromptText("Niveau d'études");
    		numeroField.setText(null);
    		numeroMere_diplomeField.setText(null);
    		niveauEtudes_professionField.setText(null);
    	} else {
    		numeroField.setPromptText("Numéro de téléphone");
    		numeroMere_diplomeField.setPromptText("Diplome");
    		niveauEtudes_professionField.setPromptText("Profession");
    		numeroField.setText(null);
    		numeroMere_diplomeField.setText(null);
    		niveauEtudes_professionField.setText(null);
    	}
    }

    
    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
    	Main.changerScene(EScenes.AGENDA);
    }
}
