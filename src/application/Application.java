package application;
import java.util.List;

import patient.Patient;
import rendezVous.RendezVous;

public class Application {
	public CompteOrthophoniste compteOrthophoniste;
	
	public class CompteOrthophoniste {
		String nom, prenom, adresse, email, motDePasse;
		int numeroTelephone;
		List<RendezVous> rendezVous;
		List<DossierPatient> dossiersPatients;
		List<Patient> patients;
		
		public CompteOrthophoniste(String nom, String prenom, String adresse, String email, String motDePasse, int numeroTelephone,
				List<RendezVous> rendezVous, List<DossierPatient> dossiersPatients) {
			this.nom = nom;
			this.prenom = prenom;
			this.adresse = adresse;
			this.email = email;
			this.motDePasse = motDePasse;
			this.numeroTelephone = numeroTelephone;
			this.rendezVous = rendezVous;
			this.dossiersPatients = dossiersPatients;
		}

		void creerRendezVous() {
			
		}
		
		void creerTest() {
			
		}
		
		void ajouterDossierPatient(Patient patient) {
			
		}
		
		void ajouterRendezVous() {
			
		}
		
		void ajouterPatient(Patient patient) {
			
		}
		
		void supprimerPatient(Patient patient) {
			
		}
		
		
	}	
	
	// Methodes d'interaction graphique avec l'utilisateur
}
