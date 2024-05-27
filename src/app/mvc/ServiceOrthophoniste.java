package app.mvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import app.data.bilans.Anamnese;
import app.data.patients.DossierPatient;
import app.data.patients.Patient;
import app.data.rendezvous.Atelier;
import app.data.rendezvous.Consultation;
import app.data.rendezvous.RendezVous;
import app.data.rendezvous.SeanceSuivi;
import app.data.tests.Test;
import app.util.CryptageMotDePasse;
import app.util.persistance.OrthophonisteDAO;

/**
 * Cette classe suit le patron de conception "Service Layer" et gère les opérations liées à l'orthophoniste, 
 * telles que la gestion des patients et des rendez-vous.
 */
public final class ServiceOrthophoniste {
	
	private Orthophoniste orthophoniste = null;
	private OrthophonisteDAO orthophonisteDAO = new OrthophonisteDAO("orthophoniste.ser");

	/**
	 * Définit l'orthophoniste actuellement connecté.
	 * @param orthophoniste L'orthophoniste à définir.
	 */
	public void setOrthophoniste(Orthophoniste orthophoniste) { this.orthophoniste = orthophoniste; }
	
	/**
	 * Récupère l'orthophoniste actuellement connecté.
	 * @return L'orthophoniste actuellement connecté.
	 */
	public Orthophoniste getOrthophoniste() { return this.orthophoniste; }
    
	/**
	 * Ajoute un nouveau patient à la liste des nouveaux patients.
	 * @param patient Le patient à ajouter.
	 */
    public void ajouterNouveauPatient(Patient patient) { if (patient != null) orthophoniste.nouveauxPatients.add(patient); }
    
    /**
	 * Supprime un patient de la liste des nouveaux patients.
	 * @param patient Le patient à supprimer.
	 */
    public void supprimerNouveauPatient(Patient patient) {
        if (patient != null) {
            orthophoniste.nouveauxPatients.remove(patient);
            Iterator<RendezVous> iterator = orthophoniste.agenda.iterator();
            while (iterator.hasNext()) {
                RendezVous rdv = iterator.next();
                if (rdv instanceof Consultation && ((Consultation)rdv).getPatient().equals(patient)) {
                    iterator.remove();
                }
            }
        }
    }

    /**
     * Ajoute un dossier patient au set de dossiers patients.
     * @param dossierPatient Le dossier patient à ajouter.
     */
 	public void ajouterDossierPatient(DossierPatient dossierPatient) {
 		if (dossierPatient != null) {
 			if (!orthophoniste.dossiersPatients.contains(dossierPatient)) orthophoniste.dossiersPatients.add(dossierPatient);
 		}
    }
 	
 	/**
 	 * Crée un dossier pour un nouveau patient.
 	 * @param patient Le nouveau patient pour lequel créer le dossier.
 	 */
 	public void creerDossierPatient(Patient patient) {
 		if (patient != null && orthophoniste.nouveauxPatients.contains(patient)) {
 			ajouterDossierPatient(new DossierPatient());
 			orthophoniste.patients.put(DossierPatient.compteurNumero, patient);
 			DossierPatient.compteurNumero++;
 	 		orthophoniste.nouveauxPatients.remove(patient);
 		}
 	}
 	
 	/**
 	 * Supprime le dossier d'un patient ainsi que le patient lui-même.
 	 *
 	 * @param dossier le dossier du patient à supprimer
 	 * @return true si le dossier a été supprimé avec succès, sinon false
 	 */
 	public boolean supprimerDossierPatient(DossierPatient dossier) {
 	    if (dossier != null && orthophoniste.dossiersPatients.contains(dossier)) {
 	        orthophoniste.dossiersPatients.remove(dossier);
 	        Iterator<RendezVous> iterator = orthophoniste.agenda.iterator();
 	        while (iterator.hasNext()) {
 	            RendezVous rdv = iterator.next();
 	            if (rdv instanceof Consultation && ((Consultation)rdv).getPatient().equals(patientDeNumeroDossier(dossier.getNumero()))) {
 	                iterator.remove();
 	            } else if (rdv instanceof SeanceSuivi && ((SeanceSuivi)rdv).getNumeroDossier() == dossier.getNumero()) {
 	                iterator.remove();
 	            } else if (rdv instanceof Atelier && ((Atelier)rdv).getNumerosDossiers().contains(dossier.getNumero())) {
 	                iterator.remove();
 	            }
 	        }
 	        orthophoniste.patients.remove(dossier.getNumero());
 	        return true;
 	    }
 	    return false;
 	}

