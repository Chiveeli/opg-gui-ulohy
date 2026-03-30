package sk.spse.uloha1.procedural;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    private TextField field1;
    private TextField field2;

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        HBox row1 = new HBox(10);
        Label label1 = new Label("Hodnota 1:");
        field1 = new TextField();
        field1.setPromptText("Zadajte číslo");
        Label unit1 = new Label("°C");
        row1.getChildren().addAll(label1, field1, unit1);

        HBox row2 = new HBox(10);
        Label label2 = new Label("Hodnota 2:");
        field2 = new TextField();
        field2.setPromptText("Automaticky vypočítané");
        Label unit2 = new Label("°F");
        row2.getChildren().addAll(label2, field2, unit2);

        root.getChildren().addAll(row1, row2);

        field1.setOnKeyTyped(this::onKeyTyped);
        field2.setOnKeyTyped(this::onKeyTyped);

        Scene scene = new Scene(root, 300, 150);

        stage.setTitle("Procedural Application 1");
        stage.setScene(scene);
        stage.show();
    }

    private void onKeyTyped(KeyEvent event) {
        TextField source = (TextField) event.getSource();
        TextField other = (source == field1) ? field2 : field1;
        try {
            String textSource = source.getText().trim();
            String textOther = other.getText().trim();
            if (!textSource.isEmpty() && textOther.isEmpty()) {
                double valSource = Double.parseDouble(textSource);
                double valOther = (source == field1) ? (valSource * 9.0 / 5.0) + 32 : (valSource - 32) * 5.0 / 9.0;
                other.setText(String.format("%.2f", valOther));
            }
        } catch (NumberFormatException ignored) {
        }
    }
}
