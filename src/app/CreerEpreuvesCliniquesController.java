package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import app.data.bilans.BilanOrthophonique;
import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class CreerEpreuvesCliniquesController {

	private Controlleur controlleur;
	private Contexte contexte;
	private int nombreTests;
	private BilanOrthophonique bo;
	
    @FXML
    private TextField codesTestsArea;

    @FXML
    private Text erreurText;

    @FXML
    private TextArea testsArea;

    @FXML
    private void initialize() { 
    	controlleur = Controlleur.getInstance();    	
    	contexte = Contexte.getInstance();
    	erreurText.setVisible(false);
    	bo = contexte.getBo();
    	nombreTests = controlleur.getServiceOrthophoniste().getTests().size();
    	afficherTests();
    }
    
    @FXML
    private void handleCreerEpreuvesButtonAction(ActionEvent event) {
    	try {
    		if (codesTestsArea.getText().isEmpty() || codesTestsArea.getText() == null) {
            	// Champ vide
                erreurText.setText("Veuillez entrer en moins un test.");
                erreurText.setVisible(true);
                return;
            }
    		
        	List<Integer> codesTests = new ArrayList<>();
            for (String chaineNumero : codesTestsArea.getText().split("\\s+")) {
                int numero = Integer.parseInt(chaineNumero);
                if (numero < 0 || numero >= nombreTests) {
                	erreurText.setText("Aucun test de code " + chaineNumero + " trouvé.\nVeuillez insérez des codes valides.");
                	erreurText.setVisible(true);
    	        	return;
                } else {
                	codesTests.add(numero);
                }
            }
            controlleur.creerEpreuvesCliniques(codesTests, bo);
            Main.changerScene(EScenes.DEROULER_EPREUVES_CLINIQUES);
    	} catch (NumberFormatException e) {
        	erreurText.setText("Codes des tests invalides.");
        	erreurText.setVisible(true);
            return;
        }
    	
    }
    
    @FXML // Afficher les tests
    private void afficherTests() {
    	// Transformer les tests en une liste de chaines
    	List<String> testsEnChaine = controlleur.testsToString();
    	Iterator<String> iterator = testsEnChaine.iterator();
    	// Remplir le TextArea
    	while (iterator.hasNext()) { testsArea.appendText(iterator.next() + "\n"); }
    }

    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
    	contexte.clear();
    	Main.changerScene(EScenes.TALKTRACK);
    }
}
