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
	List<RendezVous> listeRendezVous = new ArrayList<RendezVous>();
	List<BilanOrthophonique> listeBilansOrthophoniques = new ArrayList<BilanOrthophonique>();
	
	// Constructeur
	public DossierPatient(int numero) { this.numero = numero; }
	
	// Getters et setters
	public int getNumero() { return numero; }
	
	public List<RendezVous> getListRendezVous() { return listeRendezVous; }
	
	public List<BilanOrthophonique> getListBilansOrthophoniques() { return listeBilansOrthophoniques; }
	
	// Autres methodes
	@Override public int compareTo(DossierPatient autre) { return Integer.compare(this.numero, autre.numero); }
	
	public static int getCompteurNumero() { return compteurNumero; }
	
	public static void incrementerCompteurNumero() { compteurNumero++; }
	
	public void ajouterRendezVous(RendezVous rendezVous) { listeRendezVous.add(rendezVous); }
	public void supprimerRendezVous(RendezVous rendezVous) { listeRendezVous.remove(rendezVous); }
	
	public void ajouterBilanOrthophonique(BilanOrthophonique bilanOrthophonique) { listeBilansOrthophoniques.add(bilanOrthophonique); }
	public void supprimerBilanOrthophonique(BilanOrthophonique bilanOrthophonique) { listeBilansOrthophoniques.remove(bilanOrthophonique); }
}