package com.finance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection connection = databaseconnection.getConnection()) {
            if (connection != null) {
                System.out.println("Attempting to insert test data...");
                String sqlQuery = "INSERT INTO transactions (category_id, amount, transaction_date, description) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(sqlQuery)) {
               
                    stmt.setString(1, "food");
                    stmt.setDouble(2, 50.0);
                    stmt.setString(3, "2023-12-10");
                    stmt.setString(4, "Lunch");

                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Inserted data successfully!");
                    } else {
                        System.err.println("No rows inserted.");
                    }
                } catch (SQLException e) {
                    System.err.println("Error while executing query: " + e.getMessage());
                }
            } else {
                System.err.println("No database connection.");
            }
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}


