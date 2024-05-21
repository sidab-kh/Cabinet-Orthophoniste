package app.mvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.data.patients.Patient;
import app.data.rendezvous.RendezVous;
import app.util.Affichable;
import app.util.CryptageMotDePasse;
import app.util.fabriques.FabriquePatient;
import app.util.fabriques.FabriqueRendezVous;

public final class Vue { 

	Scanner scanner = new Scanner(System.in);
	Controlleur controlleur;
	
	// Constructeur
    public Vue(Controlleur contolleur) { this.controlleur = contolleur; }
    
    // Lire les informations personnelles de l'orthophoniste
    public Orthophoniste lireInformationsOrthophoniste() {
    	afficher_("Lecture des informations de l'orthophoniste :");
        String nom = lireChaine("Nom: ");
        String prenom = lireChaine("Prenom: ");
        String adresse = lireChaine("Adresse: ");
        String email = lireChaine("Email: ");
        String motDePasse = lireChaine("Mot de passe: ");
        int numeroTelephone = lireEntier("Numero de telephone: ");
        afficher_("Informations de l'orthophoniste enregistrées avec succès.");
        
        sautCar();
        return new Orthophoniste(nom, prenom, adresse, email, motDePasse, numeroTelephone);
    }
    
    // Afficher les informations de l'orthophoniste
    public void afficherInformationsOrthophoniste(Orthophoniste orthophoniste) {
    	afficher_("Nom: " + orthophoniste.getNom());
        afficher_("Prenom: " + orthophoniste.getPrenom());
        afficher_("Adresse: " + orthophoniste.getAdresse());
        afficher_("Email: " + orthophoniste.getEmail());
        afficher_("Numero de telephone: " + orthophoniste.getNumeroTelephone());
    }
    
    // Afficher le menu principal
    public void afficherMenuPrincipal() {}
    
    // Afficher l'agenda
    public void afficherAgenda() {
    	afficher_("Agenda de l'orthophoniste :");
    	for (RendezVous rdv : controlleur.getAgenda()) { afficher(rdv); }
    }
    
    // Afficher le menu de connexion
    public boolean connexion(Orthophoniste orthophonisteCharge) {
    	if (orthophonisteCharge == null) {
    		afficherErreur("Veuillez vous inscrire d'abord.");
    		return false;
    	}
    	afficher_("Bonjour");
    	String motDePasse = lireChaine("Veuillez enter votre mot de passe : ");
    	if (CryptageMotDePasse.verifierMotDePasse(motDePasse, orthophonisteCharge.getMotDePasseCrypte())) {
    		afficher_("Connexion reussie, bienvenue.");
    		return true;
    	}
    	else {
    		afficherErreur("Mot de passe errone, veuillez reessayer.");
    		return false;
    	}
    }
    
