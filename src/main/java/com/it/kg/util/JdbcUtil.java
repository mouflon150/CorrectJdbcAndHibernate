package com.it.kg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

    private final Connection connection;

    public JdbcUtil() throws SQLException {

        connection = DriverManager.getConnection
                (
                        "jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "marlen27056"
                );
    }

    public Connection getConnection() {
        return connection;
    }
}
