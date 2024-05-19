package app.mvc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import app.data.patient.DossierPatient;
import app.data.patient.Patient;
import app.data.rdv.RendezVous;

// Cette classe joue le role de "Model" dans l'architecture MVC
// Contient les donnees de l'orthophoniste
@SuppressWarnings("serial")
public final class Orthophoniste implements Serializable {
	
	// Ces champs sont prives car ils sont confidentiels
	private String nom, prenom, adresse, email, motDePasse;
    private int numeroTelephone;
    
    // Ceux-ci sont en acces package puisqu'ils ne sont pas confidentiels et le Service Layer en a besoin constamment
    List<RendezVous> agenda = new ArrayList<RendezVous>();
    Set<DossierPatient> dossiersPatients = new TreeSet<DossierPatient>(); // Mis dans l'ordre pour faciliter la recherche
    List<Patient> nouveauxPatients = new ArrayList<Patient>(); // Pour y mettre les nouveaux patients qui n'ont pas encore de dossier
    Map<Integer, Patient> patients = new TreeMap<Integer, Patient>(); // Pour y mettre les patients avec comme cle leurs numeros de dossier
    
    // Constructeur par defaut
    public Orthophoniste() {}
    
    // Constructeur
	public Orthophoniste(String nom, String prenom, String adresse, String email, String motDePasse, int numeroTelephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.motDePasse = motDePasse;
		this.numeroTelephone = numeroTelephone;
	}

    // Getters et setters
	String getNom() { return nom; }
	String getPrenom() { return prenom; }
	String getAdresse() { return adresse; }
	void setAdresse(String adresse) { this.adresse = adresse;	}
	String getEmail() { return email; }
	void setEmail(String email) { this.email = email; }
	String getMotDePasse() { return motDePasse; }
	void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
	int getNumeroTelephone() { return numeroTelephone; }
	void setNumeroTelephone(int numeroTelephone) { this.numeroTelephone = numeroTelephone; }
}