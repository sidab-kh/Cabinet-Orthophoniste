package app.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import app.Contexte;
import app.Main;
import app.data.bilans.BilanOrthophonique;
import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * Contrôleur de la page de création des épreuves cliniques.
 */
public class CreerEpreuvesCliniquesController {

    /** Instance du contrôleur principal de l'application. */
    private Controlleur controlleur;

    /** Instance du contexte de l'application. */
    private Contexte contexte;

    /** Nombre total de tests disponibles. */
    private int nombreTests;

    /** Bilan orthophonique en cours de création. */
    private BilanOrthophonique bo;

    /** Champ de saisie des codes des tests. */
    @FXML
    private TextField codesTestsArea;

    /** Message d'erreur. */
    @FXML
    private Text erreurText;

    /** Zone d'affichage des tests disponibles. */
    @FXML
    private TextArea testsArea;

    /** Méthode d'initialisation du contrôleur. */
    @FXML
    private void initialize() {
        controlleur = Controlleur.getInstance();
        contexte = Contexte.getInstance();
        erreurText.setVisible(false);
        bo = contexte.getBo();
        nombreTests = controlleur.getServiceOrthophoniste().getTests().size();
        afficherTests();
    }

    /** Action effectuée lors du clic sur le bouton de création des épreuves cliniques. */
    @FXML
    private void handleCreerEpreuvesButtonAction(ActionEvent event) {
        try {
            if (codesTestsArea.getText().isEmpty() || codesTestsArea.getText() == null) {
                // Champ vide
                erreurText.setText("Veuillez entrer au moins un test.");
                erreurText.setVisible(true);
                return;
            }

            List<Integer> codesTests = new ArrayList<>();
            for (String chaineNumero : codesTestsArea.getText().split("\\s+")) {
                int numero = Integer.parseInt(chaineNumero);
                if (numero < 0 || numero >= nombreTests) {
                    erreurText.setText("Aucun test de code " + chaineNumero + " trouvé.\nVeuillez insérer des codes valides.");
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

    /** Action effectuée lors du clic sur le bouton de quitter. */
    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {
        contexte.clear();
        Main.changerScene(EScenes.TALKTRACK);
    }

    /** Affiche les tests disponibles dans la zone de texte. */
    @FXML
    private void afficherTests() {
        // Transformer les tests en une liste de chaînes
        List<String> testsEnChaine = controlleur.testsToString();
        Iterator<String> iterator = testsEnChaine.iterator();
        // Remplir le TextArea
        while (iterator.hasNext()) {
            testsArea.appendText(iterator.next() + "\n");
        }
    }
}