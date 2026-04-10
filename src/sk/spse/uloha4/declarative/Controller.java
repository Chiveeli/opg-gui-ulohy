package sk.spse.uloha4.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.Random;

public class Controller {
    @FXML private VBox vbox1;
    @FXML private VBox vbox2;
    @FXML private VBox vbox3;
    @FXML private VBox vbox4;

    @FXML private ImageView img1;
    @FXML private ImageView img2;
    @FXML private ImageView img3;
    @FXML private ImageView img4;

    private final Random rand = new Random();

    private String getRandomColor() {
        String r = String.format("%02X", rand.nextInt(256));
        String g = String.format("%02X", rand.nextInt(256));
        String b = String.format("%02X", rand.nextInt(256));
        return "#" + r + g + b;
    }

    private double getRandomOpacity() {
        return 0.3 + rand.nextDouble() * 0.7;
    }

    private double getRandomScale() {
        return 0.3 + rand.nextDouble() * 1.5;
    }

    @FXML
    private void randomize() {
        vbox1.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity: " + getRandomOpacity() + ";");
        vbox2.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity: " + getRandomOpacity() + ";");
        vbox3.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity: " + getRandomOpacity() + ";");
        vbox4.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity: " + getRandomOpacity() + ";");
        img1.setRotate(rand.nextDouble() * 360 - 180);
        img2.setScaleX(getRandomScale());
        img3.setScaleY(getRandomScale());
        img4.setScaleX(getRandomScale());
        img4.setScaleY(getRandomScale());
        img4.setRotate(rand.nextDouble() * 360 - 180);
    }

    @FXML
    private void close() {
        Platform.exit();
    }
}