package com.mycompany.librarymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    public static void createNewDatabase() {
        // This defines WHERE the file will be created. 
        // Using just "library.db" puts it in your project's root folder.
        String url = "jdbc:sqlite:library.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("A new database file has been created!");
                
                // Now let's create your first table automatically
                String sql = "CREATE TABLE IF NOT EXISTS books ("
                           + " id integer PRIMARY KEY,"
                           + " title text NOT NULL,"
                           + " author text NOT NULL"
                           + ");";
                
                Statement stmt = conn.createStatement();
                stmt.execute(sql);
                System.out.println("Table 'books' is ready!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewDatabase();
    }
}