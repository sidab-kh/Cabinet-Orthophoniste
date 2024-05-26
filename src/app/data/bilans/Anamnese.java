package app.data.bilans;

import java.io.Serializable;
import java.util.List;

import app.data.questions.QO;
import app.util.Affichable;
import app.util.enumerations.ETypesPatients;

/**
 * La classe Anamnese représente une anamnèse associée à un bilan.
 * Elle contient le nom de l'anamnèse, une liste de questions ouvertes (QO) et le type de patient auquel elle est associée.
 */
@SuppressWarnings("serial")
public class Anamnese implements Serializable, Affichable {
    /** Le nom de l'anamnèse. */
    String nomAnamnese;
    
    /** La liste des questions ouvertes (QO) associées à cette anamnèse. */
    List<QO> questions;
    
    /** Le type de patient auquel cette anamnèse est associée. */
    ETypesPatients typeAnamnese;

    /**
     * Constructeur pour créer une anamnèse avec un nom, une liste de questions et un type de patient.
     * 
     * @param nomAnamnese Le nom de l'anamnèse.
     * @param questions La liste des questions ouvertes (QO) associées à cette anamnèse.
     * @param typeAnamnese Le type de patient auquel cette anamnèse est associée.
     */
    public Anamnese(String nomAnamnese, List<QO> questions, ETypesPatients typeAnamnese) {
        this.nomAnamnese = nomAnamnese;
        this.questions = questions;
        this.typeAnamnese = typeAnamnese;
    }
    
    /**
     * Constructeur pour créer une copie d'une anamnèse existante.
     * 
     * @param anamnese L'anamnèse à copier.
     */
    public Anamnese(Anamnese anamnese) { this(anamnese.nomAnamnese, anamnese.questions, anamnese.typeAnamnese); }

    /**
     * Obtient le type de patient auquel cette anamnèse est associée.
     * 
     * @return Le type de patient.
     */
    public ETypesPatients getTypeAnamnese() { return typeAnamnese; }
    
    /**
     * Obtient le nom de l'anamnèse.
     * 
     * @return Le nom de l'anamnèse.
     */
    public String getNomAnamnese() { return nomAnamnese; }
    
    /**
     * Obtient la liste des questions ouvertes (QO) associées à cette anamnèse.
     * 
     * @return La liste des questions ouvertes.
     */
    public List<QO> getQuestions() { return questions; }

    /**
     * Calcule le code de hachage de l'anamnèse basé sur son nom.
     * 
     * @return Le code de hachage de l'anamnèse.
     */
    @Override
    public int hashCode() { return nomAnamnese.hashCode(); }

    /**
     * Obtient une représentation textuelle de l'anamnèse.
     * 
     * @return Une chaîne de caractères représentant l'anamnèse.
     */
    public String getChaine() { return String.format("- %s , type : %s", nomAnamnese, typeAnamnese.name().toLowerCase());  }
}
