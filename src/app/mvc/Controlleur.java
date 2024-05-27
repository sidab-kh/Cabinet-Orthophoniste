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
import app.data.bilans.BilanOrthophonique;
import app.data.bilans.EpreuveClinique;
import app.data.tests.Test;

/**
 * Contrôleur principal de l'application, implémenté selon le modèle Singleton.
 * Il agit comme une interface entre la vue et le service orthophoniste, coordonnant les actions de l'utilisateur
 * avec les fonctionnalités disponibles.
 */
public final class Controlleur {

    private static final Controlleur instance = new Controlleur();
    private ServiceOrthophoniste serviceOrthophoniste;
    private Vue vue;
    
    // Constructeur privé pour empêcher l'instanciation directe
    private Controlleur() {
       this.serviceOrthophoniste = new ServiceOrthophoniste();
       this.vue = new Vue(this);
    }

    /**
     * Retourne l'unique instance de Controlleur.
     * @return L'instance unique de Controlleur.
     */
    public static Controlleur getInstance() { return instance; }
    
    /**
     * Retourne le service orthophoniste associé à ce contrôleur.
     * @return Le service orthophoniste associé à ce contrôleur.
     */
    public ServiceOrthophoniste getServiceOrthophoniste() { return this.serviceOrthophoniste; }
    
    /**
     * Affiche le menu principal de l'application.
     */
    public void afficherMenu() { vue.afficherMenuPrincipal(); }
    
    /**
     * Lit les informations personnelles de l'orthophoniste depuis la vue.
     */
    public void lireInformationsOrthophoniste() { serviceOrthophoniste.setOrthophoniste(vue.lireInformationsOrthophoniste()); }
    
    /**
     * Vérifie la disponibilité de l'orthophoniste à une certaine date et heure.
     * @param DateEtHeure La date et l'heure pour lesquelles on souhaite vérifier la disponibilité.
     * @return true si l'orthophoniste est disponible, sinon false.
     */
    public boolean orthophonisteDisponible(LocalDateTime DateEtHeure) { return serviceOrthophoniste.estDisponible(DateEtHeure); }
    
    /**
     * Inscrit un nouveau patient dans le système.
     */
    public void inscrirePatient() { serviceOrthophoniste.ajouterNouveauPatient(vue.lirePatient()); }
    
    /**
     * Crée un dossier pour un nouveau patient.
     * @param patient Le patient pour lequel créer le dossier.
     */
    public void creerDossierPatient(Patient patient) { serviceOrthophoniste.creerDossierPatient(patient); }
    
    /**
     * Supprime un dossier patient après vérification du mot de passe.
     * @param motDePasse Le mot de passe à vérifier pour autoriser la suppression.
     * @param dossier Le dossier patient à supprimer.
     * @return true si le mot de passe est correct et le dossier est supprimé, sinon false.
     */
    public boolean supprimerDossierPatient(String motDePasse, DossierPatient dossier) {
    	if (CryptageMotDePasse.verifierMotDePasse(motDePasse, getServiceOrthophoniste().getOrthophoniste().getMotDePasseCrypte())) {
    		serviceOrthophoniste.supprimerDossierPatient(dossier);
    		return true;
    	} else return false;
    }
    
    /**
     * Vérifie si un dossier patient existe dans le système.
     * @param numeroDossier Le numéro du dossier à vérifier.
     * @return true si le dossier existe, sinon false.
     */
    public boolean dossierExiste(int numeroDossier) {return serviceOrthophoniste.existe(numeroDossier); }    
    
    /**
     * Ajoute un rendez-vous à l'agenda de l'orthophoniste.
     * @param rendezVous Le rendez-vous à ajouter.
     */
    public void confirmerRendezVous(RendezVous rendezVous) { serviceOrthophoniste.ajouterRendezVous(rendezVous); }
    
    /**
     * Rédige une observation pour un rendez-vous donné.
     * @param rendezVous Le rendez-vous pour lequel rédiger l'observation.
     */
    public void redigerObservation(RendezVous rendezVous) { serviceOrthophoniste.ajouterObservation(rendezVous, vue.lireChaine("Observation : ")); }
    
