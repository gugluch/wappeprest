package com.example.rest;

import com.example.rest.model.SplNumber;
import com.example.rest.model.SplRequest;
import com.example.rest.model.SplResponse;
import com.example.rest.model.SplResult;
import com.example.rest.util.RequestLogger;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SplServlet extends HttpServlet {
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

        SplRequest splRequest = gson.fromJson(requestBody, SplRequest.class);

        List<SplResult> results = new ArrayList<>();
        boolean needErFound = false;

        for (SplNumber splNumber : splRequest.getSpl_number()) {
            if ("NEED_ER".equals(splNumber.getErd_nr()) && !needErFound) {
                results.add(new SplResult(splNumber.getErd_nr(), splNumber.getCtrl_nr(), false, "wrong code"));
                needErFound = true;
            } else {
                results.add(new SplResult(splNumber.getErd_nr(), splNumber.getCtrl_nr(), true, ""));
            }
        }

        SplResponse splResponse = new SplResponse(true, results);

        String jsonResponse = gson.toJson(splResponse);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);

        RequestLogger.log(req, requestBody, jsonResponse);
    }
}
