package app.data.patient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import app.data.bo.BilanOrthophonique;
import app.data.rdv.RendezVous;

@SuppressWarnings("serial")
public class DossierPatient implements Serializable, Comparable<DossierPatient> {
	private static int compteurNumero;
	int numero;
	List<RendezVous> HistoriqueRendezVous = new ArrayList<RendezVous>();
	List<BilanOrthophonique> HistoriqueBilansOrthophoniques = new ArrayList<BilanOrthophonique>();
	
	// Constructeur
	public DossierPatient(int numero) { this.numero = numero; }
	
	// Getters et setters
	public int getNumero() { return numero; }
	
	public List<RendezVous> getHistoriqueRendezVous() { return HistoriqueRendezVous; }
	
	public List<BilanOrthophonique> getHistoriqueBilansOrthophoniques() { return HistoriqueBilansOrthophoniques; }
	
	// Autres methodes
	@Override public int compareTo(DossierPatient autre) { return Integer.compare(this.numero, autre.numero); }
	
	public static int getCompteurNumero() { return compteurNumero; }
	
	public static void incrementerCompteurNumero() { compteurNumero++; }
	
	public void archiverRendezVous(RendezVous rendezVous) { HistoriqueRendezVous.add(rendezVous); }
	
	public void archiverBilanOrthophonique(BilanOrthophonique bilanOrthophonique) { HistoriqueBilansOrthophoniques.add(bilanOrthophonique); }
}