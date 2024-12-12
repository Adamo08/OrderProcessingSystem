package com.adamo.dao;

import com.adamo.model.Order;
import com.adamo.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class OrderDao {

    public void addOrder(Order order) {

        // Query to check if order exists
        String checkQuery = "SELECT COUNT(*) FROM orders WHERE order_id = ?";
        String insertQuery = "INSERT INTO orders (order_id, customer_id, payment_id, shipping_id, order_date, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {

            // Check if the order ID exists
            checkStatement.setString(1, order.getOrderId());
            try (ResultSet resultSet = checkStatement.executeQuery()) {
                if (resultSet.next() && resultSet.getInt(1) > 0) {
                    return; // Skip this order and return
                }
            }

            // Proceed with inserting the order if not found
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, order.getOrderId());
                insertStatement.setString(2, order.getCustomer().getCustomerId());
                insertStatement.setString(3, order.getPayment().getPaymentId());
                insertStatement.setInt(4, order.getShipping().getShippingId());

                // Parse ISO 8601 date using ZonedDateTime and convert to LocalDateTime
                ZonedDateTime zonedDateTime = ZonedDateTime.parse(order.getOrderDate(), DateTimeFormatter.ISO_DATE_TIME);
                LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();

                insertStatement.setTimestamp(5, Timestamp.valueOf(localDateTime));
                insertStatement.setString(6, order.getStatus());

                insertStatement.executeUpdate();
                System.out.println("Order with ID " + order.getOrderId() + " inserted successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error inserting order with ID " + order.getOrderId() + ": " + e.getMessage());
        }
    }
}
