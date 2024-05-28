package app.util.enumerations;

/**
 * Cette énumération représente les différents types de matériel utilisés dans les exercices.
 */
public enum EMateriel {
    AUCUN("Aucun"),
    IMAGES("Images"),
    JEUX("Jeux"),
    LIVRE("Livre"),
    MATERIEL_ECRITURE("Materiel écriture"),
    MATERIEL_AUDITIF("Materiel auditif"),
    MATERIEL_SENSORIEL("Materiel sensoriel"),
    JEU_DE_CARTES("Jeu de cartes"),
    TABLEAU("Tableau"),
    FEUILLES("Feuilles"),
    TABLETTE_ET_APPLICATION("Tablette et application"),
    ACCESSOIRES_DIVERS("Accessoires divers");

    String nom;
	
	EMateriel(String nom) { this.nom = nom; }
	
	public String getString() { return nom; }
}
