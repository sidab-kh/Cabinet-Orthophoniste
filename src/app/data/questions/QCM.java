package app.data.questions;

import java.util.List;
import java.util.Set;

/**
 * La classe QCM représente une question à choix multiple (QCM) avec des propositions.
 * Elle hérite de la classe QuestionAvecPropositions et permet à l'utilisateur de répondre à la question en sélectionnant une ou plusieurs propositions.
 */
@SuppressWarnings("serial")
public class QCM extends QuestionAvecPropositions {
    /** La liste des propositions disponibles pour cette question à choix multiple. */
    List<Proposition> propositions;
    
    /**
     * Constructeur pour créer un objet QCM avec un énoncé et une liste de propositions.
     * 
     * @param enonce L'énoncé de la question à choix multiple.
     * @param propositions La liste des propositions disponibles pour cette question.
     */
    public QCM(String enonce, List<Proposition> propositions) { super(enonce, propositions); }
    
    /**
     * Permet à l'utilisateur de répondre à la question en sélectionnant une ou plusieurs propositions.
     * 
     * @param codesReponses Un ensemble de codes représentant les indices des propositions choisies par l'utilisateur.
     */
    public void repondre(Set<Integer> codesReponses) {
        for(int i : codesReponses) {
            try {
                propositions.get(i).setEstChoisi(true);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("La proposition " + i + " n'existe pas.");
            }
        }
    }

    /**
     * Calcule le score de la réponse à la question à choix multiple.
     * Le score est calculé en fonction du nombre de propositions correctes et incorrectes choisies par l'utilisateur.
     * 
     * @return Le score de la réponse, une valeur entre 1 et 10.
     */
    @Override
    public int calculerScore() {
        int totalCorrectes = 0;
        int correctesChoisies = 0;
        int incorrectesChoisies = 0;

        for (Proposition proposition : propositions) {
            if (proposition.EstVrai()) {
                totalCorrectes++;
                if (proposition.EstChoisi()) {
                    correctesChoisies++;
                }
            } else {
                if (proposition.EstChoisi()) {
                    incorrectesChoisies++;
                }
            }
        }

        // Calcul du score brut
        float scoreBrut = (float) correctesChoisies / totalCorrectes - (float) incorrectesChoisies / (propositions.size() - totalCorrectes);
        
        // Transformation du score en une valeur entre 1 et 10
        int scoreSur10 = Math.round(scoreBrut * 9) + 1; // Convertir en entier entre 1 et 10

        // S'assurer que le score est bien dans la plage 1-10
        if (scoreSur10 < 1) {
            scoreSur10 = 1;
        } else if (scoreSur10 > 10) {
            scoreSur10 = 10;
        }
        return scoreSur10;
    }
}