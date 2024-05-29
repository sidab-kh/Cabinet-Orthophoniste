package app.util;

/**
 * Interface décrivant les objets qui peuvent être affichés sous forme de chaîne de caractères.
 */
public interface Affichable {
    
    /**
     * Retourne une chaîne contenant les informations essentielles à afficher.
     * 
     * @return La chaîne contenant les informations essentielles à afficher.
     */
    public String getChaine();
}