package app.util.enumerations;

public enum EScenes {
	CHARGEMENT("Veuillez patienter...", "Chargement.fxml"),
	INSCRIPTION("Inscription", "Inscription.fxml"),
	CONNEXION("Connexion", "Connexion.fxml"),
	AGENDA("Agenda", "Agenda.fxml"),
	PROFIL("Profil", "Profil.fxml"),
	PATIENTS("Patients", "Patients.fxml"),
	TESTS("Tests", "Tests.fxml"),
	ANAMNESES("Anamnèses", "Anamneses.fxml"),
	LIRE_ANAMNESE("Nouvelle anamnèse", "LireAnamnese.fxml"),
	LIRE_QO_ADULTE("Nouvelle question ouverte pour adulte", "LireQOAdulte.fxml"),
	LIRE_QO_ENFANT("Nouvelle question ouverte pour enfant", "LireQOEnfant.fxml"),
	AIDE("Aide", "Aide.fxml"),
	LIRE_CONSULTATION("Nouvelle consultation", "LireConsultation.fxml"),
	LIRE_SEANCE_SUIVI("Nouvelle séance de suivi", "LireSeanceSuivi.fxml"),
	LIRE_ATELIER("Nouvel atelier", "LireAtelier.fxml"),
	AFFICHER_DOSSIER_ADULTE("Affichage dossier", "AfficherDossierAdulte.fxml"),
	AFFICHER_DOSSIER_ENFANT("Affichage dossier", "AfficherDossierEnfant.fxml");
	
	String nom;
	String nomFichier;
	
	EScenes(String nom, String nomFichier) {
		this.nom = nom;
		this.nomFichier = nomFichier;
	}
	
	public String getNom() { return nom; }
	public String getNomFichier() { return nomFichier; }
}
