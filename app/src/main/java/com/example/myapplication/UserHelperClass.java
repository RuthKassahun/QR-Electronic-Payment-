package com.example.myapplication;

public class UserHelperClass {

    String name, username, email, phoneNo, password;
    String creditbalance;

    public UserHelperClass(String name1, String s, String email, String phoneNo, String name, String username, String creditbalance) {
    }

    public UserHelperClass(String name, String username, String email, String phoneNo, String password, String creditbalance) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.creditbalance = creditbalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBalance() {
        return creditbalance;
    }

    public void setBalance(String creditbalance) {
        this.creditbalance = creditbalance;
    }
}
