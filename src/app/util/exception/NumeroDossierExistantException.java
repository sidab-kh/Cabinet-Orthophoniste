package app.util.exception;

@SuppressWarnings("serial")
public class NumeroDossierExistantException extends Exception {
	public NumeroDossierExistantException() {
        super("Un dossier avec ce numéro existe déjà.");
    }
}