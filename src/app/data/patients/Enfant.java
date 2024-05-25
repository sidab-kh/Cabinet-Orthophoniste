package app.data.patients;
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
	
	// Getters et setters
	public String getNumeroTelephonePere() { return numeroTelephonePere; }

	public void setNumeroTelephonePere(String numeroTelephonePere) { this.numeroTelephonePere = numeroTelephonePere; }

	public String getNumeroTelephoneMere() { return numeroTelephoneMere; }

	public void setNumeroTelephoneMere(String numeroTelephoneMere) { this.numeroTelephoneMere = numeroTelephoneMere; }

	public String getNiveauEtudes() { return niveauEtudes; }

	public void setNiveauEtudes(String niveauEtudes) { this.niveauEtudes = niveauEtudes; }
	
	// Autres methodes
	@Override
	public String getChaine() { return super.getChaine() + String.format("Contact : %s, %s.", numeroTelephonePere, numeroTelephoneMere); }
}