package app.mvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import app.util.Affichable;
import app.data.patients.*;
import app.data.questions.*;
import app.data.rendezvous.*;
import app.data.tests.*;
import app.util.CryptageMotDePasse;
import app.util.enumerations.*;
import app.util.fabriques.*;
import app.data.bilans.*;

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
        String numeroTelephone = lireChaine("Numero de telephone: ");
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
    public void afficher(Affichable objet) { objet.getChaine(); }
    
    // Saut de caractere
    public void sautCar() { scanner.nextLine(); }
    
    // Saut de ligne
    public void sautLigne() { System.out.println(); }
    
    // Lire un entier
    public int lireEntier() { return scanner.nextInt(); }
    
    // Lire un entier avec message
    public int lireEntier(String label) { System.out.print(label); return scanner.nextInt(); }
    
    public int lireScore() {
    	int score = lireEntier("Donnez le score : ");
    	while (score < 1 || score > 10) {
    		afficherErreur("Le score doit etre une valeur entiere entre 1 et 10.");
    		score = lireEntier("Veuillez reintroduire le score : ");
    	}
    	return score;
    }
    
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
    
    // Derouler une consultation
    public void deroulerConsultation(Consultation consultation) {
    	Patient patient = consultation.getPatient();
    	afficher("Début de la consultation avec " + patient.getNom() + " " + patient.getPrenom());
    	List<Anamnese> anamneses = controlleur.getServiceOrthophoniste().getOrthophoniste().anamneses;
    	afficherAnamneses(anamneses, patient.getType());
    	int code = lireEntier("Entrez le code de l'anamnese : ");
    	try {
    		Anamnese copyAnamnese = new Anamnese(anamneses.get(code));
    		BilanOrthophonique bo = new BilanOrthophonique(copyAnamnese);
    		deroulerAnamnese(copyAnamnese);
    		List<Test> tests = controlleur.getServiceOrthophoniste().getOrthophoniste().tests;
    		afficherTests(tests);
    		creerEpreuvesCliniques(choisirTests(tests), bo);
    		deroulerEpreuvesCliniques(bo.getEpreuvesCliniques());
    		bo.ajouterDiagnostic(etablirDiagnostic());
    		bo.ajouterProjetTherapeutique(lireProjetTherapeutique());
		} catch (IndexOutOfBoundsException e) {
			 afficherErreur("Le code de l'anamnese n'existe pas");
			 return;
		}   
    	afficher("Fin de la consultation.");
    }
    
	// Lire les informations d'une anamnese
	public Anamnese lireAnamnese() {
        // Lire le nom de l'anamnèse
        String nomAnamnese = lireChaine("Entrez le nom de l'anamnèse : ");

        // Lire le type de patient
        String typePatientStr = lireChaine("Entrez le type de patient (adulte/enfant) : ");
        ETypesPatients typeAnamnese = null;
        if (typePatientStr.equalsIgnoreCase("adulte")) {
            typeAnamnese = ETypesPatients.ADULTE;
        } else if (typePatientStr.equalsIgnoreCase("enfant")) {
            typeAnamnese = ETypesPatients.ENFANT;
        } else {
            System.out.println("Type de patient invalide.");
            return null;
        }

        // Lire les questions
        List<QO> questions = new ArrayList<>();
        boolean continuer = true;
        while (continuer) {
            String enonce = lireChaine("Entrez l'énoncé de la question :");

            // Lire la catégorie de la question
            ECategoriesQOs categorie = null;
            if (typeAnamnese == ETypesPatients.ADULTE) {
                String categorieStr = lireChaine("Entrez la catégorie de la question "
                		+ "(histoire_maladie, suivi_medical) :");
                try {
                    categorie = ECategoriesQOAdulte.valueOf(categorieStr.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Catégorie invalide.");
                    continue;
                }
            } else if (typeAnamnese == ETypesPatients.ENFANT) {
            	String categorieStr = lireChaine("Entrez la catégorie de la question "
            			+ "(structure_familiale, dynamique_familiale, antécédents_familiaux, "
            			+ "conditions_natales, développement_psychomoteur, "
            			+ "développement_langagier, comportement) :");
                try {
                    categorie = ECategoriesQOEnfant.valueOf(categorieStr.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Catégorie invalide.");
                    continue;
                }
            }

            QO question = new QO(enonce, categorie);
            questions.add(question);

            // Demander si l'utilisateur souhaite ajouter une autre question
            continuer = lireOuiNon("Souhaitez-vous ajouter une autre question ? (oui/non) : ");
        }

        // Créer et retourner l'anamnèse
        return new Anamnese(nomAnamnese, questions, typeAnamnese);
	}
	
	// Afficher les anamneses disponibles pour l'orthophoniste
	public void afficherAnamneses(List<Anamnese> anamneses, ETypesPatients typePatient) {
        System.out.println("Liste des anamneses disponibles pour " + typePatient.name().toLowerCase() + " :");
        boolean vide = true;
        for (int i = 0; i < anamneses.size(); i++) {
            Anamnese anamnese = anamneses.get(i);
            if (anamnese.getTypeAnamnese() == typePatient) {
            	if (vide) vide = false;
                System.out.println((i) + " : " + anamnese.getNomAnamnese());
            }
        }
        if (vide) 
        	afficher("La liste est vide.");
    }

	// Derouler une anamnese lors d'une consultation
	public void deroulerAnamnese(Anamnese anamnese) {
        System.out.println("Déroulement de l'anamnèse : " + anamnese.getNomAnamnese());

        for (QO question : anamnese.getQuestions()) {
            afficher("Question sur "+ question.getCategorie() + " : " + question.getEnonce());
            String reponse = lireChaine("La réponse du patient : ");
            question.repondre(reponse);
        }
        
        System.out.println("Anamnèse complétée et enregistrée.");
		
	}
	
	// Lire les informations d'un test exercice
	public TestExercices lireTestExercices() {
		String nomTest = lireChaine("Entrez le nom du test : ");
        String capacite = lireChaine("Entrez la capacité que concerne le test : ");
        ArrayList<Exercice> exercices = new ArrayList<>();
        
        System.out.println("Ajout d'exercices:");
        boolean continuer = true;
        while (continuer) {
            exercices.add(lireExercice());
            continuer = lireOuiNon("Voulez-vous ajouter un autre exercice ? (oui/non) : ");
        }

        return new TestExercices(nomTest, capacite, exercices);
    }
	
	// Lire un exercice
	private Exercice lireExercice() {
		// Lire la consigne de l'exercice
		String consigne = lireChaine("Entrez la consigne de l'exercice : ");
		
		// Lire le matériel nécessaire
		List<EMateriel> materiel = new ArrayList<>();
		boolean continuer = true;
		while (continuer) {
		    afficher("Choisissez le matériel parmi les options suivantes :");
		    for (EMateriel m : EMateriel.values()) {
		        afficher(m.ordinal() + " - " + m.name());
		    }
		    int choixMateriel = lireEntier("Entrez le numéro du matériel : ");
		    if (choixMateriel >= 0 && choixMateriel < EMateriel.values().length) {
		        materiel.add(EMateriel.values()[choixMateriel]);
		    } else {
		        afficherErreur("Choix invalide, veuillez réessayer.");
		    }
		    continuer = lireOuiNon("Voulez-vous ajouter un autre matériel ? (oui/non) : ");
		}
		
		// Créer et retourner l'exercice
		return new Exercice(consigne, materiel);
	}

	// Lire les informations d'un test questionnaire
	public TestQuestionnaire lireTestQuestionnaire() {
        String nomTest = lireChaine("Entrez le nom du test : ");
        String capacite = lireChaine("Entrez la capacité que concerne le test : ");
        HashSet<Question> questions = new HashSet<>();

        System.out.println("Ajout de questions:");
        boolean continuer = true;
        while (continuer) {
            String typeQuestion = lireChaine("Entrez le type "
            		+ "de question (QO, QCU, QCM) :").toUpperCase();

            Question question = null;
            switch (typeQuestion) {
                case "QO":
                    String enonceQO = lireChaine("Entrez l'énoncé :");
                    question = new QO(enonceQO);
                    break;
                case "QCU":
                    question = lireQCU();
                    break;
                case "QCM":
                    question = lireQCM();
                    break;
                default:
                    System.out.println("Type de question invalide.");
            }

            if (question != null) {
                questions.add(question);
            }
            
            continuer = lireOuiNon("Voulez-vous ajouter une autre question ? (oui/non) : ");
        }
        
        return new TestQuestionnaire(nomTest, capacite, questions);
	}
	
	// Lire une QCM
	private QCM lireQCM() {
        String enonceQCM = lireChaine("Entrez l'énoncé :");

        List<Proposition> propositions = new ArrayList<>();
        boolean continuer = true;
        while (continuer) {
            String enonceProp = lireChaine("Entrez une proposition :");
            boolean estVrai = lireOuiNon("Est-ce une proposition vraie ? (oui/non) : ");

            propositions.add(new Proposition(enonceProp, estVrai));

            continuer = lireOuiNon("Voulez-vous ajouter une autre proposition ? (oui/non) : ");
        }

        return new QCM(enonceQCM, propositions);
    }
	
	// Lire une QCU
	private QCU lireQCU() {
        String enonceQCU = lireChaine("Entrez l'énoncé :");

        List<Proposition> propositions = new ArrayList<>();
        boolean continuer = true;
        boolean dejaUnePropositionVraie = false;
        while (continuer) {
            String enonceProp = lireChaine("Entrez une proposition :");
            if (!dejaUnePropositionVraie) {
				boolean estVrai = lireOuiNon("Est-ce une proposition vraie ? (oui/non) : ");
				propositions.add(new Proposition(enonceProp, estVrai));
			} else {
				propositions.add(new Proposition(enonceProp, false));
			}
			continuer = lireOuiNon("Voulez-vous ajouter une autre proposition ? (oui/non) : ");
        }

        return new QCU(enonceQCU, propositions);
    }

	// Afficher les tests disponibles pour l'orthophoniste
	public void afficherTests(List<Test> tests) {
	    afficher("Liste des tests disponibles :");
	    for (int i = 0; i < tests.size(); i++) {
	        Test test = tests.get(i);
	        afficher(i + " : " + test.getNom() + " (" + (test instanceof TestQuestionnaire?"Questionnaire":"Exercices") + ")");
	    }
	    if (tests.size() == 0) 
        	afficher("La liste des tests est vide.");
	}
	
	// Choisir une liste de testes pour les affecter aux epreuves cliniques
	public List<Test> choisirTests(List<Test> tests) {
	    List<Test> testsChoisis = new ArrayList<>();
	    boolean continuer = true;
	    while (continuer) {
	        int choix = lireEntier("Entrez le numéro du test à sélectionner : ");
	        if (choix >= 0 && choix < tests.size()) {
	            testsChoisis.add(tests.get(choix));
	        } else {
	            afficherErreur("Choix invalide, veuillez réessayer.");
	        }
	        continuer = lireOuiNon("Voulez-vous sélectionner un autre test ? (oui/non) : ");
	    }
	    return testsChoisis;
	}
	
	// Creer des epreuves cliniques depuis une liste de tests et les ajouter dans la liste du bo
	public void creerEpreuvesCliniques(List<Test> testsChoisis, BilanOrthophonique bo) {
	    for (Test test : testsChoisis) {
	        bo.ajouterEpreuveClinique(new EpreuveClinique(test));
	    }
	}	
	
	// Derouler les epreuves cliniques d'un BO lors de l'evaluation
	private void deroulerEpreuvesCliniques(List<EpreuveClinique> epreuvesCliniques) {
		for (EpreuveClinique epreuve : epreuvesCliniques) {
	        Test test = epreuve.getTest();
	        System.out.print("Déroulement de l'épreuve clinique : " + test.getNom());

	        if (test instanceof TestQuestionnaire) {
	        	afficher(" (Questionnaire)");
	            deroulerTestQuestionnaire((TestQuestionnaire) test);
	            //pff jsp ida ndirou plusieurs exo dans une epreuve psq C TROP car la conclusion du test ne sert a rien dans ce cas	            
	        } else if (test instanceof TestExercices) {
	        	afficher(" (Exercices)");
	            deroulerTestExercices((TestExercices) test);
	        }
	        
	        epreuve.setObservationClinique(lireChaine("Introduisez vos observations sur cette epreuve : "));
	    }
	}

	// Derouler un test questionnaire lors d'une epreuve clinique
	public void deroulerTestQuestionnaire(TestQuestionnaire testQuestionnaire) {
	    Set<Question> questionnaire = testQuestionnaire.getQuestions();
	    Map<Question, Integer> compteRendu = new HashMap<>();
	    
	    // repondre et evaluer chaque question
	    for (Question question : questionnaire) {
	        afficher("Question : " + question.getEnonce());

	        if (question instanceof QO) {
	        	((QO) question).repondre(lireChaine("Entrez la réponse du patient : "));
	        	compteRendu.put(question, lireScore());
	        } else if (question instanceof QuestionAvecPropositions) {
	            List<Proposition> propositions = ((QuestionAvecPropositions) question).getPropositions();
	            for (int i = 0; i < propositions.size(); i++) {
	                afficher(i + " - " + propositions.get(i).getEnonce());
	            }
	            if (question instanceof QCU) {
	            	((QCU) question).repondre(lireEntier("Choisissez une proposition (numéro) : "));	         
	            } else if (question instanceof QCM) {
	                Set<Integer> reponsesSet = new HashSet<>();
	                boolean continuer = true;
	                int i = 0;
	                while (continuer && i<propositions.size()) {
	                	int numeroProposition = lireEntier("Choisissez une proposition (numéro) : ");
	                	if (numeroProposition < 0 || numeroProposition >= propositions.size()) {
	                		afficherErreur("numero de proposition erroné");
	                		continue;
	                	}	                		
	                	if (reponsesSet.add(numeroProposition))
	                		i++;
	                	else
	                		afficherErreur("Proposition déjà choisie.");
	                    continuer = lireOuiNon("Voulez-vous choisir une autre proposition ? (oui/non) : ");	                   
	                }
	                ((QCM) question).repondre(reponsesSet);
	            }
	            compteRendu.put(question, ((QuestionAvecPropositions) question).calculerScore());
	        }
	    }
	    
	    testQuestionnaire.setCompteRendu(compteRendu);
	    afficher("Le score total de ce test questionnaire : " + testQuestionnaire.calculerScoreTotal()
	    			+ "/" + questionnaire.size()*10);
	}

	// Derouler un test d'exercices lors d'une epreuve clinique
	public void deroulerTestExercices(TestExercices testExercice) {
		List<Exercice> exercices = testExercice.getExercices();
		Map<Integer, Float> compteRendu = testExercice.getCompteRendu();
	    
		for (Exercice exercice : exercices) {
			afficher("Consigne de l'exercice : " + exercice.getConsigne());
			
			afficher("Materiel : ");
			for (EMateriel materiel : exercice.getMateriel()) {
	            afficher(" - " + materiel.name());
	        }

	        boolean exerciceTermine = lireOuiNon("Confirmez-vous que l'exercice est terminé ? (oui/non) : ");
	        if (exerciceTermine) {
	            exercice.setScore(lireScore());
	        }
		}
		
		for (Map.Entry<Integer, Float> entry : compteRendu.entrySet()) {
			Integer hash = entry.getKey();
			int sommeScores = 0;
			int nb = 0;
			for (Exercice exercice : exercices) {
				if (hash.equals(exercice.hashCode())) {
					sommeScores += exercice.getScore();
					nb++;
				}
			}
			entry.setValue((float) (sommeScores/nb));
		}
		
		afficher("Le score total de ce test exercices : " + testExercice.calculerScoreTotal()
					+ "/" + compteRendu.size()*10);
	}

	// Etablir un diagnostic pour le patient
	public Diagnostic etablirDiagnostic() {
		afficher("Diagnostic du patient : ");
        List<Trouble> troubles = lireTroubles();

        Diagnostic diagnostic = new Diagnostic(troubles);
        return diagnostic;
    }

	// Lire les troubles du patient
	public List<Trouble> lireTroubles() {
        List<Trouble> troubles = new ArrayList<>();
        boolean ajouterAutre = true;
        String nom;

        while (ajouterAutre) {
        	afficher("Entrez le nom du trouble : ");
            nom = lireChaine();

            afficher("Sélectionnez une catégorie de trouble : ");
            for (ECategoriesTroubles categorie : ECategoriesTroubles.values()) {
                afficher(categorie.ordinal() + " - " + categorie.name());
            }

            int choixCategorie = lireEntier("Entrez le numéro de la catégorie : ");
            if (choixCategorie >= 0 && choixCategorie < ECategoriesTroubles.values().length) {
            	troubles.add(new Trouble(nom, ECategoriesTroubles.values()[choixCategorie]));
		    } else {
		        afficherErreur("Choix invalide, veuillez réessayer.");
		    }
            
            ajouterAutre = lireOuiNon("Voulez-vous ajouter un autre trouble ? (oui/non) : ");
        }

        return troubles;
    }

	// Lire le projet therapeutique
	public String lireProjetTherapeutique() {
        afficher("Entrez la description du projet thérapeutique : ");
        return lireTexteLong();
    }

    // Lire un texte long
    private String lireTexteLong() {
        StringBuilder texte = new StringBuilder();
        String ligne;
        
        afficher("Tapez votre texte ci-dessous. Entrez 'FIN' sur une nouvelle ligne pour terminer.");
        while (!(ligne = scanner.nextLine()).equalsIgnoreCase("FIN")) {
            texte.append(ligne).append("\n");
        }
        return texte.toString();
    }
}
