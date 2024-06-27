/**==================================================
Author: Kyle Stranick
Class: ITN261
Class Section: 201
Assignment: 10 - Grade book: JavaFX, File I/O, CSV Parsing
Notes:

=====================================================

Code adapted from: check resources

===================================================== */


package dtcc.itn261;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GradeBook extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the JavaFX application and initializes the GUI.
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. Applications may
     *                     create other stages, if needed, but they will not be
     *                     primary stages.
     */
    @Override
    public void start(Stage primaryStage) {

        try {
            LoadRoster roster = new LoadRoster();

            // Setting banner image
            BorderPane root = new BorderPane();

            //setting scene
            Scene scene = new Scene(root, 1024, 1000);

            BannerImage bannerImage = new BannerImage(scene.widthProperty());
            root.setTop(bannerImage);

            InitializeAndSetupGUI guiSetUp = new InitializeAndSetupGUI(roster); // is its own VBox

            // using ControlPanelLayout class to display components
            root.setCenter(guiSetUp);
            primaryStage.setScene(scene);

        } catch (FileNotFoundException e) {
            ExceptionAlert.showFileNotFoundAlert();
            Platform.exit();
        } catch (IOException e) {
            ExceptionAlert.showIOAlert();
            Platform.exit();
        }

        // creating and displaying stage
        primaryStage.setTitle("Grade Book");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
