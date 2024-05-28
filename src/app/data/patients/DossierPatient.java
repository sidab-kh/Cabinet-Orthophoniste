package app.data.patients;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import app.data.bilans.BilanOrthophonique;
import app.data.fichesuivi.FicheSuivi;
import app.data.rendezvous.RendezVous;

/**
 * La classe DossierPatient représente un dossier médical pour un patient.
 * Ce dossier contient des informations telles que les rendez-vous, les bilans orthophoniques
 * et les fiches de suivi associées à ce patient.
 */
@SuppressWarnings("serial")
public class DossierPatient implements Serializable, Comparable<DossierPatient> {
    /**
     * Compteur pour générer automatiquement les numéros de dossier des patients.
     */
    public static int compteurNumero;

    /**
     * Numéro unique attribué à ce dossier patient.
     */
    private int numero;

    /**
     * Liste des rendez-vous associés à ce dossier patient.
     */
    private List<RendezVous> listeRendezVous = new ArrayList<RendezVous>();

    /**
     * Liste des bilans orthophoniques associés à ce dossier patient.
     */
    private List<BilanOrthophonique> listeBilansOrthophoniques = new ArrayList<BilanOrthophonique>();

    /**
     * Liste des fiches de suivi associées à ce dossier patient.
     */
    private List<FicheSuivi> listeFichesSuivi = new ArrayList<FicheSuivi>();
    
    /**
     * Constructeur par défaut.
     */
    public DossierPatient() {}
    
    /**
     * Retourne le numéro de dossier de ce patient.
     * 
     * @return Le numéro de dossier.
     */
    public int getNumero() { return numero; }
    
    public void setNumero(int numero) { this.numero = numero; }
    
    /**
     * Retourne la liste des rendez-vous associés à ce dossier patient.
     * 
     * @return La liste des rendez-vous.
     */
    public List<RendezVous> getListRendezVous() { return listeRendezVous; }
    
    /**
     * Retourne la liste des bilans orthophoniques associés à ce dossier patient.
     * 
     * @return La liste des bilans orthophoniques.
     */
    public List<BilanOrthophonique> getListBilansOrthophoniques() { return listeBilansOrthophoniques; }
    
    /**
     * Retourne la liste des fiches de suivi associées à ce dossier patient.
     * 
     * @return La liste des fiches de suivi.
     */
    public List<FicheSuivi> getListFicheSuivis() { return listeFichesSuivi; }
    
    /**
     * Compare ce dossier patient avec un autre dossier patient en fonction de leur numéro de dossier.
     * 
     * @param autre Le dossier patient à comparer.
     * @return Un entier négatif, zéro ou un entier positif si ce dossier patient est inférieur, égal ou supérieur à l'autre dossier patient.
     */
    @Override
    public int compareTo(DossierPatient autre) { return Integer.compare(this.numero, autre.numero); }
    
    /**
     * Ajoute un rendez-vous à la liste des rendez-vous de ce dossier patient.
     * 
     * @param rendezVous Le rendez-vous à ajouter.
     */
    public void ajouterRendezVous(RendezVous rendezVous) { listeRendezVous.add(rendezVous); }
    
    /**
     * Supprime un rendez-vous de la liste des rendez-vous de ce dossier patient.
     * 
     * @param rendezVous Le rendez-vous à supprimer.
     */
    public void supprimerRendezVous(RendezVous rendezVous) { listeRendezVous.remove(rendezVous); }
    
    /**
     * Ajoute un bilan orthophonique à la liste des bilans orthophoniques de ce dossier patient.
     * 
     * @param bilanOrthophonique Le bilan orthophonique à ajouter.
     */
    public void ajouterBilanOrthophonique(BilanOrthophonique bilanOrthophonique) { listeBilansOrthophoniques.add(bilanOrthophonique); }
    
    /**
     * Supprime un bilan orthophonique de la liste des bilans orthophoniques de ce dossier patient.
     * 
     * @param bilanOrthophonique Le bilan orthophonique à supprimer.
     */
    public void supprimerBilanOrthophonique(BilanOrthophonique bilanOrthophonique) { listeBilansOrthophoniques.remove(bilanOrthophonique); }
    
    /**
     * Ajoute une fiche de suivi à la liste des fiches de suivi de ce dossier patient.
     * 
     * @param ficheSuivi La fiche de suivi à ajouter.
     */
    public void ajouterFicheSuivi(FicheSuivi ficheSuivi) { listeFichesSuivi.add(ficheSuivi); }
    
    /**
     * Supprime une fiche de suivi de la liste des fiches de suivi de ce dossier patient.
     * 
     * @param ficheSuivi La fiche de suivi à supprimer.
     */
    public void supprimerFicheSuivi(FicheSuivi ficheSuivi) { listeFichesSuivi.remove(ficheSuivi); }
    
    /**
     * Convertit la liste des rendez-vous en une liste de chaînes de caractères.
     * @return Une liste de chaînes représentant les rendez-vous du patient.
     */
    public List<String> listeRendezVousToString() {
    	List<String> rendezVousEnChaine = new ArrayList<String>();
    	for (RendezVous rdv : listeRendezVous) {
    		rendezVousEnChaine.add("- " + rdv.getType().getNom() + " : " + rdv.getDateEtHeure() + ", Observation : " + rdv.getObservation());
    	}
    	return rendezVousEnChaine;
    }
    
    public List<String> listeBilansOrthophoniquesToString() {
    	List<String> bilansEnChaine = new ArrayList<String>();
    	for (BilanOrthophonique bilan : listeBilansOrthophoniques) {
    		bilansEnChaine.add("Bilan orthophonique :\n" + bilan.getChaine());
    	}
    	return bilansEnChaine;
    }
}
