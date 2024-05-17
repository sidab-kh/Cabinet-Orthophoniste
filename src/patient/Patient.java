package patient;
import java.time.LocalDate;

public abstract class Patient {
	String nom, prenom, lieuNaissance, adresse, numeroTelephone;
	LocalDate dateNaissance; // LocalDate plutot que Date
	
	public Patient(String nom, String prenom, String lieuNaissance, String adresse,
			String numeroTelephone, LocalDate dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.lieuNaissance = lieuNaissance;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.numeroTelephone = numeroTelephone;
	}
}