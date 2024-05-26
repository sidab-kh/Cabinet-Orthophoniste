package app.data.bilans;

import java.io.Serializable;
import java.util.List;

/**
 * La classe Diagnostic représente le diagnostic établi à partir d'un bilan orthophonique.
 * Elle contient une liste de troubles identifiés lors du bilan.
 */
@SuppressWarnings("serial")
public class Diagnostic implements Serializable {
    /** La liste des troubles identifiés lors du bilan orthophonique. */
    List<Trouble> troubles; 
    
    /**
     * Constructeur pour créer un diagnostic avec une liste de troubles spécifiée.
     * 
     * @param troubles La liste des troubles identifiés lors du bilan orthophonique.
     */
    public Diagnostic(List<Trouble> troubles) { this.troubles = troubles; }
}
