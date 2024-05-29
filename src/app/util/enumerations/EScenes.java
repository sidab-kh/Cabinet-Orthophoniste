package app.util.enumerations;

/**
 * Cette énumération représente les différentes scènes de l'application et associe chaque scène à son nom et au nom de son fichier FXML correspondant.
 */
public enum EScenes {
    // Connexion/Inscription
    CHARGEMENT("Veuillez patienter...", "Chargement.fxml"),
    INSCRIPTION("Inscription", "Inscription.fxml"),
    CONNEXION("Connexion", "Connexion.fxml"),
    
    // Menu principal
    PROFIL("Profil", "Profil.fxml"),
    AGENDA("Agenda", "Agenda.fxml"),
    PATIENTS("Patients", "Patients.fxml"),
    TESTS("Tests", "Tests.fxml"),
    ANAMNESES("Anamnèses", "Anamneses.fxml"),
    AIDE("Aide", "Aide.fxml"),
    
    // Lecture des données
    LIRE_ANAMNESE("Nouvelle anamnèse", "LireAnamnese.fxml"),
    LIRE_QO_ADULTE("Nouvelle question ouverte pour adulte", "LireQOAdulte.fxml"),
    LIRE_QO_ENFANT("Nouvelle question ouverte pour enfant", "LireQOEnfant.fxml"),
    LIRE_CONSULTATION("Nouvelle consultation", "LireConsultation.fxml"),
    LIRE_SEANCE_SUIVI("Nouvelle séance de suivi", "LireSeanceSuivi.fxml"),
    LIRE_ATELIER("Nouvel atelier", "LireAtelier.fxml"),
    
    // Affichage des dossiers
    AFFICHER_DOSSIER_ADULTE("Affichage dossier", "AfficherDossierAdulte.fxml"),
    AFFICHER_DOSSIER_ENFANT("Affichage dossier", "AfficherDossierEnfant.fxml"),
    
    // TalkTrack
    TALKTRACK("TalkTrack", "TalkTrack.fxml"),
    DEROULER_CONSULTATION("Déroulement d'une consultation", "DeroulerConsultation.fxml"),
    DEROULER_SEANCE_SUIVI("Déroulement d'une séance de suivi", "DeroulerSeanceSuivi.fxml"),
    DEROULER_ATELIER("Déroulement d'une séance atelier", "DeroulerAtelier.fxml"),
    DEROULER_ANAMNESE("Déroulement de l'anamnèse", "DeroulerAnamnese.fxml"),
    CREER_EPREUVES_CLINIQUES("Création des épreuves cliniques", "CreerEpreuvesCliniques.fxml"),
    DEROULER_EPREUVES_CLINIQUES("Déroulement des épreuves cliniques", "DeroulerEpreuvesCliniques.fxml"),
    DEROULER_TEST_QUESTIONNAIRE("Déroulement d'un test questionnaire", "DeroulerTestQuestionnaire.fxml"),
    DEROULER_TEST_EXERCICES("Déroulement d'un test exercices", "DeroulerTestExercices.fxml"),
    FIN_EPREUVES_CLINIQUES("Fin des épreuves cliniques", "FinEpreuvesCliniques.fxml"),
    ETABLIR_DIAGNOSTIC("Diagnostic", "EtablirDiagnostic.fxml"),
    LIRE_PROJET_THERAPEUTIQUE("Projet thérapeutique", "LireProjetTherapeutique.fxml"),
    FIN_RENDEZ_VOUS("Fin du rendez-vous", "FinRendezVous.fxml");

    /** Le nom de la scène. */
    private final String nom;
    
    /** Le nom du fichier FXML correspondant à la scène. */
    private final String nomFichier;

    /**
     * Constructeur de l'énumération EScenes.
     * 
     * @param nom Le nom de la scène.
     * @param nomFichier Le nom du fichier FXML correspondant à la scène.
     */
    EScenes(String nom, String nomFichier) {
        this.nom = nom;
        this.nomFichier = nomFichier;
    }

    /**
     * Retourne le nom de la scène.
     * 
     * @return Le nom de la scène.
     */
    public String getNom() { 
        return nom; 
    }

    /**
     * Retourne le nom du fichier FXML correspondant à la scène.
     * 
     * @return Le nom du fichier FXML.
     */
    public String getNomFichier() { 
        return nomFichier; 
    }
}