package enumerations;

public enum ETypesTests {
	TEST_QUESTIONNAIRE("Test questionnaire"),
	TEST_EXERCICES("Test exercices");
	
	String nom;
	
	// Constructeur
	ETypesTests(String nom) {
		this.nom = nom;
	}
}
