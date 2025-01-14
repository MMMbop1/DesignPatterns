package com.example;

public class Main {
    public static void main(String[] args) {
        CurrentLogger logger = new CurrentLogger();
        RandomTextGenerator textGenerator = new RandomTextGenerator(logger);

        CandidateLogger candidateLogger = new CandidateLogger();
        LoggerAdapter loggerAdapter = new LoggerAdapter(candidateLogger);
        RandomTextGenerator textGenerator1 = new RandomTextGenerator(loggerAdapter);
    }
}