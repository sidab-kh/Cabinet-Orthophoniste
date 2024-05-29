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
    /** L'unique instance de Contexte. */
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
    
    /** Le dossier en cours de traitement dans le contexte. */
    private DossierPatient dossierEnCoursDeTraitement;
    
    /** La liste des questions dans le contexte. */
    private List<QO> questions = new ArrayList<>();
    
    /** L'état du bouton adulte dans le contexte. */
    private boolean adulteButton;
    
    /** L'intitulé actuel dans le champ du contexte. */
    private String intituleField;
    
    /** Le rendez-vous dans le contexte. */
    private RendezVous rendezVous;
    
    /** Le bilan orthophonique dans le contexte. */
    private BilanOrthophonique bo;
    
    /** L'indice de l'épreuve dans le contexte. */
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

    /**
     * Retourne le rendez-vous dans le contexte.
     * @return Le rendez-vous dans le contexte.
     */
    public RendezVous getRendezVous() { return rendezVous; }
	
    /**
     * Définit le rendez-vous dans le contexte.
     * @param rendezVous Le rendez-vous à définir dans le contexte.
     */
    public void setRendezVous(RendezVous rendezVous) { this.rendezVous = rendezVous; }

    /**
     * Retourne le bilan orthophonique dans le contexte.
     * @return Le bilan orthophonique dans le contexte.
     */
    public BilanOrthophonique getBo() { return bo; }
	
    /**
     * Définit le bilan orthophonique dans le contexte.
     * @param bo Le bilan orthophonique à définir dans le contexte.
     */
    public void setBo(BilanOrthophonique bo) { this.bo = bo; }
	
    /**
     * Retourne l'indice de l'épreuve dans le contexte.
     * @return L'indice de l'épreuve dans le contexte.
     */
    public int getIndiceEpreuve() { return indiceEpreuve; }
	
    /**
     * Définit l'indice de l'épreuve dans le contexte.
     * @param indiceEpreuve L'indice de l'épreuve à définir dans le contexte.
     */
    public void setIndiceEpreuve(int indiceEpreuve) { this.indiceEpreuve = indiceEpreuve; }
	
    /**
     * Efface toutes les données du contexte.
     */
    public void clear() {
        dossierEnCoursDeTraitement = null;
        questions = new ArrayList<>();
        adulteButton = false;
        intituleField = null;
        rendezVous = null;
        bo = null;
        indiceEpreuve = 0;
    }
}