package app.mvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import app.data.patients.DossierPatient;
import app.data.patients.Patient;
import app.data.rendezvous.Consultation;
import app.data.rendezvous.RendezVous;
import app.util.CryptageMotDePasse;
import app.util.enumerations.ETypesRendezVous;
import app.data.bilans.Anamnese;
import app.data.tests.Test;

public final class Controlleur {

    private static final Controlleur instance = new Controlleur();
    private ServiceOrthophoniste serviceOrthophoniste;
	private Vue vue;
	
    // Constructeur prive
    private Controlleur() {
	   this.serviceOrthophoniste = new ServiceOrthophoniste();
	   this.vue = new Vue(this);
    }

    // Retourner l'instance de controlleur
    public static Controlleur getInstance() { return instance; }
    
    // Retourner le service orthophoniste
    public ServiceOrthophoniste getServiceOrthophoniste() { return this.serviceOrthophoniste; }
    
    // Afficher le menu principal
    public void afficherMenu() { vue.afficherMenuPrincipal(); }
    
    // Lire les informations personnelles de l'orthophoniste
    public void lireInformationsOrthophoniste() { serviceOrthophoniste.setOrthophoniste(vue.lireInformationsOrthophoniste()); }
    
    // Verifier la disponibilite de l'orthophoniste
    public boolean orthophonisteDisponible(LocalDateTime DateEtHeure) { return serviceOrthophoniste.estDisponible(DateEtHeure); }
    
    // Ajouter un nouveau patient
    public void inscrirePatient() { serviceOrthophoniste.ajouterNouveauPatient(vue.lirePatient()); }
    
    // Creer un dossier pour un nouveau patient
    public void creerDossierPatient(Patient patient) { serviceOrthophoniste.creerDossierPatient(patient); }
    
    // Supprimer un dossier
    public boolean supprimerDossierPatient(String motDePasse, DossierPatient dossier) {
    	if (CryptageMotDePasse.verifierMotDePasse(motDePasse, getServiceOrthophoniste().getOrthophoniste().getMotDePasseCrypte())) {
    		serviceOrthophoniste.supprimerDossierPatient(dossier);
    		return true;
    	} else return false;
    }
    
    // Verifier si un dossier existe
    public boolean dossierExiste(int numeroDossier) {return serviceOrthophoniste.existe(numeroDossier); }    
    
    // Ajouter un rendez-vous a l'agenda
    public void confirmerRendezVous(RendezVous rendezVous) { serviceOrthophoniste.ajouterRendezVous(rendezVous); }
    
    // Rediger une observation pour un rendez-vous
    public void redigerObservation(RendezVous rendezVous) { serviceOrthophoniste.ajouterObservation(rendezVous, vue.lireChaine("Observation : ")); }
    
    // Retourner les dossiers des patients
    public Set<DossierPatient> getDossiersPatients() { return serviceOrthophoniste.getDossiersPatients(); }
    
    // Retourner les nouveaux patients
    public List<Patient> getNouveauxPatients() { return serviceOrthophoniste.getNouveauxPatients(); }
    
    // Retourner la liste des patients
    List<Patient> getPatients() { return new ArrayList<Patient>(serviceOrthophoniste.getPatients().values()); }
    
    // Transformer l'agenda en une liste de chaines
    public List<String> agendaToString() {
    	List<String> RendezVousEnChaine = new ArrayList<String>();
    	for (RendezVous rdv : serviceOrthophoniste.getAgenda()) { RendezVousEnChaine.add(rdv.getChaine()); }
    	return RendezVousEnChaine;
    }
    
    // Transformer la liste des nouveaux patients en une liste de chaines
    public List<String> nouveauxPatientsToString() {
    	List<String> nouveauxPatientsEnChaine = new ArrayList<String>();
    	for (Patient patient : serviceOrthophoniste.getNouveauxPatients()) {
    		nouveauxPatientsEnChaine.add(patient.getIndicePatient() + " / " + patient.getChaine());
    	}
    	return nouveauxPatientsEnChaine;
    }
    
    // Transformer la liste des patients en une liste de chaines
    public List<String> patientsToString() {
    	List<String> patientsEnChaine = new ArrayList<String>();
    	Map<Integer, Patient> patients = serviceOrthophoniste.getPatients();
    	for (int numeroDossier : patients.keySet()) {
    		patientsEnChaine.add(numeroDossier + " / " + patients.get(numeroDossier).getChaine());
    	}
    	return patientsEnChaine;
    }
    
    // Transformer la liste des tests en une liste de chaines
    public List<String> testsToString() {
    	List<String> testsEnChaine = new ArrayList<String>();
    	for (Test test : serviceOrthophoniste.getTests()) { testsEnChaine.add(test.getChaine()); }
    	return testsEnChaine;
    }
    
    // Transformer la liste des anamneses en une liste de chaines
    public List<String> AnamnesesToString() {
    	List<String> anamnesesEnChaine = new ArrayList<String>();
    	for (Anamnese anamnese : serviceOrthophoniste.getAnamneses()) { anamnesesEnChaine.add(anamnese.getChaine()); }
    	return anamnesesEnChaine;
    }
    
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
    	
    	serviceOrthophoniste.setOrthophoniste(orthophonisteCharge);
    	return 3; // Connexion reussie
    }

    // Se deconnecter
    public void deconnexion() {
    	serviceOrthophoniste.sauvegarderOrthophoniste();
    	serviceOrthophoniste.setOrthophoniste(null);
    }
    
    // Supprimer l'orthophoniste de la machine
    public void supprimerCompte() { serviceOrthophoniste.supprimerOrthophoniste(); }
    
    public void deroulerRdv(int rdvCode) {
    	try {
    		RendezVous rdv = serviceOrthophoniste.getOrthophoniste().agenda.get(rdvCode);
    		switch (rdv.getType()) {
				case CONSULTATION:
					vue.deroulerConsultation((Consultation)rdv);
		        	break;
		        case SEANCE_SUIVI:
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