package com.vastika.teamA.ob.model;

import java.util.Date;

public class TransactionModel extends AccountModel{
    double balance;
    double withdrawnAmount;
    double depositAmount;
    Date depositedDate;
    Date withdrawnDate;

    public TransactionModel(int id, String account_no, String account_name, String email, String mobile) {
        super(id, account_no, account_name, email, mobile);
    }

}
