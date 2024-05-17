package mvc;

import java.util.Scanner;

// Cette classe joue le role de vue pour selon l'architecture MVC
// Contient toutes les methodes d'affichage et d'interaction avec l'utilisateur
public final class Vue { 
	
    // Patron de conception singleton
    private static Vue instance;
    
    // Constructeur prive pour eviter toute instanciation externe
    private Vue() {}

    // Methode pour recuperer l'instance unique de la vue a partir des autres classes
    public static Vue getInstance() {
        if (instance == null) {
            instance = new Vue();
        }
        return instance;
    }
    
    // Lire les informations de l'orthophoniste
    public void lireInformationsOrthophoniste() {
        Scanner scanner = new Scanner(System.in);

        // Lire les informations de l'othophoniste
        System.out.print("Nom: ");
        String nom = scanner.nextLine();

        System.out.print("Prenom: ");
        String prenom = scanner.nextLine();

        System.out.print("Adresse: ");
        String adresse = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();

        System.out.print("Numero de telephone: ");
        int numeroTelephone = scanner.nextInt();
        
        // Le mettre en ligne
        Orthophoniste.setOrthophoniste(nom, prenom, adresse, email, motDePasse, numeroTelephone);
        
        scanner.close(); // Fermer le scanner
    }  
    
    // Afficher les informations de l'orthophoniste
    public void afficherInformationsOrthophoniste() {
    	Orthophoniste orthophoniste = Orthophoniste.getInstance();
    	System.out.println("Nom: " + orthophoniste.getNom());
        System.out.println("Prenom: " + orthophoniste.getPrenom());
        System.out.println("Adresse: " + orthophoniste.getAdresse());
        System.out.println("Email: " + orthophoniste.getEmail());
        System.out.println("Mot de Passe: " + orthophoniste.getMotDePasse());
        System.out.println("Numero de telephone: " + orthophoniste.getNumeroTelephone());
    }
}
