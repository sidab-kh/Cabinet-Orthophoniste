package app;

import app.data.patients.DossierPatient;

public class Contexte {
    private static Contexte instance;
    
    private DossierPatient dossierEnCoursDeTraitement;
    
    private Contexte() {}

    public static Contexte getInstance() {
        if (instance == null) {
            instance = new Contexte();
        }
        return instance;
    }

    // Getters et setters
	public DossierPatient getDossierEnCoursDeTraitement() { return dossierEnCoursDeTraitement; }

	public void setDossierEnCoursDeTraitement(DossierPatient dossierEnCoursDeTraitement) { this.dossierEnCoursDeTraitement = dossierEnCoursDeTraitement; }
}
