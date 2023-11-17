package puk.team.sandbox.javafxsandbox.grid;

import javafx.scene.Node;
import javafx.scene.paint.Color;

import java.util.function.Consumer;

public interface VisualGrid {

    void setup(int width, int height, int unitSize, Consumer<Node> visualConsumer);
    Node getActualNode();
    void fillCoordinates(Color color, Coordinate... coordinates);
    void clearCoordinates(Coordinate... coordinates);
}
