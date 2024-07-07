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
            User user = userManager.getUserByCardNumber(cardNumber);
            userManager.verifyPinCode(user,pinCode);
            TerminalManager newTerminalManager = new TerminalManagerUser(terminalManager.getTerminal(),user);
            terminalManager.changeTerminalManager(newTerminalManager);
            String result = String.format("%s, you have successfully logged into your account.",user.getUserName());
            System.out.println(result);

        }
        catch (AuthenticationException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
