package app.data.questions;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Question implements Serializable {
	private int score;
	
	// Getters et setters
	public int getScore() {return score; }
    public void setScore(int score) { this.score = score; } 
}
