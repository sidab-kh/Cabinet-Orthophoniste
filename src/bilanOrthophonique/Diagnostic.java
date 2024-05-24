package bilanOrthophonique;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Diagnostic implements Serializable {
	List<Trouble> troubles; /* Pas besoin d'une collection, on assigne directement un tableau,
	s'il y a de nouveaux troubles, on les detectera durant le pochain bilan orthopedique */
	// List et puis a chaque fois on reprend le meme diagnostic qu'on va enrechir
	
	public Diagnostic(List<Trouble> troubles) {
		this.troubles = troubles;
	}
}