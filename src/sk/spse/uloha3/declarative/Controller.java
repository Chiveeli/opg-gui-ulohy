package sk.spse.uloha3.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class Controller {

    @FXML
    private void openLink() {
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI("https://www.spse-po.sk"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void close() {
        Platform.exit();
    }
}