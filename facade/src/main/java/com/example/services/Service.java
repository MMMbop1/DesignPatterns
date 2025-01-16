package com.example.services;

import com.example.InvestmentAccountService;

import java.util.HashMap;
import java.util.Map;

public abstract class Service {

    private final Map<String, Double> assets = new HashMap<>();

    public Double getAssetAmount(String userId) {
        return assets.get(userId);
    }

    public boolean buy(String userId, Double amount) {
        try {
            InvestmentAccountService.getInstance().useAmount(userId, amount);
            assets.replace(userId, assets.get(userId) + amount);
            return true;
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public void addUser(String userId) {
        assets.put(userId, 0d);
    }
}
