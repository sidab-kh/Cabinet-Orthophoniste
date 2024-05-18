package mvc;

import java.util.Scanner;

// Cette classe joue le role de vue pour selon l'architecture MVC
// Contient toutes les methodes d'affichage et d'interaction avec l'utilisateur
public final class Vue { 

	Scanner scanner;
	
	// Constructeur
    public Vue() {
    	scanner = new Scanner(System.in);
    }
    
    // Afficher les informations de l'orthophoniste
    public void afficherInformationsOrthophoniste(Orthophoniste orthophoniste) {
    	System.out.println("Nom: " + orthophoniste.getNom());
        System.out.println("Prenom: " + orthophoniste.getPrenom());
        System.out.println("Adresse: " + orthophoniste.getAdresse());
        System.out.println("Email: " + orthophoniste.getEmail());
        System.out.println("Mot de Passe: " + orthophoniste.getMotDePasse());
        System.out.println("Numero de telephone: " + orthophoniste.getNumeroTelephone());
    }
    
    // Afficher le menu principal (test seulement)
    public void afficherMenuPrincipal() {
        System.out.println("Menu principal");
        System.out.println("1. Gérer les orthophonistes");
        System.out.println("2. Gérer les patients");
        System.out.println("3. Gérer les rendez-vous");
        System.out.println("4. Quitter");

        System.out.print("Votre choix: ");
    }

    // Lire le choix de l'utilisateur
    public int lireChoixUtilisateur() {
        int choix = scanner.nextInt();
        return choix;
    }

    // Afficher un message d'erreur
    public void afficherErreur(String message) {
        System.out.println("(!) Erreur: " + message);
    }

    // Afficher un message
    public void afficher(String message) {
        System.out.println(message);
    }
    
    // Lire un entier
    public int lireEntier() {
    	return scanner.nextInt();
    }
    
    // Surcharge
    public int lireEntier(String label) {
        System.out.print(label);
        return scanner.nextInt();
    }

    // Lire une chaine de caracteres
    public String lireChaine() {
    	return scanner.nextLine();
    }
    
    // Surcharge
    public String lireChaine(String label) {
        System.out.print(label);
        return scanner.nextLine();
    }
    
    // Demander la confirmation de l'utilisateur
    public boolean demanderConfirmation(String message) {
        System.out.print(message + " (oui/non): ");
        String reponse = scanner.nextLine();
        return reponse.equalsIgnoreCase("oui");
    }
}
