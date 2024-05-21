package app.mvc;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import app.data.patient.DossierPatient;
import app.data.patient.Patient;
import app.data.rdv.RendezVous;
import app.util.enumeration.ETypesRendezVous;

public final class Controlleur {

	private ServiceOrthophoniste serviceOrthophoniste;
    private Vue vue;

    // Constructeur
    public Controlleur() {
        this.serviceOrthophoniste = new ServiceOrthophoniste(this);
        this.vue = new Vue(this);
    }
    
    // Afficher le menu principal
    public void afficherMenu() { vue.afficherMenuPrincipal(); }
    
    // Lire les informations personnelles de l'orthophoniste
    public void lireInformationsOrthophoniste() { serviceOrthophoniste.inscrireOrthophoniste(vue.lireInformationsOrthophoniste()); }
    
    // Afficher les informations de l'orthophoniste
    public void afficherInformationsOrthophoniste() { vue.afficherInformationsOrthophoniste(serviceOrthophoniste.getOrthophoniste()); }
    
    // Verifier la disponibilite de l'orthophoniste
    public boolean orthophonisteDisponible(LocalDateTime DateEtHeure) { return serviceOrthophoniste.estDisponible(DateEtHeure); }
    
    // Ajouter un nouveau patient
    public void inscrirePatient() { serviceOrthophoniste.ajouterNouveauPatient(vue.lirePatient()); }
    
    // Creer un dossier pour un nouveau patient
    public void creerDossierPatient(Patient patient) { serviceOrthophoniste.creerDossierPatient(patient); }
    
    // Verifier si un dossier existe
    public boolean dossierExiste(int numeroDossier) {return serviceOrthophoniste.existe(numeroDossier); }    
    
    // Ajouter un rendez-vous a l'agenda
    public void confirmerRendezVous(RendezVous rendezVous) { serviceOrthophoniste.ajouterRendezVous(rendezVous); }
    
    // Retourner l'agenda
    public List<RendezVous> getAgenda() { return serviceOrthophoniste.getAgenda(); }
    
    // Retourner les dossiers des patients
    public Set<DossierPatient> getDossiersPatients() { return serviceOrthophoniste.getDossiersPatients(); }
    
    // Retourner les nouveaux patients
    public List<Patient> getNouveauxPatients() { return serviceOrthophoniste.getNouveauxPatients(); }
    
    // Retourner la liste des patients
    List<Patient> getPatients() { return serviceOrthophoniste.getPatients(); }
    
    // Afficher l'agenda
    public void afficherAgenda() { vue.afficherAgenda(); }
    
    // Programmer un nouveau rendez-vous
    public void programmerRendezVous(ETypesRendezVous type) {
    	switch(type) {
    		case CONSULTATION : vue.lireConsultation(); break;
    		case SEANCE_SUIVI : vue.lireSeanceSuivi(); break;
    		case ATELIER : vue.lireAtelier(); break;
    	}
    }
}