package app.util.enumerations;

/**
 * Cette énumération représente les différents types de rendez-vous.
 */
public enum ETypesRendezVous {
    CONSULTATION("Consultation"), // Rendez-vous de type consultation.
    SEANCE_SUIVI("Séance de suivi"), // Rendez-vous de type séance de suivi.
    ATELIER("Atelier"); // Rendez-vous de type atelier.
    
    String nom;
	
	ETypesRendezVous(String nom) { this.nom = nom; }
	
	public String getNom() { return this.nom; }
}
