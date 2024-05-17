package rendezVous;
import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("serial")
public class Atelier extends RendezVous {
	String thematique;
	List<Integer> numerosDossiers;
	
	public Atelier(LocalDateTime dateEtHeure, String thematique, List<Integer> numerosDossiers) {
		super.dateEtHeure = dateEtHeure;
		this.thematique = thematique;
		this.numerosDossiers = numerosDossiers;
	}
}
