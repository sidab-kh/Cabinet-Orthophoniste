package app.data.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * La classe TestExercices représente un test composé d'une série d'exercices.
 * Elle étend la classe abstraite Test.
 */
@SuppressWarnings("serial")
public class TestExercices extends Test {
    /** Le compte rendu des scores obtenus pour chaque exercice, indexé par le hashcode de l'exercice. */
    Map<Integer, Float> compteRendu = new HashMap<>();

    /** La liste des exercices du test. */
    List<Exercice> exercices;
    
    /**
     * Constructeur pour créer un test d'exercices avec un nom, une capacité et une liste d'exercices spécifiés.
     * 
     * @param nom Le nom du test d'exercices.
     * @param capacite La capacité du test d'exercices.
     * @param exercices La liste des exercices du test d'exercices.
     */
    public TestExercices(String nom, String capacite, ArrayList<Exercice> exercices) {
        super(nom, capacite);

        this.exercices = exercices;
        // Initialiser le compte rendu pour avoir tous les hashcodes des exercices
        for (Exercice exercice : exercices) {
            if (compteRendu.get(exercice.hashCode()) == null)
                compteRendu.put(exercice.hashCode(), 0f);
        }
    }
    
    /**
     * Obtient la liste des exercices du test d'exercices.
     * 
     * @return La liste des exercices du test d'exercices.
     */
    public List<Exercice> getExercices() { return exercices; }
    
    /**
     * Définit le compte rendu des scores obtenus pour chaque exercice du test d'exercices.
     * 
     * @param compteRendu Le nouveau compte rendu des scores obtenus pour chaque exercice du test d'exercices.
     */
    public void setCompteRendu(Map<Integer, Float> compteRendu) { this.compteRendu = compteRendu; }

    /**
     * Obtient le compte rendu des scores obtenus pour chaque exercice du test d'exercices.
     * 
     * @return Le compte rendu des scores obtenus pour chaque exercice du test d'exercices.
     */
    public Map<Integer, Float> getCompteRendu() { return compteRendu; }
    
    /**
     * Calcule le score total du test d'exercices en ajoutant les scores obtenus pour chaque exercice.
     * 
     * @return Le score total du test d'exercices.
     */
    @Override
    public float calculerScoreTotal() {
        float scoreTotal = 0;
        for (Map.Entry<Integer, Float> entry : compteRendu.entrySet()) {
            scoreTotal += entry.getValue();
        }
        return scoreTotal;
    }
}