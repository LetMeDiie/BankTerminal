package com.letmedie.main;

import com.letmedie.commandss.Command;
import com.letmedie.commandss.user_commands.DepositCommand;
import com.letmedie.commandss.user_commands.TransferCommand;
import com.letmedie.commandss.user_commands.ViewBalanceCommand;
import com.letmedie.commandss.user_commands.ViewTransactionCommand;
import com.letmedie.commandss.user_commands.LogoutCommand;
import com.letmedie.dates.TransactionManagerSimple;
import com.letmedie.dates.UserManagerSimple;
import com.letmedie.dates.TransactionManagerInterface;
import com.letmedie.dates.UserManager;
import com.letmedie.models.Transaction;
import com.letmedie.models.User;
import java.util.Iterator;

public class TerminalManagerUser extends TerminalManager {
    private User user;
    public TerminalManagerUser(Terminal terminal, User user ) {
        super(terminal);
        this.user = user;
    }

    @Override
    protected void displayCommands() { 
        //even more commands
        System.out.println("____User Menu____");
        System.out.println("1. View Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. View Transactions");
        System.out.println("5. Logout");
        System.out.println();
    }

    @Override
    protected Command createCommand(String commandType) {
         //and this class also resembles a factory
         TransactionManagerInterface transactionManager=new TransactionManagerSimple();
        switch (commandType) {
            case "1":
                return new ViewBalanceCommand(user); 
                //ok easy 
            case "2":
                double depositAmount = getValidatedAmount("Enter amount to deposit: ");
                return new DepositCommand(user, depositAmount, transactionManager); 
                // ok not hard
            case "3":
                String recipientCardNumber = input.requestInput("Enter recipient's card number: ");
                UserManager userManager = new UserManagerSimple();
                double transferAmount = getValidatedAmount("Enter amount to transfer: ");
                return new TransferCommand(user, recipientCardNumber,userManager, transferAmount, transactionManager);
                //whaat?
            case "4":
                Iterator<Transaction> transactionIterator = transactionManager.getTransactionsIterator(user);
                return new ViewTransactionCommand(transactionIterator); 
                //hmm
            case "5":
                return new LogoutCommand(this);
                //very easy
            default:
                System.out.println("Invalid command. Try again!");
                return null;
        }
    }

    private double getValidatedAmount(String prompt) { 
        while (true) {
            try {
                return Double.parseDouble(input.requestInput(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a valid number.");
            }
        }
    }
}
