package app.mvc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import app.data.bilans.Anamnese;
import app.data.patients.DossierPatient;
import app.data.patients.Patient;
import app.data.rendezvous.RendezVous;
import app.data.tests.Test;
import app.util.CryptageMotDePasse;

/**
 * La classe Orthophoniste représente un orthophoniste dans le système.
 * Elle contient des informations sur l'orthophoniste ainsi que des données relatives à son activité.
 */
@SuppressWarnings("serial")
public final class Orthophoniste implements Serializable {
    /** Le nom de l'orthophoniste. */
    private String nom;
    
    /** Le prénom de l'orthophoniste. */
    private String prenom;
    
    /** L'adresse de l'orthophoniste. */
    private String adresse;
    
    /** L'email de l'orthophoniste. */
    private String email;
    
    /** Le mot de passe crypté de l'orthophoniste. */
    private String motDePasseCrypte;
    
    /** Le numéro de téléphone de l'orthophoniste. */
    private String numeroTelephone;
    
    /** L'agenda de rendez-vous de l'orthophoniste. */
    List<RendezVous> agenda = new ArrayList<RendezVous>();
    
    /** Les dossiers patients de l'orthophoniste. */
    Set<DossierPatient> dossiersPatients = new TreeSet<DossierPatient>();
    
    /** Les nouveaux patients sans dossier. */
    List<Patient> nouveauxPatients = new ArrayList<Patient>();
    
    /** Les patients de l'orthophoniste, indexés par leur numéro de dossier. */
    Map<Integer, Patient> patients = new TreeMap<Integer, Patient>();
    
    /** Les anamnèses de l'orthophoniste. */
    List<Anamnese> anamneses = new ArrayList<Anamnese>();
    
    /** Les tests réalisés par l'orthophoniste. */
    List<Test> tests = new ArrayList<Test>();
    
    /**
     * Compteur pour générer automatiquement les numéros de dossier des patients.
     */
    private int compteurNumeroDossier;
    
    /** Constructeur par défaut. */
    public Orthophoniste() {}
    
    /**
     * Constructeur pour créer un objet Orthophoniste avec toutes les informations nécessaires.
     * 
     * @param nom Le nom de l'orthophoniste.
     * @param prenom Le prénom de l'orthophoniste.
     * @param adresse L'adresse de l'orthophoniste.
     * @param email L'email de l'orthophoniste.
     * @param motDePasse Le mot de passe non crypté de l'orthophoniste.
     * @param numeroTelephone Le numéro de téléphone de l'orthophoniste.
     */
    public Orthophoniste(String nom, String prenom, String adresse, String email, String motDePasse, String numeroTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.motDePasseCrypte = CryptageMotDePasse.crypter(motDePasse);
        this.numeroTelephone = numeroTelephone;
    }
    
    /**
     * Passe au prochain numéro de dossier.
     */
    public void incrementerCompteurNumeroDossier() { this.compteurNumeroDossier++; }
    
    /**
     * Obtient le compteur de numéro de dossiers.
     * 
     * @return le compteur de numéro de dossiers.
     */
    public int getCompteurNumeroDossier() { return this.compteurNumeroDossier; }
    
    /**
     * Obtient le nom de l'orthophoniste.
     * 
     * @return Le nom de l'orthophoniste.
     */
    public String getNom() { return this.nom; }
    
    /**
     * Obtient le prénom de l'orthophoniste.
     * 
     * @return Le prénom de l'orthophoniste.
     */
    public String getPrenom() { return this.prenom; }
    
    /**
     * Obtient l'adresse de l'orthophoniste.
     * 
     * @return L'adresse de l'orthophoniste.
     */
    public String getAdresse() { return adresse; }
    
    /**
     * Obtient l'email de l'orthophoniste.
     * 
     * @return L'email de l'orthophoniste.
     */
    public String getEmail() { return this.email; }
    
    /**
     * Obtient le mot de passe crypté de l'orthophoniste.
     * 
     * @return Le mot de passe crypté de l'orthophoniste.
     */
    String getMotDePasseCrypte() { return this.motDePasseCrypte; }
	
    /**
     * Crypte le mot de passe fourni à l'aide de l'algorithme de cryptage spécifié dans la classe CryptageMotDePasse.
     * 
     * @param motDePasse Le mot de passe à crypter.
     */
    void setMotDePasseCrypte(String motDePasse) { this.motDePasseCrypte = CryptageMotDePasse.crypter(motDePasse); }

    /**
     * Retourne le numéro de téléphone de l'orthophoniste.
     * 
     * @return Le numéro de téléphone de l'orthophoniste.
     */
    public String getNumeroTelephone() { return this.numeroTelephone; }
}