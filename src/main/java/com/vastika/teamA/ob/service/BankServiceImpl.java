package com.vastika.teamA.ob.service;

import com.vastika.teamA.ob.dao.BankDao;
import com.vastika.teamA.ob.dao.BankDaoImpl;
import com.vastika.teamA.ob.model.AccountModel;
import com.vastika.teamA.ob.model.TransactionModel;

public class BankServiceImpl implements BankService{

    BankDao bankDao = new BankDaoImpl();

    @Override
    public String createAccount(AccountModel accountModel) {

        return bankDao.createAccount(accountModel);
    }

    @Override
    public int depositAmount(TransactionModel transactionModel) {

        return bankDao.depositAmount(transactionModel);
    }

    @Override
    public int withdrawAmount(TransactionModel transactionModel) {
        return bankDao.withdrawAmount(transactionModel);
    }
}
