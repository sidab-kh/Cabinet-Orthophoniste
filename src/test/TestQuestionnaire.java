package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import enumerations.ECapacites;
import question.Question;

public class TestQuestionnaire extends Test {
	Set<Question> questionnaire = new HashSet<Question>(); // Pas de doublons pour les questions
	Map<Question, Integer> compteRendu = new HashMap<Question, Integer>();

	// Constructeur
	public TestQuestionnaire(String nom, ECapacites capacite, HashSet<Question> questionnaire) {
		super(nom, capacite);
		this.questionnaire = questionnaire;
	}

	@Override // Redefinition de calculerScoreTotal()
	public float calculerScoreTotal() {
		return -1; // Calculer simplement la somme des scores
	}
}