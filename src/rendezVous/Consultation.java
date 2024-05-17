package rendezVous;
import java.time.LocalDateTime;
import patient.Patient;

@SuppressWarnings("serial")
public class Consultation extends RendezVous {
	Patient patient;

	// Constructeur
	public Consultation(LocalDateTime dateEtHeure, Patient patient) {
		super.dateEtHeure = dateEtHeure;
		super.duree = patient.getClass().toString().equals("Adulte") ? "1h30" : "2h30";
		this.patient = patient;
	}
}
