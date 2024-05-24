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

@SuppressWarnings("serial")
public final class Orthophoniste implements Serializable {
	
	// Ces champs sont prives car ils sont confidentiels
	private String nom, prenom, adresse, email, motDePasseCrypte, numeroTelephone;
    
    // Ceux-ci sont en acces package puisqu'ils ne sont pas confidentiels et le Service Layer en a besoin constamment
    List<RendezVous> agenda = new ArrayList<RendezVous>();
    Set<DossierPatient> dossiersPatients = new TreeSet<DossierPatient>(); // Mis dans l'ordre pour faciliter la recherche
    List<Patient> nouveauxPatients = new ArrayList<Patient>(); // Pour y mettre les nouveaux patients qui n'ont pas encore de dossier
    Map<Integer, Patient> patients = new TreeMap<Integer, Patient>(); // Pour y mettre les patients avec comme cle leurs numeros de dossier
    List<Anamnese> anamneses = new ArrayList<Anamnese>();
    List<Test> tests = new ArrayList<Test>();
    
    // Constructeur par defaut
    public Orthophoniste() {}
    
    // Constructeur
	public Orthophoniste(String nom, String prenom, String adresse, String email, String motDePasse, String numeroTelephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.motDePasseCrypte = CryptageMotDePasse.crypter(motDePasse);
		this.numeroTelephone = numeroTelephone;
	}
	
    // Getters et setters
	public String getNom() { return nom; }
	public String getPrenom() { return prenom; }
	public String getAdresse() { return adresse; }
	public String getEmail() { return email; }
	String getMotDePasseCrypte() { return motDePasseCrypte; }
	void setMotDePasseCrypte(String motDePasse) { this.motDePasseCrypte = CryptageMotDePasse.crypter(motDePasse); }
	public String getNumeroTelephone() { return numeroTelephone; }
}