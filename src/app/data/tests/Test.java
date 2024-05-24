package app.data.tests;

import java.io.Serializable;

// Les epreuves cliniques sont composees de tests
// Deux sous-classes : TestExercices, TestQuestionnaire
@SuppressWarnings("serial")
public abstract class Test implements Serializable {
	private String nom;
	private String capacite;
	private float scoreTotal;
	private String conclusion;
	
	// Constructeur
	public Test(String nom, String capacite) {
		this.nom = nom;
		this.capacite = capacite;
	}
	
	// Getters et setters
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	public String getCapacite() { return capacite; }
	public void setCapacite(String capacite) { this.capacite = capacite; }
	public float getScoreTotal() { return scoreTotal; }
	public void setScoreTotal(float scoreTotal) { this.scoreTotal = scoreTotal; }
	public String getConclusion() { return conclusion; }
	public void setConclusion(String conclusion) { this.conclusion = conclusion; }
	
	// Autres methodes
	public abstract float calculerScoreTotal();
}