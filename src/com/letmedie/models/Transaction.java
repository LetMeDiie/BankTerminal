package com.letmedie.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

//Seems like a normal transaction. 

public class Transaction {
    private User user;
    private String transactionType;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(User user, String transactionType, double amount) {
        this.user = user;
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getDescription() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        switch (transactionType) {
            case "Deposit":
                return "Successfully deposited " + amount + " into account. Time: " + timestamp.format(formatter);
            case "Withdraw":
                return "Successfully withdrew " + amount + " from account. Time: " + timestamp.format(formatter);
            case "Transfer":
                return "Successfully transferred " + amount + " to another account. Time: " + timestamp.format(formatter);
            default:
                return "Unsupported transaction";
          //This might be the worst thing I could think of. 
          //Although the main thing is that it works.
        }
    }
    public boolean isForUser(User userToCheck) {
        return this.user.equals(userToCheck); 
        //This method is supposedly used to find out which transaction applies to a given user.
    }
}
