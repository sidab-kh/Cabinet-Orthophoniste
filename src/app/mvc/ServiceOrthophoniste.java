package app.mvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import app.data.bilans.Anamnese;
import app.data.patients.DossierPatient;
import app.data.patients.Patient;
import app.data.rendezvous.Atelier;
import app.data.rendezvous.RendezVous;
import app.data.rendezvous.SeanceSuivi;
import app.data.tests.Test;
import app.util.exceptions.NumeroDossierExistantException;
import app.util.persistance.OrthophonisteDAO;

public final class ServiceOrthophoniste {
	
	private Orthophoniste orthophoniste = null;
	private OrthophonisteDAO orthophonisteDAO = new OrthophonisteDAO("orthophoniste.ser");

	// Connecter l'orthophoniste
	public void setOrthophoniste(Orthophoniste orthophoniste) { this.orthophoniste = orthophoniste; }
	
	// Retourner l'orthophoniste
	public Orthophoniste getOrthophoniste() { return this.orthophoniste; }
    
	// Ajouter un nouveau patient a la liste des nouveaux patients
    public void ajouterNouveauPatient(Patient patient) { if (patient != null) orthophoniste.nouveauxPatients.add(patient); }
    
    // Ajouter un dossier au set de dossiers
 	public void ajouterDossierPatient(DossierPatient dossierPatient) throws NumeroDossierExistantException {
 		if (dossierPatient != null) {
 			if (orthophoniste.dossiersPatients.contains(dossierPatient)) throw new NumeroDossierExistantException();
 	        orthophoniste.dossiersPatients.add(dossierPatient);
 		}
    }
 	
 	// Creer un dossier pour un nouveau patient
 	public void creerDossierPatient(Patient patient) {
 		if (patient != null && orthophoniste.nouveauxPatients.contains(patient)) {
 			int numeroDossier = DossierPatient.getCompteurNumero();
 			DossierPatient dossier = new DossierPatient(numeroDossier);
 			
 			try { ajouterDossierPatient(dossier); }
 			catch (NumeroDossierExistantException e) {
 	    		// TODO: Traiter l'exception
 	    	}
 			
 			orthophoniste.patients.put(numeroDossier, patient);
 	 		orthophoniste.nouveauxPatients.remove(patient); // Supprimer le patient de la liste des nouveaux patients
 			DossierPatient.incrementerCompteurNumero(); // Incrementer le compteur pour garantir l'unicite
 		}	
 	}
 	
 	// Supprimer le dossier d'un patient (et le patient lui-meme)
 	public boolean supprimerDossierPatient(DossierPatient dossier) {
 		if (dossier != null && orthophoniste.dossiersPatients.contains(dossier)) {
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
 	    if (rendezVous != null && orthophoniste.agenda.add(rendezVous)) {
 	    	if (rendezVous instanceof Atelier) {
 	 	        // Ajouter le rendez-vous aux dossiers de tous les participants
 	 	        for (int numeroDossier : ((Atelier) rendezVous).getNumerosDossiers()) {
 	 	            DossierPatient dossier = dossierDeNumero(numeroDossier);
 	 	            if (dossier != null) dossier.ajouterRendezVous(rendezVous);
 	 	        }
 	 	    }

 	 	    if (rendezVous instanceof SeanceSuivi) {
 	 	        // Ajouter le rendez-vous au dossier du participant
 	 	        DossierPatient dossier = dossierDeNumero(((SeanceSuivi) rendezVous).getNumeroDossier());
 	 	        if (dossier != null) dossier.ajouterRendezVous(rendezVous);
 	 	    }
 	    }
 	}
 	
 	// Annuler un rendez-vous (le supprimer)
 	public void annulerRendezVous(RendezVous rendezVous) {
 	    if (rendezVous != null && orthophoniste.agenda.remove(rendezVous)) {
 	     
 	        if (rendezVous instanceof Atelier) {
 	        	// Supprimer le rendez-vous des dossiers de tous les participants
 	            for (int numeroDossier : ((Atelier) rendezVous).getNumerosDossiers()) {
 	                DossierPatient dossier = dossierDeNumero(numeroDossier);
 	                if (dossier != null) dossier.supprimerRendezVous(rendezVous);
 	            }
 	        }

 	        if (rendezVous instanceof SeanceSuivi) {
 	        	// Supprimer le rendez-vous du dossier du participant
 	            DossierPatient dossier = dossierDeNumero(((SeanceSuivi) rendezVous).getNumeroDossier());
 	            if (dossier != null) dossier.supprimerRendezVous(rendezVous);
 	        }
 	    }
 	}

    // Verifier la disponibilite de l'orthophoniste a une date et heure donnees
    public boolean estDisponible(LocalDateTime dateEtHeure) {
    	if (dateEtHeure == null) return false;
        for (RendezVous rdv : orthophoniste.agenda) {
        	// Verifier si la date et l'heure demandees se situent pendant le rendez-vous
            if (rdv.getDateEtHeure().equals(dateEtHeure) || (dateEtHeure.isAfter(rdv.getDateEtHeure()) &&
            		dateEtHeure.isBefore(rdv.calculerHeureFin()))) return false;
        }
        return true; // Si aucun rendez-vous ne correspond, l'orthophoniste est disponible
    }
    
    // Verifier si un dossier existe
    public boolean existe(int numeroDossier) { return dossierDeNumero(numeroDossier) != null; }
    
    // Retourner l'agenda
    public List<RendezVous> getAgenda() { return new ArrayList<>(orthophoniste.agenda); }
    
    // Retourner les dossiers des patients
    public Set<DossierPatient> getDossiersPatients() { return new HashSet<>(orthophoniste.dossiersPatients); }
    
    // Retourner les nouveaux patients
    public List<Patient> getNouveauxPatients() { return new ArrayList<>(orthophoniste.nouveauxPatients); }
    
    // Retourner la liste des patients
    public List<Patient> getPatients() { return new ArrayList<>(orthophoniste.patients.values()); }
    
    // Ajouter une observation pour un rendez-vous
    public void ajouterObservation(RendezVous rendezVous, String observation) { if (rendezVous != null) rendezVous.setObservation(observation); }
    
    // Sauvegarder l'orthophoniste
    public boolean sauvegarderOrthophoniste() { return orthophonisteDAO.sauvegarder(orthophoniste); }
    
    // Charger et retourner l'orthophoniste sauvegarde
    public Orthophoniste chargerOrthophoniste() { return orthophonisteDAO.charger(); }
    
    // Supprimer l'orthophoniste
    public boolean supprimerOrthophoniste() { return orthophonisteDAO.supprimer(); }
    
	public void ajouterAnamnese(Anamnese anamnese) {
        orthophoniste.anamneses.add(anamnese);
	}
    
	public void ajouterTest(Test test) {
        orthophoniste.tests.add(test);
	}
}
