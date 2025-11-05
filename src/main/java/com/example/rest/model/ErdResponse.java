package com.example.rest.model;

public class ErdResponse {
    private String erd_nr;
    private String ctrl_nr;
    private String add_info;

    public ErdResponse(String erd_nr, String ctrl_nr, String add_info) {
        this.erd_nr = erd_nr;
        this.ctrl_nr = ctrl_nr;
        this.add_info = add_info;
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

    public String getAdd_info() {
        return add_info;
    }

    public void setAdd_info(String add_info) {
        this.add_info = add_info;
    }
}
