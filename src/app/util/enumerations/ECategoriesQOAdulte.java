package app.util.enumerations;

public enum ECategoriesQOAdulte implements ECategoriesQOs {
    HISTOIRE_MALADIE("Histoire de la maladie"),
    SUIVI_MEDICAL("Suivi médical");

    private final String toString;

    ECategoriesQOAdulte(String toString) { this.toString = toString; }

    public String getString() { return this.toString; }
    
    public static String[] getAllStrings() {
        ECategoriesQOEnfant[] values = ECategoriesQOEnfant.values();
        String[] strings = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            strings[i] = values[i].getString();
        }
        return strings;
    }
}