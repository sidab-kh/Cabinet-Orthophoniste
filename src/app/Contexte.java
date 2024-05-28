package app;

import java.util.ArrayList;
import java.util.List;

import app.data.bilans.BilanOrthophonique;
import app.data.patients.DossierPatient;
import app.data.questions.QO;
import app.data.rendezvous.RendezVous;

/**
 * Classe représentant le contexte de l'application, implémentée selon le modèle Singleton.
 * Le contexte contient des informations partagées et maintenues tout au long de l'exécution de l'application.
 */
public class Contexte {
    private static Contexte instance;
    
    private Contexte() {}

    /**
     * Retourne l'unique instance de Contexte.
     * @return L'instance unique de Contexte.
     */
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
	private RendezVous rendezVous;
	private BilanOrthophonique bo;
	private int indiceEpreuve;
	
    /**
     * Retourne le dossier en cours de traitement.
     * @return Le dossier en cours de traitement.
     */
	public DossierPatient getDossierEnCoursDeTraitement() { return dossierEnCoursDeTraitement; }

    /**
     * Définit le dossier en cours de traitement.
     * @param dossierEnCoursDeTraitement Le dossier en cours de traitement à définir.
     */
	public void setDossierEnCoursDeTraitement(DossierPatient dossierEnCoursDeTraitement) { this.dossierEnCoursDeTraitement = dossierEnCoursDeTraitement; }
	
    /**
     * Ajoute une question au contexte.
     * @param question La question à ajouter.
     */
	public void addQuestion(QO question) { questions.add(question); }
	
    /**
     * Retourne la liste des questions dans le contexte.
     * @return La liste des questions dans le contexte.
     */
	public List<QO> getQuestions() { return questions; }
	
    /**
     * Efface toutes les questions du contexte.
     */
	public void clearQuestions() { questions.clear(); }

    /**
     * Vérifie si le bouton adulte est activé dans le contexte.
     * @return true si le bouton adulte est activé, sinon false.
     */
	public boolean isAdulteButton() { return adulteButton; }

    /**
     * Définit l'état du bouton adulte dans le contexte.
     * @param adulteButton true pour activer le bouton adulte, sinon false.
     */
	public void setAdulteButton(boolean adulteButton) { this.adulteButton = adulteButton; }

    /**
     * Retourne l'intitulé actuel dans le champ du contexte.
     * @return L'intitulé actuel dans le champ du contexte.
     */
	public String getIntituleField() { return intituleField; }

    /**
     * Définit l'intitulé dans le champ du contexte.
     * @param intituleField L'intitulé à définir dans le champ du contexte.
     */
	public void setIntituleField(String intituleField) { this.intituleField = intituleField; }

	public RendezVous getRendezVous() {
		return this.rendezVous;
	}
	
	public void setRendezVous(RendezVous rdv) {
		this.rendezVous = rdv;
	}

	public void setBo(BilanOrthophonique bo) {
		this.bo = bo;
	}
	
	public BilanOrthophonique getBo() {
		return bo;
	}
	
	public void setIndiceEpreuve(int i) {
		this.indiceEpreuve = i;
	}
	
	public int getIndiceEpreuve() {
		return indiceEpreuve;
	}
	
	public void clear() {
		dossierEnCoursDeTraitement = null;
		questions = new ArrayList<QO>();
		adulteButton = false;
		intituleField = null;
		rendezVous = null;
		bo = null;
		indiceEpreuve = 0;
	}
}
