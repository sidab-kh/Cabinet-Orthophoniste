package application;

import mvc.Controlleur;
import mvc.Vue;

// Cette classe represente l'application elle-meme, elle contient la methode main()
public class Application {
	public static void main(String[] args) {
		Controlleur.getInstance().inscrireOrthophoniste();
		Vue.getInstance().afficherInformationsOrthophoniste();
	}
}
