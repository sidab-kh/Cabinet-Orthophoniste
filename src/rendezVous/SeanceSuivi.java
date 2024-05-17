package rendezVous;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class SeanceSuivi extends RendezVous {
	int numeroDossier;
	boolean presentiel;
	
	// Constructeur
	public SeanceSuivi(LocalDateTime dateEtHeure, int numeroDossier, boolean presentiel) {
		super.dateEtHeure = dateEtHeure;
		this.numeroDossier = numeroDossier;
		this.presentiel = presentiel;
	}
}
