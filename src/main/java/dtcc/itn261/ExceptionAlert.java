package dtcc.itn261;

import javafx.scene.control.Alert;
// logic for Alert class
public class ExceptionAlert {
    public static void showFileNotFoundAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("File Error");
        alert.setHeaderText("File Not Found");
        alert.setContentText("The file you are trying to access does not exist.");
        alert.showAndWait();
    }

    public static void showIOAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("IO Error");
        alert.setHeaderText("Error Reading File");
        alert.setContentText("An error occurred while reading the file");
        alert.showAndWait();
    }
}
