package app.util.exceptions;

@SuppressWarnings("serial")
public class DossierInexistantException extends Exception {
	public DossierInexistantException() {
        super("Aucun dossier portant ce numero.");
    }
}
