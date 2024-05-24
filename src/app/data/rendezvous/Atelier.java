package app.data.rendezvous;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import app.util.enumerations.ETypesRendezVous;

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
	public String afficher() {
		String numeros = "";
		for (int numeroDossier : numerosDossiers) { numeros += numeroDossier + " "; }
		return "- Atelier / " + super.rdvString() + "Thématique: " + thematique + ", numeros dossiers : " + numeros;
	}
	
	public ETypesRendezVous getType() { return ETypesRendezVous.ATELIER; }
}