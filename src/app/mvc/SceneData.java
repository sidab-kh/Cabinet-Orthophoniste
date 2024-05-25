package app.mvc;

import java.util.ArrayList;
import java.util.List;

import app.data.questions.QO;

public class SceneData {
	private List<QO> questions = new ArrayList<>();
	boolean adulteButton;
	String intituleField;
	
	public SceneData(boolean adulteButton, String intituleField) {
		this.adulteButton = adulteButton;
		this.intituleField = intituleField;
	}
	
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
