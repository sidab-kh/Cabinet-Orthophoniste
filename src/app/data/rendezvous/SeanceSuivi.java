package app.data.rendezvous;

import java.time.Duration;
import java.time.LocalDateTime;

import app.util.enumerations.ETypesRendezVous;

/**
 * La classe SeanceSuivi représente une séance de suivi.
 * Elle étend la classe abstraite RendezVous et contient des informations spécifiques à une séance de suivi, telles que le numéro de dossier et le mode de déroulement (présentiel ou en ligne).
 */
@SuppressWarnings("serial")
public class SeanceSuivi extends RendezVous {
    /** Le numéro de dossier associé à la séance de suivi. */
    int numeroDossier;
    
    /** Un indicateur indiquant si la séance de suivi se déroule en présentiel ou en ligne. */
    boolean presentiel;
    
    /**
     * Constructeur pour créer une séance de suivi avec une date et une durée spécifiées, un numéro de dossier associé et un mode de déroulement (présentiel ou en ligne).
     * 
     * @param dateEtHeure La date et l'heure de la séance de suivi.
     * @param duree La durée de la séance de suivi.
     * @param numeroDossier Le numéro de dossier associé à la séance de suivi.
     * @param presentiel Un indicateur indiquant si la séance de suivi se déroule en présentiel (true) ou en ligne (false).
     */
    public SeanceSuivi(LocalDateTime dateEtHeure, Duration duree, int numeroDossier, boolean presentiel) {
        super(dateEtHeure, duree);
        this.numeroDossier = numeroDossier;
        this.presentiel = presentiel;
    }
    
    /**
     * Obtient le numéro de dossier associé à la séance de suivi.
     * 
     * @return Le numéro de dossier associé à la séance de suivi.
     */
    public int getNumeroDossier() { return numeroDossier; }
    
    /**
     * Modifie le numéro de dossier associé à la séance de suivi.
     * 
     * @param numeroDossier Le nouveau numéro de dossier associé à la séance de suivi.
     */
    public void setNumeroDossier(int numeroDossier) { this.numeroDossier = numeroDossier; }
    
    /**
     * Modifie le mode de déroulement de la séance de suivi (présentiel ou en ligne).
     * 
     * @param presentiel true si la séance se déroule en présentiel, false sinon.
     */
    public void setPresentiel(boolean presentiel) { this.presentiel = presentiel; }
    
    /**
     * Indique si la séance de suivi se déroule en présentiel ou en ligne.
     * 
     * @return true si la séance se déroule en présentiel, false sinon.
     */
    public boolean isPresentiel() { return this.presentiel; }

    /**
     * Obtient une chaîne représentant les informations de la séance de suivi.
     * 
     * @return Une chaîne représentant les informations de la séance de suivi.
     */
    @Override
    public String getChaine() { 
        return "Séance de suivi : " + super.getChaine() + String.format("numéro de dossier: %s, en %s.", numeroDossier, presentiel ? "présentiel" : "ligne"); 
    }
    
    /**
     * Obtient le type de rendez-vous, qui est ici une séance de suivi.
     * 
     * @return Le type de rendez-vous, qui est une séance de suivi.
     */
    public ETypesRendezVous getType() { return ETypesRendezVous.SEANCE_SUIVI; }
}
