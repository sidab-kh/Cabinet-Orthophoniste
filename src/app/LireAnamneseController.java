package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LireAnamneseController {

    @FXML
    private ToggleGroup Patient;

    @FXML
    private RadioButton adulteButton;

    @FXML
    private RadioButton enfantButton;

    @FXML
    private Text erreurText;

    @FXML
    private TextField intituleField;

    @FXML
    private TextArea questionssArea;

    @FXML
    void handleAjouterQuestionButtonAction(ActionEvent event) {

    }

    @FXML
    void handleCreerAnamneseButtonAction(ActionEvent event) {

    }

    @FXML
    void handleQuitterButtonAction(MouseEvent event) {

    }

    @FXML
    void handleTypePatientButtonAction(ActionEvent event) {

    }
}