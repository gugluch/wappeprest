package com.example.rest.model;

import java.util.List;

public class SplRequest {
    private String src_idtr;
    private List<SplNumber> spl_number;

    public String getSrc_idtr() {
        return src_idtr;
    }

    public void setSrc_idtr(String src_idtr) {
        this.src_idtr = src_idtr;
    }

    public List<SplNumber> getSpl_number() {
        return spl_number;
    }

    public void setSpl_number(List<SplNumber> spl_number) {
        this.spl_number = spl_number;
    }
}
