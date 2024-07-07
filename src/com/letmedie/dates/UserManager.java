package com.letmedie.dates;

import com.letmedie.models.User;

import javax.naming.AuthenticationException;

public interface UserManager {
    public User getUserByCardNumber(String cardNumber) throws AuthenticationException;
    public void verifyPinCode(User user,String pinCode) throws AuthenticationException;
}