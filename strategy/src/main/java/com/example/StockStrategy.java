package com.example;

import java.util.Comparator;

public class StockStrategy implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p1.getStock() - p2.getStock();
    }
}
