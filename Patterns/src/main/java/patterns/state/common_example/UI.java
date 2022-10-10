package patterns.state.common_example;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Might be extended. Just create documents list and allow to User publish/reject its.
 */

public class UI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        LoginScene loginScene = new LoginScene();
        loginScene.showLoginScene(stage);
    }
}

