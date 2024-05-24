package fabriques;

import enumerations.ECapacites;
import question.Question;
import test.Exercice;
import test.TestExercices;
import test.TestQuestionnaire;

import java.util.ArrayList;
import java.util.HashSet;

// Patron de conception "Factory Method", sert a encapsuler les instanciations
public class FabriqueTest {

	// Creer un test de type Questionnaire
	public static TestQuestionnaire creerTestQuestionnaire(String nom, String capacite, HashSet<Question> questions) {
		return new TestQuestionnaire(nom, capacite, questions);
    }
	
	// Creer un test de type Exercices
	public static TestExercices creerTestExcExercices(String nom, String capacite, ArrayList<Exercice> exercices) {
		return new TestExercices(nom, capacite, exercices);
	}
}