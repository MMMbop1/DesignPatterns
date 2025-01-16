package com.example;

import com.example.services.InvestmentFacade;

public class Main {
    public static void main(String[] args) {
        InvestmentFacade facade = new InvestmentFacade();
        String userId = facade.createUser();
        System.out.println(userId);
        System.out.println(facade.getAssets(userId));
        facade.invest(userId, "stock", 5000d);
        System.out.println(facade.getAssets(userId));
        facade.invest(userId, "fund", 2000d);
        facade.invest(userId, "option", 3000d);
        System.out.println(facade.getAssets(userId));
    }
}