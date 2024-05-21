package app.util.fabrique;

import java.time.LocalDate;

import app.data.patient.Adulte;
import app.data.patient.Enfant;

// Patron de conception "Factory Method", sert a encapsuler les instanciations
public class FabriquePatient {

	// Creer un patient de type Enfant
    public static Enfant creerEnfant(String nom, String prenom, LocalDate dateNaissance, String lieuNaissance, String adresse,
    		String numeroTelephonePere, String numeroTelephoneMere, String niveauEtudes) {
	    return new Enfant(nom, prenom, dateNaissance, lieuNaissance, adresse, numeroTelephonePere, numeroTelephoneMere, niveauEtudes);
    }

	// Creer un patient de type Adulte
	public static Adulte creerAdulte(String nom, String prenom, LocalDate dateNaissance, String lieuNaissance, String adresse,
			String numeroTelephone, String diplome, String profession) {
	    return new Adulte(nom, prenom, dateNaissance, lieuNaissance, adresse, numeroTelephone, diplome, profession);
	}
}