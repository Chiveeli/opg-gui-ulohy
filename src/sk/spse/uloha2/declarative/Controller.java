package sk.spse.uloha2.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Controller {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ToggleGroup pohlavieGroup;
    @FXML
    private void register() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String pohlavie = ((RadioButton) pohlavieGroup.getSelectedToggle()).getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registrácia užívateľa");
        alert.setHeaderText("Registrácia prebehla úspešne");
        alert.setContentText("Užívateľ " + username + " (" + pohlavie + ") s heslom "
                + password + " bol pridaný do systému");
        alert.showAndWait();
    }
    @FXML
    private void close() {
        Platform.exit();
    }
}