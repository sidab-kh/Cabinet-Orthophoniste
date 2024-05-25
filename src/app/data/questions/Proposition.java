package app.data.questions;

import java.io.Serializable;

/**
 * La classe Proposition représente une proposition de réponse à une question.
 * Chaque proposition est composée d'un énoncé et d'un indicateur indiquant si elle est vraie ou fausse.
 */
@SuppressWarnings("serial")
public class Proposition implements Serializable {
    /** L'énoncé de la proposition. */
    private String enonce;
    
    /** Indique si la proposition est vraie ou fausse. */
    private boolean estVrai;
    
    /** Indique si la proposition a été choisie par l'utilisateur. */
    private boolean estChoisi;

    /**
     * Constructeur pour créer une proposition avec un énoncé et une indication de véracité.
     * 
     * @param enonce L'énoncé de la proposition.
     * @param estVrai Indique si la proposition est vraie (true) ou fausse (false).
     */
    public Proposition(String enonce, boolean estVrai) {
        this.enonce = enonce;
        this.estVrai = estVrai;
    }

    /**
     * Obtient l'énoncé de la proposition.
     * 
     * @return L'énoncé de la proposition.
     */
    public String getEnonce() { return enonce; }

    /**
     * Indique si la proposition est vraie ou fausse.
     * 
     * @return true si la proposition est vraie, sinon false.
     */
    public boolean EstVrai() { return estVrai; }

    /**
     * Indique si la proposition a été choisie par l'utilisateur.
     * 
     * @return true si la proposition a été choisie, sinon false.
     */
    public boolean EstChoisi() { return estChoisi; }

    /**
     * Modifie l'état de choix de la proposition par l'utilisateur.
     * 
     * @param estChoisi true si la proposition est choisie, sinon false.
     */
    public void setEstChoisi(boolean estChoisi) { this.estChoisi = estChoisi; }
}
