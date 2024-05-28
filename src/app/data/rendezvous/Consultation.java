package app.data.rendezvous;

import java.time.Duration;
import java.time.LocalDateTime;

import app.data.patients.Patient;
import app.util.enumerations.ETypesRendezVous;

/**
 * La classe Consultation représente une consultation avec un patient.
 * Elle étend la classe abstraite RendezVous et contient des informations spécifiques à une consultation, telles que le patient concerné.
 */
@SuppressWarnings("serial")
public class Consultation extends RendezVous {
    /** Le patient concerné par la consultation. */
    Patient patient;

    /**
     * Constructeur pour créer une consultation avec une date et une durée spécifiées, et le patient concerné.
     * 
     * @param dateEtHeure La date et l'heure de la consultation.
     * @param duree La durée de la consultation.
     * @param patient Le patient concerné par la consultation.
     */
    public Consultation(LocalDateTime dateEtHeure, Duration duree, Patient patient) {
        super(dateEtHeure, duree);
        this.patient = patient;
    }
    
    /**
     * Obtient le patient concerné par la consultation.
     * 
     * @return Le patient concerné par la consultation.
     */
    public Patient getPatient() { return patient; };
    
    /**
     * Obtient une chaîne représentant les informations de la consultation.
     * 
     * @return Une chaîne représentant les informations de la consultation.
     */
    @Override
    public String getChaine() { 
        return "Consultation : " + super.getChaine() + String.format("avec %s %s.", patient.getNom(), patient.getPrenom()); 
    }

    /**
     * Obtient le type de rendez-vous, qui est ici une consultation.
     * 
     * @return Le type de rendez-vous, qui est une consultation.
     */
    public ETypesRendezVous getType() { return ETypesRendezVous.CONSULTATION; }
}
