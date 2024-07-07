package com.letmedie.commandss.user_commands;

import com.letmedie.commandss.Command;
import com.letmedie.models.Transaction;
import com.letmedie.models.User;

import java.util.Iterator;

//A slightly complicated class for viewing transaction history. It uses something like a pattern iterator

public class ViewTransactionCommand implements Command {
    private Iterator<Transaction> iterator;


    public ViewTransactionCommand( Iterator<Transaction> iterator) {
        this.iterator=iterator;
    }

    @Override
    public void execute() {
        while (iterator.hasNext()) {
            Transaction transaction = iterator.next();
            System.out.println(transaction.getDescription());
            System.out.println();
        }
    }
}

