package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.sound.midi.SysexMessage;

public class SettingsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField sleepField;

    @FXML
    private Button acceptbtn;

    @FXML
    private TextField coefField;

    @FXML
    private TextField angleField;

    @FXML
    void initialize() {
        acceptbtn.setOnAction(actionEvent -> {
            if (!tryParseInt(angleField.getText())) {
                parseAttentionBox("angle");
                return;
            } else {
                if (Integer.parseInt(angleField.getText()) < 0 || Integer.parseInt(angleField.getText()) > 360) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("angle");
                    alert.setHeaderText("Angle can't be more 360 or less 0");
                    alert.show();
                    return;
                }
            }
            if (!tryParseInt(coefField.getText())) {
                parseAttentionBox("coefficient");
                return;
            }
            if (!tryParseInt(sleepField.getText())) {
                parseAttentionBox("sleep");
                return;
            }

        });
    }

    boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void parseAttentionBox(String str) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(str);
        alert.setHeaderText("Can't parse" + " " + str + " " + "field");
        alert.show();
    }
}
