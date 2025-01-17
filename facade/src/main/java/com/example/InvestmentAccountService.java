package com.example;

import java.util.HashMap;
import java.util.Map;

public class InvestmentAccountService {

    // Lazy instantiation
    private static InvestmentAccountService investmentAccountService;
    private Map<String, Double> funds;

    private InvestmentAccountService() {
        funds = new HashMap<>();
    }

    public Double getAvailableFunds(String userId) {
        return funds.get(userId);
    }

    public void useAmount(String userId, Double amount) {
        double capital = funds.get(userId);

        if (amount > capital) {
            throw new RuntimeException("Not enough funds for purchase");
        }

        funds.replace(userId, capital - amount);
    }

    public void addUser(String userId) {
        funds.put(userId, 10000d);
    }

    public static InvestmentAccountService getInstance() {
        if (investmentAccountService == null) {
            synchronized (InvestmentAccountService.class) {
                if (investmentAccountService == null) {
                    investmentAccountService = new InvestmentAccountService();
                }
            }
        }
        return investmentAccountService;
    }
}
