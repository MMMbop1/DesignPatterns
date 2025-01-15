package com.example.textgenerator;

import com.example.logger.Logger;

import java.util.Random;

public class RandomTextGenerator implements TextGenerator {

    public RandomTextGenerator() {}

    @Override
    public void createString(int length, Logger logger) {
        StringBuilder stringBuilder = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            char randomChar = (char) ('A' + random.nextInt(26));
            stringBuilder.append(randomChar);
        }

        logger.log(stringBuilder.toString());
    }
}
