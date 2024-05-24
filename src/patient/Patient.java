package patient;

import java.time.LocalDate;
import java.time.Period;

import enumerations.ETypesPatients;

public abstract class Patient {
	private String nom, prenom, lieuNaissance, adresse, numeroTelephone;
	private LocalDate dateNaissance; // LocalDate plutot que Date
	
	// Constructeur
	public Patient(String nom, String prenom, String lieuNaissance, String adresse,
			String numeroTelephone, LocalDate dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.lieuNaissance = lieuNaissance;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.numeroTelephone = numeroTelephone;
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
	public String getNumeroTelephone() { return numeroTelephone; }
	public void setNumeroTelephone(String numeroTelephone) { this.numeroTelephone = numeroTelephone; }
	public LocalDate getDateNaissance() { return dateNaissance; }
	public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }
	
	// Autres methodes 
	public int getAge() {
		return Period.between(dateNaissance, LocalDate.now()).getYears();
	}
	
	public ETypesPatients getType() {
		return getAge()<18 ? ETypesPatients.ENFANT : ETypesPatients.ADULTE ;
	}
}