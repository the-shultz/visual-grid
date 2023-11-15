package puk.team.sandbox.javafxsandbox.grid;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.function.Consumer;

public class CanvasGrid implements VisualGrid {

    private int width;
    private int height;
    private int unitSize;
    private GraphicsContext g;
    
    @Override
    public void setup(int width, int height, int unitSize, Consumer<Node> visualConsumer) {
        this.width = width;
        this.height = height;
        this.unitSize = unitSize;
        Canvas canvas = new Canvas(width, height);

        g = canvas.getGraphicsContext2D();

        drawBasicGrid();
        visualConsumer.accept(canvas);
    }

    private void drawBasicGrid() {
        // background
        g.setFill(Color.BLACK);
        g.fillRect(0,0, this.width, this.height);

        // lines
        g.setStroke(Color.WHITE);
        // vertical
        for (int i = 0; i <= this.width; i+= this.unitSize) {
            g.strokeLine(i, 0, i, this.height);
        }
        // horizontal
        for (int i = 0; i <= height; i+= unitSize) {
            g.strokeLine(0, i, width, i);
        }
        
        // border
        g.setStroke(Color.RED);
        g.strokeRect(0,0, width, height);
    }

    @Override
    public void fillCoordinates(Color color, Coordinate... coordinates) {
        for (Coordinate coordinate : coordinates) {
            int xCord = (coordinate.x() - 1) * unitSize;
            int yCord = (coordinate.y() - 1) * unitSize;

            g.setFill(color);
            g.fillRect(xCord, yCord, unitSize, unitSize);
        }
    }

    @Override
    public void clearCoordinates(Coordinate... coordinates) {
        for (Coordinate coordinate : coordinates) {
            int xCord = (coordinate.x() - 1) * unitSize;
            int yCord = (coordinate.y() - 1) * unitSize;

            g.setFill(Color.BLACK);
            g.fillRect(xCord, yCord, unitSize, unitSize);
            g.setStroke(Color.WHITE);
            g.strokeRect(xCord, yCord, unitSize, unitSize);
        }
    }

}
