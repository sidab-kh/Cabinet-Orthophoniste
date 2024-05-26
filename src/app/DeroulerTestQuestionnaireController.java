package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class DeroulerTestQuestionnaireController {
	
    @FXML
    private Text erreurText, nomTestField;

    @FXML
    private TextField noteField;

    @FXML
    private TextArea enonceArea, observationArea, reponseArea, scoresArea, numeroQuestionText;

    @FXML
    private void handleEnregistrerReponseButtonAction(ActionEvent event) {

    }

    @FXML
    private void handleQuitterButtonAction(MouseEvent event) {

    }
}
