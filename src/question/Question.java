package question;

abstract public class Question {
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
