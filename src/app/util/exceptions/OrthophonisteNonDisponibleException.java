package app.util.exceptions;

/**
 * Cette exception est levée lorsqu'un orthophoniste n'est pas disponible à la date et à l'heure indiquées.
 */
@SuppressWarnings("serial")
public class OrthophonisteNonDisponibleException extends Exception {
    
    /**
     * Constructeur par défaut de l'exception.
     * Il crée une instance de l'exception avec le message par défaut.
     */
    public OrthophonisteNonDisponibleException() {
        super("Orthophoniste non disponible à la date et heure indiquées.");
    }
}
