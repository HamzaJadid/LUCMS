package controllers.components.head_of_department;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import controllers.repos.NewsRepo;
import global.Constants;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import models.News;
import utils.Alerts;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateNews implements Initializable {
    @FXML
    private JFXTextField title;
    @FXML
    private JFXTextArea body;
    @FXML
    private JFXComboBox<String> level;

    private Pane dashboard;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> levelOption = FXCollections.observableArrayList();
        levelOption.setAll(Constants.WARNING_LEVELS);
        level.setItems(levelOption);
    }

    @FXML
    void postNews(ActionEvent event) throws SQLException {
        NewsRepo.getInstance().create(new News(title.getText(), body.getText(), level.getValue()));
        Alerts.createSnackbar(dashboard, "Your news post have been uploaded!", 2);
    }

    public void setDashboard(Pane pane) {
        dashboard = pane;
    }
}