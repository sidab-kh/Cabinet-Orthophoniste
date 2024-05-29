package app.controllers;

import java.util.Iterator;
import java.util.List;

import app.Contexte;
import app.Main;
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

/**
 * Contrôleur de la page d'affichage des dossiers des patients enfants.
 */
public class AfficherDossierEnfantController {

    /** Instance du contrôleur principal. */
    private Controlleur controlleur;
    
    /** Instance du contexte de l'application. */
    private Contexte contexte;
    
    /** Champ de texte pour afficher les informations du dossier. */
    @FXML
    private TextArea affichageArea;

    /** Champ de mot de passe pour la suppression du dossier. */
    @FXML
    private PasswordField motDePasseField;

    /** Texte pour afficher le nom du patient. */
    @FXML
    private Text nomText;
    
    /** Texte pour afficher le numéro du dossier. */
    @FXML
    private Text numeroDossierText;
    
    /** Texte pour afficher le prénom du patient. */
    @FXML
    private Text prenomText;
    
    /** Texte pour afficher le numéro du père du patient. */
    @FXML
    private Text numeroPapaText;
    
    /** Texte pour afficher le numéro de la mère du patient. */
    @FXML
    private Text numeroMamanText;
    
    /** Texte pour afficher le niveau d'études du patient. */
    @FXML
    private Text niveauEtudesText;
    
    /** Texte pour afficher l'adresse du patient. */
    @FXML
    private Text adresseText;
    
    /** Texte pour afficher le lieu de naissance du patient. */
    @FXML
    private Text lieuNaissanceText;
    
    /** Texte pour afficher la date de naissance du patient. */
    @FXML
    private Text dateNaissanceText;
    
    /** Texte pour afficher les éventuelles erreurs. */
    @FXML
    private Text erreurText;
    
    /** Bouton pour afficher les rendez-vous. */
    @FXML
    private RadioButton rendezVousButton;
    
    /** Bouton pour afficher les bilans. */
    @FXML
    private RadioButton bilansButton;
    
    /** Bouton pour afficher les fiches. */
    @FXML
    private RadioButton fichesButton;

    /**
     * Méthode d'initialisation du contrôleur.
     * Appelée après que tous les champs FXML ont été injectés.
     */
    @FXML
    private void initialize() {
        controlleur = Controlleur.getInstance();
        contexte = Contexte.getInstance();
        erreurText.setVisible(false);
        
        // Affichage des informations du dossier lors de l'initialisation
        afficherInformations();
        handleAfficherButtonAction(null);
    }

    /**
     * Action lors du clic sur le bouton "Quitter".
     * Redirige vers la page des patients.
     * @param event L'événement de clic.
     */
    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
        Main.changerScene(EScenes.PATIENTS);
    }

    /**
     * Action lors du clic sur le bouton "Afficher".
     * Affiche les rendez-vous, les bilans ou les fiches de suivi du patient.
     * @param event L'événement de clic.
     */
    @FXML
    private void handleAfficherButtonAction(ActionEvent event) {
        affichageArea.clear();
        if (rendezVousButton.isSelected()) {
            // Afficher les rendez-vous
            List<String> rendezVousEnChaine = contexte.getDossierEnCoursDeTraitement().listeRendezVousToString();
            Iterator<String> iterator = rendezVousEnChaine.iterator();
            while (iterator.hasNext()) { affichageArea.appendText(iterator.next() + "\n"); }
        } else if (bilansButton.isSelected()) {
            // Afficher les bilans orthophoniques
            List<String> bilansEnChaine = contexte.getDossierEnCoursDeTraitement().listeBilansOrthophoniquesToString();
            Iterator<String> iterator = bilansEnChaine.iterator();
            while (iterator.hasNext()) { affichageArea.appendText(iterator.next() + "\n\n"); }
        }
    }

    /**
     * Action lors du clic sur le bouton "Supprimer dossier".
     * Supprime le dossier du patient en utilisant le mot de passe fourni.
     * @param event L'événement de clic.
     */
    @FXML
    private void handleSupprimerDossierButton(ActionEvent event) {
        String motDePasse = motDePasseField.getText();
        if (motDePasse.isEmpty()) {
            // Champ vide
            erreurText.setText("Veuillez insérer votre mot de passe.");
            erreurText.setVisible(true);
        } else if (!controlleur.supprimerDossierPatient(motDePasse, contexte.getDossierEnCoursDeTraitement())) {
            // Mot de passe erroné
            erreurText.setText("Mot de passe erroné.");
            erreurText.setVisible(true);
        } else {
            // Retourner vers la page des patients
            Main.changerScene(EScenes.PATIENTS);
        }
    }

    /**
     * Affiche les informations du patient dans les champs correspondants.
     */
    @FXML
    private void afficherInformations() {
        int numeroDossier = contexte.getDossierEnCoursDeTraitement().getNumero();
        Enfant enfant = (Enfant) controlleur.getServiceOrthophoniste().patientDeNumeroDossier(numeroDossier);
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