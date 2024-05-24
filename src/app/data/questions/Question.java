package app.data.questions;

import java.io.Serializable;

@SuppressWarnings("serial")
abstract public class Question implements Serializable {
	private String enonce;
	
	public Question(String enonce) {
		this.enonce = enonce;
	}


	// Getters et setters
    public String getEnonce() { return enonce; }
    
    @Override
    public int hashCode() {
    	return enonce.hashCode();
    }
}