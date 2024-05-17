package mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import patient.DossierPatient;
import patient.Patient;
import rendezVous.RendezVous;

// Cette classe joue le role de modele selon l'architecture MVC
// Contient les donnees de l'orthophoniste
public final class Orthophoniste {
	
	// Patron de conception singleton
	private static Orthophoniste instance; /* Celle-ci est la seule et unique instance d'orthophoniste, si on decide de permettre 
	plusieurs orthophonistes, on devra stocker leurs informations dans un fichier, puis charger l'orthophoniste voulu dans ce
	singleton. On pourra utiliser le fait que l'instance soit non nulle pour indiquer qu'un orthophoniste est connecte, 
	mais de toute facon, ca sera toujours le cas, l'application ne fonctionnera pas s'il n'y a pas de session ouverte */
	
	// Ces champs sont prives car confidentiels
	private String nom, prenom, adresse, email, motDePasse;
    private int numeroTelephone;
    
    // Ceux-ci sont en acces package puisqu'ils ne sont pas confidentiels et le controlleur/vue en ont besoin constamment
    List<RendezVous> agenda;
    Set<DossierPatient> dossiersPatients;
    List<Patient> nouveauxPatients; // Pour y mettre les nouveaux patients qui n'ont pas encore de dossier
    Map<Integer, Patient> patients; // Pour y mettre les patients avec comme cle leurs numeros de dossier
    
	// Constructeur prive pour eviter toute instanciation externe
	private Orthophoniste(String nom, String prenom, String adresse, String email,
             String motDePasse, int numeroTelephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.motDePasse = motDePasse;
		this.numeroTelephone = numeroTelephone;
		agenda = new ArrayList<RendezVous>();
		dossiersPatients = new TreeSet<DossierPatient>();
		nouveauxPatients = new ArrayList<Patient>();
		patients = new TreeMap<Integer, Patient>();
	}
	
	// Methode pour recuperer l'instance unique de l'orthophoniste a partir des autres classes
	public static Orthophoniste getInstance() {
		if (instance == null) {
			System.out.println("Aucun orthophoniste connecte !");
		}
		return instance;
	}
	
	// Methode pour mettre l'orthophoniste en ligne
	public static void setOrthophoniste(String nom, String prenom, String adresse, String email,
            String motDePasse, int numeroTelephone) {
		// Si aucun orthophoniste est connecte
		if (instance == null) instance = new Orthophoniste(nom, prenom, adresse, email, motDePasse, numeroTelephone);
		else System.out.println("Un orthophoniste est deja connecte !");
	}
	
	// Verifier si un orthophoniste est connecte
	public static boolean estConnecte() {
		return instance != null;
	}
	
	// Methode pour se deconnecter
	public static void seDeconnecter() {
		instance = null;
	}

    // Getters et setters
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(int numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

}