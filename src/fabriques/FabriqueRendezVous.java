package fabriques;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import patient.Patient;
import rendezVous.Atelier;
import rendezVous.Consultation;
import rendezVous.SeanceSuivi;

// Patron de conception "Factory Method"
public class FabriqueRendezVous {

	// Creer un rendez-vous de type Consultation
	public static Consultation creerConsultation(String type, LocalDateTime dateEtHeure, Patient patient) {
		switch (type.toLowerCase()) {
		case "enfant":
			return new Consultation(dateEtHeure, Duration.ofHours(2).plusMinutes(30), patient);
		case "adulte":
			return new Consultation(dateEtHeure, Duration.ofHours(1).plusMinutes(30), patient);
		default:
			throw new IllegalArgumentException("Type de consultation invalide : " + type);
	    }
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