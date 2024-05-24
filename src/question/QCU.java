package question;

import java.util.List;

public class QCU extends QuestionAvecPropositions {
	List<Proposition> propositions;
	
	public QCU(String enonce, List<Proposition> propositions) {
        super(enonce, propositions);
    }
	
	public void repondre(int codeReponse) {
		try {
			propositions.get(codeReponse).setEstChoisi(true);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("La proposition " + codeReponse + " n'existe pas.");
		}
	}
	
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
