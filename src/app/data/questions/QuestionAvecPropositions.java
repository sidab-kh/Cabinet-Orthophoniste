package question;

import java.util.List;

public abstract class QuestionAvecPropositions extends Question {
	List<Proposition> propositions;
	
	public QuestionAvecPropositions(String enonce, List<Proposition> propositions) {
		super(enonce);
		this.propositions = propositions;
	}

	public List<Proposition> getPropositions() {
		return propositions;
	}
	
	public abstract int calculerScore();
}

