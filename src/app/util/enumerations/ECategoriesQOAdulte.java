package app.util.enumerations;

/**
 * Cette énumération représente les différentes catégories de questions ouvertes pour les adultes.
 */
public enum ECategoriesQOAdulte implements ECategoriesQOs {
    HISTOIRE_MALADIE("Histoire de la maladie"),
    SUIVI_MEDICAL("Suivi médical");

	/** La représentation textuelle de la catégorie. */
    private final String nom;

    /**
     * Constructeur de l'énumération ECategoriesQOAdulte.
     * 
     * @param toString La représentation textuelle de la catégorie.
     */
    ECategoriesQOAdulte(String toString) { 
        this.nom = toString; 
    }

    /**
     * Retourne la représentation textuelle de la catégorie.
     * 
     * @return La représentation textuelle de la catégorie.
     */
    public String getString() { 
        return this.nom; 
    }
    
    /**
     * Retourne un tableau de chaînes de caractères contenant toutes les représentations textuelles des catégories.
     * 
     * @return Un tableau de chaînes de caractères contenant toutes les représentations textuelles des catégories.
     */
    public static String[] getAllStrings() {
        ECategoriesQOAdulte[] values = ECategoriesQOAdulte.values();
        String[] strings = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            strings[i] = values[i].getString();
        }
        return strings;
    }
    
    /**
     * Retourne la catégorie correspondant à la représentation textuelle spécifiée.
     * 
     * @param categorieStr La représentation textuelle de la catégorie.
     * @return La catégorie correspondant à la représentation textuelle spécifiée, ou null si aucune correspondance n'est trouvée.
     */
    public static ECategoriesQOAdulte getCategorieFromString(String categorieStr) {
        for (ECategoriesQOAdulte categorie : ECategoriesQOAdulte.values()) {
            if (categorie.getString().equals(categorieStr)) {
                return categorie;
            }
        }
        return null;
    }
}