package com.letmedie.models;


//And most importantly - money. Balance of our favorite user.
//Most importantly, let the balance never be zero.
//And let withdraw not throw an exception when he calls it. We need money.

public class AccountBalance {
    private double balance;

    public AccountBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        } else if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        } else {
            throw new IllegalArgumentException("Insufficient funds for withdrawal.");
        }
    }

    public void transfer(AccountBalance recipient, double amount) {
        if (recipient == null) {
            throw new IllegalArgumentException("Recipient account cannot be null.");
        }
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            recipient.deposit(amount);
        } else if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than zero.");
        } else {
            throw new IllegalArgumentException("Insufficient funds for transfer.");
        }
    }
}
