package enumerations;

import java.time.Duration;

public enum ETypesRendezVous {
	CONSULTATION_ADULTE("Consultation adulte", Duration.ofHours(1).plusMinutes(30)),
	CONSULTATION_ENFANT("Consultation enfant", Duration.ofHours(2).plusMinutes(30)),
	SEANCE_SUIVI("Seance de Suivi", Duration.ofHours(1)),
	ATELIER("Atelier", Duration.ofHours(1));
	
	String nom;
	Duration duree;
	
	// Constructeur
	private ETypesRendezVous(String nom, Duration duree) {
		this.nom = nom;
		this.duree = duree;
	}
}