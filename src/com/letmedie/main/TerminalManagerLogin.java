package com.letmedie.main;

import com.letmedie.commandss.Command;
import com.letmedie.commandss.login_commands.ExitCommand;
import com.letmedie.commandss.login_commands.LoginCommand;
import com.letmedie.dates.UserManagerSimple; 

//And this class is more like a factory than a state.

public class TerminalManagerLogin extends TerminalManager {
    public TerminalManagerLogin(Terminal terminal) {
        super(terminal);
    }

    protected void displayCommands() { 
        //commands
        System.out.println("Available commands:");
        System.out.println("1. Login");
        System.out.println("2. Exit");
    }
    protected Command createCommand(String commandType) {
        switch (commandType) {
            case "1":
                String cardNumber = this.input.requestInput("Enter card number: "); 
                String pinCode = this.input.requestInput("Enter PIN code: ");
                return new LoginCommand(this,new UserManagerSimple(),cardNumber,pinCode);
            case "2":
                return new ExitCommand();
            default:
                return null;
        }
    }
}

