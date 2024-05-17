package rendezVous;
import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public abstract class RendezVous implements Serializable {
	LocalDateTime dateEtHeure; // LocalDateTime est moderne et contient des informations sur la date et l'heure en meme temps
	String duree = "1h"; // 1h par defaut 
    String observation = ""; 

	// Ecrire une observation apres la fin d'un rendez vous (sera probablement deplacee vers le controlleur)
	public void ajouterObservation(String observation) {
		this.observation = observation;
	}
}