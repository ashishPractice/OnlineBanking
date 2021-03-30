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
    public TransactionModel(){
        super();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getWithdrawnAmount() {
        return withdrawnAmount;
    }

    public void setWithdrawnAmount(double withdrawnAmount) {
        this.withdrawnAmount = withdrawnAmount;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Date getDepositedDate() {
        return depositedDate;
    }

    public void setDepositedDate(Date depositedDate) {
        this.depositedDate = depositedDate;
    }

    public Date getWithdrawnDate() {
        return withdrawnDate;
    }

    public void setWithdrawnDate(Date withdrawnDate) {
        this.withdrawnDate = withdrawnDate;
    }
}
