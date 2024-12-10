package com.adamo;

import com.adamo.model.OrderList;
import com.adamo.service.FileService;
import com.adamo.service.OrderService;
import com.adamo.util.JsonParser;
import com.adamo.util.Scheduler;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // Start the Scheduler to read orders every hour
        Scheduler scheduler = new Scheduler();
        scheduler.startReadingOrdersEveryHour();

        // Create instances of FileService and OrderService to handle orders
        FileService fileService = new FileService();
        OrderService orderService = new OrderService();

        // Simulate processing orders from an initial file
        String ordersFilePath = "src/main/java/com/adamo/resources/data/orders.json";

        // Read and process orders immediately (optional, in case we need an immediate start)
        fileService.readOrdersFromFile(ordersFilePath);

        // If you want to trigger order processing manually in the main method for testing purposes, uncomment below
        OrderList orderList = JsonParser.readJsonFile(ordersFilePath, OrderList.class);
        orderService.processOrders(orderList);

        // Let the scheduler handle the regular reading and processing every hour
        System.out.println("Order processing scheduler started. Will process orders every hour.");
    }
}