package app.data.patient;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Enfant extends Patient {
	String numeroTelephonePere, numeroTelephoneMere, niveauEtudes;
	
	// Constructeur
	public Enfant(String nom, String prenom, LocalDate dateNaissance, String lieuNaissance, String adresse,
			String numeroTelephonePere, String numeroTelephoneMere, String niveauEtudes) {
		super(nom, prenom, lieuNaissance, adresse, dateNaissance);
		this.numeroTelephonePere = numeroTelephonePere;
		this.numeroTelephoneMere = numeroTelephoneMere;
		this.niveauEtudes = niveauEtudes;
	}
	
	// Autres methodes
	public void afficher() {
		super.afficher();
		System.out.println(String.format("numero du papa: %s, numero de la maman: %s, niveau d'etudes: %s",
				numeroTelephonePere, numeroTelephoneMere, niveauEtudes));
	}
}