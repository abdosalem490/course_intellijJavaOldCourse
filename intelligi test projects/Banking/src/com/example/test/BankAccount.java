package com.example.test;

import java.util.stream.Stream;

public class BankAccount
{
    private String firstName;
    private String lastName;
    private double balance;
    public static final int CHECKING = 1;
    public static final int  SAVINGS = 2;
    private int accountType;
    public BankAccount(String firstName, String lastName, double balance , int typeOfAcc) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = typeOfAcc;
    }
    public boolean isChecking()
    {
        return accountType == CHECKING;
    }
    public double deposit(double amount , boolean branch)
    {
        if (amount > 500.00 && !branch)
        {
            throw new IllegalArgumentException();
        }
        balance+= amount;
        return balance;
    }
    public double withdraw(double amount , boolean branch)
    {
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }
}
