package app.data.rdv;
import java.time.Duration;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class SeanceSuivi extends RendezVous {
	int numeroDossier;
	boolean presentiel;
	
	// Constructeur
	public SeanceSuivi(LocalDateTime dateEtHeure, Duration duree, int numeroDossier, boolean presentiel) {
		super(dateEtHeure, duree);
		this.numeroDossier = numeroDossier;
		this.presentiel = presentiel;
	}
}