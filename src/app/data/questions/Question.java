package app.data.questions;

import java.io.Serializable;

/**
 * La classe abstraite Question représente une question.
 * Elle est utilisée comme classe de base pour différents types de questions telles que QCM, QCU et QO.
 */
@SuppressWarnings("serial")
abstract public class Question implements Serializable {
    /** L'énoncé de la question. */
    private String enonce;
    
    /**
     * Constructeur pour créer une question avec un énoncé spécifié.
     * 
     * @param enonce L'énoncé de la question.
     */
    public Question(String enonce) {
        this.enonce = enonce;
    }

    /**
     * Obtient l'énoncé de la question.
     * 
     * @return L'énoncé de la question.
     */
    public String getEnonce() { return enonce; }
    
    /**
     * Calcule le code de hachage de la question basé sur son énoncé.
     * 
     * @return Le code de hachage de la question.
     */
    @Override
    public int hashCode() {
        return enonce.hashCode();
    }
}
