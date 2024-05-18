package rendezVous;
import java.time.Duration;
import java.time.LocalDateTime;
import patient.Patient;

@SuppressWarnings("serial")
public class Consultation extends RendezVous {
	Patient patient;

	// Constructeur
	public Consultation(LocalDateTime dateEtHeure, Patient patient) {
		super.dateEtHeure = dateEtHeure;
		super.duree = patient.getClass().toString().equals("Adulte") ? Duration.ofHours(1).plusMinutes(30) : Duration.ofHours(2).plusMinutes(30);;
		this.patient = patient;
	}
}
