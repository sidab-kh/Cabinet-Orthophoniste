package app.data.rdv;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

// Sous-classes: Atelier, Consultation, SeanceSuivi
@SuppressWarnings("serial")
public abstract class RendezVous implements Serializable {
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
}