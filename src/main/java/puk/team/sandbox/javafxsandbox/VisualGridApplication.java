package puk.team.sandbox.javafxsandbox;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import puk.team.sandbox.javafxsandbox.grid.CanvasGrid;

import java.io.IOException;

public class VisualGridApplication extends Application {

    private final int WIDTH = 600;
    private final int HEIGHT = 400;

    @Override
    public void start(Stage stage) throws IOException {
        CanvasGrid canvasGrid = new CanvasGrid();
        canvasGrid.setup(WIDTH, HEIGHT, 25);
        final StackPane root = new StackPane();
        canvasGrid.embed(v -> {
            root.getChildren().add(v);
        });

        Scene scene = new Scene(root, WIDTH + 100, HEIGHT + 100);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}