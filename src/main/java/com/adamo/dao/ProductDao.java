package com.adamo.dao;

import com.adamo.model.Item;
import com.adamo.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public Item getProductById(String productId) {
        String query = "SELECT * FROM products WHERE product_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, productId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Item(
                        rs.getString("product_id"),
                        rs.getString("product_name"),
                        0,  // Placeholder, will be updated later
                        rs.getDouble("price"),
                        0   // Placeholder, will be updated later
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Item> getProductsByOrder(List<String> productIds) {
        String query = "SELECT * FROM products WHERE product_id IN (" + String.join(",", productIds) + ")";
        List<Item> items = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < productIds.size(); i++) {
                statement.setString(i + 1, productIds.get(i));
            }
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                items.add(new Item(
                        rs.getString("product_id"),
                        rs.getString("product_name"),
                        0,  // Placeholder, will be updated later
                        rs.getDouble("price"),
                        0   // Placeholder, will be updated later
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}