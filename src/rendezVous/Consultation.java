package rendezVous;
import java.time.Duration;
import java.time.LocalDateTime;
import patient.Patient;

@SuppressWarnings("serial")
public class Consultation extends RendezVous {
	Patient patient;

	// Constructeur
	public Consultation(LocalDateTime dateEtHeure, Duration duree, Patient patient) {
		super(dateEtHeure, duree);
		this.patient = patient;
	}
}
