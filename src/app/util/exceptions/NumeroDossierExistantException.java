package app.util.exceptions;

/**
 * Cette exception est levée lorsqu'un numéro de dossier existe déjà.
 */
@SuppressWarnings("serial")
public class NumeroDossierExistantException extends Exception {
    
    /**
     * Constructeur par défaut de l'exception.
     * Il crée une instance de l'exception avec le message par défaut.
     */
    public NumeroDossierExistantException() {
        super("Un dossier avec ce numéro existe déjà.");
    }
}