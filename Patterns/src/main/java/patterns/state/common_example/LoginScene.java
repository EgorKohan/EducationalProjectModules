package patterns.state.common_example;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class LoginScene {

    private boolean isAdmin = false;

    public void showLoginScene(Stage stage) {
        Label label = new Label("Input your name");
        CheckBox checkBox = new CheckBox("Is it admin");
        Button button = new Button("Login");
        button.setOnMouseClicked(mouseEvent -> {
            isAdmin = checkBox.isSelected();
            showDocumentsScene(stage);
        });
        VBox vBox = new VBox(label, checkBox, button);
        vBox.setPadding(new Insets(10));
        stage.setScene(new Scene(vBox));
        stage.show();
    }

    public void showDocumentsScene(Stage stage) {
        TextField textField = new TextField();
        textField.setDisable(true);
        Button publish = new Button("Publish");
        Button reject = new Button("Reject");
        List<Document> documentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            documentList.add(new Document(String.valueOf(i), "Some Text " + i * i));
        }
        ListView<Document> listView = new ListView<>(FXCollections.observableList(documentList));
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView.getSelectionModel().selectedItemProperty().addListener((observableValue, documentMultipleSelectionModel, document) -> {
            document.setAdmin(isAdmin);
            textField.setText(document.getText());
            publish.setOnMouseClicked(mouseEvent -> textField.setText(document.getState().publish()));
            reject.setOnMouseClicked(mouseEvent -> textField.setText(document.getState().reject()));
        });

        VBox vBox = new VBox(listView, textField, publish, reject);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);

        stage.setScene(scene);
        stage.show();
    }

}
