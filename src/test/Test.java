package test;

import enumerations.ECapacites;

// Les epreuves cliniques sont composees de tests
public abstract class Test {
	private String nom;
	private ECapacites capacite;
	private float scoreTotal;
	
	public abstract float calculerScore();
}