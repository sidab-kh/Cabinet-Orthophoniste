package enumerations;

public enum ETypesQuestions {
	QO("Question ouverte"),
	QCM("Question a choix multiples"),
	QCU("Question a choix unique");
	
	String nom;

	// Constructeur
	private ETypesQuestions(String nom) {
		this.nom = nom;
	}
}