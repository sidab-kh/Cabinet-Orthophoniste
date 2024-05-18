package application;

import mvc.Controlleur;
import patient.DossierPatient;

// Cette classe represente l'application elle-meme, elle contient la methode main()
public final class Application {
	public static void main(String[] args) {
		// Le controlleur controle tout
		Controlleur controlleur = new Controlleur();
		// controlleur.afficherMenu();
		controlleur.lireInformationsOrthophoniste();;
		controlleur.afficherInformationsOrthophoniste();
		controlleur.ajouterDossierPatient(new DossierPatient(0));
		controlleur.ajouterDossierPatient(new DossierPatient(0));
	}
}