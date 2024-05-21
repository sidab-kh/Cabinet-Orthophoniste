package app.data.bilans;

import java.io.Serializable;

import app.util.enumerations.ECategoriesTroubles;

@SuppressWarnings("serial")
public class Trouble implements Serializable {
	String nom;
	ECategoriesTroubles categorie;
	
	public Trouble(String nom, ECategoriesTroubles categorie) {
		this.nom = nom;
		this.categorie = categorie;
	}
}