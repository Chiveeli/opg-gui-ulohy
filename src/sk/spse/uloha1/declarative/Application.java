package sk.spse.uloha1.declarative;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("primary.fxml"));

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        String cssPath = getClass().getResource("styl.css").toExternalForm();
        scene.getStylesheets().add(cssPath);

        stage.setTitle("Declarative Application 1");
        stage.setScene(scene);
        stage.show();
    }
}