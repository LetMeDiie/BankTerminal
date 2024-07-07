package com.letmedie.main;

//Our main class. 

public class Terminal {
    private TerminalManager terminalManager; 
    //terminal status and commands

    public Terminal() {
        terminalManager = new TerminalManagerLogin(this);
    }


    public void run(){ 
        //Launch the program
        while (true)
            terminalManager.run();

    }

    public void setTerminalManager(TerminalManager terminalManager) {
        this.terminalManager = terminalManager;
    }

    public TerminalManager getTerminalManager() {
        return terminalManager;
    }
}
