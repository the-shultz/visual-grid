package puk.team.sandbox.javafxsandbox.grid;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.paint.Color;

import java.util.function.Consumer;

public interface VisualGrid {

    void setup(int width, int height, int unitSize);

    void embed(Consumer<Node> visualConsumer);

    void fillCoordinates(Color color, Coordinate... coordinates);


}
