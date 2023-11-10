package puk.team.sandbox.javafxsandbox.grid;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

import static javafx.scene.layout.BorderStroke.MEDIUM;

public class ResizeableCanvas extends Region {

    private Canvas canvas;

    public ResizeableCanvas(double width, double height) {
        //set the width and height of this and the canvas as the same
        setWidth(width);
        setHeight(height);
        canvas = new Canvas(width, height);
        //add the canvas as a child
        getChildren().add(canvas);
        //bind the canvas width and height to the region
//        canvas.widthProperty().bind(this.widthProperty());
//        canvas.heightProperty().bind(this.heightProperty());

        setBorder(Border.stroke(Color.RED));
    }

    public GraphicsContext getGraphicsContext2D() {
        return canvas.getGraphicsContext2D();
    }
}
