package com.example;

import com.example.InvestmentAccountService;
import com.example.services.FundService;
import com.example.services.OptionsService;
import com.example.services.Service;
import com.example.services.StockService;

import java.util.Random;

public class InvestmentFacade {

    private final Service stockService = new StockService();
    private final Service fundService = new FundService();
    private final Service optionService = new OptionsService();

    public String getAssets(String userId) {
        Double stockAssets = stockService.getAssetAmount(userId);
        Double fundAssets = fundService.getAssetAmount(userId);
        Double optionsAssets = optionService.getAssetAmount(userId);
        Double availableFunds = InvestmentAccountService.getInstance().getAvailableFunds(userId);

        return String.format("User %s has: %.2f stock assets, %.2f fund assets, %.2f options assets, and %.2f available funds.",
                userId, stockAssets, fundAssets, optionsAssets, availableFunds);
    }

    public boolean invest(String userId, String type, Double amount) {
        boolean purchased;

        switch (type) {
            case "stock" -> purchased = stockService.buy(userId, amount);
            case "option" -> purchased = fundService.buy(userId, amount);
            case "fund" -> purchased = optionService.buy(userId, amount);
            default -> {
                System.out.println("Not a valid option");
                purchased = false;
            }
        }

        return purchased;
    }

    public String createUser() {
        String userId = randomizeUserId();

        stockService.addUser(userId);
        optionService.addUser(userId);
        fundService.addUser(userId);
        InvestmentAccountService.getInstance().addUser(userId);

        return userId;
    }

    private String randomizeUserId() {
        int length = 4;

        StringBuilder stringBuilder = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            char randomChar = (char) ('A' + random.nextInt(26));
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }
}
