package patient;
import java.time.LocalDate;

public class Enfant extends Patient {
	String niveauEtudes, numeroTelephoneMere;
	
	public Enfant(String nom, String prenom, String lieuNaissance, String adresse, LocalDate dateNaissance, 
			String numeroTelephonePere, String numeroTelephoneMere, String niveauEtudes) {
		super(nom, prenom, lieuNaissance, adresse, numeroTelephonePere, dateNaissance);
		this.numeroTelephoneMere = numeroTelephoneMere;
		this.niveauEtudes = niveauEtudes;
	}
}
