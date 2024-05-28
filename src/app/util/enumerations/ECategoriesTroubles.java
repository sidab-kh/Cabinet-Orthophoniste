package app.util.enumerations;

public enum ECategoriesTroubles {
    DE_DEGLUTITION("De déglutiton"),
    NEURODEVELOPPEMENTAL("Neurodéveloppemental"),
    COGNITIF("Cognitif");
    
    private final String toString;

	ECategoriesTroubles(String toString) { this.toString = toString; }

    public String getString() { return this.toString; }

    public static String[] getAllStrings() {
    	ECategoriesTroubles[] values = ECategoriesTroubles.values();
        String[] strings = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            strings[i] = values[i].getString();
        }
        return strings;
    }

    public static ECategoriesTroubles getCategorieFromString(String categorieStr) {
        for (ECategoriesTroubles categoriesTroubles : ECategoriesTroubles.values()) {
            if (categoriesTroubles.getString().equals(categorieStr))
                return categoriesTroubles;
        }
        return null;
    }
}
