package app.data.patient;
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
	
	// Autres methodes
	public void afficher() {
		super.afficher();
		System.out.println(String.format("numero de telephone: %s, diplome: %s, profession: %s",
				numeroTelephone, diplome, profession));
	}
}