package com.example.iot;

import java.util.Map;

public class cambio {
    String id_variable,id_widgets;
    int val;

    public cambio() {
    }

    public cambio(String id_variable, String id_widgets, int val) {
        this.id_variable = id_variable;
        this.id_widgets = id_widgets;
        this.val = val;
    }

    public String getId_widgets() {
        return id_widgets;
    }

    public void setId_widgets(String id_widgets) {
        this.id_widgets = id_widgets;
    }

    public String getId_variable() {
        return id_variable;
    }

    public void setId_variable(String id_variable) {
        this.id_variable = id_variable;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
