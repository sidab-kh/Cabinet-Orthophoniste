package app.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import app.Main;
import app.data.questions.Proposition;
import app.data.questions.QCM;
import app.data.questions.QO;
import app.data.questions.Question;
import app.data.tests.Exercice;
import app.data.tests.TestExercices;
import app.data.tests.TestQuestionnaire;
import app.mvc.Controlleur;
import app.mvc.Orthophoniste;
import app.util.enumerations.EMateriel;
import app.util.enumerations.EScenes;
import app.util.fabriques.FabriqueTest;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class InscriptionController {

	Controlleur controlleur;
	
    @FXML
    private TextField nomField, prenomField, adresseField, emailField, telephoneField;

    @FXML
    private PasswordField motDePasseField;

    @FXML
    private Button inscriptionButton, connexionButton;
    
    @FXML
    private Text erreurText;
    
    @FXML
    private void initialize() {
    	controlleur = Controlleur.getInstance();
    	erreurText.setVisible(false);
    }

    @FXML // Lire les informations
    private void handleInscriptionButtonAction() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String adresse = adresseField.getText();
        String email = emailField.getText();
        String telephone = telephoneField.getText();
        String motDePasse = motDePasseField.getText();
        String messageErreur = "";

        if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || email.isEmpty() || telephone.isEmpty() || motDePasse.isEmpty()) {
            messageErreur = "Tous les champs sont obligatoires.";
        } else if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            messageErreur = "Adresse email invalide.";
        } else if (!telephone.matches("\\d{10}")) {
            messageErreur = "Numéro de téléphone invalide. Doit contenir 10 chiffres.";
        } else if (motDePasse.length() < 8) {
            messageErreur = "Le mot de passe doit contenir au moins 8 caractères.";
        }
        
        if (!messageErreur.isEmpty()) {
            erreurText.setText(messageErreur);
            erreurText.setVisible(true);
        } else {
            controlleur.inscription(new Orthophoniste(nom, prenom, adresse, email, motDePasse, telephone));
            
            // HARD CODE
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // EXERCICE 1
            List<EMateriel> materiel1 = new ArrayList<>();
            materiel1.add(EMateriel.LIVRE);
            materiel1.add(EMateriel.FEUILLES);
            Exercice exercice1 = new Exercice("Lecture et dessin", materiel1);

            // EXERCICE 2
            List<EMateriel> materiel2 = new ArrayList<>();
            materiel2.add(EMateriel.TABLETTE_ET_APPLICATION);
            materiel2.add(EMateriel.MATERIEL_AUDITIF);
            Exercice exercice2 = new Exercice("Imiter les animaux", materiel2);

            // EXERCICE 3
            List<EMateriel> materiel3 = new ArrayList<>();
            materiel3.add(EMateriel.JEU_DE_CARTES);
            Exercice exercice3 = new Exercice("Jeu de cartes", materiel3);

            // EXERCICE 4
            List<EMateriel> materiel4 = new ArrayList<>();
            materiel4.add(EMateriel.TABLEAU);
            Exercice exercice4 = new Exercice("La prononciation", materiel4);

            // EXERCICE 5
            List<EMateriel> materiel5 = new ArrayList<>();
            materiel5.add(EMateriel.MATERIEL_ECRITURE);
            materiel5.add(EMateriel.FEUILLES);
            materiel5.add(EMateriel.IMAGES);
            Exercice exercice5 = new Exercice("Écrire ses pensées", materiel5);

            // LISTES DES EXERCICES
            ArrayList<Exercice> exercicesList1 = new ArrayList<>();
            exercicesList1.add(exercice1);
            exercicesList1.add(exercice2);
            exercicesList1.add(exercice1);
            exercicesList1.add(exercice4);

            ArrayList<Exercice> exercicesList2 = new ArrayList<>();
            exercicesList2.add(exercice1);
            exercicesList2.add(exercice3);
            exercicesList2.add(exercice5);
            exercicesList2.add(exercice5);
            
            // TESTS EXERCICES
            TestExercices testExercices1 = FabriqueTest.creerTestExercices("Test exercices 1", "La prononciation", exercicesList1);
            TestExercices testExercices2 = FabriqueTest.creerTestExercices("Test exercices 2", "La pensée", exercicesList2);

            // QCM 1
            Proposition prop1 = new Proposition("Pizza", true);
            Proposition prop2 = new Proposition("Poisson", true);
            Proposition prop3 = new Proposition("Chocolat", true);
            Proposition prop4 = new Proposition("Vache", false);
            List<Proposition> propositions1 = new ArrayList<>();
            propositions1.add(prop1);
            propositions1.add(prop2);
            propositions1.add(prop3);
            propositions1.add(prop4);
            QCM qcm1 = new QCM("C'est de la nourriture", propositions1);
            
            // QCM 2
            prop1 = new Proposition("Pizza", false);
            prop2 = new Proposition("Poisson", false);
            prop3 = new Proposition("Chocolat", false);
            prop4 = new Proposition("Vache", false);
            propositions1 = new ArrayList<>();
            propositions1.add(prop1);
            propositions1.add(prop2);
            propositions1.add(prop3);
            propositions1.add(prop4);
            QCM qcm2 = new QCM("C'est un animal", propositions1);
            
            // QCM 3
            prop1 = new Proposition("Pizza", true);
            prop2 = new Proposition("Poisson", true);
            prop3 = new Proposition("Chocolat", true);
            prop4 = new Proposition("Vache", true);
            propositions1 = new ArrayList<>();
            propositions1.add(prop1);
            propositions1.add(prop2);
            propositions1.add(prop3);
            propositions1.add(prop4);
            QCM qcm3 = new QCM("Fait partie de la nature", propositions1);

            // QOs
            QO qo1 = new QO("Comment vous sentez-vous ?");
            QO qo2 = new QO("Quel est votre plat préféré ?");
            QO qo3 = new QO("Quel est votre jeu vidéo favori ?");
            QO qo4 = new QO("Peux-tu me chanter ta chanson préférée ?");

            // LISTES DE QUESTIONS
            HashSet<Question> questionsSet1 = new HashSet<>();
            questionsSet1.add(qcm1);
            questionsSet1.add(qo1);
            questionsSet1.add(qo2);
            questionsSet1.add(qo3);

            HashSet<Question> questionsSet2 = new HashSet<>();
            questionsSet2.add(qcm2);
            questionsSet2.add(qcm3);
            questionsSet2.add(qo2);
            questionsSet2.add(qo4);
            
            // TESTS QUESTIONNAIRES
            TestQuestionnaire testQuestionnaire1 = FabriqueTest.creerTestQuestionnaire("Test questionnaire 1", "L'analyse", questionsSet1);
            TestQuestionnaire testQuestionnaire2 = FabriqueTest.creerTestQuestionnaire("Test questionnaire 2", "L'anxiété", questionsSet2);

            // AJOUT DES TESTS
            controlleur.getServiceOrthophoniste().ajouterTest(testExercices1);
            controlleur.getServiceOrthophoniste().ajouterTest(testExercices2);
            controlleur.getServiceOrthophoniste().ajouterTest(testQuestionnaire1);
            controlleur.getServiceOrthophoniste().ajouterTest(testQuestionnaire2);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            Main.changerScene(EScenes.AGENDA);
        }
    }

    @FXML // Aller a la page de connexion
    private void handleConnexionButtonAction() { Main.changerScene(EScenes.CONNEXION); }
}