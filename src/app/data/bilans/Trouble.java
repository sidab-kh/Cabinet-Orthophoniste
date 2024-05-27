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
    
    // Getters et setters
    public String getNom() { return nom; }

	public void setNom(String nom) { this.nom = nom; }

	public ECategoriesTroubles getCategorie() { return categorie; }

	public void setCategorie(ECategoriesTroubles categorie) { this.categorie = categorie; }

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
}
