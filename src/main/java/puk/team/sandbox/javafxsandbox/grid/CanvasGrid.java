package puk.team.sandbox.javafxsandbox.grid;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.function.Consumer;

public class CanvasGrid implements VisualGrid {

    private int width;
    private int height;
    private int unitSize;
    private ResizeableCanvas canvas;

    @Override
    public void setup(int width, int height, int unitSize) {
        canvas = new ResizeableCanvas(width, height);

        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.YELLOW);
        g.fillRect(
                0,
                0,
                canvas.getWidth(),
                canvas.getHeight());
        g.setStroke(Color.RED);
        g.strokeLine(10, 10 , 20, 20);

    }

    @Override
    public void embed(Consumer<Node> visualConsumer) {
        visualConsumer.accept(canvas);
    }

    @Override
    public void fillCoordinates(Color color, Coordinate... coordinates) {

    }


}
