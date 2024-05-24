package app.util.enumerations;

public enum EScenes {
	CHARGEMENT("Veuillez patienter...", "Chargement.fxml"),
	INSCRIPTION("Inscription", "Inscription.fxml"),
	CONNEXION("Connexion", "Connexion.fxml"),
	AGENDA("Agenda", "Agenda.fxml"),
	LIRE_CONSULTATION("Nouvelle consultation", "LireConsultation.fxml"),
	LIRE_SEANCE_SUIVI("Nouvelle séance de suivi", "LireSeanceSuivi.fxml"),
	LIRE_ATELIER("Nouvel atelier", "LireAtelier.fxml");
	
	String nom;
	String nomFichier;
	
	EScenes(String nom, String nomFichier) {
		this.nom = nom;
		this.nomFichier = nomFichier;
	}
	
	public String getNom() { return nom; }
	public String getNomFichier() { return nomFichier; }
}
