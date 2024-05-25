package app;

import java.util.Iterator;
import java.util.List;

import app.data.patients.Patient;
import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import app.util.enumerations.ETypesPatients;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PatientsController {

	private Controlleur controlleur;
	private Contexte contexte;
	private boolean nouveauxPatientsAreaVide;
	
    @FXML
    private TextField dossierAfficherField, indicePatientField;

    @FXML
    private Text erreurText, erreurText1;

    @FXML
    private TextArea nouveauxPatientsArea, patientsReguliersArea;
    
    @FXML
    private void initialize() {
    	controlleur = Controlleur.getInstance();
    	contexte = Contexte.getInstance();
    	erreurText.setVisible(false);
    	erreurText1.setVisible(false);
    	
    	afficherNouveauxPatients();
    	afficherPatientsReguliers();
    }
    
    @FXML // Aller vers le profil
    private void goToProfil() { Main.changerScene(EScenes.PROFIL); }

    @FXML // Aller vers la page agenda
    private void goToAgenda() { Main.changerScene(EScenes.AGENDA); }
    
    @FXML // Aller vers la pages des tests
    private void goToTests() { Main.changerScene(EScenes.TESTS); }
    
    @FXML // Aller vers la page des anamneses
    private void goToAnamneses() { Main.changerScene(EScenes.ANAMNESES); }
    
    @FXML // Aller vers la page d'aide
    private void goToAide() { Main.changerScene(EScenes.AIDE); }
    
    @FXML // Afficher le dossier en détail
    private void handleAfficherDossierButtonAction(ActionEvent event) {
        String numeroDossier = dossierAfficherField.getText();
        if (numeroDossier.isEmpty()) {
        	// Champ vide
            erreurText1.setText("Entrez un dossier.");
            erreurText1.setVisible(true);
        } else {
            try {
                int numeroDossierInt = Integer.parseInt(numeroDossier);
                if (!controlleur.dossierExiste(numeroDossierInt)) {
                	// Dossier inexistant
                    erreurText1.setText("Dossier inexistant.");
                    erreurText1.setVisible(true);
                } else {
                	// Mettre le dossier dans le contexte et changer de scene selon le type du patient
                    contexte.setDossierEnCoursDeTraitement(controlleur.getServiceOrthophoniste().dossierDeNumero(numeroDossierInt));
                    ETypesPatients type = controlleur.getServiceOrthophoniste().patientDeNumeroDossier(numeroDossierInt).getType();
                    if (type == ETypesPatients.ADULTE) Main.changerScene(EScenes.AFFICHER_DOSSIER_ADULTE);
                    else Main.changerScene(EScenes.AFFICHER_DOSSIER_ENFANT);
                }
            } catch (NumberFormatException e) {
                erreurText1.setText("Numéro invalide.");
                erreurText1.setVisible(true);
            }
        }
    }

    @FXML // Supprimer un patient
    private void handleSupprimerPatientButtonAction(ActionEvent event) {
        if (!nouveauxPatientsAreaVide) {
            try {
                int indice = Integer.parseInt(indicePatientField.getText());
                Patient patient = controlleur.getServiceOrthophoniste().patientDeIndice(indice);
                if (patient != null) {
                    controlleur.getServiceOrthophoniste().supprimerNouveauPatient(patient);
                    nouveauxPatientsArea.clear();
                    indicePatientField.clear();
                    afficherNouveauxPatients();
                } else {
                    erreurText.setText("Aucun patient d'indice " + indice + " trouvé.");
                    erreurText.setVisible(true);
                }
            } catch (NumberFormatException e) {
                erreurText.setText("Veuillez insérer un nombre entier.");
                erreurText.setVisible(true);
            }
        } else {
            erreurText.setText("Aucun patient à supprimer.");
            erreurText.setVisible(true);
        }
    }
    
    @FXML // Creer un dossier pour un nouveau patient
    private void handleCreerDossierButtonAction(ActionEvent event) {
    	if (!nouveauxPatientsAreaVide) {
    		try {
                int indice = Integer.parseInt(indicePatientField.getText());
                Patient patient = controlleur.getServiceOrthophoniste().patientDeIndice(indice);
                if (patient != null) {
                    controlleur.getServiceOrthophoniste().creerDossierPatient(patient);
                    nouveauxPatientsArea.clear();
                    patientsReguliersArea.clear();
                    indicePatientField.clear();
                    afficherNouveauxPatients();
                    afficherPatientsReguliers();
                } else {
                    erreurText.setText("Aucun patient d'indice " + indice + " trouvé.");
                    erreurText.setVisible(true);
                }
            } catch (NumberFormatException e) {
                erreurText.setText("Veuillez insérer un nombre entier.");
                erreurText.setVisible(true);
            }
    	} else {
    		erreurText.setText("Aucun patient trouvé.");
    		erreurText.setVisible(true);
    	}
    }
    
    @FXML // Afficher les nouveaux patients
    private void afficherNouveauxPatients() {
    	// Transformer a liste des nouveaux patients en liste de chaines
    	List<String> nouveauxPatientsEnChaine = controlleur.nouveauxPatientsToString();
    	if (!nouveauxPatientsEnChaine.isEmpty()) {
    		nouveauxPatientsAreaVide = false;
    		Iterator<String> iterator = nouveauxPatientsEnChaine.iterator();
        	// Remplir le TextArea
        	while (iterator.hasNext()) { nouveauxPatientsArea.appendText(iterator.next() + "\n"); }
    	} else nouveauxPatientsAreaVide = true;
    }
    
    @FXML // Afficher les patients reguliers
    private void afficherPatientsReguliers() {
    	// Transformer a liste des patients en liste de chaines
    	List<String> patientsEnChaine = controlleur.patientsToString();
    	Iterator<String> iterator = patientsEnChaine.iterator();
       	// Remplir le TextArea
        while (iterator.hasNext()) { patientsReguliersArea.appendText(iterator.next() + "\n"); }
    }
}