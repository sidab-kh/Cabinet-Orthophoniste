package test;

import enumerations.ECapacites;

// Les epreuves cliniques sont composees de tests
// Deux sous-classes : TestExercices, TestQuestionnaire
public abstract class Test {
	private String nom;
	private ECapacites capacite;
	private float scoreTotal;
	private String conclusion;
	
	// Constructeur
	public Test(String nom, ECapacites capacite) {
		this.nom = nom;
		this.capacite = capacite;
	}
	
	// Getters et setters
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	public ECapacites getCapacite() { return capacite; }
	public void setCapacite(ECapacites capacite) { this.capacite = capacite; }
	public float getScoreTotal() { return scoreTotal; }
	public void setScoreTotal(float scoreTotal) { this.scoreTotal = scoreTotal; }
	public String getConclusion() { return conclusion; }
	public void setConclusion(String conclusion) { this.conclusion = conclusion; }
	
	// Autres methodes
	public abstract float calculerScoreTotal();
}