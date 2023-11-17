package puk.team.sandbox.javafxsandbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import puk.team.sandbox.javafxsandbox.grid.CanvasGrid;
import puk.team.sandbox.javafxsandbox.grid.Coordinate;
import puk.team.sandbox.javafxsandbox.main.VisualGridMainController;

import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class VisualGridApplication extends Application {

    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int UNIT_SIZE = 25;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        URL resource = VisualGridApplication.class.getResource("visual-world-main.fxml");
        loader.setLocation(resource);
        Parent root = loader.load();
        VisualGridMainController controller = loader.getController();
        //controller.setup(WIDTH, HEIGHT, UNIT_SIZE);

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