package com.letmedie.dates;
import com.letmedie.models.Transaction;
import com.letmedie.models.User;
import java.util.Iterator;

public interface TransactionManagerInterface {
    void addTransaction(Transaction transaction);
    Iterator<Transaction> getTransactionsIterator(User user);
}