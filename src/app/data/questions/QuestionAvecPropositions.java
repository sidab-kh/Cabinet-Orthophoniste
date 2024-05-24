package app.data.questions;

import java.util.List;

@SuppressWarnings("serial")
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

