package com.vastika.teamA.ob.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Method that return the connection
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        // loading the driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // creating a connection
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db", "teamA", "teamA");

    }

}
