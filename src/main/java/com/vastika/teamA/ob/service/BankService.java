package com.vastika.teamA.ob.service;

import com.vastika.teamA.ob.model.AccountModel;
import com.vastika.teamA.ob.model.TransactionModel;

public interface BankService {

    public String createAccount(AccountModel accountModel);
    public int depositAmount(TransactionModel transactionModel);
    public int withdrawAmount(TransactionModel transactionModel);

}
