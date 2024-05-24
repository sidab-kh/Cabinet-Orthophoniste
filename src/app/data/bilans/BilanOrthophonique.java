package app.data.bilans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class BilanOrthophonique implements Serializable {
	Anamnese anamnese;
	List<EpreuveClinique> epreuvesCliniques;
	Diagnostic diagnostic;
	String projetTherapeutique;
	
	// Pas besoin d'un constructeur exhaustif puisqu'un BO se remplit au fur et a mesure
	
	//Cas BO qui n'est pas le premier
	public BilanOrthophonique() {
		this(null);
	}
	
	//Cas du premier BO
	public BilanOrthophonique(Anamnese anamnese) {
		this.anamnese = anamnese;
		this.epreuvesCliniques = new ArrayList<EpreuveClinique>();
		this.diagnostic = null;
		this.projetTherapeutique = null;
	}

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
	
	public List<EpreuveClinique> getEpreuvesCliniques() {
		return epreuvesCliniques;
	}
}

