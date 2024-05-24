package app.data.questions;

import java.util.List;
import java.util.Set;

@SuppressWarnings("serial")
public class QCM extends QuestionAvecPropositions {
	List<Proposition> propositions;
	
	public QCM(String enonce, List<Proposition> propositions) {
        super(enonce, propositions);
    }
	
	public void repondre(Set<Integer> codesReponses) {
		for(int i : codesReponses) {
			try {
				propositions.get(i).setEstChoisi(true);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("La proposition " + i + " n'existe pas.");
			}
		}
	}

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