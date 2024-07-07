package com.letmedie.dates;

import com.letmedie.models.Transaction;
import com.letmedie.models.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransactionManagerSimple implements TransactionManagerInterface {
    private static List<Transaction> transactionList=new ArrayList<>();

    @Override
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    @Override
    public Iterator<Transaction> getTransactionsIterator(User user) {
        return new UserTransactionIterator(user);
    }

    private class UserTransactionIterator implements Iterator<Transaction> {
        private Iterator<Transaction> iterator;
        private User user;

        public UserTransactionIterator(User user) {
            List<Transaction> userTransactions = new ArrayList<>();
            for (Transaction transaction : transactionList) {
                if (transaction.isForUser(user)) {
                    userTransactions.add(transaction);
                }
            }
            this.iterator = userTransactions.iterator();
            this.user = user;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Transaction next() {
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    }
}
