package com.example;

import com.example.logger.CandidateLogger;
import com.example.textgenerator.RandomTextGenerator;

public class Main {
    public static void main(String[] args) {
        CandidateLogger candidateLogger = new CandidateLogger();
        LoggerAdapter loggerAdapter = new LoggerAdapter(candidateLogger);

        RandomTextGenerator textGenerator = new RandomTextGenerator();
        textGenerator.createString(10, loggerAdapter);
    }
}