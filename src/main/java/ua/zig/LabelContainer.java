package ua.zig;

import javafx.scene.control.Label;

public class LabelContainer {
    private Label labelFrom;
    private Label labelTo;
    private String milliseconds;

    public String getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(String milliseconds) {
        this.milliseconds = milliseconds;
    }

    public Label getLabelFrom() {
        return labelFrom;
    }

    public Label getLabelTo() {
        return labelTo;
    }

    public LabelContainer(Label labelfrom, Label labelTo) {

        this.labelFrom = labelfrom;
        this.labelTo = labelTo;
    }
}
