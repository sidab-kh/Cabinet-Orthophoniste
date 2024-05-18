package patient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import rendezVous.RendezVous;
import bilanOrthophonique.BilanOrthophonique;

@SuppressWarnings("serial")
public class DossierPatient implements Serializable, Comparable<DossierPatient>  {
	int numero;
	List<RendezVous> HistoriqueRendezVous = new ArrayList<RendezVous>();
	List<BilanOrthophonique> HistoriqueBilansOrthophoniques = new ArrayList<BilanOrthophonique>();
	// TODO: List<FicheSuivi> HistoriqueFichesSuivi
	
	public DossierPatient(int numero) {
		this.numero = numero;
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
	
	@Override // Comparaison du numero pour le set
    public int compareTo(DossierPatient autre) {
        return Integer.compare(this.numero, autre.numero);
    }
}