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
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BankController {
    String output = "";

    // Method to get account info
    public static AccountModel getAccount() {

        String account_no = JOptionPane.showInputDialog("Enter Account Number:");
        Pattern numbersOnly = Pattern.compile("^[0-9]*$");
        Pattern alphabetOnly = Pattern.compile("^[a-zA-Z]+$");


        try{
            Matcher m = numbersOnly.matcher(account_no);
            while (!m.find()){
                JOptionPane.showMessageDialog(null, "Please enter only numbers");
                 account_no = JOptionPane.showInputDialog("Enter Account Number:");
                 m = numbersOnly.matcher(account_no);
            }
        } catch (NullPointerException E){

            //PLEASE REVIEW
            //Don't think this is a good approach
            //Need Logic to return to initial screen
                return null;
        }


        String account_name = JOptionPane.showInputDialog("Enter AccountHolder Name:");

        try{
            Matcher m = alphabetOnly.matcher(account_name);
            while(!m.find()){
                JOptionPane.showMessageDialog(null, "AccountHolder Name needs to be Alphabet Only");
                account_name = JOptionPane.showInputDialog("Enter AccountHolder Name:");
                m = alphabetOnly.matcher(account_name);
             }

        } catch (NullPointerException E){
            //PLEASE REVIEW
            //Don't think this is a good approach
            //Need Logic to return to initial screen
            return null;
        }

        String email = JOptionPane.showInputDialog("Enter email:");

        try{

            while (!isValidEmail(email)){
                JOptionPane.showMessageDialog(null, "Enter email in proper format");
                email = JOptionPane.showInputDialog("Enter email:");
            };
        } catch (NullPointerException E){
            //PLEASE REVIEW
            //Don't think this is a good approach
            //Need Logic to return to initial screen
            return null;
        }

        String mobile = JOptionPane.showInputDialog("Enter Mobile Number:");

        try{
            Matcher m = numbersOnly.matcher(mobile);
            while (!m.find()){
                JOptionPane.showMessageDialog(null, "Please enter only numbers");
                account_no = mobile = JOptionPane.showInputDialog("Enter Mobile Number:");
                m = numbersOnly.matcher(account_no);
            }
        } catch (NullPointerException E){

            //PLEASE REVIEW
            //Don't think this is a good approach
            //Need Logic to return to initial screen
            return null;
        }



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

    static boolean isValidEmail(String inputEmail) {

        String email = inputEmail;
        for(int i = 0; i<email.length(); i++){
            if(email.charAt(i) == '@'){
                return true;
            }
        }
        return false;
    }

}

