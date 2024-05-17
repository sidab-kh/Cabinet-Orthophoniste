package patient;
import java.time.LocalDate;

public class Adulte extends Patient {
	String diplome, profession;

	public Adulte(String nom, String prenom, String lieuNaissance, String adresse, String numeroTelephone,
			LocalDate dateNaissance, String diplome, String profession) {
		super(nom, prenom, lieuNaissance, adresse, numeroTelephone, dateNaissance);
		this.diplome = diplome;
		this.profession = profession;
	}
}
