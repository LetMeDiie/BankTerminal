package com.letmedie.dates;

import com.letmedie.models.User;

import javax.naming.AuthenticationException;

public interface UserManager {
    //Retrieving a user by card number.
    public User getUserByCardNumber(String cardNumber) throws AuthenticationException; 

    //Checking the entered PIN code. Only required for authentication
    public void verifyPinCode(User user,String pinCode) throws AuthenticationException;
}
