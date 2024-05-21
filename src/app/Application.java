package app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import app.mvc.Controlleur;
import app.util.fabrique.FabriquePatient;
import app.util.fabrique.FabriqueRendezVous;
import app.data.patient.Patient;
import app.data.rdv.RendezVous;

// Cette classe represente l'application elle-meme, elle contient la methode main()
public final class Application {
	public static void main(String[] args) {
		Controlleur controlleur = new Controlleur();
//		controlleur.afficherMenu();
//		controlleur.lireInformationsOrthophoniste();
//		controlleur.afficherInformationsOrthophoniste();
		Patient patient1 = FabriquePatient.creerAdulte( "Babali", "Malik", LocalDate.parse("2000-01-01"), "Tizi Ouzou", "Tizi Ouzou, Nouvelle Ville", "0655250610", "Ingenieur", "Aucune");
		Patient patient2 = FabriquePatient.creerEnfant( "Hikoun", "Sara", LocalDate.parse("2016-02-02"), "Alger", "Alger, Oued Smar", "0655250609", "0629887609", "Primaire");
		controlleur.creerDossierPatient(patient1);
		controlleur.creerDossierPatient(patient2);
		List<Integer> dossiers = new ArrayList<Integer>();
		dossiers.add(0);
		dossiers.add(1);
		RendezVous rendezVous1 = FabriqueRendezVous.creerConsultation(LocalDateTime.parse("2024-07-07 10:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), patient1);
		RendezVous rendezVous2 = FabriqueRendezVous.creerConsultation(LocalDateTime.parse("2024-07-07 14:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), patient2);
		RendezVous rendezVous3 = FabriqueRendezVous.creerSeanceSuivi(LocalDateTime.parse("2024-07-07 18:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 0, false);
		RendezVous rendezVous4 = FabriqueRendezVous.creerSeanceSuivi(LocalDateTime.parse("2024-07-07 22:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 1, true);
		RendezVous rendezVous5 = FabriqueRendezVous.creerAtelier(LocalDateTime.parse("2024-07-07 08:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), "La prononciation", dossiers);
		controlleur.confirmerRendezVous(rendezVous1);
		controlleur.confirmerRendezVous(rendezVous2);
		controlleur.confirmerRendezVous(rendezVous3);
		controlleur.confirmerRendezVous(rendezVous4);
		controlleur.confirmerRendezVous(rendezVous5);
		controlleur.afficherAgenda();
	}
}