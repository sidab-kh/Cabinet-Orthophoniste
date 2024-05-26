package app.data.questions;

import app.util.enumerations.ECategoriesQOs;

/**
 * La classe QO représente une question ouverte (QO) sans propositions de réponses prédéfinies.
 * Elle hérite de la classe Question et peut être utilisée pour poser des questions nécessitant une réponse sous forme de texte.
 */
@SuppressWarnings("serial")
public class QO extends Question {
    /** La réponse à la question ouverte. */
    String reponse;
    
    /** La catégorie de la question ouverte. */
    ECategoriesQOs categorie;
    
    /**
     * Constructeur pour créer une question ouverte sans catégorie.
     * 
     * @param enonce L'énoncé de la question ouverte.
     */
    public QO(String enonce) { this(enonce, null); }
    
    /**
     * Constructeur pour créer une question ouverte avec une catégorie spécifiée.
     * 
     * @param enonce L'énoncé de la question ouverte.
     * @param categorie La catégorie de la question ouverte.
     */
    public QO(String enonce, ECategoriesQOs categorie) {
        super(enonce);
        this.categorie = categorie;
    }
    
    /**
     * Obtient la catégorie de la question ouverte.
     * 
     * @return La catégorie de la question ouverte.
     */
    public ECategoriesQOs getCategorie() { return categorie; }

    /**
     * Permet de répondre à la question ouverte en spécifiant une réponse sous forme de texte.
     * 
     * @param reponse La réponse à la question ouverte.
     */
    public void repondre(String reponse) { this.reponse = reponse; }
}
