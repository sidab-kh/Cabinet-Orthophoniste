package app.data.patients;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import app.data.bilans.BilanOrthophonique;
import app.util.Affichable;
import app.util.enumerations.ETypesPatients;

/**
 * La classe abstraite Patient représente un patient.
 * Elle implémente les interfaces Serializable et Affichable et fournit des fonctionnalités de base communes à tous les types de patients.
 * Les sous-classes telles que Enfant et Adulte ajoutent des informations spécifiques à chaque type de patient.
 */
@SuppressWarnings("serial")
public abstract class Patient implements Serializable, Affichable {
    /** Compteur pour générer automatiquement l'indice des patients. */
    public static int compteurPatients = 0;
    
    /** Le nom du patient. */
    private String nom;
    
    /** Le prénom du patient. */
    private String prenom;
    
    /** Le lieu de naissance du patient. */
    private String lieuNaissance;
    
    /** L'adresse du patient. */
    private String adresse;
    
    /** La date de naissance du patient. */
    private LocalDate dateNaissance;
    
    /** L'indice du patient. */
    private int indicePatient;
    
    /** Premier bilan orthophonique. */
    private BilanOrthophonique premierBo;
    
    /**
     * Constructeur pour créer un objet Patient avec les informations de base.
     * 
     * @param nom Le nom du patient.
     * @param prenom Le prénom du patient.
     * @param lieuNaissance Le lieu de naissance du patient.
     * @param adresse L'adresse du patient.
     * @param dateNaissance La date de naissance du patient.
     */
    public Patient(String nom, String prenom, String lieuNaissance, String adresse, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.lieuNaissance = lieuNaissance;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        indicePatient = compteurPatients;
        compteurPatients++;
    }
    
    /**
     * Obtient l'indice du patient.
     * 
     * @return L'indice du patient.
     */
    public int getIndicePatient() { return indicePatient; }
    
    /**
     * Obtient le nom du patient.
     * 
     * @return Le nom du patient.
     */
    public String getNom() { return nom; }
    
    /**
     * Modifie le nom du patient.
     * 
     * @param nom Le nouveau nom du patient.
     */
    public void setNom(String nom) { this.nom = nom; }
    
    /**
     * Obtient le prénom du patient.
     * 
     * @return Le prénom du patient.
     */
    public String getPrenom() { return prenom; }
    
    /**
     * Modifie le prénom du patient.
     * 
     * @param prenom Le nouveau prénom du patient.
     */
    public void setPrenom(String prenom) { this.prenom = prenom; }
    
    /**
     * Obtient le lieu de naissance du patient.
     * 
     * @return Le lieu de naissance du patient.
     */
    public String getLieuNaissance() { return lieuNaissance; }
    
    /**
     * Modifie le lieu de naissance du patient.
     * 
     * @param lieuNaissance Le nouveau lieu de naissance du patient.
     */
    public void setLieuNaissance(String lieuNaissance) { this.lieuNaissance = lieuNaissance; }
    
    /**
     * Obtient l'adresse du patient.
     * 
     * @return L'adresse du patient.
     */
    public String getAdresse() { return adresse; }
    
    /**
     * Modifie l'adresse du patient.
     * 
     * @param adresse La nouvelle adresse du patient.
     */
    public void setAdresse(String adresse) { this.adresse = adresse; }
    
    /**
     * Obtient la date de naissance du patient.
     * 
     * @return La date de naissance du patient.
     */
    public LocalDate getDateNaissance() { return dateNaissance; }
    
    /**
     * Modifie la date de naissance du patient.
     * 
     * @param dateNaissance La nouvelle date de naissance du patient.
     */
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }

    /**
     * Calcule l'âge du patient.
     * 
     * @return L'âge du patient en années.
     */
    public int getAge() { return Period.between(dateNaissance, LocalDate.now()).getYears(); }
	
    /**
     * Retourne une chaîne de caractères représentant les informations de ce patient.
     * 
     * @return Une chaîne de caractères représentant les informations de ce patient.
     */
    @Override
    public String getChaine() { return String.format("%s %s, %s, ", nom, prenom, dateNaissance); }
    
    /**
     * Retourne le type du patient en fonction de son âge.
     * 
     * @return Le type du patient : ENFANT si l'âge est inférieur à 18 ans, sinon ADULTE.
     */
    public ETypesPatients getType() { return getAge() < 18 ? ETypesPatients.ENFANT : ETypesPatients.ADULTE ; }

    /**
     * Obtient le premier bilan orthophonique du patient.
     * 
     * @return Le premier bilan orthophonique du patient, ou null s'il n'y a pas de bilan enregistré.
     */
    public BilanOrthophonique getPremierBo() { return premierBo; }

    /**
     * Modifie le premier bilan orthophonique du patient.
     * 
     * @param premierBo Le nouveau premier bilan orthophonique du patient.
     */
    public void setPremierBo(BilanOrthophonique premierBo) { this.premierBo = premierBo; }
}
