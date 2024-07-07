package com.letmedie.commandss.login_commands;

import com.letmedie.commandss.Command;
import com.letmedie.dates.UserManager;
import com.letmedie.main.TerminalManager;
import com.letmedie.main.TerminalManagerUser;
import com.letmedie.models.User;
import javax.naming.AuthenticationException;
public class LoginCommand implements Command {
    private TerminalManager terminalManager;
    private UserManager userManager;
    private String cardNumber;
    private String pinCode;

    public LoginCommand(TerminalManager terminalManager, UserManager userManager, String cardNumber, String pinCode) {
        this.terminalManager = terminalManager;
        this.userManager = userManager;
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
    }

    @Override
    public void execute() {
        try { 
            //We get the user using the transferred card number.
            User user = userManager.getUserByCardNumber(cardNumber); 
            
            //If the entered card exists, check the PIN code
            userManager.verifyPinCode(user,pinCode); 

            //Until this point, the exception is not thrown? Great, the recording was successful. Then it's time to go to the User Account Control menu.
            TerminalManager newTerminalManager = new TerminalManagerUser(terminalManager.getTerminal(),user);  
            //change the terminal state
            terminalManager.changeTerminalManager(newTerminalManager); 
            String result = String.format("%s, you have successfully logged into your account.",user.getUserName());
            System.out.println(result);

        }
        catch (AuthenticationException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
