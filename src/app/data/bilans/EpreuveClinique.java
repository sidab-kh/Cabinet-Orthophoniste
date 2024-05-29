package app.data.bilans;

import java.io.Serializable;

import app.data.tests.Test;
import app.util.Affichable;

/**
 * La classe EpreuveClinique représente une épreuve clinique réalisée dans le cadre d'un bilan orthophonique.
 * Chaque épreuve clinique est caractérisée par une observation clinique et un test associé.
 */
@SuppressWarnings("serial")
public class EpreuveClinique implements Serializable, Affichable {
    /** L'observation clinique associée à l'épreuve clinique. */
    private String observationClinique;
    
    /** Le test associé à l'épreuve clinique. */
    private Test test;
    
    /**
     * Constructeur pour créer une épreuve clinique avec un test spécifié.
     * 
     * @param test Le test associé à l'épreuve clinique.
     */
    public EpreuveClinique(Test test) { this.test = test; }

    /**
     * Obtient l'observation clinique associée à l'épreuve clinique.
     * 
     * @return L'observation clinique.
     */
    public String getObservationClinique() { return observationClinique; }
    
    /**
     * Modifie l'observation clinique associée à l'épreuve clinique.
     * 
     * @param observationClinique La nouvelle observation clinique.
     */
    public void setObservationClinique(String observationClinique) { this.observationClinique = observationClinique; }
    
    /**
     * Obtient le test associé à l'épreuve clinique.
     * 
     * @return Le test associé à l'épreuve clinique.
     */
    public Test getTest() { return test; }
    
    /**
     * Modifie le test associé à l'épreuve clinique.
     * 
     * @param test Le nouveau test associé à l'épreuve clinique.
     */
    public void setTest(Test test) { this.test = test; }
    
    /**
     * Retourne une chaîne de caractères représentant les informations de l'épreuve clinique.
     * 
     * @return Une chaîne de caractères représentant les informations de l'épreuve clinique.
     */
    @Override
    public String getChaine() { return test.getChaine() + " / Observation : " + observationClinique; }
}