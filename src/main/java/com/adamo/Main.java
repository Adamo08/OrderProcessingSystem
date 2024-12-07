package com.adamo;

import com.adamo.model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create sample orders
        List<Order> orders = new ArrayList<>();

        // Add a sample order
        Order order = new Order();
        order.setOrderId("ORD10001");
        Customer customer = new Customer("CUST001", "Alice Johnson", "alice.johnson@example.com", "+1234567890",
                new Address("12 Apple Lane", "Seattle", "WA", "98101", "USA"));
        order.setCustomer(customer);

        List<Item> items = new ArrayList<>();
        items.add(new Item("PROD001", "Laptop", 1, 999.99, 999.99));
        items.add(new Item("PROD002", "Laptop Bag", 1, 49.99, 49.99));
        order.setItems(items);

        order.setOrderDate("2024-12-01T10:15:00Z");
        order.setStatus("Delivered");

        Payment payment = new Payment("PAY10001", "Credit Card", 1049.98, "USD", "Paid");
        order.setPayment(payment);

        Shipping shipping = new Shipping("Standard Shipping", "TRACK10001", "2024-12-05T00:00:00Z");
        order.setShipping(shipping);

        orders.add(order);

        // Serialize to JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(new OrderList(orders));
        System.out.println(json);

        // Deserialize back to object
        OrderList deserializedOrders = gson.fromJson(json, OrderList.class);
        System.out.println(deserializedOrders);
    }
}
