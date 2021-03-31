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

    public String depositAmount(String account_id, Double amount) {
        return bankDao.depositAmount(account_id, amount);
    }

    @Override
    public String withdrawAmount(String account_id, Double amount) {
        return bankDao.withdrawAmount(account_id, amount);
    }

    @Override
    public AccountModel searchUser(String account_num) {
        return bankDao.searchUser(account_num);

    }

    @Override
    public String initialDeposite(String accountNum, Double amount) {
        return bankDao.initialDeposite(accountNum,amount);
    }

    @Override
    public Double checkBalance(String account_id) {
        return bankDao.checkBalance(account_id);
    }


}
