package appli.ininity;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage stage;
    private static FXMLLoader fxmlLoader;
    @Override
    public void start(Stage firstStage) throws IOException {

        stage = firstStage;
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("accueill.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeScene(String fxml,Object controller) {
        // Step 1
        stage.close();
        try {
            // Step 2
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
            // Step 4
            fxmlLoader.setController(controller);
            // Step 5
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }
    public static void changeScene(String fxml) {
        // Step 1
        stage.close();
        try {
            // Step 2
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
            // Step 5
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

}