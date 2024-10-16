package app.util.enumerations;

/**
 * Cette énumération représente les différentes catégories de questions ouvertes pour les enfants.
 */
public enum ECategoriesQOEnfant implements ECategoriesQOs {
    STRUCTURE_FAMILIALE("Structure familiale"), // Catégorie de structure familiale.
    DYNAMIQUE_FAMILIALE("Dynamique familiale"), // Catégorie de dynamique familiale.
    ANTECEDENTS_FAMILIAUX("Antécédents familiaux"), // Catégorie d'antécédents familiaux.
    CONDITIONS_NATALES("Conditions natales"), // Catégorie de conditions natales.
    DEVELOPPEMENT_PSYCHOMOTEUR("Développement psychomoteur"), // Catégorie de développement psychomoteur.
    DEVELOPPEMENT_LANGAGIER("Développement langagier"), // Catégorie de développement langagier.
    COMPORTEMENT("Comportement"); // Catégorie de comportement.

    /** La représentation textuelle de la catégorie. */
    private final String nom;

    /**
     * Constructeur de l'énumération ECategoriesQOEnfant.
     * 
     * @param toString La représentation textuelle de la catégorie.
     */
    ECategoriesQOEnfant(String toString) { this.nom = toString; }

    /**
     * Retourne la représentation textuelle de la catégorie.
     * 
     * @return La représentation textuelle de la catégorie.
     */
    public String getString() { return this.nom; }
    
    /**
     * Retourne un tableau de chaînes de caractères contenant toutes les représentations textuelles des catégories.
     * 
     * @return Un tableau de chaînes de caractères contenant toutes les représentations textuelles des catégories.
     */
    public static String[] getAllStrings() {
        ECategoriesQOEnfant[] values = ECategoriesQOEnfant.values();
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
    public static ECategoriesQOEnfant getCategorieFromString(String categorieStr) {
        for (ECategoriesQOEnfant categorie : ECategoriesQOEnfant.values()) {
            if (categorie.getString().equals(categorieStr))
                return categorie;
        }
        return null;
    }
}