    /**
     * Retourne l'ensemble des dossiers patients dans le système.
     * @return Un ensemble de dossiers patients.
     */
    public Set<DossierPatient> getDossiersPatients() { return serviceOrthophoniste.getDossiersPatients(); }
    
    /**
     * Retourne la liste des nouveaux patients.
     * @return Une liste de nouveaux patients.
     */
    public List<Patient> getNouveauxPatients() { return serviceOrthophoniste.getNouveauxPatients(); }
    
    /**
     * Retourne la liste de tous les patients.
     * @return Une liste de tous les patients.
     */
    List<Patient> getPatients() { return new ArrayList<Patient>(serviceOrthophoniste.getPatients().values()); }
    
    /**
     * Convertit l'agenda des rendez-vous en une liste de chaînes de caractères.
     * @return Une liste de chaînes représentant les rendez-vous.
     */
    public List<String> agendaToString() {
    	List<String> RendezVousEnChaine = new ArrayList<String>();
    	for (RendezVous rdv : serviceOrthophoniste.getAgenda()) { RendezVousEnChaine.add(rdv.getChaine()); }
    	return RendezVousEnChaine;
    }
    
    /**
     * Convertit la liste des nouveaux patients en une liste de chaînes de caractères.
     * @return Une liste de chaînes représentant les nouveaux patients.
     */
    public List<String> nouveauxPatientsToString() {
    	List<String> nouveauxPatientsEnChaine = new ArrayList<String>();
    	for (Patient patient : serviceOrthophoniste.getNouveauxPatients()) {
    		nouveauxPatientsEnChaine.add(patient.getIndicePatient() + " / " + patient.getChaine());
    	}
    	return nouveauxPatientsEnChaine;
    }
    
    /**
     * Convertit la liste de tous les patients en une liste de chaînes de caractères.
     * @return Une liste de chaînes représentant tous les patients.
     */
    public List<String> patientsToString() {
    	List<String> patientsEnChaine = new ArrayList<String>();
    	Map<Integer, Patient> patients = serviceOrthophoniste.getPatients();
    	for (int numeroDossier : patients.keySet()) {
    		patientsEnChaine.add(numeroDossier + " / " + patients.get(numeroDossier).getChaine());
    	}
    	return patientsEnChaine;
    }
    
    /**
     * Convertit la liste des tests en une liste de chaînes de caractères.
     * @return Une liste de chaînes représentant les tests.
     */
    public List<String> testsToString() {
    	List<String> testsEnChaine = new ArrayList<String>();
    	for (Test test : serviceOrthophoniste.getTests()) { testsEnChaine.add(test.getChaine()); }
    	return testsEnChaine;
    }
    
    /**
     * Convertit la liste des anamnèses en une liste de chaînes de caractères.
     * @return Une liste de chaînes représentant les anamnèses.
     */
    public List<String> AnamnesesToString() {
    	List<String> anamnesesEnChaine = new ArrayList<String>();
    	for (Anamnese anamnese : serviceOrthophoniste.getAnamneses()) { anamnesesEnChaine.add(anamnese.getChaine()); }
    	return anamnesesEnChaine;
    }
    
    /**
     * Programme un nouveau rendez-vous selon le type spécifié.
     * @param type Le type de rendez-vous à programmer.
     */
    public void programmerRendezVous(ETypesRendezVous type) {
    	switch(type) {
    		case CONSULTATION : vue.lireConsultation(); break;
    		case SEANCE_SUIVI : vue.lireSeanceSuivi(); break;
    		case ATELIER : vue.lireAtelier(); break;
    	}
    }

    /**
     * Effectue l'inscription initiale de l'orthophoniste dans le système.
     * @param nouvelOrthophoniste L'orthophoniste à inscrire.
     */
    public void inscription(Orthophoniste nouvelOrthophoniste) {
    	serviceOrthophoniste.setOrthophoniste(nouvelOrthophoniste);
    	serviceOrthophoniste.sauvegarderOrthophoniste();
    }
    
