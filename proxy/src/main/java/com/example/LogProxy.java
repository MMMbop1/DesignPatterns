package com.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class LogProxy implements Logger{

    private final String ACTIVITY_LOG_NAME = "proxy/src/main/resources/activity_log.txt";

    public LogProxy() {}

    @Override
    public void write(String data) {

        boolean illegalWord = filter(data);
        StringBuilder sb = new StringBuilder();
        sb.append(data);
        sb.append(" contains illegal words : ")
                .append(illegalWord).append(": type = write : date = ")
                .append(new Date());

        activity(sb.toString());

        if (!illegalWord) {
            Log.getInstance().write(data);
            return;
        }

        System.out.println("Your message contained bad phrasing");
    }

    @Override
    public String read() {
        StringBuilder sb = new StringBuilder();
        sb.append("type = read : date = ")
                .append(new Date());
        activity(sb.toString());

        return Log.getInstance().read();
    }

    public void activity(String data) {
        try {
            PrintWriter output = new PrintWriter
                    (new BufferedWriter
                            (new OutputStreamWriter
                                    (new FileOutputStream(ACTIVITY_LOG_NAME, true), StandardCharsets.UTF_8)));


            output.println(data);
            output.flush();
            output.close();

        } catch (IOException ex) {
            System.out.println("Something went wrong:" + ex.getMessage());
        }
    }

    private boolean filter(String data) {
        return data.contains("hamburger");
    }
}
