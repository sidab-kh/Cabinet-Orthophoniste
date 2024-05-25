package app.util.fabriques;

import java.util.ArrayList;
import java.util.HashSet;

import app.data.questions.Question;
import app.data.tests.Exercice;
import app.data.tests.TestExercices;
import app.data.tests.TestQuestionnaire;

/**
 * Cette classe représente une fabrique pour créer des instances de tests.
 * Elle utilise le patron de conception "Factory Method" pour encapsuler les instanciations.
 */
public class FabriqueTest {

    /**
     * Crée et retourne un test de type Questionnaire avec les informations spécifiées.
     * 
     * @param nom Le nom du test.
     * @param capacite La capacité évaluée par le test.
     * @param questions L'ensemble des questions du questionnaire.
     * @return Un nouvel objet de type TestQuestionnaire.
     */
    public static TestQuestionnaire creerTestQuestionnaire(String nom, String capacite, HashSet<Question> questions) {
        return new TestQuestionnaire(nom, capacite, questions);
    }
    
    /**
     * Crée et retourne un test de type Exercices avec les informations spécifiées.
     * 
     * @param nom Le nom du test.
     * @param capacite La capacité évaluée par le test.
     * @param exercices La liste des exercices du test.
     * @return Un nouvel objet de type TestExercices.
     */
    public static TestExercices creerTestExercices(String nom, String capacite, ArrayList<Exercice> exercices) {
        return new TestExercices(nom, capacite, exercices);
    }
}
