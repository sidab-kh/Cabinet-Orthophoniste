import application.Application;

public class Main {
	public static void main(String[] args) {
		Application application = new Application();
		application.compteOrthophoniste = application.new CompteOrthophoniste(null, null, null,
				null, null, 0, null, null);
	}
}
