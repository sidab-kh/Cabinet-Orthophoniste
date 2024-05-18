package exceptionsPersonnalisees;

@SuppressWarnings("serial")
public class NumeroDossierExistantException extends Exception {
	public NumeroDossierExistantException() {
        super("Un dossier avec ce numéro existe déjà.");
    }
}