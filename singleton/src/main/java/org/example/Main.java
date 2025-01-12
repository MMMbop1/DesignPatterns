package org.example;

public class Main {
    public static void main(String[] args) {

        Serializer serializer = new Serializer();
        Person person = serializer.readPersonFromCfg();
        System.out.println("hej");
    }
}