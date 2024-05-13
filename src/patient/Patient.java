package patient;
import java.util.Date;

public abstract class Patient {
	String nom, prenom, lieuNaissance, adresse, numeroTelephone;
	Date dateNaissance;
	
	public Patient(String nom, String prenom, String lieuNaissance, String adresse,
			String numeroTelephone, Date dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.lieuNaissance = lieuNaissance;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.numeroTelephone = numeroTelephone;
	}
}
