package dtcc.itn261;

import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class InitializeAndSetupGUI extends VBox {
    private SelectableDropDownBox cbxProgram;
    private final StudentListView listview;
    private Label displayedStudentInformation;
    private SearchTextBox searchBox;
    private CustomButtons clearButton;

    public InitializeAndSetupGUI(LoadRoster roster) {
        super(); // call VBox's constructor
        this.listview = new StudentListView(roster);
        initializeSearchBox();
        initializeComboBox();
        initializeClearButton();
        initializeSelectedResults();
        setupLayout();
    }

    private void setupLayout() {
        SplitPane splitPane = new SplitPane();
        HBox comboBoxAndButton = new HBox(10); // 10 is the spacing between the ComboBox and the Button
        VBox leftPane = new VBox(comboBoxAndButton,searchBox, listview);
        VBox rightPane = new VBox(displayedStudentInformation);

        comboBoxAndButton.getChildren().addAll(cbxProgram, clearButton);
        rightPane.setBackground(Background.fill(Color.DARKSLATEGRAY));
        splitPane.getItems().addAll(leftPane, rightPane);

        this.getChildren().addAll(splitPane);
    }

    // logic for selecting a student
    private void initializeSelectedResults() {
        this.displayedStudentInformation = new Label();

        listview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                displayedStudentInformation.setTextFill(Color.LIGHTGOLDENRODYELLOW);
                displayedStudentInformation.setText(String.format("Selected Student: %s - Average for student: %.2f", newValue.getFullName(), newValue.getAverage()));
            }
        });
    }

    private void initializeSearchBox() {
        //creating new instance of search text box
        this.searchBox = new SearchTextBox();
        searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                listview.updateStudentList(cbxProgram.getValue());
            } else {
                listview.searchAndUpdateStudentList(newValue);
            }
        });
    }

    private void initializeComboBox() {
        //creating a new instance of class standing combo box
        this.cbxProgram = new SelectableDropDownBox();

        cbxProgram.setOnAction(e -> {
            ProgramOfStudy selectedProgram = cbxProgram.getValue();
            if (selectedProgram != ProgramOfStudy.SELECTION) {
                listview.updateStudentList(selectedProgram);
            }
        });
    }

    private void initializeClearButton(){
        this.clearButton = new CustomButtons("Clear", e -> clearUI());
    }

    /**
     * Reset the search box
     *  to make right pane "clear"
     *  Reset the class standing dropdown
     */
    private void clearUI() {
        searchBox.clear();
        displayedStudentInformation.setText("");
        cbxProgram.getSelectionModel().clearSelection();
        cbxProgram.setValue(ProgramOfStudy.SELECTION);
        listview.getSelectionModel().clearSelection();
    }
}