 	/**
 	 * Retourne le dossier ayant le numéro donné.
 	 *
 	 * @param numeroDossier le numéro du dossier à rechercher
 	 * @return le dossier correspondant au numéro donné, null si non trouvé
 	 */
 	public DossierPatient dossierDeNumero(int numeroDossier) {
 	    for (DossierPatient dossier : orthophoniste.dossiersPatients) {
 	        if (dossier.getNumero() == numeroDossier) return dossier;
 	    }
 	    return null;
 	}

 	/**
 	 * Retourne le patient ayant le numéro de dossier donné.
 	 *
 	 * @param numeroDossier le numéro de dossier du patient à rechercher
 	 * @return le patient correspondant au numéro de dossier donné, null si non trouvé
 	 */
 	public Patient patientDeNumeroDossier(int numeroDossier) { return orthophoniste.patients.get(numeroDossier); }

 	/**
 	 * Retourne le nouveau patient ayant l'indice donné.
 	 *
 	 * @param numero l'indice du patient à rechercher parmi les nouveaux patients
 	 * @return le nouveau patient correspondant à l'indice donné, null si non trouvé
 	 */
 	public Patient patientDeIndice(int numero) {
 	    for (Patient patient : orthophoniste.nouveauxPatients) {
 	        if (patient.getIndicePatient() == numero) return patient;
 	    }
 	    return null;
 	}

 	/**
 	 * Ajoute un rendez-vous à l'agenda de l'orthophoniste.
 	 *
 	 * @param rendezVous le rendez-vous à ajouter à l'agenda
 	 */
 	public void ajouterRendezVous(RendezVous rendezVous) {
 	    if (rendezVous != null && orthophoniste.agenda.add(rendezVous)) {
 	        if (rendezVous instanceof Consultation) {
 	            // Ajouter le patient à la liste des nouveaux patients
 	            Patient patient = ((Consultation) rendezVous).getPatient();
 	            if (!orthophoniste.nouveauxPatients.contains(patient)) ajouterNouveauPatient(patient);
 	        }

 	        if (rendezVous instanceof SeanceSuivi) {
 	            // Ajouter le rendez-vous au dossier du participant
 	            DossierPatient dossier = dossierDeNumero(((SeanceSuivi) rendezVous).getNumeroDossier());
 	            if (dossier != null) dossier.ajouterRendezVous(rendezVous);
 	        }

 	        if (rendezVous instanceof Atelier) {
 	            // Ajouter le rendez-vous aux dossiers de tous les participants
 	            for (int numeroDossier : ((Atelier) rendezVous).getNumerosDossiers()) {
 	                DossierPatient dossier = dossierDeNumero(numeroDossier);
 	                if (dossier != null) dossier.ajouterRendezVous(rendezVous);
 	            }
 	        }
 	    }
 	}

 	/**
 	 * Annule un rendez-vous en le supprimant de l'agenda.
 	 *
 	 * @param rendezVous le rendez-vous à annuler
 	 */
 	public void annulerRendezVous(RendezVous rendezVous) {
 	    if (rendezVous != null && orthophoniste.agenda.remove(rendezVous)) {
 	    	// TODO: Consultation
 	    	
 	    	if (rendezVous instanceof SeanceSuivi) {
 	            // Supprimer le rendez-vous du dossier du participant
 	            DossierPatient dossier = dossierDeNumero(((SeanceSuivi) rendezVous).getNumeroDossier());
 	            if (dossier != null) dossier.supprimerRendezVous(rendezVous);
 	        }
 	    	
 	        if (rendezVous instanceof Atelier) {
 	            // Supprimer le rendez-vous des dossiers de tous les participants
 	            for (int numeroDossier : ((Atelier) rendezVous).getNumerosDossiers()) {
 	                DossierPatient dossier = dossierDeNumero(numeroDossier);
 	                if (dossier != null) dossier.supprimerRendezVous(rendezVous);
 	            }
 	        }
 	    }
 	}

 	/**
 	 * Vérifie la disponibilité de l'orthophoniste à une date et une heure données.
 	 *
 	 * @param dateEtHeure la date et l'heure à vérifier
 	 * @return true si l'orthophoniste est disponible à la date et heure données, sinon false
 	 */
 	public boolean estDisponible(LocalDateTime dateEtHeure) {
 	    if (dateEtHeure == null) return false;
 	    for (RendezVous rdv : orthophoniste.agenda) {
 	        // Vérifie si la date et l'heure demandées se situent pendant le rendez-vous
 	        if (rdv.getDateEtHeure().equals(dateEtHeure) || (dateEtHeure.isAfter(rdv.getDateEtHeure()) &&
 	                dateEtHeure.isBefore(rdv.calculerHeureFin()))) return false;
 	    }
 	    return true; // Si aucun rendez-vous ne correspond, l'orthophoniste est disponible
 	}

