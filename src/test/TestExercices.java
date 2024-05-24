package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enumerations.ECapacites;

public class TestExercices extends Test {
//	List<Exercice> exercices = new ArrayList<Exercice>();
	// Compte rendu qui contient les moyennes des exerices Map<exercice.hashcode, moyenneExercice>
	Map<Integer, Float> compteRendu = new HashMap<>();
	// Integer : hashcode d'un exercice (hashcode de la consigne), List : la liste qui contient le meme exerice un List.sizeOf() nombre de fois (car les exercices sont répétitifs)
//	Map<Integer, List<Exercice>> exercices = new HashMap<>();
	List<Exercice> exercices;
	
	// Constructeur
	public TestExercices(String nom, String capacite, ArrayList<Exercice> exercices) {
		super(nom, capacite);
//		List<Exercice> exoI;
//		for(Exercice exercice : exercices) {
//			if ((exoI = this.exercices.get(exercice.hashCode())) != null) {
//				exoI.add(exercice);
//			} else {
//				exoI = new ArrayList<Exercice>();
//				exoI.add(exercice);
//				this.exercices.put(exercice.hashCode(), exoI);
//			}
//		}
		this.exercices = exercices;
		// Initialiser le compte rendu pour avoir tous les hashcodes des exercices
		for (Exercice exercice : exercices) {
			if (compteRendu.get(exercice.hashCode()) == null)
				compteRendu.put(exercice.hashCode(), 0f);
		}
	}

	public List<Exercice> getExercices() {
		return exercices;
	}
	
	@Override // Redefinition de calculerScoreTotal()
	public float calculerScoreTotal() {
		float scoreTotal = 0;
		for (Map.Entry<Integer, Float> entry : compteRendu.entrySet()) {
			scoreTotal += entry.getValue();
		}
		return scoreTotal;
	}

	public void setCompteRendu(Map<Integer, Float> compteRendu) {
		this.compteRendu = compteRendu;
	}

	public Map<Integer, Float> getCompteRendu() {
		return compteRendu;
	}
}
