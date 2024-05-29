package app.util.exceptions;

/**
 * Cette exception est levée lorsqu'un dossier est introuvable.
 */
@SuppressWarnings("serial")
public class DossierInexistantException extends Exception {
    
    /**
     * Constructeur par défaut de l'exception.
     * Il crée une instance de l'exception avec le message par défaut.
     */
    public DossierInexistantException() {
        super("Aucun dossier portant ce numéro.");
    }
}