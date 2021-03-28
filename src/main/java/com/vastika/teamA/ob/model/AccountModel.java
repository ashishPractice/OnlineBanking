package com.vastika.teamA.ob.model;

public class AccountModel {
    private int id;
    private String account_no;
    private String account_name;
    private String email;
    private String mobile;


    public AccountModel(int id, String account_no, String account_name, String email, String mobile) {
        this.id = id;
        this.account_no = account_no;
        this.account_name = account_name;
        this.email = email;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "AccountModel{" +
                "id=" + id +
                ", account_no='" + account_no + '\'' +
                ", account_name='" + account_name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
