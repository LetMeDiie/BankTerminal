package com.letmedie.commandss.user_commands;

import com.letmedie.commandss.Command;
import com.letmedie.main.TerminalManager;
import com.letmedie.main.TerminalManagerLogin;

public class LogoutCommand implements Command {
    private TerminalManager terminalManager;


    public LogoutCommand(TerminalManager terminalManager) {
        this.terminalManager = terminalManager;
    }
    @Override
    public void execute() {
        //If the user has decided to log out of the account, it is time to go to the authentication menu  
        //so that others can use the terminal.
       TerminalManager newTerminalManager = new TerminalManagerLogin(terminalManager.getTerminal());
       //change the terminal state 
       System.out.println("You have successfully logged out.");
       terminalManager.changeTerminalManager(newTerminalManager);
    }
}