    // lire un nouveau patient
    public Patient lirePatient() {
    	afficher_("Entrez les informations du patient :");
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
            return FabriquePatient.creerEnfant(nom, prenom, dateNaissance, lieuNaissance, adresse, numeroPere, numeroMere, niveauEtudes);
        } else {  
        	String numeroTelephone = lireChaine("Numero de telephone : ");
            String diplome = lireChaine("Diplome : ");
            String profession = lireChaine("Profession : ");
            return FabriquePatient.creerAdulte(nom, prenom, dateNaissance, lieuNaissance, adresse, numeroTelephone, diplome, profession);
        }
    }
    
    // Lire une nouvelle consultation
    public void lireConsultation() {
    	afficher("Entrez la date et heure de la consultation (YYYY-MM-DD HH:MM) : ");
        LocalDateTime dateEtHeure = lireDateEtHeure();
        
        if (controlleur.orthophonisteDisponible(dateEtHeure)) {
        	Patient nouveauPatient = lirePatient();
        	
        	if (lireOuiNon("Voulez-vous confirmer cette consultation ? (oui/non) : ")) {
        		controlleur.confirmerRendezVous(FabriqueRendezVous.creerConsultation(dateEtHeure, nouveauPatient));
        		afficher_("La consultation a ete ajoutee a votre agenda.");
        	} else {
        		afficher_("La consultation n'a pas ete programmee.");
        	}
        }
        else {
        	// L'orthophoniste n'est pas disponible
            afficherErreur("L'orthophoniste n'est pas disponible a la date et heure indique.e");
        }
        sautCar();
    }

    // Lire une nouvelle seance de suivi
    public void lireSeanceSuivi() {
    	afficher("Entrez la date et heure de la seance de suivi (YYYY-MM-DD HH:MM) : ");
        LocalDateTime dateEtHeure = lireDateEtHeure();
        
        if (controlleur.orthophonisteDisponible(dateEtHeure)) {
        	boolean presentiel = lireOuiNon("La seance sera-t-elle en presentiel ? (oui/non) : ");
        	int numeroDossier = lireEntier("Entrez le numero du dossier du patient : ");
        	if (controlleur.dossierExiste(numeroDossier)) {
        		
            	if (lireOuiNon("Voulez-vous confirmer cette seance de suivi ? (oui/non) : ")) {
            		controlleur.confirmerRendezVous(FabriqueRendezVous.creerSeanceSuivi(dateEtHeure, numeroDossier, presentiel));
            		afficher_("La seance de suivi a ete ajoutee a votre agenda.");
            	} else {
            		afficher_("La seance de suivi n'a pas ete programmee.");
            	}
        	} else {
        		afficherErreur("Ce dossier n'existe pas.");
        	}
        }
        else {
        	// L'orthophoniste n'est pas disponible
        	afficherErreur("L'orthophoniste n'est pas disponible a la date et heure indiquee.");
        }
        sautCar();
    }
    
    // Lire une nouvelle seance d'atelier
    public void lireAtelier() {
    	afficher("Entrez la date et heure de l'atelier (YYYY-MM-DD HH:MM) : ");
        LocalDateTime dateEtHeure = lireDateEtHeure();
        
        if (controlleur.orthophonisteDisponible(dateEtHeure)) {
        	String thematique = lireChaine("Indiquez la thematique de l'atelier : ");
        	afficher_("Selectionnez les numeros de dossiers des participants : ");
        	
        	// Lire les numeros separes par des espaces (n1 n2 n3 ...)
        	List<Integer> numerosDossiers = new ArrayList<>();
            for (String chaineNumero : lireChaine().split("\\s+")) {
                try {
                    int numero = Integer.parseInt(chaineNumero);
                    if (controlleur.dossierExiste(numero)) {
                    	numerosDossiers.add(numero);
                    } else {
                    	afficherErreur("Aucun dossier de numero " + chaineNumero + " trouve.");
                    }
                } catch (NumberFormatException e) {
                    afficherErreur("Numero de dossier invalide : " + chaineNumero);
                }
            }
            
            if (lireOuiNon("Voulez-vous confirmer cette seance d'atelier ? (oui/non) : ")) {
        		controlleur.confirmerRendezVous(FabriqueRendezVous.creerAtelier(dateEtHeure, thematique, numerosDossiers));
        		afficher_("L'atelier a ete ajoute a votre agenda.");
        	} else {
        		afficher_("L'atelier n'a pas ete programme.");
        	}
        }
        else {
        	// L'orthophoniste n'est pas disponible
        	afficherErreur("L'orthophoniste n'est pas disponible a la date et heure indiquee.");
        }
        sautCar();
    }

    // Afficher un message d'erreur
    public void afficherErreur(String message) { System.out.println("(!) Erreur : " + message); }
    
    // Afficher un message avec saut de ligne
    public void afficher_(String message) { System.out.println(message); }
    
    // Afficher message sans saut de ligne
    public void afficher(String message) { System.out.print(message); }
    
    // Afficher un objet affichable
    public void afficher(Affichable objet) { objet.afficher(); }
    
    // Saut de caractere
    public void sautCar() { scanner.nextLine(); }
    
    // Saut de ligne
    public void sautLigne() { System.out.println(); }
    
    // Lire un entier
    public int lireEntier() { return scanner.nextInt(); }
    
    // Lire un entier avec message
    public int lireEntier(String label) { System.out.print(label); return scanner.nextInt(); }
    
    // Lire une chaine de caracteres
    public String lireChaine() { return scanner.nextLine(); }
    
    // Lire une chaine de caracteres avec message
    public String lireChaine(String label) { System.out.print(label); return scanner.nextLine(); }
    
    // Lire une date
    public LocalDate lireDate() { return LocalDate.parse(scanner.nextLine()); } 
    
    // Lire une date et heure 
    public LocalDateTime lireDateEtHeure() { return LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")); }
    
    // Lire le choix de l'utilisateur (oui ou non)
    public boolean lireOuiNon(String message) {
        System.out.print(message);
        String reponse = scanner.nextLine();
        return reponse.equalsIgnoreCase("oui");
    }
}
