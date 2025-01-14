package com.example;

public class RandomTextGenerator implements TextGenerator {

    private Logger logger;

    public RandomTextGenerator() {}

    public RandomTextGenerator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void createString(int length, Logger logger) {

    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

}
