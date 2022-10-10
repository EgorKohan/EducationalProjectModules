package patterns.state.java_example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FxUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Player player = new Player();
        stage.setTitle("Test Player");

        TextField textField = new TextField();
        textField.setDisable(true);

        Button buttonPlay = new Button("Play");
        buttonPlay.setOnMouseClicked(mouseEvent -> textField.setText(player.getState().onPlay()));
        Button buttonPause = new Button("Pause");
        buttonPause.setOnMouseClicked(mouseEvent -> textField.setText(player.getState().onLock()));
        Button buttonNext = new Button("Next");
        buttonNext.setOnMouseClicked(mouseEvent -> textField.setText(player.getState().onNext()));
        Button buttonPrev = new Button("Prev");
        buttonPrev.setOnMouseClicked(mouseEvent -> textField.setText(player.getState().onPrevious()));

        HBox hBox = new HBox(textField, buttonPlay, buttonPause, buttonNext, buttonPrev);

        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.show();
    }
}
