package com.example.rest.model;

import java.util.List;

public class SplResponse {
    private boolean valid;
    private List<SplResult> results;

    public SplResponse(boolean valid, List<SplResult> results) {
        this.valid = valid;
        this.results = results;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<SplResult> getResults() {
        return results;
    }

    public void setResults(List<SplResult> results) {
        this.results = results;
    }
}
