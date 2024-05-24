package application;

import mvc.Controlleur;

// Cette classe represente l'application elle-meme, elle contient la methode main()
public final class Application {
	public static void main(String[] args) {
		Controlleur controlleur = new Controlleur();
		// controlleur.afficherMenu();
//		controlleur.lireInformationsOrthophoniste();;
//		controlleur.afficherInformationsOrthophoniste();
//		controlleur.programmerRendezVous();
//		controlleur.serviceOrthophoniste.afficherAgenda();
		controlleur.deroulerRdv(4);
		controlleur.ajouterNouvelleAnamnese();
		/*
		 * afficher anamnese ? et tests ajouter/afficher/modifer... aaa je pense pas
		 * ndir g3 hadou makach lwekt le plus importants le deroulement de la seance...
		 * interface graphique aussi asaaap go go go and MERGE
		 */	
	}
}