package app.data.tests;

import java.io.Serializable;

import app.util.Affichable;

/**
 * La classe Test est une classe abstraite représentant un test.
 * Elle est étendue par les sous-classes test d'exercices et test questionnaire
 */
@SuppressWarnings("serial")
public abstract class Test implements Serializable, Affichable {
    /** Un compteur pour suivre le nombre de tests créés. */
    public static int compteurTests = 0;
    
    /** L'indice du test. */
    private int indiceTest;
    
    /** Le nom du test. */
    private String nom;
    
    /** La capacité du test. */
    private String capacite;
    
    /** Le score total du test. */
    private float scoreTotal;
    
    /** La conclusion du test. */
    private String conclusion;
    
    /**
     * Constructeur pour créer un test avec un nom et une capacité spécifiés.
     * 
     * @param nom Le nom du test.
     * @param capacite La capacité du test.
     */
    public Test(String nom, String capacite) {
        this.indiceTest = compteurTests;
        compteurTests++;
        this.nom = nom;
        this.capacite = capacite;
    }
    
    /**
     * Obtient le nom du test.
     * 
     * @return Le nom du test.
     */
    public String getNom() { return nom; }
    
    /**
     * Définit le nom du test.
     * 
     * @param nom Le nouveau nom du test.
     */
    public void setNom(String nom) { this.nom = nom; }
    
    /**
     * Obtient la capacité du test.
     * 
     * @return La capacité du test.
     */
    public String getCapacite() { return capacite; }
    
    /**
     * Définit la capacité du test.
     * 
     * @param capacite La nouvelle capacité du test.
     */
    public void setCapacite(String capacite) { this.capacite = capacite; }
    
    /**
     * Obtient le score total du test.
     * 
     * @return Le score total du test.
     */
    public float getScoreTotal() { return scoreTotal; }
    
    /**
     * Définit le score total du test.
     * 
     * @param scoreTotal Le nouveau score total du test.
     */
    public void setScoreTotal(float scoreTotal) { this.scoreTotal = scoreTotal; }
    
    /**
     * Obtient la conclusion du test.
     * 
     * @return La conclusion du test.
     */
    public String getConclusion() { return conclusion; }
    
    /**
     * Définit la conclusion du test.
     * 
     * @param conclusion La nouvelle conclusion du test.
     */
    public void setConclusion(String conclusion) { this.conclusion = conclusion; }
    
    /**
     * Méthode abstraite pour calculer le score total du test.
     * 
     * @return Le score total du test.
     */
    public abstract float calculerScoreTotal();
    
    /**
     * Obtient une représentation sous forme de chaîne de caractères du test.
     * 
     * @return Une chaîne de caractères représentant le test.
     */
    public String getChaine() { return indiceTest + " / " + nom + " / " + "Capacité : " + capacite + " / "; }
}
