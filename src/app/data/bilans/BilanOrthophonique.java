package app.data.bilans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import app.util.Affichable;

/**
 * La classe BilanOrthophonique représente un bilan orthophonique effectué pour un patient.
 * Elle contient une anamnèse, une liste d'épreuves cliniques, un diagnostic et un projet thérapeutique.
 */
@SuppressWarnings("serial")
public class BilanOrthophonique implements Serializable, Affichable {
    /** L'anamnèse associée au bilan orthophonique. */
    Anamnese anamnese;
    
    /** La liste des épreuves cliniques réalisées dans le cadre du bilan orthophonique. */
    List<EpreuveClinique> epreuvesCliniques;
    
    /** Le diagnostic établi à partir du bilan orthophonique. */
    Diagnostic diagnostic;
    
    /** Le projet thérapeutique recommandé à partir du bilan orthophonique. */
    String projetTherapeutique;
    
    /**
     * Constructeur pour créer un bilan orthophonique sans anamnèse ni diagnostic.
     * Ce constructeur est utilisé lorsque ce bilan orthophonique n'est pas le premier pour le patient.
     */
    public BilanOrthophonique() { this(null); }
    
    /**
     * Constructeur pour créer un premier bilan orthophonique avec une anamnèse spécifiée.
     * 
     * @param anamnese L'anamnèse associée au bilan orthophonique.
     */
    public BilanOrthophonique(Anamnese anamnese) {
        this.anamnese = anamnese;
        this.epreuvesCliniques = new ArrayList<>();
        this.diagnostic = null;
        this.projetTherapeutique = null;
    }

    /**
     * Ajoute une anamnèse au bilan orthophonique.
     * 
     * @param anamnese L'anamnèse à ajouter.
     */
    public void ajouterAnamnese(Anamnese anamnese) { this.anamnese = anamnese; }
    
    /**
     * Ajoute une épreuve clinique à la liste des épreuves cliniques du bilan orthophonique.
     * 
     * @param epreuveClinique L'épreuve clinique à ajouter.
     */
    public void ajouterEpreuveClinique(EpreuveClinique epreuveClinique) { this.epreuvesCliniques.add(epreuveClinique); }
    
    /**
     * Définit le diagnostic du bilan orthophonique.
     * 
     * @param diagnostic Le diagnostic établi.
     */
    public void ajouterDiagnostic(Diagnostic diagnostic) { this.diagnostic = diagnostic; }
    
    /**
     * Définit le projet thérapeutique recommandé à partir du bilan orthophonique.
     * 
     * @param projetTherapeutique Le projet thérapeutique recommandé.
     */
    public void ajouterProjetTherapeutique(String projetTherapeutique) { this.projetTherapeutique = projetTherapeutique; }
    
    /**
     * Obtient la liste des épreuves cliniques réalisées dans le cadre du bilan orthophonique.
     * 
     * @return La liste des épreuves cliniques.
     */
    public List<EpreuveClinique> getEpreuvesCliniques() { return epreuvesCliniques; }
    
    @Override
    public String getChaine() {
    	String epreuvesCliniquesEnChaine = "";
    	for (EpreuveClinique epreuve : epreuvesCliniques) { epreuvesCliniquesEnChaine += epreuve.getChaine() + "\n"; }
    	return "Anamnèse : " + anamnese.getChaine() + "\nEpreuves cliniques : " + epreuvesCliniquesEnChaine + "\nDiagnostic : " +
    	diagnostic.getChaine() + "\nProjet thérapeutique : " + projetTherapeutique;
    }
}