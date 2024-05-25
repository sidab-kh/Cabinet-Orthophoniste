package app.data.bilans;

import java.io.Serializable;
import java.util.List;

import app.data.questions.QO;
import app.util.enumerations.ETypesPatients;

@SuppressWarnings("serial")
public class Anamnese implements Serializable {
	String nomAnamnese;
	List<QO> questions;
	ETypesPatients typeAnamnese;

	public Anamnese(String nomAnamnese, List<QO> questions, ETypesPatients typeAnamnese) {
		this.nomAnamnese = nomAnamnese;
		this.questions = questions;
		this.typeAnamnese = typeAnamnese;
	}
	
	// Pour créer une copie d'une anamnese pour qu'un patient puisse y répondre
	public Anamnese(Anamnese anamnese) {
		this(anamnese.nomAnamnese, anamnese.questions, anamnese.typeAnamnese);
	}

	public ETypesPatients getTypeAnamnese() {
		return typeAnamnese;
	}
	
	public String getNomAnamnese() {
		return nomAnamnese;
	}
	
	@Override
	public int hashCode() {
		return nomAnamnese.hashCode();
	}

	public List<QO> getQuestions() {
		return questions;
	}

	public String getChaine() {
		return String.format("%s , type : %s", nomAnamnese, typeAnamnese.name().toLowerCase());
	}
}
