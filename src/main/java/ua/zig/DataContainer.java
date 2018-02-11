package ua.zig;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataContainer {
    private StringProperty data1 = new SimpleStringProperty();
    private StringProperty data2 = new SimpleStringProperty();

    public DataContainer(String data1, String data2) {
        this.data1.setValue(data1);
        this.data2.setValue(data2);
    }

    public String getData1() {
        return data1.get();
    }

    public StringProperty data1Property() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1.set(data1);
    }

    public String getData2() {
        return data2.get();
    }

    public StringProperty data2Property() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2.set(data2);
    }
}
