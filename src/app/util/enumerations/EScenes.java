package app.util.enumerations;

/**
 * Cette énumération représente les différentes scènes de l'application et associe chaque scène à son nom et au nom de son fichier FXML correspondant.
 */
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

    private final String nom;
    private final String nomFichier;

    /**
     * Constructeur de l'énumération EScenes.
     * @param nom Le nom de la scène.
     * @param nomFichier Le nom du fichier FXML correspondant à la scène.
     */
    EScenes(String nom, String nomFichier) {
        this.nom = nom;
        this.nomFichier = nomFichier;
    }

    /**
     * Retourne le nom de la scène.
     * @return Le nom de la scène.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le nom du fichier FXML correspondant à la scène.
     * @return Le nom du fichier FXML.
     */
    public String getNomFichier() {
        return nomFichier;
    }
}