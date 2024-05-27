package app;

import java.util.Iterator;
import java.util.List;

import app.data.patients.Adulte;
import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class AfficherDossierAdulteController {

	private Controlleur controlleur;
	private Contexte contexte;
	
    @FXML
    private TextArea affichageArea;

    @FXML
    private PasswordField motDePasseField;

    @FXML
    private Text nomText, numeroDossierText, numeroText, prenomText, professionText, adresseText, erreurText, lieuNaissanceText, dateNaissanceText, diplomeText;

    @FXML
    private RadioButton rendezVousButton, bilansButton, fichesButton;
    
    @FXML
    private void initialize() {
    	controlleur = Controlleur.getInstance();
    	contexte = Contexte.getInstance();
    	erreurText.setVisible(false);
    	
    	afficherInformations();
    	handleAfficherButtonAction(null);
    }

    @FXML // Aller vers la page des patients
    private void handleQuitterButtonAction(MouseEvent event) { Main.changerScene(EScenes.PATIENTS); }

    @FXML // Afficher les rendez-vous, bilans ou fiches de suivi du patient
    private void handleAfficherButtonAction(ActionEvent event) {
    	affichageArea.clear();
    	if (rendezVousButton.isSelected()) {
    		// Convertir la liste des rendez-vous du patient en une liste de chaines
    		List<String> rendezVousEnChaine = contexte.getDossierEnCoursDeTraitement().listeRendezVousToString();
    		Iterator<String> iterator = rendezVousEnChaine.iterator();
        	// Remplir le TextArea
        	while (iterator.hasNext()) { affichageArea.appendText(iterator.next() + "\n"); }
    	}
    }

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
    
    @FXML // Afficher les informations de l'adulte
    private void afficherInformations() {
        // Obtenir le numéro de dossier à partir du contexte
        int numeroDossier = contexte.getDossierEnCoursDeTraitement().getNumero();
        
        // Récupérer le patient à partir du numéro de dossier
        Adulte adulte = (Adulte) controlleur.getServiceOrthophoniste().patientDeNumeroDossier(numeroDossier);
        
        // Afficher les informations du patient dans les champs correspondants
        nomText.setText(adulte.getNom());
        prenomText.setText(adulte.getPrenom());
        numeroDossierText.setText("Dossier nº" + String.valueOf(numeroDossier));
        numeroText.setText(adulte.getNumeroTelephone());
        professionText.setText(adulte.getProfession());
        adresseText.setText(adulte.getAdresse());
        lieuNaissanceText.setText(adulte.getLieuNaissance());
        dateNaissanceText.setText(adulte.getDateNaissance().toString());
        diplomeText.setText(adulte.getDiplome());
    }
}