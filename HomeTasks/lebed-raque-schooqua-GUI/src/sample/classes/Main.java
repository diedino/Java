package sample.classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("/sample/fxml/sample.fxml"));
        primaryStage.setTitle("Swan, Crawfish, Pike");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/images/icon.jpg")));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setResizable(false);
        //------------SWAN BUTTON------------
        Button swanbtn = (Button) primaryStage.getScene().lookup("#swanbtn");
        InputStream input =
                getClass().getResourceAsStream("/images/swan.png");

        Image image = new Image(input,40,40,false, true);
        ImageView imageView = new ImageView(image);
        swanbtn.setText("Swan");
        swanbtn.setGraphic(imageView);
        //------------SWAN BUTTON------------
        //------------CRAWFISH BUTTON------------
        Button crawfishbtn = (Button) primaryStage.getScene().lookup("#crawfishbtn");
        input =
                getClass().getResourceAsStream("/images/crawfish.png");

        image = new Image(input,40,40,false, true);
        imageView = new ImageView(image);
        crawfishbtn.setText("Crawfish");
        crawfishbtn.setGraphic(imageView);
        //------------CRAWFISH BUTTON------------
        //------------PIKE BUTTON------------
        Button pikebtn = (Button) primaryStage.getScene().lookup("#pikebtn");
        input =
                getClass().getResourceAsStream("/images/pike.png");

        image = new Image(input,40,40,false, true);
        imageView = new ImageView(image);
        pikebtn.setText("Pike");
        pikebtn.setGraphic(imageView);
        //------------PIKE BUTTON------------
        root.getChildren().addAll(swanbtn, crawfishbtn, pikebtn);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}