package mvc;

import patient.Patient;
import rendezVous.RendezVous;

// Cette classe joue le role de controlleur selon l'architecture MVC
// Controle la logique de l'application
public final class Controlleur {

	// Patron de conception singleton
	private static Controlleur instance;

	private Controlleur() {} // Constructeur prive pour eviter toute instanciation externe
    
	// Methode pour recuperer l'instance unique du controlleur a partir des autres classes
    public static Controlleur getInstance() {
        if (instance == null) {
            instance = new Controlleur();
        }
        return instance;
    }
	
    // Methode pour introduire les informations de l'orthophoniste quand il s'inscrit pour la premiere fois
    public void inscrireOrthophoniste() {
    	// Faire appel a la vue pour lire les differents champs
    	Vue.getInstance().lireInformationsOrthophoniste();
    }
    
    public void ajouterDossierPatient(DossierPatient dossierPatient) throws NumeroDossierExistantException {
        /* Verifier si le dossier existe deja
         * - Si c'est le cas : throw new NumeroDossierExistantException();
         * - Sinon : */ Orthophoniste.getInstance().dossiersPatients.add(dossierPatient);
    }
    
    public void ajouterNouveauPatient(Patient patient) {
    	Orthophoniste.getInstance().nouveauxPatients.add(patient);
    }

    public void ajouterRendezVous(RendezVous rendezVous) throws OrthophonisteNonDisponibleException {
        /* Verifier si l'orthophoniste est libre
         * - Si c'est le cas : throw new OrthophonisteNonDisponibleException();
         * - Sinon : */ Orthophoniste.getInstance().agenda.add(rendezVous);
    }
    
    // TODO: public void creerTest()
}