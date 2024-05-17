package Application;

import mvc.Controlleur;
import mvc.Vue;

public class Application {
	public static void main(String[] args) {
		Controlleur.getInstance().inscrireOrthophoniste();
		Vue.getInstance().afficherInformationsOrthophoniste();
	}
}
