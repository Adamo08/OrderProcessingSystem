package com.adamo;

import com.adamo.util.Scheduler;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // Start the Scheduler to read orders every hour
        Scheduler scheduler = new Scheduler();
        scheduler.startReadingOrdersEveryHour();
        System.out.println("Order processing scheduler started. Will process orders every Hour.");
    }
}