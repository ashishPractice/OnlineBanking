package com.vastika.teamA.ob.controller;

import com.vastika.teamA.ob.database.DBConnection;
import com.vastika.teamA.ob.model.AccountModel;
import com.vastika.teamA.ob.model.TransactionModel;
import com.vastika.teamA.ob.service.BankService;
import com.vastika.teamA.ob.service.BankServiceImpl;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BankController {
    String output = "";

    // Method to get account info
    public static AccountModel getAccount() {

        String account_no = JOptionPane.showInputDialog("Enter Account Number:");
        String account_name = JOptionPane.showInputDialog("Enter AccountHolder Name:");
        String email = JOptionPane.showInputDialog("Enter email:");
        String mobile = JOptionPane.showInputDialog("Enter Mobile Number:");

        AccountModel accountModel = new AccountModel(0, account_no, account_name, email, mobile);
        return accountModel;
    }

    public static String initialDeposite(String accountNum) {
        String message = "";
        Double amount = 0.0;
        String choice = JOptionPane.showInputDialog("You wana make initial Deposite<Y/N>");
        if (choice.equalsIgnoreCase("Y")) {
            amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the deposite amount:"));
        }
        BankService bankService = new BankServiceImpl();
        message = bankService.initialDeposite(accountNum, amount);
        return message;
    }


    public void displayAccountInfo(AccountModel accountModel) {
        output = output + "Account Number:\t" + accountModel.getAccount_no() + "\nAccountHolder Name:\t" + accountModel.getAccount_name() +
                "\nEmail Address:\t" + accountModel.getEmail() + "\nMobile Number:\t" + accountModel.getMobile() + "\n";

        JOptionPane.showMessageDialog(null, output, "AccountHolder Info", JOptionPane.PLAIN_MESSAGE);

    }


    //main method

}
