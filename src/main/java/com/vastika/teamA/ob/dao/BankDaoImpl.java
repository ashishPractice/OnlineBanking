package com.vastika.teamA.ob.dao;

import com.vastika.teamA.ob.database.DBConnection;
import com.vastika.teamA.ob.model.AccountModel;

import java.sql.PreparedStatement;

public class BankDaoImpl implements BankDao {

    @Override
    public String createAccount(AccountModel accountModel) {
        int count = 0;
        String query = "INSERT INTO account_tbl(account_no,account_name,email,mobile) VALUES(?,?,?,?)";

        try (
                PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query);

        ) {
            pstmt.setString(1,accountModel.getAccount_no());
            pstmt.setString(2,accountModel.getAccount_name());
            pstmt.setString(3,accountModel.getEmail());
            pstmt.setString(4,accountModel.getMobile());
            count = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (count > 0)?"One record Inserted":"Insertion Failed";
    }
}
