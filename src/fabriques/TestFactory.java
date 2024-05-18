package fabriques;

import enumerations.ECapacites;
import enumerations.ETypesTests;
import question.Question;
import test.Exercice;
import test.Test;
import test.TestExercices;
import test.TestQuestionnaire;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Patron de conception "Factory Method"
public class TestFactory {

    // Permet de creer n'importe quel test sans avoir a instancier avec le mot cle 'new'
	@SuppressWarnings("unchecked")
	public static Test creerTest(ETypesTests type, String nom, ECapacites capacite, Object exercicesOuQuestions) {
        switch (type) {
            case TEST_EXERCICES:
                if (exercicesOuQuestions instanceof List<?>) {
                    return new TestExercices(nom, capacite, (ArrayList<Exercice>) exercicesOuQuestions);
                } else {
                    throw new IllegalArgumentException("Pour un test exercices, fournissez une ArrayList d'exercices.");
                }
            case TEST_QUESTIONNAIRE:
                if (exercicesOuQuestions instanceof HashSet<?>) {
                    return new TestQuestionnaire(nom, capacite, (HashSet<Question>) exercicesOuQuestions);
                } else {
                    throw new IllegalArgumentException("Pour un test questionnaire, fournissez une HashSet de questions.");
                }
            default:
                throw new IllegalArgumentException("Type de test invalide (doit être 'test questionnaire' ou 'test exercices').");
        }
    }
}
