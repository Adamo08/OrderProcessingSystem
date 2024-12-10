package com.adamo.dao;

import com.adamo.model.Order;
import com.adamo.util.DatabaseUtil;

import java.sql.*;

public class OrderDao {

    public void addOrder(Order order) {
        String query = "INSERT INTO orders (order_id, customer_id, payment_id, shipping_id, order_date, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, order.getOrderId());
            statement.setString(2, order.getCustomer().getCustomerId());
            statement.setString(3, order.getPayment().getPaymentId());
            statement.setString(4, order.getShipping().getTrackingNumber());
            statement.setString(5, order.getOrderDate());
            statement.setString(6, order.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
