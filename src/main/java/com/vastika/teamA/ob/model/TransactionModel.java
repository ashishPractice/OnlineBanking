package com.vastika.teamA.ob.model;

import java.time.LocalDate;

public class TransactionModel extends AccountModel{
    private double balance;
    private double withdrawnAmount;
    private double depositAmount;
    private LocalDate depositedDate;
    private LocalDate withdrawnDate;

    public TransactionModel(){

    }

    public TransactionModel(int id, String account_no, String account_name, String email, String mobile, double balance, double withdrawnAmount, double depositAmount, LocalDate depositedDate, LocalDate withdrawnDate) {
        super(id, account_no, account_name, email, mobile);
        this.balance = balance;
        this.withdrawnAmount = withdrawnAmount;
        this.depositAmount = depositAmount;
        this.depositedDate = depositedDate;
        this.withdrawnDate = withdrawnDate;
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

    public LocalDate getDepositedDate() {
        return depositedDate;
    }

    public void setDepositedDate(LocalDate depositedDate) {
        this.depositedDate = depositedDate;
    }

    public LocalDate getWithdrawnDate() {
        return withdrawnDate;
    }

    public void setWithdrawnDate(LocalDate withdrawnDate) {
        this.withdrawnDate = withdrawnDate;
    }

    @Override
    public String toString() {
        return "TransactionModel{" +
                "balance=" + balance +
                ", withdrawnAmount=" + withdrawnAmount +
                ", depositAmount=" + depositAmount +
                ", depositedDate=" + depositedDate +
                ", withdrawnDate=" + withdrawnDate +
                '}';
    }
}
