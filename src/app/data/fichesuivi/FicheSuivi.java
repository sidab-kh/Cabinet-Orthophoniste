package app.data.fichesuivi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe FicheSuivi représente une fiche de suivi contenant une liste d'objectifs.
 * Elle permet d'ajouter et d'évaluer des objectifs, ainsi que de vérifier si tous
 * les objectifs ont été atteints.
 */
@SuppressWarnings("serial")
public class FicheSuivi implements Serializable {
    private List<Objectif> objectifs;
    private boolean isOldVersion;

    /**
     * Constructeur de la classe FicheSuivi.
     * Initialise une nouvelle fiche de suivi avec une liste vide d'objectifs.
     */
    public FicheSuivi() {
        this.objectifs = new ArrayList<Objectif>();
    }

    /**
     * Retourne la liste des objectifs de la fiche de suivi.
     * 
     * @return la liste des objectifs.
     */
    public List<Objectif> getObjectifs() {
        return objectifs;
    }

    /**
     * Indique si cette fiche de suivi est une ancienne version.
     * 
     * @return true si c'est une ancienne version, false sinon.
     */
    public boolean isOldVersion() {
        return isOldVersion;
    }

    /**
     * Définit si cette fiche de suivi est une ancienne version.
     * 
     * @param isOldVersion true pour marquer cette fiche comme ancienne version, false sinon.
     */
    public void setOldVersion(boolean isOldVersion) {
        this.isOldVersion = isOldVersion;
    }

    /**
     * Ajoute un nouvel objectif à la fiche de suivi.
     * 
     * @param objectif l'objectif à ajouter.
     */
    public void ajouterObjectif(Objectif objectif) {
        this.objectifs.add(objectif);
    }

    /**
     * Évalue un objectif existant dans la fiche de suivi en lui attribuant une note.
     * 
     * @param nomObjectif le nom de l'objectif à évaluer.
     * @param note la note à attribuer à l'objectif.
     */
    public void evaluerObjectif(String nomObjectif, int note) {
        for (Objectif objectif : objectifs) {
            if (objectif.getNom().equals(nomObjectif)) {
                objectif.setNote(note);
                return;
            }
        }
    }

    /**
     * Vérifie si tous les objectifs de la fiche de suivi ont été atteints.
     * Un objectif est considéré comme atteint si sa note est supérieure ou égale à 3.
     * 
     * @return true si tous les objectifs sont atteints, false sinon.
     */
    public boolean objectifsAtteints() {
        for (Objectif objectif : objectifs) {
            if (objectif.getNote() < 3) {
                return false;
            }
        }
        return true;
    }
}