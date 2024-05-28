package app.data.rendezvous;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

import app.util.Affichable;
import app.util.enumerations.ETypesRendezVous;

/**
 * La classe abstraite RendezVous représente un rendez-vous.
 * Elle contient des informations telles que la date et l'heure du rendez-vous, sa durée et une observation éventuelle.
 */
@SuppressWarnings("serial")
public abstract class RendezVous implements Serializable, Affichable {
    /** La date et l'heure du rendez-vous. */
    LocalDateTime dateEtHeure;
    
    /** La durée du rendez-vous. */
    Duration duree = Duration.ofHours(1);
    
    /** Une observation ou un commentaire associé au rendez-vous. */
    String observation = ""; 

    /**
     * Constructeur pour créer un rendez-vous avec une date et une durée spécifiées.
     * 
     * @param dateEtHeure La date et l'heure du rendez-vous.
     * @param duree La durée du rendez-vous.
     */
    public RendezVous(LocalDateTime dateEtHeure, Duration duree) {
        this.dateEtHeure = dateEtHeure;
        this.duree = duree;
    }
    
    /**
     * Obtient la date et l'heure du rendez-vous.
     * 
     * @return La date et l'heure du rendez-vous.
     */
    public LocalDateTime getDateEtHeure() { return dateEtHeure; }
    
    /**
     * Modifie la date et l'heure du rendez-vous.
     * 
     * @param dateEtHeure La nouvelle date et heure du rendez-vous.
     */
    public void setDateEtHeure(LocalDateTime dateEtHeure) { this.dateEtHeure = dateEtHeure; }
    
    /**
     * Obtient la durée du rendez-vous.
     * 
     * @return La durée du rendez-vous.
     */
    public Duration getDuree() { return duree; }
    
    /**
     * Obtient l'observation associée au rendez-vous.
     * 
     * @return L'observation associée au rendez-vous si non vide, "Aucune" sinon.
     */
    public String getObservation() { 
    	if (observation.isEmpty()) return "Aucune";
    	return observation;
    }
    
    /**
     * Modifie l'observation ou le commentaire associé au rendez-vous.
     * 
     * @param observation La nouvelle observation ou commentaire.
     */
    public void setObservation(String observation) { this.observation = observation; }
    
    /**
     * Calcule l'heure de fin du rendez-vous en ajoutant la durée au moment du rendez-vous.
     * 
     * @return L'heure de fin du rendez-vous.
     */
    public LocalDateTime calculerHeureFin() { return dateEtHeure.plus(duree); }

    /**
     * Obtient le type du rendez-vous.
     * 
     * @return Le type du rendez-vous.
     */
    public abstract ETypesRendezVous getType();
    
    /**
     * Obtient une chaîne représentant les informations du rendez-vous.
     * 
     * @return Une chaîne représentant les informations du rendez-vous.
     */
    @Override
    public String getChaine() { return String.format("Le %s à %s, durée : %s, ", dateEtHeure.toLocalDate(), dateEtHeure.toLocalTime(), duree); }
}
