package app.data.rdv;
import java.time.Duration;
import java.time.LocalDateTime;

import app.data.patient.Patient;

@SuppressWarnings("serial")
public class Consultation extends RendezVous {
	Patient patient;

	// Constructeur
	public Consultation(LocalDateTime dateEtHeure, Duration duree, Patient patient) {
		super(dateEtHeure, duree);
		this.patient = patient;
	}
	
	// Autres methodes
	public void afficher() {
		System.out.print("- Consultation/ ");
		super.afficher();
		System.out.println(String.format("Avec %s %s.", patient.getNom(), patient.getPrenom()));
	}
}