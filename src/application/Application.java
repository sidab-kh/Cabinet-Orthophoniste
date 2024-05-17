package application;
import java.util.List;
import patient.Patient;
import rendezVous.OrthophonisteNonDisponibleException;
import rendezVous.RendezVous;

public class Application {
	public CompteOrthophoniste compteOrthophoniste;
	
	public class CompteOrthophoniste {
		String nom, prenom, adresse, email, motDePasse;
		int numeroTelephone;
		List<RendezVous> agenda;
		List<DossierPatient> dossiersPatients;
		List<Patient> patients;
		
		public CompteOrthophoniste(String nom, String prenom, String adresse, String email, String motDePasse, int numeroTelephone,
				List<RendezVous> agenda, List<DossierPatient> dossiersPatients) {
			this.nom = nom;
			this.prenom = prenom;
			this.adresse = adresse;
			this.email = email;
			this.motDePasse = motDePasse;
			this.numeroTelephone = numeroTelephone;
			this.agenda = agenda;
			this.dossiersPatients = dossiersPatients;
		}

	    public void creerTest() {
	        // Implementation a ajouter
	    }

	    public void ajouterDossierPatient(DossierPatient dossierPatient) throws NumeroDossierExistantException {
	    	/* Verifier si le dossier existe deja
	    	 * - Si c'est le cas : throw new NumeroDossierExistantException();
	    	 * - Sinon : */ this.dossiersPatients.add(dossierPatient);
	    }
	    
	    public void ajouterPatient(Patient patient) {
	        this.patients.add(patient);
	    }

	    public void ajouterRendezVous(RendezVous rendezVous) throws OrthophonisteNonDisponibleException {
	    	/* Verifier si l'orthophoniste est libre
	    	 * - Si c'est le cas : throw new OrthophonisteNonDisponibleException();
	    	 * - Sinon : */ this.agenda.add(rendezVous);
	    }
	}	
	
	// Methodes d'interaction graphique avec l'utilisateur
}
