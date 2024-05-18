package application;

import mvc.Controlleur;

// Cette classe represente l'application elle-meme, elle contient la methode main()
public final class Application {
	public static void main(String[] args) {
		Controlleur controlleur = new Controlleur();
		// controlleur.afficherMenu();
		controlleur.lireInformationsOrthophoniste();;
		controlleur.afficherInformationsOrthophoniste();
		controlleur.programmerRendezVous();
	}
}