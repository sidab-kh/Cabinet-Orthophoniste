package fabriques;

import java.time.LocalDate;

import enumerations.ETypesPatients;
import patient.Adulte;
import patient.Enfant;
import patient.Patient;

// Patron de conception "Factory Method"
public class PatientFactory {

	// Permet de creer n'importe quel patient sans avoir a instancier avec le mot cle 'new'
    public static Patient creerPatient(ETypesPatients type, String nom, String prenom, String lieuNaissance, String adresse,
    		String numeroTelephone, LocalDate dateNaissance, String InformationsAdditionelles) {
        switch (type) {
            case ENFANT:
                if (InformationsAdditionelles == null || InformationsAdditionelles.isEmpty()) {
                    throw new IllegalArgumentException("Niveau d'etudes et numero de dossier mere requis pour l'enfant.");
                }
                String[] enfantInfo = InformationsAdditionelles.split(",");
                if (enfantInfo.length != 2) {
                    throw new IllegalArgumentException("Format invalide pour les informations d'enfant.");
                }
                String niveauEtudes = enfantInfo[0];
                int numeroMere;
                try {
                    numeroMere = Integer.parseInt(enfantInfo[1]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Numero de telephone mere invalide (doit etre un entier).");
                }
                return new Enfant(nom, prenom, lieuNaissance, adresse, numeroTelephone, dateNaissance, niveauEtudes, numeroMere);
            case ADULTE:
            	if (InformationsAdditionelles == null || InformationsAdditionelles.isEmpty()) {
                    throw new IllegalArgumentException("Diplome et profession requis pour Adulte.");
                }
                String[] adulteInfo = InformationsAdditionelles.split(",");
                if (adulteInfo.length != 2) {
                    throw new IllegalArgumentException("Format invalide pour les informations d'adulte.");
                }
                String diplome = adulteInfo[0];
                String profession = adulteInfo[1];
                return new Adulte(nom, prenom, lieuNaissance, adresse, numeroTelephone, dateNaissance, diplome, profession);
            default:
                throw new IllegalArgumentException("Type de patient invalide (doit etre 'enfant' ou 'adulte').");
        }
    }
}