package bilanOrthophonique;

public class Trouble {
	String nom;
	ECategoriesTroubles categorie;
	
	public Trouble(String nom, ECategoriesTroubles categorie) {
		this.nom = nom;
		this.categorie = categorie;
	}
}