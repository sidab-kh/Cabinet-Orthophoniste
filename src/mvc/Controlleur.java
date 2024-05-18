package mvc;

import java.time.LocalDateTime;

import patient.Patient;
import rendezVous.RendezVous;

// Cette classe joue le role de 'Controller' dans l'architecture MVC
// Cette classe doit rester simple et se contenter de donner les ordres
public final class Controlleur {

	private ServiceOrthophoniste serviceOrthophoniste; // Operations
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
    public boolean estDisponible(LocalDateTime DateEtHeure) {
    	return serviceOrthophoniste.estDisponible(DateEtHeure);
    }
}