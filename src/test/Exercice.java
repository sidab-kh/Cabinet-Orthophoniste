package test;

import java.util.ArrayList;
import java.util.List;

import enumerations.EMateriel;

public class Exercice {
	private String consigne;
	private List<EMateriel> materiel = new ArrayList<EMateriel>();
	private int score;
	
	// Constructeur
	public Exercice(String consigne, List<EMateriel> materiel) {
		super();
		this.consigne = consigne;
		this.materiel = materiel;
	}

	// Getters et setters
	public String getConsigne() { return consigne; }
	public void setConsigne(String consigne) { this.consigne = consigne; }
	public List<EMateriel> getMateriel() { return materiel; }
    public void setMateriel(List<EMateriel> materiel) { this.materiel = materiel; }
    public int getScore() {return score; }
    public void setScore(int score) { this.score = score; } 
}
