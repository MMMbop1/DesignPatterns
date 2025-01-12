package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Properties;
import java.util.stream.Collectors;

public class Serializer {
    private final String fileName = "singleton/src/main/resources/file.cfg";

    public Serializer() {}

    public Person readPersonFromCfg() {
        Properties propsFromFile = loadProperties(getFileName());

        return propsFromFile.stringPropertyNames()
                .stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(
                                key -> key,
                                propsFromFile::getProperty
                        ),
                        personData -> new Person(
                                personData.get("name"),
                                Integer.parseInt(personData.get("age")),
                                personData.get("occupation"),
                                personData.get("email")
                        )
                ));
    }

    private Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream input = Files.newInputStream(Path.of(fileName))) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties from file: " + fileName, e);
        }
        return properties;
    }

    public String getFileName() {
        return fileName;
    }
}
