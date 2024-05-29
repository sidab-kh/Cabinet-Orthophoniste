package app.util.enumerations;

/**
 * Cette énumération représente les différents types de rendez-vous.
 */
public enum ETypesRendezVous {
    CONSULTATION("Consultation"), // Rendez-vous de type consultation.
    SEANCE_SUIVI("Séance de suivi"), // Rendez-vous de type séance de suivi.
    ATELIER("Atelier"); // Rendez-vous de type atelier.
    
    /** Le nom du type de rendez-vous. */
    private String nom;
	
    /**
     * Constructeur de l'énumération ETypesRendezVous.
     * 
     * @param nom Le nom du type de rendez-vous.
     */
    ETypesRendezVous(String nom) {
        this.nom = nom;
    }
	
    /**
     * Retourne le nom du type de rendez-vous.
     * 
     * @return Le nom du type de rendez-vous.
     */
    public String getNom() { 
        return this.nom; 
    }
}