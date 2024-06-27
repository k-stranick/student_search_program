package dtcc.itn261;

import javafx.scene.control.ComboBox;

public class SelectableDropDownBox extends ComboBox<ProgramOfStudy> {

    public SelectableDropDownBox() {
        this.getItems().addAll(ProgramOfStudy.values());
        this.setValue(ProgramOfStudy.SELECTION);
    }

    /*public ClassStandingDropDown() need to re-implement on refactor
    {
        this.getItems().addAll(ClassStanding.values());
        this.setValue(ClassStanding.SELECTION);
    }*/
}