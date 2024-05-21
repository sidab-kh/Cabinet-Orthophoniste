package app.util.exceptions;

@SuppressWarnings("serial")
public class NumeroDossierExistantException extends Exception {
	public NumeroDossierExistantException() {
        super("Un dossier avec ce numero existe deja.");
    }
}