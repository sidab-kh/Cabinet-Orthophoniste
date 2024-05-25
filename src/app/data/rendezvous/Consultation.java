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
	
	// Getters et setters
	public Patient getPatient() { return patient; };
	
	// Autres methodes
	@Override
	public String getChaine() { return "Consultation / " + super.getChaine() + String.format("avec %s %s.", patient.getNom(), patient.getPrenom()); }

	public ETypesRendezVous getType() { return ETypesRendezVous.CONSULTATION; }
}
