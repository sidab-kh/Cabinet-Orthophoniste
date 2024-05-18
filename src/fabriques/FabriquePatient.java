package fabriques;

import java.time.LocalDate;

import patient.Adulte;
import patient.Enfant;

// Patron de conception "Factory Method"
public class FabriquePatient {

	// Creer un patient de type Enfant
    public static Enfant creerEnfant(String nom, String prenom, String lieuNaissance, String adresse, LocalDate dateNaissance,
    		String numeroTelephonePere, String numeroTelephoneMere, String niveauEtudes) {
	    return new Enfant(nom, prenom, lieuNaissance, adresse, dateNaissance, numeroTelephonePere, numeroTelephoneMere, niveauEtudes);
    }

	// Creer un patient de type Adulte
	public static Adulte creerAdulte(String nom, String prenom, String lieuNaissance, String adresse,
			String numeroTelephone, LocalDate dateNaissance, String diplome, String profession) {
	    return new Adulte(nom, prenom, lieuNaissance, adresse, numeroTelephone, dateNaissance, diplome, profession);
	}
}