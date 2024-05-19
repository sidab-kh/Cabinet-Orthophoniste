package app.util.fabrique;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import app.data.patient.Patient;
import app.data.rdv.Atelier;
import app.data.rdv.Consultation;
import app.data.rdv.SeanceSuivi;

// Patron de conception "Factory Method", sert a encapsuler les instanciations
public class FabriqueRendezVous {

	// Creer un rendez-vous de type Consultation
	public static Consultation creerConsultation(LocalDateTime dateEtHeure, Patient patient) {
		if (patient.getAge() < 18) return new Consultation(dateEtHeure, Duration.ofHours(2).plusMinutes(30), patient);
		else return new Consultation(dateEtHeure, Duration.ofHours(1).plusMinutes(30), patient);
	}
	
	// Creer un rendez-vous de type Seance de Suivi
	public static SeanceSuivi creerSeanceSuivi(LocalDateTime dateEtHeure, int numeroDossier, boolean presentiel) {
		return new SeanceSuivi(dateEtHeure, Duration.ofHours(1), numeroDossier, presentiel);
	}
	
	// Creer un rendez-vous de type Atelier
	public static Atelier creerAtelier(LocalDateTime dateEtHeure, String thematique, List<Integer> numerosDossiers) {
		return new Atelier(dateEtHeure, Duration.ofHours(1), thematique, numerosDossiers);
	}
}