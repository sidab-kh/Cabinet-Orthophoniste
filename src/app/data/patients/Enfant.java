package app.data.patients;

import java.time.LocalDate;

/**
 * La classe Enfant représente un patient enfant.
 * Elle étend la classe Patient et ajoute des informations spécifiques aux enfants telles que les numéros de téléphone des parents et le niveau d'études.
 */
@SuppressWarnings("serial")
public class Enfant extends Patient {
    /** Le numéro de téléphone du père de l'enfant. */
    String numeroTelephonePere;
    
    /** Le numéro de téléphone de la mère de l'enfant. */
    String numeroTelephoneMere;
    
    /** Le niveau d'études de l'enfant. */
    String niveauEtudes;

    /**
     * Constructeur pour créer un objet Enfant avec les informations de base ainsi que les numéros de téléphone des parents et le niveau d'études.
     * 
     * @param nom Le nom de l'enfant.
     * @param prenom Le prénom de l'enfant.
     * @param dateNaissance La date de naissance de l'enfant.
     * @param lieuNaissance Le lieu de naissance de l'enfant.
     * @param adresse L'adresse de l'enfant.
     * @param numeroTelephonePere Le numéro de téléphone du père de l'enfant.
     * @param numeroTelephoneMere Le numéro de téléphone de la mère de l'enfant.
     * @param niveauEtudes Le niveau d'études de l'enfant.
     */
    public Enfant(String nom, String prenom, LocalDate dateNaissance, String lieuNaissance, String adresse,
            String numeroTelephonePere, String numeroTelephoneMere, String niveauEtudes) {
        super(nom, prenom, lieuNaissance, adresse, dateNaissance);
        this.numeroTelephonePere = numeroTelephonePere;
        this.numeroTelephoneMere = numeroTelephoneMere;
        this.niveauEtudes = niveauEtudes;
    }
    
    /**
     * Obtient le numéro de téléphone du père de l'enfant.
     * 
     * @return Le numéro de téléphone du père de l'enfant.
     */
    public String getNumeroTelephonePere() { return numeroTelephonePere; }

    /**
     * Modifie le numéro de téléphone du père de l'enfant.
     * 
     * @param numeroTelephonePere Le nouveau numéro de téléphone du père de l'enfant.
     */
    public void setNumeroTelephonePere(String numeroTelephonePere) { this.numeroTelephonePere = numeroTelephonePere; }

    /**
     * Obtient le numéro de téléphone de la mère de l'enfant.
     * 
     * @return Le numéro de téléphone de la mère de l'enfant.
     */
    public String getNumeroTelephoneMere() { return numeroTelephoneMere; }

    /**
     * Modifie le numéro de téléphone de la mère de l'enfant.
     * 
     * @param numeroTelephoneMere Le nouveau numéro de téléphone de la mère de l'enfant.
     */
    public void setNumeroTelephoneMere(String numeroTelephoneMere) { this.numeroTelephoneMere = numeroTelephoneMere; }

    /**
     * Obtient le niveau d'études de l'enfant.
     * 
     * @return Le niveau d'études de l'enfant.
     */
    public String getNiveauEtudes() { return niveauEtudes; }

    /**
     * Modifie le niveau d'études de l'enfant.
     * 
     * @param niveauEtudes Le nouveau niveau d'études de l'enfant.
     */
    public void setNiveauEtudes(String niveauEtudes) { this.niveauEtudes = niveauEtudes; }
    
    /**
     * Retourne une chaîne de caractères représentant les informations de cet enfant,
     * incluant les informations de base du patient ainsi que les numéros de téléphone des parents.
     * 
     * @return Une chaîne de caractères représentant les informations de cet enfant.
     */
    @Override
    public String getChaine() { return super.getChaine() + String.format("Contact : %s, %s.", numeroTelephonePere, numeroTelephoneMere); }
}