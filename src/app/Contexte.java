package app;

import java.util.ArrayList;
import java.util.List;

import app.data.patients.DossierPatient;
import app.data.questions.QO;

public class Contexte {
    private static Contexte instance;
    
    private Contexte() {}

    public static Contexte getInstance() {
        if (instance == null) {
            instance = new Contexte();
        }
        return instance;
    }
    
    private DossierPatient dossierEnCoursDeTraitement;
    private List<QO> questions = new ArrayList<>();
	private boolean adulteButton;
	private String intituleField;

    // Getters et setters
	public DossierPatient getDossierEnCoursDeTraitement() { return dossierEnCoursDeTraitement; }

	public void setDossierEnCoursDeTraitement(DossierPatient dossierEnCoursDeTraitement) { this.dossierEnCoursDeTraitement = dossierEnCoursDeTraitement; }
	
	public void addQuestion(QO question) {
    	questions.add(question);
    }
	
	public List<QO> getQuestions() {
    	return questions;
    }
	
	public void clearQuestions() {
    	questions.clear();
    }

	public boolean isAdulteButton() {
		return adulteButton;
	}

	public void setAdulteButton(boolean adulteButton) {
		this.adulteButton = adulteButton;
	}

	public String getIntituleField() {
		return intituleField;
	}

	public void setIntituleField(String intituleField) {
		this.intituleField = intituleField;
	}
}
