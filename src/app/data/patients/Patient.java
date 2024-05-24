package app.data.patients;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import app.util.Affichable;

@SuppressWarnings("serial")
public abstract class Patient implements Serializable, Affichable {
	private String nom, prenom, lieuNaissance, adresse;
	private LocalDate dateNaissance;
	
	// Constructeur
	public Patient(String nom, String prenom, String lieuNaissance, String adresse, LocalDate dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.lieuNaissance = lieuNaissance;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
	}
	
	// Getters et setters
	public String getNom() { return nom; }
	
	public void setNom(String nom) { this.nom = nom; }
	
	public String getPrenom() { return prenom; }
	
	public void setPrenom(String prenom) { this.prenom = prenom; }
	
	public String getLieuNaissance() { return lieuNaissance; }
	
	public void setLieuNaissance(String lieuNaissance) { this.lieuNaissance = lieuNaissance; }
	
	public String getAdresse() { return adresse; }
	
	public void setAdresse(String adresse) { this.adresse = adresse; }
	
	public LocalDate getDateNaissance() { return dateNaissance; }
	
	public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }
	
	// Autres methodes 
	public int getAge() { return Period.between(dateNaissance, LocalDate.now()).getYears(); }
	
	public void afficher() {
		System.out.print(String.format("- %s %s, date et lieu de naissance: %s %s, adresse: %s, ",
				nom, prenom, dateNaissance, lieuNaissance, adresse));
	}
	
	public ETypesPatients getType() {
		return getAge()<18 ? ETypesPatients.ENFANT : ETypesPatients.ADULTE ;
	}
}