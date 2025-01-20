package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Product p1 = new Product("Toyota", 20000d, 51);
        Product p2 = new Product("BMW", 25000d, 21);
        Product p3 = new Product("Volvo", 24000, 31);
        Product p4 = new Product("Mercedes", 26000d, 11);
        Product p5 = new Product("Saab", 18000d, 1);

        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);

        Cart cart = new Cart(productList);
        cart.setStrategy("price");

        cart.sort();

        cart.getProducts().forEach(System.out::println);
    }
}