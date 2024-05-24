package app.data.bilans;
import java.io.Serializable;

import app.data.tests.Test;

// Un BO comporte un plusieurs epreuves cliniques
@SuppressWarnings("serial")
public class EpreuveClinique implements Serializable {
	private String ObservationClinique;
	private Test test;
	
	// Constructeur
	public EpreuveClinique(Test test) {
		this.test = test;
	}

	// Getters et setters
	public String getObservationClinique() { return ObservationClinique; }
	public void setObservationClinique(String observationClinique) { ObservationClinique = observationClinique; }
    public Test getTest() { return test; }
    public void setTest(Test test) { this.test = test; }
}
