package dtcc.itn261;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CustomButtons extends Button {
// used to create custom buttons
    public CustomButtons(String buttonText, EventHandler<ActionEvent> eventHandler) {
        super(buttonText);
        this.setOnAction(eventHandler);
    }
}
