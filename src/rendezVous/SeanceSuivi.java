package rendezVous;
import java.time.Duration;
import java.time.LocalDateTime;

import enumerations.ETypesRendezVous;

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

	public ETypesRendezVous getType() { return ETypesRendezVous.SEANCESUIVI; }
}