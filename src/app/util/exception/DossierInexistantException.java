package app.util.exception;

@SuppressWarnings("serial")
public class DossierInexistantException extends Exception {
	public DossierInexistantException() {
        super("Aucun dossier portant ce numero.");
    }
}
