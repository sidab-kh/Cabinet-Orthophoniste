package application;

import java.util.ArrayList;
import java.util.HashSet;

import enumerations.ECapacites;
import enumerations.ETypesTests;
import fabriques.TestFactory;
import mvc.Controlleur;
import patient.DossierPatient;
import question.Question;
import test.Exercice;
import test.Test;

// Cette classe represente l'application elle-meme, elle contient la methode main()
public final class Application {
	public static void main(String[] args) {
		// Le controlleur controle tout
		Controlleur controlleur = new Controlleur();
		// controlleur.afficherMenu();
		controlleur.lireInformationsOrthophoniste();;
		controlleur.afficherInformationsOrthophoniste();
		controlleur.ajouterDossierPatient(new DossierPatient(0));
		controlleur.ajouterDossierPatient(new DossierPatient(0));
		Test n = TestFactory.creerTest(ETypesTests.TEST_QUESTIONNAIRE, "TQ1", ECapacites.AUCUNE, new HashSet<Question>());
		Test p = TestFactory.creerTest(ETypesTests.TEST_EXERCICES, "TE1", ECapacites.AUCUNE, new ArrayList<Exercice>());

		System.out.println(n.getNom());
		System.out.println(p.getCapacite());
	}
}