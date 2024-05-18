package mvc;

import exceptionsPersonnalisees.NumeroDossierExistantException;
import exceptionsPersonnalisees.OrthophonisteNonDisponibleException;
import patient.DossierPatient;
import rendezVous.RendezVous;

// Cette classe joue le role de 'Controlleur' dans l'architecture MVC
// Notre architecture : Vue <- Controlleur -> Couche Service -> Modele
public final class Controlleur {

	private ServiceOrthophoniste serviceOrthophoniste; // Operations
    private Vue vue; // Affichages
    
    public Controlleur() {
        this.serviceOrthophoniste = new ServiceOrthophoniste();
        this.vue = new Vue();
    }
    
    public void afficherMenu() {
    	vue.afficherMenuPrincipal();
    }
	
    public void lireInformationsOrthophoniste() {
        String nom = vue.lireChaine("Nom: ");
        String prenom = vue.lireChaine("Prenom: ");
        String adresse = vue.lireChaine("Adresse: ");
        String email = vue.lireChaine("Email: ");
        String motDePasse = vue.lireChaine("Mot de passe: ");
        int numeroTelephone = vue.lireEntier("Numero de telephone: ");
        
        serviceOrthophoniste.inscrireOrthophoniste(nom, prenom, adresse, email, motDePasse, numeroTelephone);
        vue.afficher("Informations de l'orthophoniste enregistrées avec succès.");
    }
    
    public void afficherInformationsOrthophoniste() {
    	vue.afficherInformationsOrthophoniste(serviceOrthophoniste.getOrthophoniste());
    }
    
    public void ajouterDossierPatient(DossierPatient dossierPatient) {
    	try {
    		serviceOrthophoniste.ajouterDossierPatient(dossierPatient);
    	} catch (NumeroDossierExistantException e) {
    		vue.afficherErreur(e.getMessage());
    	}
    }
    
    public void ajouterRendezVous(RendezVous rendezVous) {
    	try {
    		serviceOrthophoniste.ajouterRendezVous(rendezVous);
    	} catch (OrthophonisteNonDisponibleException e) {
    		vue.afficherErreur(e.getMessage());
    	}
    }
}