    /**
     * Effectue la connexion de l'orthophoniste au système.
     * @param email L'email de l'orthophoniste.
     * @param motDePasse Le mot de passe de l'orthophoniste.
     * @return Un code représentant le résultat de la connexion :
     *          0 - Champs vides
     *          1 - Compte inexistant
     *          2 - Mot de passe incorrect
     *          3 - Connexion réussie
     */
    public int connexion(String email, String motDePasse) {
    	// Cas champs vides
    	if (email.isEmpty() || motDePasse.isEmpty()) return 0;
    	
    	// Charger l'orthophoniste
    	Orthophoniste orthophonisteCharge = serviceOrthophoniste.chargerOrthophoniste();
    	
    	// Cas compte inexistant
    	if (orthophonisteCharge == null || !email.equals(orthophonisteCharge.getEmail())) return 1;
    	
    	// Cas mot de passe erroné
    	if (!CryptageMotDePasse.verifierMotDePasse(motDePasse, orthophonisteCharge.getMotDePasseCrypte())) return 2;
    	
    	serviceOrthophoniste.setOrthophoniste(orthophonisteCharge);
    	return 3; // Connexion réussie
    }

    /**
     * Effectue la déconnexion de l'orthophoniste du système.
     * Sauvegarde également les informations de l'orthophoniste avant la déconnexion.
     */
    public void deconnexion() {
    	serviceOrthophoniste.sauvegarderOrthophoniste();
    	serviceOrthophoniste.setOrthophoniste(null);
    }
    
    /**
     * Supprime définitivement le compte de l'orthophoniste de la machine.
     * Toutes les données associées à ce compte seront perdues.
     */
    public void supprimerCompte() { serviceOrthophoniste.supprimerOrthophoniste(); }
    
    /**
     * Déroule un rendez-vous spécifié par son code.
     * @param rdvCode Le code du rendez-vous à dérouler.
     */
    public void deroulerRdv(int rdvCode) {
    	try {
    		RendezVous rdv = serviceOrthophoniste.getOrthophoniste().agenda.get(rdvCode);
    		switch (rdv.getType()) {
				case CONSULTATION:
					vue.deroulerConsultation((Consultation)rdv);
		        	break;
		        case SEANCE_SUIVI:
		        	// vue.deroulerSeanceSuivi((SeanceSuivi)rdv);
		        	break;	
				case ATELIER:
					// vue.deroulerAtelier((Atelier)rdv);
		        	break;				
				default:
					break;
			}
		} catch (IndexOutOfBoundsException e) {
			 vue.afficherErreur("Le rendez-vous à dérouler n'existe pas");
		}
    }
    
    /**
     * Crée une nouvelle anamnèse pour l'orthophoniste en utilisant les informations fournies par la vue.
     * Affiche un message de succès ou d'erreur selon le résultat de l'opération.
     */
    public void ajouterNouvelleAnamnese() {
    	Anamnese anamnese = vue.lireAnamnese();
    	if (anamnese != null) {
    		serviceOrthophoniste.ajouterAnamnese(anamnese);
            vue.afficher("Anamnèse ajoutée avec succès.");
        } else {
            vue.afficherErreur("Échec de l'ajout de l'anamnèse.");
        }
    }
    
    /**
     * Crée un nouveau test pour l'orthophoniste en utilisant les informations fournies par la vue.
     * Affiche un message de succès ou d'erreur selon le résultat de l'opération.
     */
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
    
    public RendezVous getRendezVousActuel() {
    	LocalDateTime dateEtHeure = LocalDateTime.now();
        for (RendezVous rdv : serviceOrthophoniste.getAgenda()) {
            if (rdv.getDateEtHeure().equals(dateEtHeure) || (dateEtHeure.isAfter(rdv.getDateEtHeure()) &&
            		dateEtHeure.isBefore(rdv.calculerHeureFin())))
            	return rdv;
        }
        return null; 
    }
    
    public void creerEpreuvesCliniques(List<Integer> indicesTests, BilanOrthophonique bo) {
		List<Test> tests = serviceOrthophoniste.getTests();
		for (int indice : indicesTests) {
	        bo.ajouterEpreuveClinique(new EpreuveClinique(tests.get(indice)));
	    }
	}
}