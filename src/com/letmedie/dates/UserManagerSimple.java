package com.letmedie.dates;

import com.letmedie.models.AccountBalance;
import com.letmedie.models.User;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

public class UserManagerSimple implements UserManager {
    private static List<User> users = new ArrayList<>();

    static { 
        //Creating multiple users for the terminal. This is a kind of database)
        users.add(new User("LetMeDie", "18062002", "7777", new AccountBalance(999999999)));
        users.add(new User("Ami","12122012","1111",new AccountBalance(1)));
        users.add(new User("Alice", "1234567890", "4132", new AccountBalance(1000.0)));
        users.add(new User("Bob", "0987654321", "0941", new AccountBalance(1500.0)));
        users.add(new User("Charlie", "1122334455", "4134", new AccountBalance(2000.0)));
    }
    
        public User getUserByCardNumber(String cardNumber) throws AuthenticationException {
            for (User user : users) {
                if (user.getCardNumber().equals(cardNumber)) {
                    return user;
                }
            }
            throw new AuthenticationException("User with card number " + cardNumber + " not found.");
        }

        public void verifyPinCode(User user, String pinCode) throws AuthenticationException {
            if (!user.getPinCode().equals(pinCode)) {
                throw new AuthenticationException("Invalid pin code for card number " + user.getCardNumber());
            }
        }
}
