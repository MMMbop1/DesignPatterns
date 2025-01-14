package com.example;

public class LoggerAdapter implements Logger {
    private CandidateLogger candidateLogger;

    public LoggerAdapter() {}

    public LoggerAdapter(CandidateLogger candidateLogger) {
        this.candidateLogger = candidateLogger;
    }

    @Override
    public void log(String string) {

    }

    public CandidateLogger getCandidateLogger() {
        return candidateLogger;
    }

    public void setCandidateLogger(CandidateLogger candidateLogger) {
        this.candidateLogger = candidateLogger;
    }
}
