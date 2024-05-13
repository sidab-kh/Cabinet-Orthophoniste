package patient;
import java.util.Date;

public class Adulte extends Patient {
	String diplome, profession;

	public Adulte(String nom, String prenom, String lieuNaissance, String adresse, String numeroTelephone,
			Date dateNaissance, String diplome, String profession) {
		super(nom, prenom, lieuNaissance, adresse, numeroTelephone, dateNaissance);
		this.diplome = diplome;
		this.profession = profession;
	}
}
