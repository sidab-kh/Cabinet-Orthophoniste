package app.data.questions;

import app.util.enumerations.ECategoriesQOs;

@SuppressWarnings("serial")
public class QO extends Question {
	String reponse;
	ECategoriesQOs categorie;
	
	// Constructeur pour les questions des tests (sans categorie)
	public QO(String enonce) {
		this(enonce, null);
	}
	
	// Constructeur pour les questions des anamneses (avec categorie)
	public QO(String enonce, ECategoriesQOs categorie) {
		super(enonce);
		this.categorie = categorie;
	}
	
	public ECategoriesQOs getCategorie() {
		return categorie;
	}

	public void repondre(String reponse) {
		this.reponse = reponse;
	}
}
