package puk.team.sandbox.javafxsandbox.grid;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ResizeableCanvas extends Region {

    private Canvas canvas;

    public ResizeableCanvas(double width, double height) {

        //set the width and height of this and the canvas as the same
        setWidth(width);
        setHeight(height);

        //create and add the canvas as a child
        canvas = new Canvas(width, height);
        getChildren().add(canvas);
    }

    public GraphicsContext getGraphicsContext2D() {
        return canvas.getGraphicsContext2D();
    }
}
