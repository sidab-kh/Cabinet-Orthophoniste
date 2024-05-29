package app.util.fabriques;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import app.data.patients.Patient;
import app.data.rendezvous.Atelier;
import app.data.rendezvous.Consultation;
import app.data.rendezvous.SeanceSuivi;

/**
 * Cette classe représente une fabrique pour créer des instances de rendez-vous.
 * Elle utilise le patron de conception "Factory Method" pour encapsuler les instanciations.
 */
public class FabriqueRendezVous {

    /**
     * Crée et retourne un rendez-vous de type Consultation avec les informations spécifiées.
     * 
     * @param dateEtHeure La date et l'heure de la consultation.
     * @param patient Le patient associé à la consultation.
     * @return Un nouvel objet de type Consultation.
     */
    public static Consultation creerConsultation(LocalDateTime dateEtHeure, Patient patient) {
        if (patient.getAge() < 18)
            return new Consultation(dateEtHeure, Duration.ofHours(2).plusMinutes(30), patient);
        else
            return new Consultation(dateEtHeure, Duration.ofHours(1).plusMinutes(30), patient);
    }
    
    /**
     * Crée et retourne un rendez-vous de type Séance de Suivi avec les informations spécifiées.
     * 
     * @param dateEtHeure La date et l'heure de la séance de suivi.
     * @param numeroDossier Le numéro de dossier du patient pour la séance.
     * @param presentiel Indique si la séance est en présentiel ou en ligne.
     * @return Un nouvel objet de type SeanceSuivi.
     */
    public static SeanceSuivi creerSeanceSuivi(LocalDateTime dateEtHeure, int numeroDossier, boolean presentiel) {
        return new SeanceSuivi(dateEtHeure, Duration.ofHours(1), numeroDossier, presentiel);
    }
    
    /**
     * Crée et retourne un rendez-vous de type Atelier avec les informations spécifiées.
     * 
     * @param dateEtHeure La date et l'heure de l'atelier.
     * @param thematique La thématique de l'atelier.
     * @param numerosDossiers La liste des numéros de dossier des participants à l'atelier.
     * @return Un nouvel objet de type Atelier.
     */
    public static Atelier creerAtelier(LocalDateTime dateEtHeure, String thematique, List<Integer> numerosDossiers) {
        return new Atelier(dateEtHeure, Duration.ofHours(1), thematique, numerosDossiers);
    }
}