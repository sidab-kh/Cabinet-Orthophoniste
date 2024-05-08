import java.util.List;

public class Atelier extends RendezVous {
	String thematique;
	List<Integer> numerosDossiers;
	
	public Atelier(String thematique, List<Integer> numerosDossiers) {
		this.thematique = thematique;
		this.numerosDossiers = numerosDossiers;
	}
}
