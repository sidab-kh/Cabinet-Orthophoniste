package app.data.tests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import app.data.questions.Question;

@SuppressWarnings("serial")
public class TestQuestionnaire extends Test {
	Set<Question> questionnaire = new HashSet<Question>(); // Pas de doublons pour les questions
	Map<Question, Integer> compteRendu = new HashMap<Question, Integer>();

	// Constructeur
	public TestQuestionnaire(String nom, String capacite, HashSet<Question> questionnaire) {
		super(nom, capacite);
		this.questionnaire = questionnaire;
	}

	@Override // Redefinition de calculerScoreTotal()
	public float calculerScoreTotal() {
		int scoreTotal = 0;
		for (Map.Entry<Question, Integer> entry : compteRendu.entrySet()) {
			scoreTotal += entry.getValue();			
		}
		return scoreTotal;
	}

	public Set<Question> getQuestions() {
		return questionnaire;
	}

	public void setCompteRendu(Map<Question, Integer> compteRendu) {
		this.compteRendu = compteRendu;
	}
}