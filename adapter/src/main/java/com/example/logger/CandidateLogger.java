package com.example.logger;

import com.example.logger.BestLogger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class CandidateLogger implements BestLogger {


    @Override
    public void log(String string, Date date) {
        try {

            PrintWriter output = new PrintWriter(
                    new BufferedWriter
                            (new OutputStreamWriter
                                    (new FileOutputStream("adapter/src/main/resources/log.txt", true), StandardCharsets.UTF_8)));

            output.println(string + " : " + date.toString());
            output.flush();
            output.close();
            System.out.println("Text has been generated to File");

        } catch (IOException ex) {
            System.out.println("Something went wrong writing to log" + ex.getMessage());
        }
    }
}
