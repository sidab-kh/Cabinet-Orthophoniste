package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestExercices extends Test {
	List<Exercice> exercices = new ArrayList<Exercice>();
	Map<Exercice, Integer> compteRendu = new HashMap<Exercice, Integer>();
	
	@Override // Redefinition de calculerScore()
	public float calculerScore() {
		return -1;
	}
}
