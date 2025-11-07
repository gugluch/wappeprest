package com.example.rest.util;

import jakarta.servlet.http.HttpServletRequest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestLogger {

    public static synchronized void log(HttpServletRequest request, String requestBody, String responseBody) {
        try {
            String warName = getWarName(request);
            File logFile = getLogFile(warName);

            try (FileWriter fw = new FileWriter(logFile, true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {

                String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
                out.println("Start Time: " + startTime);
                out.println("Request: " + requestBody);
                out.println("Response: " + responseBody);
                String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
                out.println("End Time: " + endTime);
                out.println("---------------------------------------------------");
            }
        } catch (IOException e) {
            // In a real application, you'd want to log this error to the console or another logger
            e.printStackTrace();
        }
    }

    private static String getWarName(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        if (contextPath == null || contextPath.isEmpty() || contextPath.equals("/")) {
            // This is the ROOT context
            return "ROOT";
        }
        // remove the leading slash
        return contextPath.substring(1);
    }

    private static File getLogFile(String warName) {
        String catalinaBase = System.getProperty("catalina.base");
        if (catalinaBase == null) {
            // Fallback for environments where catalina.base is not set
            // In a real application, you might want a more robust fallback
            catalinaBase = ".";
        }
        File logsDir = new File(catalinaBase, "logs");
        if (!logsDir.exists()) {
            logsDir.mkdirs();
        }
        return new File(logsDir, warName + ".log");
    }
}
