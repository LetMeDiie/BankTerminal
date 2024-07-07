package com.letmedie.commandss.user_commands;
import com.letmedie.commandss.Command;
import com.letmedie.dates.TransactionManagerInterface;
import com.letmedie.dates.UserManager;
import com.letmedie.models.Transaction;
import com.letmedie.models.User;

public class TransferCommand implements Command {
    private User sender;
    private String cardNumber;
    private UserManager userManager;
    private double amount;
    private TransactionManagerInterface transactionManager;

    public TransferCommand(User sender, String cardNumber, UserManager userManager, double amount, TransactionManagerInterface transactionManager) {
        this.sender = sender;
        this.cardNumber = cardNumber;
        this.userManager = userManager;
        this.amount = amount;
        this.transactionManager = transactionManager;
    }

    @Override
    public void execute() {
        try {
            //We get the user who needs to make a transfer.
            User recipient = userManager.getUserByCardNumber(cardNumber);
            sender.transfer(recipient,amount);

            //Save the transaction
            Transaction transaction = new Transaction(sender, "Transfer", amount);
            transactionManager.addTransaction(transaction); 
            
            String result ="Successfully transferred " + amount + " to " + recipient.getUserName();
            System.out.println(result);
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }
}

