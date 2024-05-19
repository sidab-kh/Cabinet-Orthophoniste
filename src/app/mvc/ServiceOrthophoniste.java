package app.mvc;

import java.time.LocalDateTime;

import app.data.patient.DossierPatient;
import app.data.patient.Patient;
import app.data.rdv.RendezVous;
import app.util.exception.NumeroDossierExistantException;
import app.util.persistance.OrthophonisteDAO;

// Cette classe represente le patron de conception "Service Layer", colle bien avec la structure MVC
// Fournit tous les services possibles a l'orthophoniste, c'est l'unique classe ayant acces direct au modele (Orthophoniste)
public class ServiceOrthophoniste {
	private Controlleur controlleur;
	private Orthophoniste orthophoniste;
	private OrthophonisteDAO orthophonisteDAO;
	
	// Constructeur
	public ServiceOrthophoniste(Controlleur controlleur) {
		this.controlleur = controlleur;
		this.orthophoniste = new Orthophoniste();
        this.orthophonisteDAO = new OrthophonisteDAO();
    }

	public void inscrireOrthophoniste(Orthophoniste orthophoniste) {
        this.orthophoniste = orthophoniste;
    }
	
	public Orthophoniste getOrthophoniste() {
		return this.orthophoniste;
	}
	
	// Ajouter un dossier au set de dossiers
	public void ajouterDossierPatient(DossierPatient dossierPatient) throws NumeroDossierExistantException {
		if (orthophoniste.dossiersPatients.contains(dossierPatient)) throw new NumeroDossierExistantException();
        orthophoniste.dossiersPatients.add(dossierPatient);
    }
	
	// Mettre le patient dans la map, avec son numero de dossier comme cle
	public void enregistrerPatient(int numeroDossier, Patient patient) {
		orthophoniste.patients.put(numeroDossier, patient);
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
			DossierPatient.incrementerCompteurNumero();
		}	
	}
    
	// Ajouter un nouveau patient a la liste des nouveaux patients
    public void ajouterNouveauPatient(Patient patient) {
    	orthophoniste.nouveauxPatients.add(patient);
    }

    // Ajouter un rendez-vous a l'agenda
    public void ajouterRendezVousAgenda(RendezVous rendezVous) {
    	if (estDisponible(rendezVous.getDateEtHeure())) {
    		orthophoniste.agenda.add(rendezVous);
    	}
    }
    
    // Verifier la disponibilite de l'orthophoniste a une date/heure donnee
    public boolean estDisponible(LocalDateTime dateEtHeure) {
        for (RendezVous rdv : orthophoniste.agenda) {
        	 // Verifier si la date et l'heure demandees se situent pendant le rendez-vous
            if (rdv.getDateEtHeure().equals(dateEtHeure) || (dateEtHeure.isAfter(rdv.getDateEtHeure()) &&
            		dateEtHeure.isBefore(rdv.calculerHeureFin()))) return false;
        }
        // Si aucun rendez-vous ne correspond, l'orthophoniste est disponible
        return true;
    }
}
