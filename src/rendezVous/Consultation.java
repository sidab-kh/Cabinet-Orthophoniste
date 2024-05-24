package rendezVous;
import java.time.Duration;
import java.time.LocalDateTime;

import enumerations.ETypesRendezVous;
import patient.Patient;

@SuppressWarnings("serial")
public class Consultation extends RendezVous {
	Patient patient;

	// Constructeur
	public Consultation(LocalDateTime dateEtHeure, Duration duree, Patient patient) {
		super(dateEtHeure, duree);
		this.patient = patient;
	}

	public ETypesRendezVous getType() { return ETypesRendezVous.CONSULTATION; }
	
	public Patient getPatient() { return patient; };
	
}
