package utils;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXSnackbar;
import controllers.components.cards.SnackbarController;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import services.ViewsManager;

public final class Alerts {
    /**
     * @param title alert title
     * @param msg alert message to be displayed
     * @return Alert having a default OK button
     */
    public static JFXAlert<String> createDefaultAlert(String title, String msg){
        final JFXAlert<String> alert = new JFXAlert<>();
        alert.initModality(Modality.APPLICATION_MODAL);
        ((Stage) alert.getDialogPane().getScene().getWindow()).initStyle(StageStyle.UNDECORATED);
        alert.setOverlayClose(false);

        final JFXDialogLayout layout = createLayout(title, msg);

        JFXButton okBtn = new JFXButton("OK");
        okBtn.setDefaultButton(true);
        okBtn.setOnAction(addEvent -> alert.hideWithAnimation());
        layout.setActions(okBtn);

        alert.setContent(layout);
        return alert;
    }

    /**
     * @return Empty Alert
     */
    public static JFXAlert<String> createAlert() {
        final JFXAlert<String> alert = new JFXAlert<>();
        alert.initModality(Modality.APPLICATION_MODAL);
        ((Stage) alert.getDialogPane().getScene().getWindow()).initStyle(StageStyle.UNDECORATED);
        alert.setOverlayClose(false);
        return alert;
    }

    /**
     * @param title title for the Dialog
     * @param msg message to be displayed on the dialog body
     * @return Layout containing the title and the message
     */
    public static JFXDialogLayout createLayout(String title, String msg) {
        final JFXDialogLayout layout = new JFXDialogLayout();
        layout.setHeading(new Label(title));
        layout.setBody(new VBox(new Label(msg)));
        layout.setStyle("-fx-border-color: grey;");
        return layout;
    }


    /**
     * Create a snackbar using default color
     * @param pane The target pane to display the snackbar
     * @param message message to be displayed
     * @param timeInSeconds display time
     */
    public static void createSnackbar(Pane pane, String message, double timeInSeconds) {
        createSnackbar(pane, message, timeInSeconds, "#222", "#FFF");
    }

    /**
     * Create a snackbar using custom colors
     * @param pane the target pane to display the snackbar
     * @param message message to be displayed
     * @param timeInSeconds display time
     * @param backgroundColor snackbar color
     * @param textFill text color
     */
    public static void createSnackbar(Pane pane, String message, double timeInSeconds, String backgroundColor, String textFill) {
        final JFXSnackbar bar = new JFXSnackbar(pane);
        final ViewsManager.DetailedComponent component = ViewsManager.requestDetailedComponent("cards/Snackbar");
        final SnackbarController controller = component.getLoader().getController();
        controller.setText(message);
        controller.setBackgroundColor(backgroundColor);
        controller.setTextColor(textFill);
        bar.enqueue(new JFXSnackbar.SnackbarEvent(component.getRoot(), new Duration(timeInSeconds * 1000), null));
    }
}
