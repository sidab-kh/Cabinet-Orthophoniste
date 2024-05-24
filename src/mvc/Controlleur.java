package mvc;

import java.time.LocalDateTime;

import bilanOrthophonique.Anamnese;
import enumerations.*;
import patient.Patient;
import rendezVous.*;
import rendezVous.RendezVous;
import test.Test;

// Cette classe joue le role de "Controller" dans l'architecture MVC
// Cette classe doit rester simple et se contenter de donner les ordres
public final class Controlleur {

	public ServiceOrthophoniste serviceOrthophoniste; // Operations
    private Vue vue; // Affichages
    
    public Controlleur() {
        this.serviceOrthophoniste = new ServiceOrthophoniste(this);
        this.vue = new Vue(this);
    }
    
    // Afficher le menu principal
    public void afficherMenu() {
    	vue.afficherMenuPrincipal();
    }
	
    // Lire les informations personnelles de l'orthophoniste
    public void lireInformationsOrthophoniste() {
    	Orthophoniste orthophoniste = vue.lireInformationsOrthophoniste();
    	serviceOrthophoniste.inscrireOrthophoniste(orthophoniste);
    }
    
    // Afficher les informations de l'orthophoniste
    public void afficherInformationsOrthophoniste() {
    	vue.afficherInformationsOrthophoniste(serviceOrthophoniste.getOrthophoniste());
    }
    
    // Ajouter un nouveau patient
    public void inscrirePatient() {
    	serviceOrthophoniste.ajouterNouveauPatient(vue.lirePatient());
    }
    
    // Creer un dossier pour un nouveau patient
    public void creerDossierPatient(Patient patient) {
    	serviceOrthophoniste.creerDossierPatient(patient);
    }
    
    // Creer une nouvelle consultation
    public void programmerRendezVous() {
    	// TODO: switch(type)
    	vue.lireConsultation();
    }
    
    // Ajouter le rendez-vous a l'agenda
    public void confirmerRendezVous(RendezVous rendezVous) {
    	serviceOrthophoniste.ajouterRendezVousAgenda(rendezVous);
    }
    
    // Verifier la disponibilite de l'orthophoniste
    public boolean orthophonisteDisponible(LocalDateTime DateEtHeure) {
    	return serviceOrthophoniste.estDisponible(DateEtHeure);
    }
    
    public void deroulerRdv(int rdvCode) {
    	try {
    		RendezVous rdv = serviceOrthophoniste.getOrthophoniste().agenda.get(rdvCode);
    		switch (rdv.getType()) {
				case CONSULTATION:
					vue.deroulerConsultation((Consultation)rdv);
		        	break;
		        case SEANCESUIVI:
//					vue.deroulerSeanceSuivi((SeanceSuivi)rdv);
		        	break;	
				case ATELIER:
//					vue.deroulerAtelier((Atelier)rdv);
		        	break;				
				default:
					break;
			}
		} catch (IndexOutOfBoundsException e) {
			 vue.afficherErreur("Le rendez-vous à derouler n'existe pas");
		}
    }
    
    // Créer une nouvelle anamnese pour l'orthophoniste
    public void ajouterNouvelleAnamnese() {
    	Anamnese anamnese = vue.lireAnamnese();
    	if (anamnese != null) {
    		serviceOrthophoniste.ajouterAnamnese(anamnese);
            vue.afficher("Anamnèse ajoutée avec succès.");
        } else {
            vue.afficherErreur("Échec de l'ajout de l'anamnèse.");
        }
    }
    
    // Créer un nouveau test pour l'orthophoniste
    public void ajouterNouveauTest() {
    	String typeTest = vue.lireChaine("Entrez le type du test "
    			+ "(exercice/questionnaire) : ").toLowerCase();
    	Test test = null;
    	switch(typeTest) {
    	case "exercice" :
    		test = vue.lireTestExercices();
    		break;
    	case "questionnaire" :
    		test = vue.lireTestQuestionnaire();
    		break;
    	default :
    		vue.afficherErreur("Type invalide.");
    		return;
    	}
    	serviceOrthophoniste.ajouterTest(test);
    	vue.afficher("Test ajouté avec succès.");
    }
}