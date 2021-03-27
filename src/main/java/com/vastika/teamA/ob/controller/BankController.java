package com.vastika.teamA.ob.controller;

import com.vastika.teamA.ob.database.DBConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class BankController {

    //main method
    public static void main(String[] args) {

//        try {
//            Connection con = DBConnection.getConnection();
//            if(con!=null){
//                System.out.println("Connection successful!!!");
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }

        while(true){
            int choice = Integer.parseInt(
                    JOptionPane.showInputDialog("Enter your choice:: \n 1. Create account \n 2. Search Account holder"
                            + "\n 3. Deposite Fund \n 4.Withdrawl Amount \n 5. Check Balance \n 6. Exit"));

            switch (choice){
                case 1:
                    System.out.println("Create account");
                    break;
                case 2:
                    System.out.println("Account search");
                    break;
                case 3:
                    System.out.println("Deposite fund");
                    break;
                case 4:
                    System.out.println("Withdrawl Amount");
                    break;
                case 5:
                    System.out.println("Check Balance");
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");

            }
        }

    }
}
