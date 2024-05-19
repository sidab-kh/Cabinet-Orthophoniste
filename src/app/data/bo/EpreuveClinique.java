package app.data.bo;
import java.io.Serializable;

import app.data.test.Test;

// Un BO comporte un plusieurs epreuves cliniques
@SuppressWarnings("serial")
public class EpreuveClinique implements Serializable {
	private String ObservationClinique;
	private Test test;
	
	// Constructeur
	public EpreuveClinique(String observationClinique, Test test) {
		ObservationClinique = observationClinique;
		this.test = test;
	}

	// Getters et setters
	public String getObservationClinique() { return ObservationClinique; }
	public void setObservationClinique(String observationClinique) { ObservationClinique = observationClinique; }
    public Test getTest() { return test; }
    public void setTest(Test test) { this.test = test; }
}
