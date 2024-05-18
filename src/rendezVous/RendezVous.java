package rendezVous;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public abstract class RendezVous implements Serializable {
	LocalDateTime dateEtHeure; // LocalDateTime est moderne et contient des informations sur la date et l'heure en meme temps
	Duration duree = Duration.ofHours(1);
    String observation = ""; 

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