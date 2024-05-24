package app.data.rendezvous;
import java.time.Duration;
import java.time.LocalDateTime;

import app.util.enumerations.ETypesRendezVous;

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
	
	// Getters et setters
	public int getNumeroDossier() { return numeroDossier; }

	public void setNumeroDossier(int numeroDossier) { this.numeroDossier = numeroDossier; }

	public boolean isPresentiel() { return presentiel; }

	public void setPresentiel(boolean presentiel) { this.presentiel = presentiel; }

	// Autres methodes
	public String rdvString() { return "- Séance de suivi / " + super.rdvString() + String.format("Numero dossier: %s, en %s.", numeroDossier, presentiel ? "présentiel" : "ligne"); }
	
	public ETypesRendezVous getType() { return ETypesRendezVous.SEANCE_SUIVI; }
}