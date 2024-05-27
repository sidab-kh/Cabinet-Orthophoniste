package app.data.tests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import app.data.questions.Question;

/**
 * La classe TestQuestionnaire représente un test sous forme de questionnaire.
 * Elle étend la classe abstraite Test.
 */
@SuppressWarnings("serial")
public class TestQuestionnaire extends Test {
    /** Le questionnaire du test, sans doublons pour les questions. */
    Set<Question> questionnaire = new HashSet<Question>();
    
    /** Le compte rendu des réponses à chaque question du questionnaire. */
    Map<Question, Integer> compteRendu = new HashMap<Question, Integer>();

    /**
     * Constructeur pour créer un test questionnaire avec un nom, une capacité et un ensemble de questions spécifiés.
     * 
     * @param nom Le nom du test questionnaire.
     * @param capacite La capacité du test questionnaire.
     * @param questionnaire L'ensemble des questions du test questionnaire.
     */
    public TestQuestionnaire(String nom, String capacite, HashSet<Question> questionnaire) {
        super(nom, capacite);
        this.questionnaire = questionnaire;
    }

    /**
     * Obtient l'ensemble des questions du test questionnaire.
     * 
     * @return L'ensemble des questions du test questionnaire.
     */
    public Set<Question> getQuestions() { return questionnaire; }

    /**
     * Définit le compte rendu des réponses à chaque question du test questionnaire.
     * 
     * @param compteRendu Le nouveau compte rendu des réponses à chaque question du test questionnaire.
     */
    public void setCompteRendu(Map<Question, Integer> compteRendu) { this.compteRendu = compteRendu; }
    
    /**
     * Calcule le score total du test questionnaire en ajoutant les scores de toutes les questions.
     * 
     * @return Le score total du test questionnaire.
     */
    @Override
    public float calculerScoreTotal() {
        int scoreTotal = 0;
        for (Map.Entry<Question, Integer> entry : compteRendu.entrySet()) {
            scoreTotal += entry.getValue();           
        }
        return scoreTotal;
    }
    
    @Override
    public String getChaine() { return super.getChaine() + "Type : Questionnaire"; }
}