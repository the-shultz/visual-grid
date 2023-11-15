package puk.team.sandbox.javafxsandbox.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import puk.team.sandbox.javafxsandbox.grid.CanvasGrid;

public class VisualGridMainController {

    public void setup(int width, int height, int unitSize) {
        CanvasGrid canvasGrid = new CanvasGrid();
        canvasGrid.setup(width, height, unitSize, cg -> {
            gridPlaceholder.add(cg, 1, 1);
        });
    }

    @FXML
    private ColorPicker coordinateColorPicker;

    @FXML
    private Spinner<?> coordinateColumnSpinner;

    @FXML
    private Spinner<?> coordinateRowSpinner;

    @FXML
    private GridPane gridPlaceholder;

    @FXML
    private Spinner<?> setupColumnsSpinner;

    @FXML
    private Spinner<?> setupRowsSpinner;

    @FXML
    private Spinner<?> setupUnitsizeSpinner;

    @FXML
    void changeLayoutButtonClicked(ActionEvent event) {

    }

    @FXML
    void clearCoordinateClicked(ActionEvent event) {

    }

    @FXML
    void setCoordinateClicked(ActionEvent event) {

    }
}