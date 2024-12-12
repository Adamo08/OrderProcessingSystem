package com.adamo.util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseUtilTest {

    private static Connection connection;

    @BeforeAll
    static void setUp() throws SQLException {
        connection = DatabaseUtil.getConnection();
    }


    @Test
    void testGetConnection() {
        // Ensure the connection is not null, meaning a connection was established
        assertNotNull(connection, "Database connection should not be null.");
    }

}
