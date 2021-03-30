package com.vastika.teamA.ob.dao;

import com.vastika.teamA.ob.database.DBConnection;
import com.vastika.teamA.ob.model.AccountModel;
import com.vastika.teamA.ob.model.TransactionModel;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankDaoImpl implements BankDao {
    public static final String UPDATE_SQL = "update transaction_tbl set balance=?, deposit_amount=? where id= ?";

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
}
