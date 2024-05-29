package app.util.enumerations;

/**
 * Cette énumération représente les différents types de matériel utilisés dans les exercices.
 */
public enum EMateriel {
    AUCUN("Aucun"),
    IMAGES("Images"),
    JEUX("Jeux"),
    LIVRE("Livre"),
    MATERIEL_ECRITURE("Matériel écriture"),
    MATERIEL_AUDITIF("Matériel auditif"),
    MATERIEL_SENSORIEL("Matériel sensoriel"),
    JEU_DE_CARTES("Jeu de cartes"),
    TABLEAU("Tableau"),
    FEUILLES("Feuilles"),
    TABLETTE_ET_APPLICATION("Tablette et application"),
    ACCESSOIRES_DIVERS("Accessoires divers");

    private final String nom;

    /**
     * Constructeur de l'énumération EMateriel.
     * 
     * @param nom La représentation textuelle du matériel.
     */
    EMateriel(String nom) { 
        this.nom = nom; 
    }

    /**
     * Retourne la représentation textuelle du matériel.
     * 
     * @return La représentation textuelle du matériel.
     */
    public String getString() { 
        return this.nom; 
    }
}