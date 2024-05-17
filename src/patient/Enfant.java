package patient;
import java.time.LocalDate;

public class Enfant extends Patient {
	String niveauEtudes;
	int numeroMere;
	
	public Enfant(String nom, String prenom, String lieuNaissance, String adresse, String numeroTelephone,
			LocalDate dateNaissance, String niveauEtudes, int numeroMere) {
		super(nom, prenom, lieuNaissance, adresse, numeroTelephone, dateNaissance);
		this.niveauEtudes = niveauEtudes;
		this.numeroMere = numeroMere;
	}
}
