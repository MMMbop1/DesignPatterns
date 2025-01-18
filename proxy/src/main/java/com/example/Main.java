package com.example;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        LogProxy proxy = new LogProxy();
        proxy.write("Hello,");
        proxy.write("How are you?");
        proxy.write("Can we meet up at the coffee House at 18:00?");
        System.out.println(proxy.read());
    }
}