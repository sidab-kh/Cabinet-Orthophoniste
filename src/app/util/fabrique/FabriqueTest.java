package app.util.fabrique;

import java.util.ArrayList;
import java.util.HashSet;

import app.data.question.Question;
import app.data.test.Exercice;
import app.data.test.TestExercices;
import app.data.test.TestQuestionnaire;
import app.util.enumeration.ECapacites;

// Patron de conception "Factory Method", sert a encapsuler les instanciations
public class FabriqueTest {

	// Creer un test de type Questionnaire
	public static TestQuestionnaire creerTestQuestionnaire(String nom, ECapacites capacite, HashSet<Question> questions) {
		return new TestQuestionnaire(nom, capacite, questions);
    }
	
	// Creer un test de type Exercices
	public static TestExercices creerTestExcExercices(String nom, ECapacites capacite, ArrayList<Exercice> exercices) {
		return new TestExercices(nom, capacite, exercices);
	}
}