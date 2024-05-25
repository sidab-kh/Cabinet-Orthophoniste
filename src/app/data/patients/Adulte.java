package app.data.patients;

import java.time.LocalDate;

/**
 * La classe Adulte représente un patient adulte.
 * Elle étend la classe Patient et ajoute des informations spécifiques aux adultes telles que le numéro de téléphone, le diplôme et la profession.
 */
@SuppressWarnings("serial")
public class Adulte extends Patient {
    /** Le numéro de téléphone de l'adulte. */
    String numeroTelephone;
    
    /** Le diplôme de l'adulte. */
    String diplome;
    
    /** La profession de l'adulte. */
    String profession;

    /**
     * Constructeur pour créer un objet Adulte avec les informations de base ainsi que le numéro de téléphone, le diplôme et la profession.
     * 
     * @param nom Le nom de l'adulte.
     * @param prenom Le prénom de l'adulte.
     * @param dateNaissance La date de naissance de l'adulte.
     * @param lieuNaissance Le lieu de naissance de l'adulte.
     * @param adresse L'adresse de l'adulte.
     * @param numeroTelephone Le numéro de téléphone de l'adulte.
     * @param diplome Le diplôme de l'adulte.
     * @param profession La profession de l'adulte.
     */
    public Adulte(String nom, String prenom, LocalDate dateNaissance, String lieuNaissance, String adresse,
            String numeroTelephone, String diplome, String profession) {
        super(nom, prenom, lieuNaissance, adresse, dateNaissance);
        this.numeroTelephone = numeroTelephone;
        this.diplome = diplome;
        this.profession = profession;
    }
    
    /**
     * Obtient le numéro de téléphone de l'adulte.
     * 
     * @return Le numéro de téléphone de l'adulte.
     */
    public String getNumeroTelephone() { return numeroTelephone; }

    /**
     * Modifie le numéro de téléphone de l'adulte.
     * 
     * @param numeroTelephone Le nouveau numéro de téléphone de l'adulte.
     */
    public void setNumeroTelephone(String numeroTelephone) { this.numeroTelephone = numeroTelephone; }

    /**
     * Obtient le diplôme de l'adulte.
     * 
     * @return Le diplôme de l'adulte.
     */
    public String getDiplome() { return diplome; }

    /**
     * Modifie le diplôme de l'adulte.
     * 
     * @param diplome Le nouveau diplôme de l'adulte.
     */
    public void setDiplome(String diplome) { this.diplome = diplome; }

    /**
     * Obtient la profession de l'adulte.
     * 
     * @return La profession de l'adulte.
     */
    public String getProfession() { return profession; }

    /**
     * Modifie la profession de l'adulte.
     * 
     * @param profession La nouvelle profession de l'adulte.
     */
    public void setProfession(String profession) { this.profession = profession; }
    
    /**
     * Retourne une chaîne de caractères représentant les informations de cet adulte,
     * incluant les informations de base du patient ainsi que son numéro de téléphone.
     * 
     * @return Une chaîne de caractères représentant les informations de cet adulte.
     */
    @Override
    public String getChaine() { return super.getChaine() + String.format("Contact : %s.", numeroTelephone); }
}
