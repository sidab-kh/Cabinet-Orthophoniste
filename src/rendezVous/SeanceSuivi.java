package rendezVous;
import java.util.Date;

public class SeanceSuivi extends RendezVous {
	int numeroDossier;
	boolean presentiel;
	
	public SeanceSuivi(Date date, int numeroDossier, boolean presentiel) {
		super.date = date;
		this.numeroDossier = numeroDossier;
		this.presentiel = presentiel;
	}
}
