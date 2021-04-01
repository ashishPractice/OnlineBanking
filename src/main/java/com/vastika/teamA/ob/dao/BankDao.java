package com.vastika.teamA.ob.dao;

import com.vastika.teamA.ob.model.AccountModel;
import com.vastika.teamA.ob.model.TransactionModel;

import java.util.List;

public interface BankDao {

    public String createAccount(AccountModel accountModel);

    public String depositAmount(String account_id, Double amount);

    public String withdrawAmount(String account_id, Double amount);

    public AccountModel searchUser(String account_num);

    public String initialDeposite(String accountNum, Double amount);

    public Double checkBalance(String account_id);

    public List<AccountModel> getAllAccountInfo();

}
