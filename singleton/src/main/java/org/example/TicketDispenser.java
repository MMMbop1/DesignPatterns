package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TicketDispenser {

    private static final String CFG_FILE_PATH = "singleton/src/main/resources/file.cfg";
    private String name;
    private int ticketNumber;
    private boolean empty;
    private static TicketDispenser ticketDispenser;

    private TicketDispenser() {
        Properties propsFromFile = loadProperties();
        this.name = propsFromFile.getProperty("name");
        this.ticketNumber = Integer.parseInt(propsFromFile.getProperty("ticketNumber"));
        this.empty = Boolean.parseBoolean(propsFromFile.getProperty("empty"));
    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        try {
            InputStream input = Files.newInputStream(Path.of(CFG_FILE_PATH));
            properties.load(input);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties from file: " + "singleton/src/main/resources/file.cfg", e);
        }
        return properties;
    }

    public void writeProperties() {
        Properties properties = new Properties();
        ticketDispenserToMap().forEach(properties::setProperty);

        try {
            OutputStream output = Files.newOutputStream(Path.of(CFG_FILE_PATH));
            properties.store(output, null);
            output.flush();
            output.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to write properties to file: " + "singleton/src/main/resources/file.cfg", e);
        }
    }

    public static synchronized TicketDispenser getInstance() {
        if (ticketDispenser == null) {
            ticketDispenser = new TicketDispenser();
        }

        return ticketDispenser;
    }

    public int printTicket() {
        if (ticketNumber > 20) {
            empty = true;
            return -1;
        }

        return ticketNumber++;
    }

    public void resetTicketDispenser() {
        this.ticketNumber = 0;
        this.empty = false;
        writeProperties();
    }

    public String getName() {
        return name;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public boolean isEmpty() {
        return empty;
    }

    public Map<String, String> ticketDispenserToMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("ticketNumber", String.valueOf(ticketNumber));
        map.put("empty", String.valueOf(empty));

        return map;
    }
}
