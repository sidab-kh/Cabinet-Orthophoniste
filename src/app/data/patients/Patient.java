package app.data.patients;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import app.util.Affichable;
import app.util.enumerations.ETypesPatients;

@SuppressWarnings("serial")
public abstract class Patient implements Serializable, Affichable {
	public static int compteurPatients = 0;
	private String nom, prenom, lieuNaissance, adresse;
	private LocalDate dateNaissance;
	private int indicePatient;
	
	// Constructeur
	public Patient(String nom, String prenom, String lieuNaissance, String adresse, LocalDate dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.lieuNaissance = lieuNaissance;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		indicePatient = compteurPatients;
		compteurPatients++;
	}
	
	// Getters et setters
	public int getIndicePatient() { return indicePatient; }
	
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
	// Calculer l'age du patient
	public int getAge() { return Period.between(dateNaissance, LocalDate.now()).getYears(); }
	
	@Override
	public String getChaine() { return String.format("%s %s, %s, ", nom, prenom, dateNaissance); }
	
	// Retourner le type du patient
	public ETypesPatients getType() { return getAge() < 18 ? ETypesPatients.ENFANT : ETypesPatients.ADULTE ; }
}