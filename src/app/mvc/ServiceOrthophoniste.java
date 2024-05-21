package app.mvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import app.data.patient.DossierPatient;
import app.data.patient.Patient;
import app.data.rdv.RendezVous;
import app.util.exception.NumeroDossierExistantException;
import app.util.persistance.OrthophonisteDAO;

public final class ServiceOrthophoniste {
	private Controlleur controlleur;
	private Orthophoniste orthophoniste = new Orthophoniste();
	private OrthophonisteDAO orthophonisteDAO = new OrthophonisteDAO();
	
	// Constructeur
	public ServiceOrthophoniste(Controlleur controlleur) { this.controlleur = controlleur; }

	// Inscrire l'orthophoniste
	public void inscrireOrthophoniste(Orthophoniste orthophoniste) { this.orthophoniste = orthophoniste; }
	
	// Retourner l'orthophoniste
	public Orthophoniste getOrthophoniste() { return this.orthophoniste; }
    
	// Ajouter un nouveau patient a la liste des nouveaux patients
    public void ajouterNouveauPatient(Patient patient) { orthophoniste.nouveauxPatients.add(patient); }
    
    // Ajouter un dossier au set de dossiers
 	public void ajouterDossierPatient(DossierPatient dossierPatient) throws NumeroDossierExistantException {
 		if (orthophoniste.dossiersPatients.contains(dossierPatient)) throw new NumeroDossierExistantException();
        orthophoniste.dossiersPatients.add(dossierPatient);
    }
 	
 	// Mettre le patient dans la map, avec son numero de dossier comme cle
 	public void enregistrerPatient(int numeroDossier, Patient patient) {
 		orthophoniste.patients.put(numeroDossier, patient);
 		orthophoniste.nouveauxPatients.remove(patient); // Supprimer le patient de la liste des nouveaux patients
 	}
 	
 	// Creer un dossier pour un nouveau patient
 	public void creerDossierPatient(Patient patient) {
 		if (orthophoniste.nouveauxPatients.contains(patient)) {
 			DossierPatient dossier = new DossierPatient(DossierPatient.getCompteurNumero());
 			try {
 				ajouterDossierPatient(dossier);
 			} catch (NumeroDossierExistantException e) {
 	    		// TODO: Traiter l'exception
 	    	}
 			enregistrerPatient(DossierPatient.getCompteurNumero(), patient);
 			DossierPatient.incrementerCompteurNumero(); // Incrementer le compteur pour garentir l'unicite
 		}	
 	}
 	
 	// Supprimer le dossier d'un patient (et le patient lui-meme)
 	public boolean supprimerDossierPatient(DossierPatient dossier) {
 		if (orthophoniste.dossiersPatients.contains(dossier)) {
 			orthophoniste.dossiersPatients.remove(dossier);
 			orthophoniste.patients.remove(dossier.getNumero());
 			return true;
 		}
 		return false;
 	}
 	
 	// Retourner le dossier ayant le numero donne
 	public DossierPatient dossierDeNumero(int numeroDossier) {
 		for (DossierPatient dossier : orthophoniste.dossiersPatients) { if (dossier.getNumero() == numeroDossier) return dossier; }
 		return null;
 	}

    // Ajouter un rendez-vous a l'agenda
    public void ajouterRendezVous(RendezVous rendezVous) {
    	orthophoniste.agenda.add(rendezVous);
    }
    
    // Verifier la disponibilite de l'orthophoniste a une date et heure donnees
    public boolean estDisponible(LocalDateTime dateEtHeure) {
        for (RendezVous rdv : orthophoniste.agenda) {
        	// Verifier si la date et l'heure demandees se situent pendant le rendez-vous
            if (rdv.getDateEtHeure().equals(dateEtHeure) || (dateEtHeure.isAfter(rdv.getDateEtHeure()) &&
            		dateEtHeure.isBefore(rdv.calculerHeureFin()))) return false;
        }
        return true; // Si aucun rendez-vous ne correspond, l'orthophoniste est disponible
    }
    
    // Verifier si un dossier existe
    public boolean existe(int numeroDossier) { return dossierDeNumero(numeroDossier) != null &&
    		orthophoniste.dossiersPatients.contains(dossierDeNumero(numeroDossier)); }
    
    // Retourner l'agenda
    public List<RendezVous> getAgenda() { return orthophoniste.agenda; }
    
    // Retourner les dossiers des patients
    public Set<DossierPatient> getDossiersPatients() { return orthophoniste.dossiersPatients; }
    
    // Retourner les nouveaux patients
    public List<Patient> getNouveauxPatients() { return orthophoniste.nouveauxPatients; }
    
    // Retourner la liste des patients
    List<Patient> getPatients() { return new ArrayList<>(orthophoniste.patients.values()); }
}
