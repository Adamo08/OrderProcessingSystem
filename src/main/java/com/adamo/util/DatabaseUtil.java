package com.adamo.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String URL = "jdbc:mysql://localhost:4306/oms_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(10);
        dataSource = new HikariDataSource(config);
    }

    // Private constructor to prevent instantiation
    private DatabaseUtil() {}

    // Method to establish a connection
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Method to close the data source
    public static void closeDataSource() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}