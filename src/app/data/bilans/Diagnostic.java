package app.data.bilans;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Diagnostic implements Serializable {
	Trouble[] troubles; /* Pas besoin d'une collection, on assigne directement un tableau,
	s'il y a de nouveaux troubles, on les detectera durant le pochain bilan orthopedique */
	
	public Diagnostic(Trouble[] troubles) {
		this.troubles = troubles;
	}
}