package app.util.enumerations;

/**
 * Cette énumération représente les différentes catégories de troubles.
 */
public enum ECategoriesTroubles {
    DE_DEGLUTITION("De déglutition"), // Catégorie de troubles de la déglutition.
    NEURODEVELOPPEMENTAL("Neurodéveloppemental"), // Catégorie de troubles neurodéveloppementaux.
    COGNITIF("Cognitif"); // Catégorie de troubles cognitifs.
    
    /** La représentation textuelle de la catégorie. */
    private final String toString;

    /**
     * Constructeur de l'énumération ECategoriesTroubles.
     * 
     * @param toString La représentation textuelle de la catégorie.
     */
    ECategoriesTroubles(String toString) { 
        this.toString = toString; 
    }

    /**
     * Retourne la représentation textuelle de la catégorie.
     * 
     * @return La représentation textuelle de la catégorie.
     */
    public String getString() { 
        return this.toString; 
    }

    /**
     * Retourne un tableau de chaînes de caractères contenant toutes les représentations textuelles des catégories.
     * 
     * @return Un tableau de chaînes de caractères contenant toutes les représentations textuelles des catégories.
     */
    public static String[] getAllStrings() {
        ECategoriesTroubles[] values = ECategoriesTroubles.values();
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
    public static ECategoriesTroubles getCategorieFromString(String categorieStr) {
        for (ECategoriesTroubles categoriesTroubles : ECategoriesTroubles.values()) {
            if (categoriesTroubles.getString().equals(categorieStr))
                return categoriesTroubles;
        }
        return null;
    }
}