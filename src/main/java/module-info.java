module puk.team.sandbox.javafxsandbox {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens puk.team.sandbox.javafxsandbox to javafx.fxml;
    exports puk.team.sandbox.javafxsandbox;
}