package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import question.Question;

public class TestQuestionnaire extends Test {
	Set<Question> questionnaire = new HashSet<Question>(); // Pas de doublons pour les questions
	Map<Question, Integer> compteRendu = new HashMap<Question, Integer>();
	
	@Override // Redefinition de calculerScore()
	public float calculerScore() {
		return -1;
	}
}