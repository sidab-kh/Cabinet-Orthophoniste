package app.data.rendezvous;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import app.util.enumerations.ETypesRendezVous;

/**
 * La classe Atelier représente un rendez-vous de type atelier.
 * Elle étend la classe abstraite RendezVous et contient des informations spécifiques à un atelier, telles que la thématique et les numéros de dossiers associés.
 */
@SuppressWarnings("serial")
public class Atelier extends RendezVous {
    /** La thématique de l'atelier. */
    String thematique;
    
    /** Les numéros de dossiers associés à l'atelier. */
    List<Integer> numerosDossiers;
    
    /**
     * Constructeur pour créer un atelier avec une date et une durée spécifiées, ainsi que sa thématique et les numéros de dossiers associés.
     * 
     * @param dateEtHeure La date et l'heure de l'atelier.
     * @param duree La durée de l'atelier.
     * @param thematique La thématique de l'atelier.
     * @param numerosDossiers Les numéros de dossiers associés à l'atelier.
     */
    public Atelier(LocalDateTime dateEtHeure, Duration duree, String thematique, List<Integer> numerosDossiers) {
        super(dateEtHeure, duree);
        this.thematique = thematique;
        this.numerosDossiers = numerosDossiers;
    }
    
    /**
     * Obtient la thématique de l'atelier.
     * 
     * @return La thématique de l'atelier.
     */
    public String getThematique() { return thematique; }

    /**
     * Modifie la thématique de l'atelier.
     * 
     * @param thematique La nouvelle thématique de l'atelier.
     */
    public void setThematique(String thematique) { this.thematique = thematique; }

    /**
     * Obtient les numéros de dossiers associés à l'atelier.
     * 
     * @return Les numéros de dossiers associés à l'atelier.
     */
    public List<Integer> getNumerosDossiers() { return numerosDossiers; }

    /**
     * Modifie les numéros de dossiers associés à l'atelier.
     * 
     * @param numerosDossiers Les nouveaux numéros de dossiers associés à l'atelier.
     */
    public void setNumerosDossiers(List<Integer> numerosDossiers) { this.numerosDossiers = numerosDossiers; }

    /**
     * Obtient une chaîne représentant les informations de l'atelier.
     * 
     * @return Une chaîne représentant les informations de l'atelier.
     */
    @Override
    public String getChaine() {
        String numeros = "";
        for (int numeroDossier : numerosDossiers) { numeros += numeroDossier + " "; }
        return "Atelier / " + super.getChaine() + "thématique: " + thematique + ", numéros de dossiers : " + numeros;
    }
    
    /**
     * Obtient le type de rendez-vous, qui est ici un atelier.
     * 
     * @return Le type de rendez-vous, qui est un atelier.
     */
    public ETypesRendezVous getType() { return ETypesRendezVous.ATELIER; }
}
