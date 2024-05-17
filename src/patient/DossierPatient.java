package patient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import rendezVous.RendezVous;
import bilanOrthophonique.BilanOrthophonique;

@SuppressWarnings("serial")
public class DossierPatient implements Serializable {
	int numero; // Doit etre unique !
	List<RendezVous> HistoriqueRendezVous;
	List<BilanOrthophonique> HistoriqueBilansOrthophoniques;
	// TODO: List<FicheSuivi> HistoriqueFichesSuivi
	
	public DossierPatient(int numero) {
		this.numero = numero;
		HistoriqueRendezVous = new ArrayList<RendezVous>();
		HistoriqueBilansOrthophoniques = new ArrayList<BilanOrthophonique>();
	}
	
	public void archiverRendezVous(RendezVous rendezVous) {
		HistoriqueRendezVous.add(rendezVous);
		// TODO: Serialiser le rendez-vous et l'ecrire dans le fichier
	}
	
	public void archiverBilanOrthophonique(BilanOrthophonique bilanOrthophonique) {
		HistoriqueBilansOrthophoniques.add(bilanOrthophonique);
		// TODO: Serialiser le bilan orthophonique et l'ecrire dans le fichier
	}
	
	// TODO: archiverFicheSuivi(FicheSuivi fichesSuivi)
}
