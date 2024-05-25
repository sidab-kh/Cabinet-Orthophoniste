package app.data.fichesuivi;

import java.io.Serializable;

/**
 * La classe Objectif représente un objectif dans une fiche de suivi.
 * Chaque objectif est caractérisé par un nom, une description et une note.
 */
@SuppressWarnings("serial")
public class Objectif implements Serializable {
    /** Le nom de l'objectif. */
    private String nom;
    
    /** Une brève description de l'objectif. */
    private String description;
    
    /** La note attribuée à l'objectif, entre 1 et 5. */
    private int note;

    /**
     * Constructeur pour créer un objectif avec un nom et une description.
     * 
     * @param nom Le nom de l'objectif.
     * @param description Une brève description de l'objectif.
     */
    public Objectif(String nom, String description) {
        this.nom = nom;
        this.description = description;
        this.note = 0; // Initialisé à 0 par défaut
    }

    /**
     * Obtient le nom de l'objectif.
     * 
     * @return Le nom de l'objectif.
     */
    public String getNom() { return nom; }
    
    /**
     * Modifie le nom de l'objectif.
     * 
     * @param nom Le nouveau nom de l'objectif.
     */
    public void setNom(String nom) { this.nom = nom; }
    
    /**
     * Obtient la description de l'objectif.
     * 
     * @return La description de l'objectif.
     */
    public String getDescription() { return description; }
    
    /**
     * Modifie la description de l'objectif.
     * 
     * @param description La nouvelle description de l'objectif.
     */
    public void setDescription(String description) { this.description = description; }
    
    /**
     * Obtient la note attribuée à l'objectif.
     * 
     * @return La note attribuée à l'objectif.
     */
    public int getNote() { return note; }
    
    /**
     * Modifie la note attribuée à l'objectif, en vérifiant si elle est dans la plage autorisée (entre 1 et 5).
     * Si la note fournie est en dehors de cette plage, elle est ajustée à la valeur la plus proche dans cette plage.
     * 
     * @param note La nouvelle note attribuée à l'objectif.
     */
    public void setNote(int note) { 
        if (note >= 1 && note <= 5) {
            this.note = note;
        } else if (note > 5) {
            this.note = 5;
        } else {
            this.note = 1;
        }
    }
}