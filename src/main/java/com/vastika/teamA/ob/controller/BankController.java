package com.vastika.teamA.ob.controller;

import com.vastika.teamA.ob.database.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class BankController {

    //main method
    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConnection();
            if(con!=null){
                System.out.println("Connection successful!!!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
