package puk.team.sandbox.javafxsandbox;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import puk.team.sandbox.javafxsandbox.grid.CanvasGrid;
import puk.team.sandbox.javafxsandbox.grid.Coordinate;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class VisualGridApplication extends Application {

    private final int WIDTH = 600;
    private final int HEIGHT = 400;

    @Override
    public void start(Stage stage) throws IOException {
        CanvasGrid canvasGrid = new CanvasGrid();
        final StackPane root = new StackPane();
        canvasGrid.setup(WIDTH, HEIGHT, 25, v -> {
            root.getChildren().add(v);
        });

        canvasGrid.fillCoordinates(Color.RED, new Coordinate(2, 2));
        canvasGrid.fillCoordinates(Color.GREEN, new Coordinate(3, 3));
        canvasGrid.fillCoordinates(Color.BLUE, new Coordinate(3, 4));
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                canvasGrid.clearCoordinates(new Coordinate(3, 4), new Coordinate(2, 2));
            }
        }, 3000);
        Scene scene = new Scene(root, WIDTH + 100, HEIGHT + 100);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}