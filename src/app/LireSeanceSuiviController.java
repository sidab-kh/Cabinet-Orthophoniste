package app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import app.util.fabriques.FabriqueRendezVous;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LireSeanceSuiviController {

	Controlleur controlleur;

    @FXML
    private RadioButton enLigne, enPresentiel;

    @FXML
    private Text erreurText;

    @FXML
    private TextField dateField, heureField, numeroDossierField;

    @FXML
    private ToggleGroup typeSeance;
    
    @FXML
    private void initialize() {
    	controlleur = Controlleur.getInstance();
    	erreurText.setVisible(false);
    }

    @FXML
    void handleCreerSeanceButtonAction(ActionEvent event) {
    	try {
    		LocalDateTime dateEtHeure = LocalDateTime.parse(dateField.getText() + " " + heureField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    		
    		if (controlleur.orthophonisteDisponible(dateEtHeure)) {
    			int numeroDossier = Integer.parseInt(numeroDossierField.getText());
    			if (!controlleur.dossierExiste(numeroDossier)) {
    				erreurText.setText("Aucun dossier de numéro " + numeroDossierField.getText() + " trouvé.\nVeuillez insérez un numéro valide.");
    				erreurText.setVisible(true);
    	        	return;
    			}
    			boolean presentiel = enPresentiel.isSelected() ? true : false;
    			controlleur.confirmerRendezVous(FabriqueRendezVous.creerSeanceSuivi(dateEtHeure, numeroDossier, presentiel));
    			Main.changerScene(EScenes.AGENDA);
    		} else {
            	erreurText.setText("L'orthophoniste n'est pas disponible à la date et heure indiquée.");
            	erreurText.setVisible(true);
            	return;
            }    		
    	} catch (DateTimeParseException e) {
			erreurText.setText("Date ou heure invalide.");
        	erreurText.setVisible(true);
        	return;
    	} catch (NumberFormatException e) {
        	erreurText.setText("Numéro de dossier invalide.");
        	erreurText.setVisible(true);
            return;
        }
    }
    
    @FXML
    void handleQuitterButtonAction(MouseEvent event) { Main.changerScene(EScenes.AGENDA); }
}
