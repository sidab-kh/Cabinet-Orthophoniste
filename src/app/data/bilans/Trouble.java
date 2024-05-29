package app.data.bilans;

import java.io.Serializable;

import app.util.enumerations.ECategoriesTroubles;

/**
 * La classe Trouble représente un trouble identifié lors d'un bilan orthophonique.
 * Chaque trouble est caractérisé par un nom et une catégorie.
 */
@SuppressWarnings("serial")
public class Trouble implements Serializable {
    /** Le nom du trouble. */
    String nom;
    
    /** La catégorie à laquelle appartient le trouble. */
    ECategoriesTroubles categorie;
    
    /**
     * Constructeur pour créer un trouble avec un nom et une catégorie spécifiés.
     * 
     * @param nom Le nom du trouble.
     * @param categorie La catégorie à laquelle appartient le trouble.
     */
    public Trouble(String nom, ECategoriesTroubles categorie) {
        this.nom = nom;
        this.categorie = categorie;
    }
    
    /**
     * Obtient le nom du trouble.
     * 
     * @return Le nom du trouble.
     */
    public String getNom() { return nom; }

    /**
     * Modifie le nom du trouble.
     * 
     * @param nom Le nouveau nom du trouble.
     */
    public void setNom(String nom) { this.nom = nom; }

    /**
     * Obtient la catégorie à laquelle appartient le trouble.
     * 
     * @return La catégorie du trouble.
     */
    public ECategoriesTroubles getCategorie() { return categorie; }

    /**
     * Modifie la catégorie du trouble.
     * 
     * @param categorie La nouvelle catégorie du trouble.
     */
    public void setCategorie(ECategoriesTroubles categorie) { this.categorie = categorie; }
}