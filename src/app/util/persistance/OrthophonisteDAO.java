package app.util.persistance;

import java.io.*;

import app.mvc.Orthophoniste;

/**
 * Cette classe implémente un patron de conception "DAO" (Data Access Object) pour la gestion de la persistance des objets Orthophoniste.
 * Elle permet de sauvegarder, charger et supprimer des instances d'Orthophoniste sur la machine.
 */
public class OrthophonisteDAO {
    
    private String fichier;

    /**
     * Constructeur de la classe OrthophonisteDAO.
     * 
     * @param fichier Le nom du fichier dans lequel les données de l'Orthophoniste seront sauvegardées ou chargées.
     */
    public OrthophonisteDAO(String fichier) {
        this.fichier = fichier;
    }

    /**
     * Sauvegarde l'objet Orthophoniste spécifié dans le fichier.
     * 
     * @param orthophoniste L'objet Orthophoniste à sauvegarder.
     * @return True si la sauvegarde est réussie, sinon False.
     */
    public boolean sauvegarder(Orthophoniste orthophoniste) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(orthophoniste);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Charge l'objet Orthophoniste à partir du fichier spécifié.
     * 
     * @return L'objet Orthophoniste chargé depuis le fichier, ou null si une erreur se produit.
     */
    public Orthophoniste charger() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            Orthophoniste orthophoniste = (Orthophoniste) ois.readObject();
            return orthophoniste;
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Supprime le fichier contenant les données de l'Orthophoniste.
     * 
     * @return True si la suppression est réussie, sinon False.
     */
    public boolean supprimer() {
        File file = new File(fichier);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }
}