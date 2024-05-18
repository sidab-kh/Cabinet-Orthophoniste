package exceptionsPersonnalisees;

@SuppressWarnings("serial")
public class OrthophonisteNonDisponibleException extends Exception {
	public OrthophonisteNonDisponibleException() {
        super("L'orthophoniste n'est pas disponible à cette date.");
    }
}