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
        canvas.setLayoutX(50);
        canvas.setLayoutY(50);

//        Border border = new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.DOTTED, null, new BorderWidths(3)));
//        setBorder(border);

        //bind the canvas width and height to the region
//        canvas.widthProperty().bind(this.widthProperty());
//        canvas.heightProperty().bind(this.heightProperty());
    }

    public GraphicsContext getGraphicsContext2D() {
        return canvas.getGraphicsContext2D();
    }
}
