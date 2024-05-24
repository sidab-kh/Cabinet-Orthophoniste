package app.data.rendezvous;
import java.time.Duration;
import java.time.LocalDateTime;

import app.data.patients.Patient;
import app.util.enumerations.ETypesRendezVous;

@SuppressWarnings("serial")
public class Consultation extends RendezVous {
	Patient patient;

	// Constructeur
	public Consultation(LocalDateTime dateEtHeure, Duration duree, Patient patient) {
		super(dateEtHeure, duree);
		this.patient = patient;
	}
	
	// Autres methodes
	public String rdvString() { return "- Consultation / " + super.rdvString() + String.format("Avec %s %s.", patient.getNom(), patient.getPrenom()); }

	public ETypesRendezVous getType() { return ETypesRendezVous.CONSULTATION; }
	
	public Patient getPatient() { return patient; };
}
