package app.data.questions;

import java.util.List;

/**
 * La classe abstraite QuestionAvecPropositions est une sous-classe de Question et représente une question avec des propositions de réponses.
 * Elle est utilisée comme classe de base pour les différentes types de questions à choix multiple (QCM) et à choix unique (QCU).
 */
@SuppressWarnings("serial")
public abstract class QuestionAvecPropositions extends Question {
    /** La liste des propositions de réponses associées à la question. */
    List<Proposition> propositions;
    
    /**
     * Constructeur pour créer une question avec des propositions de réponses.
     * 
     * @param enonce L'énoncé de la question.
     * @param propositions La liste des propositions de réponses associées à la question.
     */
    public QuestionAvecPropositions(String enonce, List<Proposition> propositions) {
        super(enonce);
        this.propositions = propositions;
    }

    /**
     * Obtient la liste des propositions de réponses associées à la question.
     * 
     * @return La liste des propositions de réponses.
     */
    public List<Proposition> getPropositions() { return propositions; }
    
    /**
     * Calcule le score de la réponse à la question.
     * Cette méthode doit être implémentée dans les sous-classes pour fournir une logique de calcul de score spécifique.
     * 
     * @return Le score de la réponse.
     */
    public abstract int calculerScore();
}
