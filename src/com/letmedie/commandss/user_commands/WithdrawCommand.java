package com.letmedie.commandss.user_commands;

import com.letmedie.commandss.Command;
import com.letmedie.dates.TransactionManagerInterface;
import com.letmedie.models.Transaction;
import com.letmedie.models.User;

public class WithdrawCommand implements Command {
    private User user;
    private double amount;
    private TransactionManagerInterface transactionManager;
    public WithdrawCommand(User user, double amount,TransactionManagerInterface transactionManager) {
        this.amount = amount;
        this.user=user;
        this.transactionManager=transactionManager;
    }

    @Override
    public void execute() {
        try {
            user.withdraw(amount);
            String balance = "Your new balance: " + user.getBalance();
            System.out.println(balance);
            System.out.println();
            Transaction transaction = new Transaction(user,"Withdraw", amount);
            transactionManager.addTransaction(transaction);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
