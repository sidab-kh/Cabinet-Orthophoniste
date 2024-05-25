package app.data.patients;

import java.time.LocalDate;

@SuppressWarnings("serial")
public class Adulte extends Patient {
	String numeroTelephone, diplome, profession;

	// Constructeur
	public Adulte(String nom, String prenom, LocalDate dateNaissance, String lieuNaissance, String adresse,
			String numeroTelephone, String diplome, String profession) {
		super(nom, prenom, lieuNaissance, adresse, dateNaissance);
		this.numeroTelephone = numeroTelephone;
		this.diplome = diplome;
		this.profession = profession;
	}
	
	// Getters et setters
	public String getNumeroTelephone() { return numeroTelephone; }

	public void setNumeroTelephone(String numeroTelephone) { this.numeroTelephone = numeroTelephone; }

	public String getDiplome() { return diplome; }

	public void setDiplome(String diplome) { this.diplome = diplome; }

	public String getProfession() { return profession; }

	public void setProfession(String profession) { this.profession = profession; }
	
	// Autres methodes
	@Override
	public String getChaine() { return super.getChaine() + String.format("Contact : %s.", numeroTelephone); }
}