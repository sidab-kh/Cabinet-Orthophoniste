package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class EtablirDiagnosticController {

    @FXML
    private ChoiceBox<String> categorieBox;

    @FXML
    private Text erreurText;

    @FXML
    private TextField troubleField;

    @FXML
    private TextArea troublesArea;

    @FXML
    private void handleAjouterTroubleButtonAction(ActionEvent event) {

    }

    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {

    }

    @FXML
    private void handleTerminerDiagnosticButtonAction(ActionEvent event) {

    }
}
