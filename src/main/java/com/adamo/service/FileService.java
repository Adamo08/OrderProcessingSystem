package com.adamo.service;

import com.adamo.model.OrderList;
import com.adamo.util.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileService {

    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    // Method to read orders from a file and process them
    public void readOrdersFromFile(String filePath) {
        executor.submit(() -> {
            try {
                // Read orders from file and parse into OrderList
                OrderList orderList = JsonParser.readJsonFile(filePath, OrderList.class);
                OrderService orderService = new OrderService();
                // Process the orders using OrderService
                orderService.processOrders(orderList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    // Method to write confirmed orders to a file
    public void writeConfirmedOrdersToFile(String filePath, OrderList orderList) {
        executor.submit(() -> {
            try (FileWriter writer = new FileWriter(filePath)) {
                // Write confirmed orders to file
                JsonParser.writeJsonFile(orderList, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    // Method to write error orders to a file
    public void writeErrorOrdersToFile(String filePath, OrderList orderList) {
        executor.submit(() -> {
            try (FileWriter writer = new FileWriter(filePath)) {
                // Write error orders to file
                JsonParser.writeJsonFile(orderList, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}