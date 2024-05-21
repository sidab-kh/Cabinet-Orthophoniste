package app.data.bilans;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class BilanOrthophonique implements Serializable {
	Anamnese anamnese;
	List<EpreuveClinique> epreuvesCliniques;
    Diagnostic diagnostic;
	String projetTherapeutique;
	
	// Pas besoin d'un constructeur exhaustif puisqu'un BO se remplit au fur et a mesure
	
	public void ajouterAnamnese(Anamnese anamnese) {
		this.anamnese = anamnese;
	}
	
	public void ajouterEpreuveClinique(EpreuveClinique epreuveClinique) {
		this.epreuvesCliniques.add(epreuveClinique);
	}
	
	public void ajouterDiagnostic(Diagnostic diagnostic) {
		this.diagnostic = diagnostic;
	}
	
	public void ajouterProjetTherapeutique(String projetTherapeutique) {
		this.projetTherapeutique = projetTherapeutique;
	}
}

