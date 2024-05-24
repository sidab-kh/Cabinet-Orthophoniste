package app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import app.util.fabriques.FabriqueRendezVous;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LireAtelierController {

	Controlleur controlleur;
	
    @FXML
    private TextField dateField, heureField, numerosDossiersField, thematiqueField;
    
    @FXML
    private Text erreurTextDossiers, erreurText;
    
    @FXML
    private void initialize() {
    	controlleur = Controlleur.getInstance();
    	erreurText.setVisible(false);
    }

    @FXML
    void handleCreerAtelierButtonAction(ActionEvent event) {
    	try {
    		LocalDateTime dateEtHeure = LocalDateTime.parse(dateField.getText()+" "+heureField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            
            if (controlleur.orthophonisteDisponible(dateEtHeure)) {
            	String thematique = thematiqueField.getText();
            	List<Integer> numerosDossiers = new ArrayList<>();
                for (String chaineNumero : numerosDossiersField.getText().split("\\s+")) {
                    int numero = Integer.parseInt(chaineNumero);
                    if (controlleur.dossierExiste(numero)) {
                    	numerosDossiers.add(numero);
                    } else {
                    	erreurTextDossiers.setText("Aucun dossier de numéro " + chaineNumero + " trouvé.\nVeuillez insérez des numéros valides.");
                    	erreurTextDossiers.setVisible(true);
        	        	return;
                    }
                }
                controlleur.confirmerRendezVous(FabriqueRendezVous.creerAtelier(dateEtHeure, thematique, numerosDossiers));
                Main.changerScene(EScenes.AGENDA);
            }
            else {
            	erreurText.setText("L'orthophoniste n'est pas disponible à la date et heure indiquée.");
            	erreurText.setVisible(true);
            }
		} catch (DateTimeParseException e) {
			erreurText.setText("Date ou heure invalide.");
        	erreurText.setVisible(true);
		} catch (NumberFormatException e) {
        	erreurText.setText("Numéros de dossiers invalides.");
        	erreurText.setVisible(true);
            return;
        }
    }

    @FXML
    void handleQuitterButtonAction(MouseEvent event) {
    	Main.changerScene(EScenes.AGENDA);
    }

}
