package com.vastika.teamA.ob.dao;

import com.vastika.teamA.ob.database.DBConnection;
import com.vastika.teamA.ob.model.AccountModel;
import com.vastika.teamA.ob.model.TransactionModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class BankDaoImpl implements BankDao {
    public static final String UPDATE_SQL = "update transaction_tbl set balance=?, deposit_amount=? where id= ?";

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

        return (count > 0) ? "One record Inserted" : "Insertion Failed";
    }

    @Override

    public int depositAmount(TransactionModel transactionModel) {
        int deposited = 0;
        try (
                PreparedStatement ps = DBConnection.getConnection().prepareStatement(UPDATE_SQL);

        ) {
            ps.setDouble(1, transactionModel.getBalance());
            ps.setDouble(2, transactionModel.getDepositAmount());
            deposited = ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return deposited;
    }

    @Override
    public int withdrawAmount(TransactionModel transactionModel) {
        int withdrawn = 0;
        try (
                PreparedStatement ps = DBConnection.getConnection().prepareStatement(UPDATE_SQL);

        ) {
            ps.setDouble(1, transactionModel.getBalance());
            ps.setDouble(2, transactionModel.getDepositAmount());
            withdrawn = ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return withdrawn;
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
}
