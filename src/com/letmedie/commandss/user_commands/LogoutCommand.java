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
       TerminalManager newTerminalManager = new TerminalManagerLogin(terminalManager.getTerminal());
       System.out.println("You have successfully logged out.");
       terminalManager.changeTerminalManager(newTerminalManager);
    }
}
