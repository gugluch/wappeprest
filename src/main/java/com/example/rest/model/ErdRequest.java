package com.example.rest.model;

import java.util.List;

public class ErdRequest {
    private ErdKey erd_key;
    private String cm_name;
    private String or_type;
    private String ss_ifr;
    private List<SrNr> sr_nr;
    private List<Detail> details;

    public ErdKey getErd_key() {
        return erd_key;
    }

    public void setErd_key(ErdKey erd_key) {
        this.erd_key = erd_key;
    }

    public String getCm_name() {
        return cm_name;
    }

    public void setCm_name(String cm_name) {
        this.cm_name = cm_name;
    }

    public String getOr_type() {
        return or_type;
    }

    public void setOr_type(String or_type) {
        this.or_type = or_type;
    }

    public String getSs_ifr() {
        return ss_ifr;
    }

    public void setSs_ifr(String ss_ifr) {
        this.ss_ifr = ss_ifr;
    }

    public List<SrNr> getSr_nr() {
        return sr_nr;
    }

    public void setSr_nr(List<SrNr> sr_nr) {
        this.sr_nr = sr_nr;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
