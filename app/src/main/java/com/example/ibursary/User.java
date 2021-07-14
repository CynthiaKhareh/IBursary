package com.example.ibursary;

public class User {
    private String names;
    private String university;
    private String admission_no;
    private String fee_payable;
    private String fee_balance;
    private String application_date;
    public User(String name,String uni,String adminno,String payable, String balance,String date ){
        names = name;
        university = uni;
        admission_no = adminno;
        fee_payable = payable;
        fee_balance = balance;
        application_date = date;
    }

    public String getNames() {
        return names;
    }

    public String getUniversity() {
        return university;
    }

    public String getAdmission_no() {
        return admission_no;
    }

    public String getFee_payable() {
        return fee_payable;
    }

    public String getFee_balance() {
        return fee_balance;
    }

    public String getApplication_date() {
        return application_date;
    }
}
