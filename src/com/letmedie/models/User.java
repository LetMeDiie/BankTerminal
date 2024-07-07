package com.letmedie.models;

//our favorite user
public class User {
    private String userName;
    private String cardNumber;
    private String pinCode;
    private AccountBalance accountBalance;

    public User(String userName, String cardNumber, String pinCode, AccountBalance accountBalance) {
        this.userName = userName;
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.accountBalance = accountBalance;
    }

    public double getBalance() throws IllegalArgumentException{
        //delegation
        return accountBalance.getBalance(); 
    }
    public void deposit(double amount) throws IllegalArgumentException{
        //delegation
        accountBalance.deposit(amount);
    }
    public void withdraw(double amount) throws IllegalArgumentException{
        //delegation
        accountBalance.withdraw(amount);
    }
    public void transfer(User recipient, double amount)throws IllegalArgumentException{
        //delegation
        accountBalance.transfer(recipient.getAccountBalance(),amount);
    }

    public String getUserName() {
        return userName;
    }
    public AccountBalance getAccountBalance() {
        return accountBalance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPinCode() {
        return pinCode;
        //Well it seems everyone can now access the PIN code
    }
}
