package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enumerations.ECapacites;

public class TestExercices extends Test {
	List<Exercice> exercices = new ArrayList<Exercice>();
	Map<Exercice, Integer> compteRendu = new HashMap<Exercice, Integer>();
	
	// Constructeur
	public TestExercices(String nom, ECapacites capacite, ArrayList<Exercice> exercices) {
		super(nom, capacite);
		this.exercices = exercices;
	}

	@Override // Redefinition de calculerScoreTotal()
	public float calculerScoreTotal() {
		return -1; // Calculer et additionner les moyennes de scores de chaque exercice
	}
}
