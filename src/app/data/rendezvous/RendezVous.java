package app.data.rendezvous;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

import app.util.Affichable;
import app.util.enumerations.ETypesRendezVous;

// Sous-classes : Atelier, Consultation, SeanceSuivi
@SuppressWarnings("serial")
public abstract class RendezVous implements Serializable, Affichable {
	LocalDateTime dateEtHeure;
	Duration duree = Duration.ofHours(1);
    String observation = ""; 

    // Constructeur
	public RendezVous(LocalDateTime dateEtHeure, Duration duree) {
		this.dateEtHeure = dateEtHeure;
		this.duree = duree;
	}
	
	// Getters et setters
	public LocalDateTime getDateEtHeure() { return dateEtHeure; }
	public void setDateEtHeure(LocalDateTime dateEtHeure) { this.dateEtHeure = dateEtHeure; }
	public Duration getDuree() { return duree; }
	public String getObservation() { return observation; }
	public void setObservation(String observation) { this.observation = observation; }
	
	// Autres methodes
	public LocalDateTime calculerHeureFin() {
	    return dateEtHeure.plus(duree);
	}

	@Override
	public String getChaine() { return String.format("Le %s à %s, durée: %s, ", dateEtHeure.toLocalDate(), dateEtHeure.toLocalTime(), duree); }
	
	public abstract ETypesRendezVous getType();
}