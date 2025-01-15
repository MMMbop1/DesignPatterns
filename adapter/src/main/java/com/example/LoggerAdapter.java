package com.example;

import com.example.logger.CandidateLogger;
import com.example.logger.Logger;

import java.util.Date;

public class LoggerAdapter implements Logger {
    private CandidateLogger candidateLogger;

    public LoggerAdapter() {}

    public LoggerAdapter(CandidateLogger candidateLogger) {
        this.candidateLogger = candidateLogger;
    }

    @Override
    public void log(String string) {
        candidateLogger.log(string, new Date());
    }

    public CandidateLogger getCandidateLogger() {
        return candidateLogger;
    }

    public void setCandidateLogger(CandidateLogger candidateLogger) {
        this.candidateLogger = candidateLogger;
    }
}