 	/**
 	 * Vérifie si un dossier existe.
 	 *
 	 * @param numeroDossier le numéro de dossier à vérifier
 	 * @return true si le dossier existe, sinon false
 	 */
 	public boolean existe(int numeroDossier) { return dossierDeNumero(numeroDossier) != null; }

 	/**
 	 * Retourne l'agenda de l'orthophoniste.
 	 *
 	 * @return une liste contenant les rendez-vous de l'orthophoniste
 	 */
 	public List<RendezVous> getAgenda() { return new ArrayList<>(orthophoniste.agenda); }

 	/**
 	 * Retourne les dossiers des patients de l'orthophoniste.
 	 *
 	 * @return un ensemble contenant les dossiers des patients de l'orthophoniste
 	 */
 	public Set<DossierPatient> getDossiersPatients() { return new HashSet<>(orthophoniste.dossiersPatients); }

 	/**
 	 * Retourne la liste des nouveaux patients de l'orthophoniste.
 	 *
 	 * @return une liste contenant les nouveaux patients de l'orthophoniste
 	 */
 	public List<Patient> getNouveauxPatients() { return new ArrayList<>(orthophoniste.nouveauxPatients); }

 	/**
 	 * Retourne la liste des patients de l'orthophoniste.
 	 *
 	 * @return une carte contenant les patients de l'orthophoniste, indexés par leur numéro de dossier
 	 */
 	public Map<Integer, Patient> getPatients() { return orthophoniste.patients; }

 	/**
 	 * Retourne la liste des tests de l'orthophoniste.
 	 *
 	 * @return une liste contenant les tests de l'orthophoniste
 	 */
 	public List<Test> getTests() { return orthophoniste.tests; }

 	/**
 	 * Retourne la liste des anamnèses de l'orthophoniste.
 	 *
 	 * @return une liste contenant les anamnèses de l'orthophoniste
 	 */
 	public List<Anamnese> getAnamneses() { return orthophoniste.anamneses; }

 	/**
 	 * Ajoute une observation pour un rendez-vous.
 	 *
 	 * @param rendezVous le rendez-vous auquel ajouter l'observation
 	 * @param observation l'observation à ajouter
 	 */
 	public void ajouterObservation(RendezVous rendezVous, String observation) {
 	    if (rendezVous != null) rendezVous.setObservation(observation);
 	}

 	/**
 	 * Sauvegarde l'orthophoniste.
 	 *
 	 * @return true si la sauvegarde a réussi, sinon false
 	 */
 	public boolean sauvegarderOrthophoniste() { return orthophonisteDAO.sauvegarder(orthophoniste); }

 	/**
 	 * Charge et retourne l'orthophoniste sauvegardé.
 	 *
 	 * @return l'orthophoniste sauvegardé, ou null s'il n'existe pas
 	 */
 	public Orthophoniste chargerOrthophoniste() { return orthophonisteDAO.charger(); }

 	/**
 	 * Supprime l'orthophoniste.
 	 *
 	 * @return true si la suppression a réussi, sinon false
 	 */
 	public boolean supprimerOrthophoniste() { return orthophonisteDAO.supprimer(); }

 	/**
 	 * Modifie le mot de passe de l'orthophoniste.
 	 *
 	 * @param ancienMdp l'ancien mot de passe
 	 * @param nouveauMdp le nouveau mot de passe
 	 * @return 0 si la modification a réussi, 1 si le nouveau mot de passe est trop court, 2 si l'ancien mot de passe est incorrect
 	 */
 	public int modifierMotDePasse(String ancienMdp, String nouveauMdp) {
 	    if (CryptageMotDePasse.verifierMotDePasse(ancienMdp, orthophoniste.getMotDePasseCrypte()) &&
 	            nouveauMdp.length() >= 8) {
 	        orthophoniste.setMotDePasseCrypte(nouveauMdp);
 	        sauvegarderOrthophoniste();
 	        return 0;
 	    } else if (nouveauMdp.length() >= 8) {
 	        return 2;
 	    } else {
 	        return 1;
 	    }
 	}

 	/**
 	 * Ajoute une anamnèse à la liste d'anamnèses de l'orthophoniste.
 	 *
 	 * @param anamnese l'anamnèse à ajouter
 	 */
 	public void ajouterAnamnese(Anamnese anamnese) { orthophoniste.anamneses.add(anamnese); }

 	/**
 	 * Ajoute un test à la liste des tests de l'orthophoniste.
 	 *
 	 * @param test le test à ajouter
 	 */
 	public void ajouterTest(Test test) { orthophoniste.tests.add(test); }
}
