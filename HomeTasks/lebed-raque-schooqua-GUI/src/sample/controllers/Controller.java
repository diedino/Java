package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import sample.lastHW.*;

public class Controller {

    private Cart cart;

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
    private Circle circle;

    @FXML
    private Button startbtn;

    @FXML
    private Button stopbtn;

    @FXML
    private Button resetbtn;

    @FXML
    private AnchorPane coordsPane;

    @FXML
    private TextField xField;

    @FXML
    private TextField yField;

    @FXML
    private TextField timeField;

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
        startbtn.setOnAction(actionEvent -> {
            if (tryParseDouble(timeField.getText()) && tryParseDouble(xField.getText()) && tryParseDouble(yField.getText())){
                circle.setCenterX(Double.parseDouble(xField.getText()));
                circle.setCenterY(Double.parseDouble(yField.getText())*(-1));
                circle.setRadius(7);
                cart = new Cart();
                Pulling pulling = new Pulling(
                        cart,
                        Long.parseLong(timeField.getText()),
                        new Animal("lebed", 60),
                        new Animal("raque", 180),
                        new Animal("schooqua", 300));
                pulling.start();
                System.out.println("123");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Allert");
                alert.setHeaderText("Can't parse one of fields");
                alert.show();
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
    boolean tryParseDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
