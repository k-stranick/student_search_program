package dtcc.itn261;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class StudentListView extends ListView<Student> {
    private final ObservableList<Student> studentDataArray = FXCollections.observableArrayList();
    private final LoadRoster roster;

    public StudentListView(LoadRoster roster) {
        super(); // calls constructor from ListView class
        this.roster = roster;
        this.setItems(studentDataArray);
    }

    // used with combo box
    public void updateStudentList(ProgramOfStudy program) {
        studentDataArray.clear();
        var students = roster.GetStudentsByProgramOfStudy(program);
        studentDataArray.addAll(students);
    }

    // used for searchbar
    public void searchAndUpdateStudentList(String query) {
        studentDataArray.clear();
        var searchResults = roster.searchForStudent(query); // holds array of selected elements for use in the search bar
        studentDataArray.addAll(searchResults);
    }
}
