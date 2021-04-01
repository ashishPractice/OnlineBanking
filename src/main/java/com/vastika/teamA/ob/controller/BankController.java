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
    public static void main(String[] args) {
        BankController bankController = new BankController();
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
                            + "\n 3. Deposite Fund \n 4. Withdrawl Amount \n 5. Check Balance \n 6. Show all AccounHolder \n 7. Exit"));

            switch (choice) {
                case 1:
                    System.out.println("Create account");

                    AccountModel accountModel = getAccount();
                    result = bankService.createAccount(accountModel);

                    if (result.equalsIgnoreCase("Account created")) {
                        String message = initialDeposite(accountModel.getAccount_no());

                        result = result + " and " + message;
                    }
                    JOptionPane.showMessageDialog(null, result);
                    break;

                case 2:
                    System.out.println("Account search");

                    String account_no = JOptionPane.showInputDialog("Enter Account Number:");

                    AccountModel accountModel1 = bankService.searchUser(account_no);

                    if (accountModel1 != null) {
                        bankController.displayAccountInfo(accountModel1);

                    } else {
                        JOptionPane.showMessageDialog(null, "Search not found");
                    }
                    break;


                case 3:
                    System.out.println("Deposite fund");

                    String account_no1 = JOptionPane.showInputDialog("Enter Account Number:");

                    AccountModel accountModel2 = bankService.searchUser(account_no1);

                    Double amount = 0.0;

                    if (accountModel2 != null) {
                        while(amount <= 0.0) {
                            amount = Double.parseDouble(JOptionPane.showInputDialog("Enter your deposite amount"));
                        }

                        result = bankService.depositAmount(account_no1,amount);

                        JOptionPane.showMessageDialog(null, result);

                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter the correct account number!!!!");
                    }


                    break;

                case 4:
                    System.out.println("Withdraw Amount");
                    System.out.println("Deposite fund");

                    String account_no2 = JOptionPane.showInputDialog("Enter Account Number:");

                    AccountModel accountModel3 = bankService.searchUser(account_no2);

                    Double amount1 = 0.0;

                    if (accountModel3 != null) {
                        while(amount1 <= 0.0) {
                            amount1 = Double.parseDouble(JOptionPane.showInputDialog("Enter your withdrawl amount"));
                        }

                        result = bankService.withdrawAmount(account_no2,amount1);

                        JOptionPane.showMessageDialog(null, result);

                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter the correct account number!!!!");
                    }
                    break;

                case 5:
                    System.out.println("Check Balance");
                    String account_num = JOptionPane.showInputDialog("Enter Account Number:");

                    AccountModel accountModel5 = bankService.searchUser(account_num);

                    if (accountModel5 != null) {
                        Double balance = bankService.checkBalance(account_num);
                        JOptionPane.showMessageDialog(null, "You current balance is: "+ balance);

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Account number!!!");
                    }
                    break;

                case 6:
                    List<AccountModel> model = new ArrayList<AccountModel>();

                    model = bankService.getAllAccountInfo();

                    String[] cols= {"Account Number", "AccountHolder Name", "Email Address", "Mobile Number", "Current Balance"};

                    String[][] datas = new String[model.size()][5];

                    int i =0;
                    for (AccountModel m: model){
                        System.out.println(m.getAccount_name());
                        Double balance = bankService.checkBalance(m.getAccount_no());
                        datas[i][0] = m.getAccount_no();
                        datas[i][1] = m.getAccount_name();
                        datas[i][2] = m.getEmail();
                        datas[i][3] = m.getMobile();
                        datas[i][4] = String.valueOf(balance);
                        i++;
                    }

                   JTable table = new JTable(datas,cols);
                    JScrollPane sp = new JScrollPane(table);
                    sp.setSize(100,50);
                    JOptionPane.showMessageDialog(null,sp,"AccountHolder Info",JOptionPane.PLAIN_MESSAGE);

                    break;

                case 7:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
