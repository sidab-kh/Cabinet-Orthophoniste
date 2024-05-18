package mvc;

import java.time.LocalDateTime;

import exceptionsPersonnalisees.NumeroDossierExistantException;
import exceptionsPersonnalisees.OrthophonisteNonDisponibleException;
import patient.DossierPatient;
import patient.Patient;
import persistance.OrthophonisteDAO;
import rendezVous.RendezVous;

// Cette classe represente le service layer (patron de conception)
public class ServiceOrthophoniste {
	private Orthophoniste orthophoniste;
	private OrthophonisteDAO orthophonisteDAO;
	
	// Constructeur
	public ServiceOrthophoniste() {
        this.orthophonisteDAO = new OrthophonisteDAO();
        this.orthophoniste = new Orthophoniste();
    }

	public void inscrireOrthophoniste(String nom, String prenom, String adresse, String email,
			String motDePasse, int numeroTelephone) {
        this.orthophoniste = new Orthophoniste(nom, prenom, adresse, email, motDePasse, numeroTelephone);
    }
	
	public Orthophoniste getOrthophoniste() {
		return this.orthophoniste;
	}
	
	// Ajouter un dossier au set de dossiers
	public void ajouterDossierPatient(DossierPatient dossierPatient) throws NumeroDossierExistantException {
		if (orthophoniste.dossiersPatients.contains(dossierPatient)) throw new NumeroDossierExistantException();
        orthophoniste.dossiersPatients.add(dossierPatient);
    }
    
	// Ajouter un nouveau patient a la liste des nouveaux patients
    public void ajouterNouveauPatient(Patient patient) {
    	orthophoniste.nouveauxPatients.add(patient);
    }

    // Ajouter un rendez-vous a l'agenda
    public void ajouterRendezVous(RendezVous rendezVous) throws OrthophonisteNonDisponibleException {
    	if (!estDisponible(rendezVous.getDateEtHeure())) throw new OrthophonisteNonDisponibleException();
        orthophoniste.agenda.add(rendezVous);
    }
    
    // Verifier la disponibilite de l'orthophoniste a une date/heure donnee
    private boolean estDisponible(LocalDateTime dateEtHeure) {
        for (RendezVous rdv : orthophoniste.agenda) {
        	 // Verifier si la date et l'heure demandees se situent pendant le rendez-vous
            if (rdv.getDateEtHeure().equals(dateEtHeure)) return false;
            if (dateEtHeure.isAfter(rdv.getDateEtHeure()) && dateEtHeure.isBefore(rdv.calculerHeureFin())) return false;
        }
        // Si aucun rendez-vous ne correspond, l'orthophoniste est disponible
        return true;
    }
}
