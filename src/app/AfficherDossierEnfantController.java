package app;

import app.data.patients.Enfant;
import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class AfficherDossierEnfantController {

	private Controlleur controlleur;
	private Contexte contexte;
	
    @FXML
    private TextArea affichageArea;

    @FXML
    private PasswordField motDePasseField;

    @FXML
    private Text nomText, numeroDossierText, numeroPapaText, prenomText, niveauEtudesText, adresseText, erreurText, lieuNaissanceText, dateNaissanceText, numeroMamanText;

    @FXML
    private RadioButton rendezVousButton, bilansButton, fichesButton;
    
    @FXML
    private void initialize() {
    	controlleur = Controlleur.getInstance();
    	contexte = Contexte.getInstance();
    	erreurText.setVisible(false);
    	
    	afficherInformations();
    }

    @FXML // Aller vers la page des patients
    private void handleQuitterButtonAction(MouseEvent event) { Main.changerScene(EScenes.PATIENTS); }

    @FXML
    private void handleAfficherButtonAction(ActionEvent event) {}

    @FXML // Supprimer le dossier
    private void handleSupprimerDossierButton(ActionEvent event) {
    	String motDePasse = motDePasseField.getText();
    	if (motDePasse.isEmpty()) {
    		// Champ vide
    		erreurText.setText("Veuillez insérer votre mot de passe.");
    		erreurText.setVisible(true);
    	} else if (!controlleur.supprimerDossierPatient(motDePasse, contexte.getDossierEnCoursDeTraitement())) {
    		// Mot de passe errone
    		erreurText.setText("Mot de passe erroné.");
    		erreurText.setVisible(true);
    	} else {
    		// Retourner vers la page des patients
    		Main.changerScene(EScenes.PATIENTS);
    	}
    }
    
    @FXML // Afficher les informations de l'enfant
    private void afficherInformations() {
        // Obtenir le numéro de dossier à partir du contexte
        int numeroDossier = contexte.getDossierEnCoursDeTraitement().getNumero();
        
        // Récupérer le patient à partir du numéro de dossier
        Enfant enfant = (Enfant) controlleur.getServiceOrthophoniste().patientDeNumeroDossier(numeroDossier);
        
        // Afficher les informations du patient dans les champs correspondants
        nomText.setText(enfant.getNom());
        prenomText.setText(enfant.getPrenom());
        numeroDossierText.setText("Dossier nº" + String.valueOf(numeroDossier));
        numeroPapaText.setText(enfant.getNumeroTelephonePere());
        numeroMamanText.setText(enfant.getNumeroTelephoneMere());
        niveauEtudesText.setText(enfant.getNiveauEtudes());
        adresseText.setText(enfant.getAdresse());
        lieuNaissanceText.setText(enfant.getLieuNaissance());
        dateNaissanceText.setText(enfant.getDateNaissance().toString());
    }
}
