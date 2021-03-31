package com.vastika.teamA.ob.dao;

import com.vastika.teamA.ob.database.DBConnection;
import com.vastika.teamA.ob.model.AccountModel;
import com.vastika.teamA.ob.model.TransactionModel;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;

public class BankDaoImpl implements BankDao {
    public static final String UPDATE_SQL = "update transaction_tbl set balance=?, deposite_amount=? , deposite_date=? where account_id=?";
    public static final String UPDATE_SQL1 = "update transaction_tbl set balance=?, withdrawl_amount=? , withdrawl_date=? where account_id=?";

    ResultSet rs = null;

    @Override
    public String createAccount(AccountModel accountModel) {
        int count = 0;
        String query = "INSERT INTO account_tbl(account_no,account_name,email,mobile) VALUES(?,?,?,?)";

        try (
                PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query);

        ) {
            pstmt.setString(1, accountModel.getAccount_no());
            pstmt.setString(2, accountModel.getAccount_name());
            pstmt.setString(3, accountModel.getEmail());
            pstmt.setString(4, accountModel.getMobile());
            count = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (count > 0) ? "Account created" : "Account creation Failed";
    }

    @Override

    public String depositAmount(String account_id, Double amount) {
        int deposited = 0;
        Double balance = 0.0;
        try (
                PreparedStatement ps = DBConnection.getConnection().prepareStatement(UPDATE_SQL);

        ) {
           balance = checkBalance(account_id);
            ps.setDouble(1, balance + amount);
            ps.setDouble(2, amount);
            ps.setDate(3,Date.valueOf(LocalDate.now()));
            ps.setString(4, account_id);

            deposited = ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return (deposited > 0) ? "Your new balance is $" +(balance+amount)+" after depositing of $"+amount: "Deposite Failed";
    }

    @Override
    public String withdrawAmount(String account_id, Double amount) {
        int withdrawl = 0;
        Double balance = 0.0;
        try (
                PreparedStatement ps = DBConnection.getConnection().prepareStatement(UPDATE_SQL1);
        ) {
            balance = checkBalance(account_id);
            if(balance < amount){
                return "Insufficient fund!!!!";
            }

            ps.setDouble(1, balance - amount);
            ps.setDouble(2, amount);
            ps.setDate(3,Date.valueOf(LocalDate.now()));
            ps.setString(4, account_id);

            withdrawl = ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return (withdrawl > 0) ? "Your new balance is $" +(balance-amount)+" after withdrawl of $"+amount: "Withdrawl Failed";
    }

    @Override
    public AccountModel searchUser(String account_num) {

        AccountModel accountModel =  null;

        String query = "SELECT * FROM account_tbl WHERE account_no=?";
        try (
                PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query);

        ) {
            pstmt.setString(1,account_num);
            rs = pstmt.executeQuery();

            if(rs.next()){
                accountModel = new AccountModel(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(accountModel);
        return accountModel;
    }

    @Override
    public String initialDeposite(String accountNum, Double amount) {
        int count = 0;
        String query = "INSERT INTO transaction_tbl(account_id,balance,deposite_amount,deposite_date) VALUE(?,?,?,?)";
        try (
                PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query);

        ) {
            pstmt.setString(1,accountNum);
            pstmt.setDouble(2,amount);
            pstmt.setDouble(3,amount);
            pstmt.setDate(4, Date.valueOf(LocalDate.now()));

            count = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (count > 0) ? "Initial Deposite of "+amount+" is done" : "Initial Deposite Failed";
    }

    @Override
    public Double checkBalance(String account_id){

        String query = "SELECT balance FROM transaction_tbl WHERE account_id=?";
        Double balance = 0.0;
        try (
                PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query);

        ) {
            pstmt.setString(1,account_id);
            rs = pstmt.executeQuery();

            if(rs.next()){
                balance = rs.getDouble("balance");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }
}
