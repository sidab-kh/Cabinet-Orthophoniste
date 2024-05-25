package app.util.fabriques;

import java.time.LocalDate;

import app.data.patients.Adulte;
import app.data.patients.Enfant;

/**
 * Cette classe représente une fabrique pour créer des instances de patients.
 * Elle utilise le patron de conception "Factory Method" pour encapsuler les instanciations.
 */
public class FabriquePatient {

    /**
     * Crée et retourne un patient de type Enfant avec les informations spécifiées.
     * 
     * @param nom Le nom de l'enfant.
     * @param prenom Le prénom de l'enfant.
     * @param dateNaissance La date de naissance de l'enfant.
     * @param lieuNaissance Le lieu de naissance de l'enfant.
     * @param adresse L'adresse de l'enfant.
     * @param numeroTelephonePere Le numéro de téléphone du père de l'enfant.
     * @param numeroTelephoneMere Le numéro de téléphone de la mère de l'enfant.
     * @param niveauEtudes Le niveau d'études de l'enfant.
     * @return Un nouvel objet de type Enfant.
     */
    public static Enfant creerEnfant(String nom, String prenom, LocalDate dateNaissance, String lieuNaissance, String adresse,
            String numeroTelephonePere, String numeroTelephoneMere, String niveauEtudes) {
        return new Enfant(nom, prenom, dateNaissance, lieuNaissance, adresse, numeroTelephonePere, numeroTelephoneMere, niveauEtudes);
    }

    /**
     * Crée et retourne un patient de type Adulte avec les informations spécifiées.
     * 
     * @param nom Le nom de l'adulte.
     * @param prenom Le prénom de l'adulte.
     * @param dateNaissance La date de naissance de l'adulte.
     * @param lieuNaissance Le lieu de naissance de l'adulte.
     * @param adresse L'adresse de l'adulte.
     * @param numeroTelephone Le numéro de téléphone de l'adulte.
     * @param diplome Le diplôme de l'adulte.
     * @param profession La profession de l'adulte.
     * @return Un nouvel objet de type Adulte.
     */
    public static Adulte creerAdulte(String nom, String prenom, LocalDate dateNaissance, String lieuNaissance, String adresse,
            String numeroTelephone, String diplome, String profession) {
        return new Adulte(nom, prenom, dateNaissance, lieuNaissance, adresse, numeroTelephone, diplome, profession);
    }
}
