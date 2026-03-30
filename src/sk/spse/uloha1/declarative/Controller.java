package sk.spse.uloha1.declarative;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML private TextField field1;
    @FXML private TextField field2;
    @FXML
    private void onKeyTyped(KeyEvent event) {
        TextField source = (TextField) event.getSource();
        TextField target = (source == field1) ? field2 : field1;

        try {
            String text = source.getText().trim();
            if (!text.isEmpty()) {
                double value = Double.parseDouble(text);
                double converted = (source == field1) ?
                        (value * 9.0 / 5.0) + 32 :
                        (value - 32) * 5.0 / 9.0;
                target.setText(String.format("%.2f", converted));
            }
        } catch (NumberFormatException ignored) {
        }
    }
}
