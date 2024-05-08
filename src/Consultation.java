import java.util.Date;

public class Consultation extends RendezVous {
	Patient patient;

	public Consultation(Date date, Patient patient) {
		super.duree = patient.getClass().toString().equals("Adulte") ? "1h30" : "2h30";
		super.date = date;
		this.patient = patient;
	}
}
