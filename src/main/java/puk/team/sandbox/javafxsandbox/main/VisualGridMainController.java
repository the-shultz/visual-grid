package puk.team.sandbox.javafxsandbox.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
import puk.team.sandbox.javafxsandbox.grid.CanvasGrid;
import puk.team.sandbox.javafxsandbox.grid.Coordinate;

public class VisualGridMainController {

    @FXML
    private ColorPicker coordinateColorPicker;

    @FXML
    private Spinner<Integer> coordinateColumnSpinner;

    @FXML
    private Spinner<Integer> coordinateRowSpinner;

    @FXML
    private GridPane gridPlaceholder;

    @FXML
    private Spinner<Integer> setupColumnsSpinner;

    @FXML
    private Spinner<Integer> setupRowsSpinner;

    @FXML
    private Spinner<Integer> setupUnitsizeSpinner;
    private CanvasGrid canvasGrid;

    @FXML
    public void initialize() {
        SpinnerValueFactory.IntegerSpinnerValueFactory rowsSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 10, 1);
        setupRowsSpinner.setValueFactory(rowsSpinnerValueFactory);
        SpinnerValueFactory.IntegerSpinnerValueFactory columnsSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 10, 1);
        setupColumnsSpinner.setValueFactory(columnsSpinnerValueFactory);
        SpinnerValueFactory.IntegerSpinnerValueFactory stepSizeSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 75, 25, 5);
        setupUnitsizeSpinner.setValueFactory(stepSizeSpinnerValueFactory);

        SpinnerValueFactory.IntegerSpinnerValueFactory coordinateRowsSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 10, 1);
        coordinateRowsSpinnerValueFactory.maxProperty().bind(rowsSpinnerValueFactory.valueProperty());
        coordinateRowSpinner.setValueFactory(coordinateRowsSpinnerValueFactory);
        SpinnerValueFactory.IntegerSpinnerValueFactory coordinateColumnsSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 10, 1);
        coordinateColumnsSpinnerValueFactory.maxProperty().bind(columnsSpinnerValueFactory.valueProperty());
        coordinateColumnSpinner.setValueFactory(coordinateColumnsSpinnerValueFactory);


        canvasGrid = new CanvasGrid();
        rebuildGrid();
    }

    @FXML
    void changeLayoutButtonClicked(ActionEvent event) {
        rebuildGrid();
    }

    private void rebuildGrid() {
        Integer selectedUnitSize = setupUnitsizeSpinner.getValue();
        int newWidth = setupColumnsSpinner.getValue() * selectedUnitSize;
        int newHeight = setupRowsSpinner.getValue() * selectedUnitSize;
        // clear old grid, if such exists
        gridPlaceholder.getChildren().remove(canvasGrid.getActualNode());

        // place new grid node at the correct place
        canvasGrid.setup(newWidth, newHeight, selectedUnitSize, cg -> {
            gridPlaceholder.add(cg, 1, 1);
        });

    }

    @FXML
    void clearCoordinateClicked(ActionEvent event) {
        canvasGrid.clearCoordinates(new Coordinate(coordinateRowSpinner.getValue(), coordinateColumnSpinner.getValue()));
    }

    @FXML
    void setCoordinateClicked(ActionEvent event) {
        canvasGrid.fillCoordinates(coordinateColorPicker.getValue(), new Coordinate(coordinateRowSpinner.getValue(), coordinateColumnSpinner.getValue()));
    }
}