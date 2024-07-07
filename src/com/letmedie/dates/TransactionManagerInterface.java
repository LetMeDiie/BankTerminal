package com.letmedie.dates;
import com.letmedie.models.Transaction;
import com.letmedie.models.User;
import java.util.Iterator;

public interface TransactionManagerInterface { 
    //Adding a new transaction
    void addTransaction(Transaction transaction);  
    
    //Receiving a transaction for the transferred user
    Iterator<Transaction> getTransactionsIterator(User user);
}
