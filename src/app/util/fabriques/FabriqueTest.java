package app.util.fabriques;

import java.util.ArrayList;
import java.util.HashSet;

import app.data.questions.Question;
import app.data.tests.Exercice;
import app.data.tests.TestExercices;
import app.data.tests.TestQuestionnaire;

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