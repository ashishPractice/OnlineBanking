package com.vastika.teamA.ob.controller;

import com.vastika.teamA.ob.database.DBConnection;
import com.vastika.teamA.ob.model.AccountModel;
import com.vastika.teamA.ob.service.BankService;
import com.vastika.teamA.ob.service.BankServiceImpl;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class BankController {

    public static AccountModel getAccount() {

        String account_no = JOptionPane.showInputDialog("Enter Account Number:");
        String account_name = JOptionPane.showInputDialog("Enter AccountHolder Name:");
        String email = JOptionPane.showInputDialog("Enter email:");
        String mobile = JOptionPane.showInputDialog("Enter Mobile Number:");


        AccountModel accountModel = new AccountModel(0, account_no, account_name, email, mobile);
        return accountModel;
    }

    //main method
    public static void main(String[] args) {
        BankService bankService = new BankServiceImpl();
        String result = "";
//        try {
//            Connection con = DBConnection.getConnection();
//            if(con!=null){
//                System.out.println("Connection successful!!!");
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }


        while (true) {
            int choice = Integer.parseInt(
                    JOptionPane.showInputDialog("Enter your choice:: \n 1. Create account \n 2. Search Account holder"
                            + "\n 3. Deposite Fund \n 4.Withdrawl Amount \n 5. Check Balance \n 6. Exit"));

            switch (choice) {
                case 1:
                    System.out.println("Create account");
                    result = "";

                    AccountModel accountModel = getAccount();

                    result = bankService.createAccount(accountModel);

                    JOptionPane.showMessageDialog(null, result);

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
