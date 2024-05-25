package app.data.questions;

import java.util.List;

/**
 * La classe QCU représente une question à choix unique (QCU) avec des propositions.
 * Elle hérite de la classe QuestionAvecPropositions et permet à l'utilisateur de répondre à la question en sélectionnant une seule proposition parmi plusieurs.
 */
@SuppressWarnings("serial")
public class QCU extends QuestionAvecPropositions {
    /** La liste des propositions disponibles pour cette question à choix unique. */
    List<Proposition> propositions;
    
    /**
     * Constructeur pour créer un objet QCU avec un énoncé et une liste de propositions.
     * 
     * @param enonce L'énoncé de la question à choix unique.
     * @param propositions La liste des propositions disponibles pour cette question.
     */
    public QCU(String enonce, List<Proposition> propositions) {
        super(enonce, propositions);
    }
    
    /**
     * Permet à l'utilisateur de répondre à la question en sélectionnant une seule proposition.
     * 
     * @param codeReponse Le code représentant l'indice de la proposition choisie par l'utilisateur.
     */
    public void repondre(int codeReponse) {
        try {
            propositions.get(codeReponse).setEstChoisi(true);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("La proposition " + codeReponse + " n'existe pas.");
        }
    }
    
    /**
     * Calcule le score de la réponse à la question à choix unique.
     * Le score est basé sur la proposition choisie par l'utilisateur.
     * 
     * @return Le score de la réponse, soit 10 si la proposition choisie est correcte, sinon 1.
     */
    public int calculerScore() {
        int score = 1;

        for (Proposition proposition : propositions) {
            if (proposition.EstVrai()) {
               score = proposition.EstChoisi() ? 10 : 1;
            }
        }
        return score;
    }
}
