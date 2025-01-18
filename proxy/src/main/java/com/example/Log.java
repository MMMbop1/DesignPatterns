package com.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Log implements Logger{

    private static Log log;
    private final String LOG_NAME = "proxy/src/main/resources/log.txt";

    private Log() {}

    public synchronized static Log getInstance() {
        if (log == null) {
            log = new Log();
        }

        return log;
    }

    @Override
    public void write(String data) {
        try {
        PrintWriter output = new PrintWriter
                (new BufferedWriter
                        (new OutputStreamWriter
                                (new FileOutputStream(LOG_NAME, true), StandardCharsets.UTF_8)));


        output.println(data);
        output.flush();
        output.close();

        } catch (IOException ex) {
            System.out.println("Something went wrong:" + ex.getMessage());
        }
    }

    @Override
    public String read() {
        String data = null;

        try {
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader
                        (new FileInputStream(LOG_NAME)));

            data = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));

        } catch (IOException ex) {
            System.out.println("Something went wrong:" + ex.getMessage());
        }

        return data;
    }
}
