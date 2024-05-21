package app.util.exception;

@SuppressWarnings("serial")
public class OrthophonisteNonDisponibleException extends Exception {
	public OrthophonisteNonDisponibleException() {
        super("Orthophoniste non disponible a la date et heure indiquees.");
    }
}
