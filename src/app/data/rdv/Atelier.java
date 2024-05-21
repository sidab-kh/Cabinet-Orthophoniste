package app.data.rdv;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("serial")
public class Atelier extends RendezVous {
	String thematique;
	List<Integer> numerosDossiers;
	
	// Constructeur
	public Atelier(LocalDateTime dateEtHeure, Duration duree, String thematique, List<Integer> numerosDossiers) {
		super(dateEtHeure, duree);
		this.thematique = thematique;
		this.numerosDossiers = numerosDossiers;
	}
	
	// Autres methodes
	public void afficher() {
		System.out.print("- Atelier/ ");
		super.afficher();
		System.out.print("Thematique: " + thematique + ", numeros dossiers : ");
		for (int numeroDossier : numerosDossiers) { System.out.print(numeroDossier + " "); }
		System.out.println();
	}
}