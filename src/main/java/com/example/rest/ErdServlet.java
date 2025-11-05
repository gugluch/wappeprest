package com.example.rest;

import com.example.rest.model.ErdRequest;
import com.example.rest.model.ErdResponse;
import com.example.rest.model.SrNr;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ErdServlet extends HttpServlet {
    private final Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String requestBody = sb.toString();

        ErdRequest erdRequest = gson.fromJson(requestBody, ErdRequest.class);

        List<ErdResponse> erdResponses = new ArrayList<>();
        for (SrNr srNr : erdRequest.getSr_nr()) {
            String erdNr = srNr.getErd_nr();
            String ctrlNr = srNr.getCtrl_nr();
            String addInfo = "";
            if (erdNr != null && !erdNr.isEmpty()) {
                addInfo += erdNr.charAt(0);
            }
            if (ctrlNr != null && !ctrlNr.isEmpty()) {
                addInfo += ctrlNr.charAt(0);
            }
            erdResponses.add(new ErdResponse(erdNr + "TX", ctrlNr, addInfo));
        }

        String jsonResponse = gson.toJson(erdResponses);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);
    }
}
