package app.data.tests;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import app.util.enumerations.EMateriel;

/**
 * La classe Exercice représente un exercice d'un test.
 * Elle contient une consigne, une liste de matériel nécessaire pour l'exercice et un score attribué à l'exercice.
 */
@SuppressWarnings("serial")
public class Exercice implements Serializable {
    /** La consigne de l'exercice. */
    private String consigne;
    
    /** La liste de matériel nécessaire pour l'exercice. */
    private List<EMateriel> materiel = new ArrayList<EMateriel>();
    
    /** Le score attribué à l'exercice. */
    private int score;
    
    /**
     * Constructeur pour créer un exercice avec une consigne et une liste de matériel spécifiées.
     * 
     * @param consigne La consigne de l'exercice.
     * @param materiel La liste de matériel nécessaire pour l'exercice.
     */
    public Exercice(String consigne, List<EMateriel> materiel) {
        this.consigne = consigne;
        this.materiel = materiel;
    }

    /**
     * Obtient la consigne de l'exercice.
     * 
     * @return La consigne de l'exercice.
     */
    public String getConsigne() { return consigne; }
    
    /**
     * Définit la consigne de l'exercice.
     * 
     * @param consigne La nouvelle consigne de l'exercice.
     */
    public void setConsigne(String consigne) { this.consigne = consigne; }
    
    /**
     * Obtient la liste de matériel nécessaire pour l'exercice.
     * 
     * @return La liste de matériel nécessaire pour l'exercice.
     */
    public List<EMateriel> getMateriel() { return materiel; }
    
    /**
     * Définit la liste de matériel nécessaire pour l'exercice.
     * 
     * @param materiel La nouvelle liste de matériel nécessaire pour l'exercice.
     */
    public void setMateriel(List<EMateriel> materiel) { this.materiel = materiel; }
    
    /**
     * Obtient le score attribué à l'exercice.
     * 
     * @return Le score attribué à l'exercice.
     */
    public int getScore() {return score; }
    
    /**
     * Définit le score attribué à l'exercice.
     * 
     * @param score Le nouveau score attribué à l'exercice.
     */
    public void setScore(int score) { this.score = score; } 
    
    /**
     * Redéfinition de la méthode hashCode pour générer un code de hachage basé sur la consigne de l'exercice.
     * 
     * @return Le code de hachage de la consigne de l'exercice.
     */
    @Override
    public int hashCode() {
        return consigne.hashCode();
    }
}
