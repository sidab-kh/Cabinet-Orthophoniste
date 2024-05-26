package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class DeroulerTestExercicesController {
	
    @FXML
    private Text erreurText, nomTestText, numeroExerciceText;

    @FXML
    private TextArea enonceArea, observationArea, scoresArea;

    @FXML
    private TextField scoreField;

    @FXML
    private void handleProchainExerciceButtonAction(ActionEvent event) {

    }

    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {

    }
}
