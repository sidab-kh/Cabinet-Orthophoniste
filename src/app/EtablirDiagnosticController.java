package app;

import java.util.ArrayList;
import java.util.List;

import app.data.bilans.Diagnostic;
import app.data.bilans.Trouble;
import app.util.enumerations.ECategoriesTroubles;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class EtablirDiagnosticController {

	private Contexte contexte;
	private List<Trouble> troubles;
	private String[] Categoriestroubles = ECategoriesTroubles.getAllStrings();
	
    @FXML
    private ChoiceBox<String> categorieBox;

    @FXML
    private Text erreurText;

    @FXML
    private TextField troubleField;

    @FXML
    private TextArea troublesArea;

    @FXML
    private void initialize() {
    	contexte = Contexte.getInstance();
    	erreurText.setVisible(false);
    	categorieBox.getItems().addAll(Categoriestroubles);
    	troubles = new ArrayList<>();
    }
    
    @FXML
    private void handleAjouterTroubleButtonAction(ActionEvent event) {
    	erreurText.setVisible(false);
    	String nom = troubleField.getText();
        String categorieStr = categorieBox.getValue();

        if (nom == null || nom.isEmpty()) {
            erreurText.setText("Veuillez donner le nom du trouble.");
            erreurText.setVisible(true);
            return;
        }
        
        if (categorieStr == null || categorieStr.isEmpty()) {
            erreurText.setText("Veuillez indiquer la catégorie du trouble.");
            erreurText.setVisible(true);
            return;
        }

        ECategoriesTroubles categorie = ECategoriesTroubles.getCategorieFromString(categorieStr);
        if (categorie == null) {
        	erreurText.setText("Erreur catégorie.");
            erreurText.setVisible(true);
            return;
        }
        troubles.add(new Trouble(nom, categorie));        
        categorieBox.setValue(null);
        troubleField.clear();
        Trouble trouble = troubles.get(troubles.size()-1);
        troublesArea.appendText("- " + trouble.getNom() + ", catégorie: " + trouble.getCategorie().getString() + "\n");
    }

    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
    	contexte.clear();
    	Main.changerScene(EScenes.TALKTRACK);
    }

    @FXML
    private void handleTerminerDiagnosticButtonAction(ActionEvent event) {
    	// Sans vérification car il se peut que troubles soit vide (le patient n'a pas de troubles)
    	contexte.getBo().ajouterDiagnostic(new Diagnostic(troubles));
    	Main.changerScene(EScenes.LIRE_PROJET_THERAPEUTIQUE);
    }
}
