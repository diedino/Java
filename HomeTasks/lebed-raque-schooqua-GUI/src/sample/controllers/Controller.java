package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button crawfishbtn;

    @FXML
    private Button pikebtn;

    @FXML
    private Button swanbtn;

    @FXML
    void initialize() {
        swanbtn.setOnAction(actionEvent -> {
            Parent root;
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/fxml/animalsettings.fxml")), resources);
                Stage stage = new Stage();
                stage.setTitle("Swan");
                stage.setScene(new Scene(root));
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });

        crawfishbtn.setOnAction(actionEvent -> {
            Parent root;
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/fxml/animalsettings.fxml")), resources);
                Stage stage = new Stage();
                stage.setTitle("Crawfish");
                stage.setScene(new Scene(root));
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });

        pikebtn.setOnAction(actionEvent -> {
            Parent root;
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/fxml/animalsettings.fxml")), resources);
                Stage stage = new Stage();
                stage.setTitle("Pike");
                stage.setScene(new Scene(root));
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
