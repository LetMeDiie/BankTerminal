package com.letmedie.commandss.user_commands;

import com.letmedie.commandss.Command;
import com.letmedie.dates.TransactionManagerInterface;
import com.letmedie.models.Transaction;
import com.letmedie.models.User;

public class DepositCommand implements Command {
    private User user;
    private double amount;

    private TransactionManagerInterface transactionManager;

    public DepositCommand(User user, double amount,TransactionManagerInterface transactionManager) {
        this.user = user;
        this.amount = amount;
        this.transactionManager=transactionManager;
    }

    @Override
    public void execute() {
        try {
            user.deposit(amount);
            String balance = "Your new balance: " + user.getBalance();
            System.out.println(balance);
            System.out.println();
            Transaction transaction = new Transaction(user,"Deposit",amount);
            transactionManager.addTransaction(transaction);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }
}
