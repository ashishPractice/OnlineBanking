package com.vastika.teamA.ob.dao;

import com.vastika.teamA.ob.model.AccountModel;
import com.vastika.teamA.ob.model.TransactionModel;

public interface BankDao {

    public String createAccount(AccountModel accountModel);
    public int depositAmount(TransactionModel transactionModel);
    public int withdrawAmount(TransactionModel transactionModel);
}
