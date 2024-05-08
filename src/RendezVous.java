import java.util.Date;

public abstract class RendezVous {
	Date date;
	String duree = "1h", observation = "";
	
	public void ajouterObservation(String observation) {
		this.observation = observation;
	}
}
