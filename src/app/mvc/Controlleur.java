package app.mvc;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import app.data.patients.DossierPatient;
import app.data.patients.Patient;
import app.data.rendezvous.RendezVous;
import app.util.CryptageMotDePasse;
import app.util.enumerations.ETypesRendezVous;

public final class Controlleur {

    private static final Controlleur instance = new Controlleur();
    private ServiceOrthophoniste serviceOrthophoniste;
	private Vue vue;
	
    // Constructeur prive
    private Controlleur() {
	   this.serviceOrthophoniste = new ServiceOrthophoniste();
	   this.vue = new Vue(this);
    }

    public static Controlleur getInstance() { return instance; }
    
    // Afficher le menu principal
    public void afficherMenu() { vue.afficherMenuPrincipal(); }
    
    // Lire les informations personnelles de l'orthophoniste
    public void lireInformationsOrthophoniste() { serviceOrthophoniste.setOrthophoniste(vue.lireInformationsOrthophoniste()); }
    
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
    
    // Rediger une observation pour un rendez-vous
    public void redigerObservation(RendezVous rendezVous) { serviceOrthophoniste.ajouterObservation(rendezVous, vue.lireChaine("Observation : ")); }
    
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

    // Premiere inscription de l'orthophoniste
    public void inscription(Orthophoniste nouvelOrthophoniste) {
    	serviceOrthophoniste.setOrthophoniste(nouvelOrthophoniste);
    	serviceOrthophoniste.sauvegarderOrthophoniste();
    }
    
    // Mettre au point la connexion
    public int connexion(String email, String motDePasse) {
    	// Cas champs vides
    	if (email.isEmpty() || motDePasse.isEmpty()) return 0;
    	
    	// Charger l'orthophoniste
    	Orthophoniste orthophonisteCharge = serviceOrthophoniste.chargerOrthophoniste();
    	
    	// Cas compte inexistant
    	if (orthophonisteCharge == null || !email.equals(orthophonisteCharge.getEmail())) return 1;
    	
    	// Cas mot de passe errone
    	if (!CryptageMotDePasse.verifierMotDePasse(motDePasse, orthophonisteCharge.getMotDePasseCrypte())) return 2;
    	
    	// Connexion reussie
    	return 3;
    }

    // Se deconnecter
    public void deconnexion() {
    	serviceOrthophoniste.setOrthophoniste(null);
    }
    
    // Supprimer l'orthophoniste de la machine
    public void supprimerCompte() { serviceOrthophoniste.supprimerOrthophoniste(); }
}