package controllers.components;

import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class NewsCardController {
    @FXML
    private Text title;
    @FXML
    private JFXTextArea body;

    public Text getTitle() {
        return title;
    }

    public JFXTextArea getBody() {
        return body;
    }
}