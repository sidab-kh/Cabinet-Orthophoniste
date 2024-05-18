package mvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import fabriques.FabriquePatient;
import fabriques.FabriqueRendezVous;
import patient.Patient;

// Cette classe joue le role de "View" dans l'architecture MVC
// Contient toutes les methodes d'affichage et d'interaction avec l'utilisateur
public final class Vue { 

	Scanner scanner;
	Controlleur controlleur;
	
	// Constructeur
    public Vue(Controlleur contolleur) {
    	this.controlleur = contolleur;
    	scanner = new Scanner(System.in);
    }
    
    // Lire les informations personnelles de l'orthophoniste
    public Orthophoniste lireInformationsOrthophoniste() {
    	afficher("Lecture des informations de l'orthophoniste :");
        String nom = lireChaine("Nom: ");
        String prenom = lireChaine("Prenom: ");
        String adresse = lireChaine("Adresse: ");
        String email = lireChaine("Email: ");
        String motDePasse = lireChaine("Mot de passe: ");
        int numeroTelephone = lireEntier("Numero de telephone: ");
        afficher("Informations de l'orthophoniste enregistrées avec succès.");
        saut();
        
        return new Orthophoniste(nom, prenom, adresse, email, motDePasse, numeroTelephone);
    }
    
    // Afficher les informations de l'orthophoniste
    public void afficherInformationsOrthophoniste(Orthophoniste orthophoniste) {
    	System.out.println("Nom: " + orthophoniste.getNom());
        System.out.println("Prenom: " + orthophoniste.getPrenom());
        System.out.println("Adresse: " + orthophoniste.getAdresse());
        System.out.println("Email: " + orthophoniste.getEmail());
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
    
    // lire un nouveau patient
    public Patient lirePatient() {
    	afficher("Entrez les informations du patient :");
        String nom = lireChaine("Nom : ");
        String prenom = lireChaine("Prenom : ");
        afficher("Date de naissance (YYYY-MM-DD) : ");
        LocalDate dateNaissance = lireDate();
        String lieuNaissance = lireChaine("Lieu de naissance : ");
        String adresse = lireChaine("Adresse : ");
        int age = Period.between(dateNaissance, LocalDate.now()).getYears();
        if (age < 18) {
            String numeroPere = lireChaine("Numero de telephone du pere : ");
            String numeroMere = lireChaine("Numero de telephone de la mere : ");
            String niveauEtudes = lireChaine("Niveau d'etudes : ");
            return FabriquePatient.creerEnfant(nom, prenom, lieuNaissance, adresse, dateNaissance, numeroPere,
            		numeroMere, niveauEtudes);
        } else {  
            String diplome = lireChaine("Diplome : ");
            String profession = lireChaine("Profession : ");
            return FabriquePatient.creerAdulte(nom, prenom, lieuNaissance, adresse, adresse, dateNaissance,
            		diplome, profession);
        }
    }
    
    // Lire une nouvelle consultation
    public void lireConsultation() {
    	afficher("Entrez la date et heure de la seance (YYYY-MM-DD HH:MM) : ");
        LocalDateTime dateEtHeure = lireDateEtHeure();
        if (controlleur.estDisponible(dateEtHeure)) {
        	Patient nouveauPatient = lirePatient();
        	controlleur.confirmerRendezVous(FabriqueRendezVous.creerConsultation(dateEtHeure, nouveauPatient));
        }
    }

    // Lire le choix de l'utilisateur
    public int lireChoixUtilisateur() { int choix = scanner.nextInt(); return choix; }

    // Afficher un message d'erreur
    public void afficherErreur(String message) { System.out.println("(!) Erreur: " + message); }

    // Afficher un message
    public void afficher(String message) { System.out.println(message); }
    
    // Lire un entier
    public int lireEntier() { return scanner.nextInt(); } 
    public int lireEntier(String label) { System.out.print(label); return scanner.nextInt(); }

    // Lire une chaine de caracteres
    public String lireChaine() { return scanner.nextLine(); }
    public String lireChaine(String label) { System.out.print(label); return scanner.nextLine(); }
    
    // Lire date et heure 
    public LocalDateTime lireDateEtHeure() {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    	return LocalDateTime.parse(scanner.nextLine(), formatter);
    }
    
    // Lire une date
    public LocalDate lireDate() {
    	return LocalDate.parse(scanner.nextLine());
    }
    
    // Saut de caractere
    public void saut() {
    	scanner.nextLine();
    }
 
    // Demander la confirmation de l'utilisateur
    public boolean demanderConfirmation(String message) {
        System.out.print(message + " (oui/non): ");
        String reponse = scanner.nextLine();
        return reponse.equalsIgnoreCase("oui");
    }
}
