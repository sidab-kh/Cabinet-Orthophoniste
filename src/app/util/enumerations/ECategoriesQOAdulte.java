package app.util.enumerations;

public enum ECategoriesQOAdulte implements ECategoriesQOs {
    HISTOIRE_MALADIE("Histoire de la maladie"),
    SUIVI_MEDICAL("Suivi médical");

    private final String toString;

    ECategoriesQOAdulte(String toString) { this.toString = toString; }

    public String getString() { return this.toString; }
    
    public static String[] getAllStrings() {
    	ECategoriesQOAdulte[] values = ECategoriesQOAdulte.values();
        String[] strings = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            strings[i] = values[i].getString();
        }
        return strings;
    }
    
    public static ECategoriesQOAdulte getCategorieFromString(String categorieStr) {
        for (ECategoriesQOAdulte categoriesQOAdulte : ECategoriesQOAdulte.values()) {
			if (categoriesQOAdulte.toString().equals(categorieStr))
				return categoriesQOAdulte;
		}
        return null;
    }
}