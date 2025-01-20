package com.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cart {
    private List<Product> products;
    private String strategy = "";

    public Cart(List<Product> products) {
        this.products = products;
    }

    public void sort() {
        Comparator<Product> comparator;

        switch (strategy) {
            case "price" -> comparator = new PriceStrategy();
            case "stock" -> comparator = new StockStrategy();
            default -> comparator = new NameStrategy();
        }

        products.sort(comparator);
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
