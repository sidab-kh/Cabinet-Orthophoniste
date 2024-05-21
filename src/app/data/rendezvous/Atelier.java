package app.data.rendezvous;
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
	
	// Getters et setters
	public String getThematique() { return thematique; }

	public void setThematique(String thematique) { this.thematique = thematique; }

	public List<Integer> getNumerosDossiers() { return numerosDossiers; }

	public void setNumerosDossiers(List<Integer> numerosDossiers) { this.numerosDossiers = numerosDossiers; }

	// Autres methodes
	public void afficher() {
		System.out.print("- Atelier/ ");
		super.afficher();
		System.out.print("Thematique: " + thematique + ", numeros dossiers : ");
		for (int numeroDossier : numerosDossiers) { System.out.print(numeroDossier + " "); }
		System.out.println();
	}
}