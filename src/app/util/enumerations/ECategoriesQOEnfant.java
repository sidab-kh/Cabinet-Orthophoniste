package app.util.enumerations;

public enum ECategoriesQOEnfant implements ECategoriesQOs {
    STRUCTURE_FAMILIALE("Structure familiale"),
    DYNAMIQUE_FAMILIALE("Dynamique familiale"),
    ANTECEDENTS_FAMILIAUX("Antécédents familiaux"),
    CONDITIONS_NATALES("Conditions natales"),
    DEVELOPPEMENT_PSYCHOMOTEUR("Développement psychomoteur"),
    DEVELOPPEMENT_LANGAGIER("Développement langagier"),
    COMPORTEMENT("Comportement");

    private final String toString;

    ECategoriesQOEnfant(String toString) { this.toString = toString; }

    public String getString() { return this.toString; }
    
    public static String[] getAllStrings() {
        ECategoriesQOEnfant[] values = ECategoriesQOEnfant.values();
        String[] strings = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            strings[i] = values[i].getString();
        }
        return strings;
    }
    
    public static ECategoriesQOEnfant getCategorieFromString(String categorieStr) {
        for (ECategoriesQOEnfant categoriesQOEnfant : ECategoriesQOEnfant.values()) {
			if (categoriesQOEnfant.toString().equals(categorieStr))
				return categoriesQOEnfant;
		}
        return null;
    }
}

