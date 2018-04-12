package ui;

import code.DisplayUtility;

public abstract class Ui {
    protected DisplayUtility du;

    public Ui(DisplayUtility displayUtility) {
        this.du = displayUtility;
    }
}