module dtcc.itn {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens dtcc.itn261 to javafx.fxml;
    exports dtcc.itn261;
}