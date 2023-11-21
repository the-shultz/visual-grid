package puk.team.sandbox.javafxsandbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import puk.team.sandbox.javafxsandbox.main.VisualGridMainController;

import java.io.IOException;
import java.net.URL;

public class VisualGridApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        URL resource = VisualGridApplication.class.getResource("visual-world-main.fxml");
        loader.setLocation(resource);
        Parent root = loader.load();
        VisualGridMainController controller = loader.getController();

        Scene scene = new Scene(root, 1000, 1000);
        stage.setMinHeight(700);
        stage.setMinWidth(800);
        stage.setTitle("Visual Grid Sandbox !");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}