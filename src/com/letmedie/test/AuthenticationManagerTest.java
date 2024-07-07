package com.letmedie.test;

import com.letmedie.dates.UserManager;
import com.letmedie.dates.UserManagerSimple;
import com.letmedie.models.User;

import javax.naming.AuthenticationException;

public class AuthenticationManagerTest {

    public static void main(String[] args) {
        testSuccessfulLogin("18062002", "7777"); //valid



        testSuccessfulLogin("18062002", "77--"); //invalid pin code
        testSuccessfulLogin("180123", "123123"); //invalid card number


    }

    /**
     * Tests successful user login.
     */
    public static void testSuccessfulLogin(String cardNumber , String pinCode) {
        UserManager userManager = new UserManagerSimple();
        System.out.println("_______GET USER ________");
        try {
            User user = userManager.getUserByCardNumber(cardNumber);
            userManager.verifyPinCode(user, pinCode);
            System.out.println(user.getUserName());
        } catch (AuthenticationException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println();
    }
}