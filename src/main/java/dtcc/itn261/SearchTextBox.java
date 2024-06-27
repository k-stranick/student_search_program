package dtcc.itn261;

import javafx.scene.control.TextField;

public class SearchTextBox extends TextField {
    private static final String PROMPT_TEXT = "Search By Name, Student Number, or Program of Study";

    public SearchTextBox() {
        this.setPromptText(PROMPT_TEXT);
    }
}
