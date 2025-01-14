package org.example;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 25; i++) {
            System.out.println(TicketDispenser.getInstance().printTicket());
        }

        TicketDispenser.getInstance().writeProperties();
        TicketDispenser.getInstance().resetTicketDispenser();

    }
}