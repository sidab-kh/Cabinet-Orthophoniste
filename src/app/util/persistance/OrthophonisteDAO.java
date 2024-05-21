package app.util.persistance;

import java.io.*;

import app.mvc.Orthophoniste;

// Patron de conception "DAO" (Data Access Object)
public class OrthophonisteDAO {
	
    private String fichier;

    // Constructeur
    public OrthophonisteDAO(String fichier) { this.fichier = fichier; }

	// Sauvegarder l'orthophoniste
    public boolean sauvegarder(Orthophoniste orthophoniste) {
    	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
    		oos.writeObject(orthophoniste);
    		return true;
    	}
    	catch (Exception e) { return false; }
    }

    // Charger l'orthophoniste
    public Orthophoniste charger() {
    	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
    		Orthophoniste orthophoniste = (Orthophoniste) ois.readObject();
    		return orthophoniste;
    	}
    	catch (Exception e) { return null; }
    }
    
    // Supprimer l'orthophoniste
    public boolean supprimer() {
        File file = new File(fichier);
        if (file.exists()) { return file.delete(); }
        return false;
    }
}