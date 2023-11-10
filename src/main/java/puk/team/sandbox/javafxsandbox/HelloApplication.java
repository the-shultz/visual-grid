package puk.team.sandbox.javafxsandbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import puk.team.sandbox.javafxsandbox.grid.CanvasGrid;
import puk.team.sandbox.javafxsandbox.grid.ResizeableCanvas;

import java.io.IOException;

public class HelloApplication extends Application {

    private final int WIDTH = 600;
    private final int HEIGHT = 400;

    @Override
    public void start(Stage stage) throws IOException {
        CanvasGrid canvasGrid = new CanvasGrid();
        canvasGrid.setup(WIDTH, HEIGHT, 25);
        StackPane root = new StackPane();
        canvasGrid.embed(v -> root.getChildren().add(v));
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}