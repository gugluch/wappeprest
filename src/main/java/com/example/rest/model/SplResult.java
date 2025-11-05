package com.example.rest.model;

public class SplResult {
    private String erd_nr;
    private String ctrl_nr;
    private boolean valid;
    private String err_text;

    public SplResult(String erd_nr, String ctrl_nr, boolean valid, String err_text) {
        this.erd_nr = erd_nr;
        this.ctrl_nr = ctrl_nr;
        this.valid = valid;
        this.err_text = err_text;
    }

    public String getErd_nr() {
        return erd_nr;
    }

    public void setErd_nr(String erd_nr) {
        this.erd_nr = erd_nr;
    }

    public String getCtrl_nr() {
        return ctrl_nr;
    }

    public void setCtrl_nr(String ctrl_nr) {
        this.ctrl_nr = ctrl_nr;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getErr_text() {
        return err_text;
    }

    public void setErr_text(String err_text) {
        this.err_text = err_text;
    }
}
