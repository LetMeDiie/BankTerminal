package com.letmedie.main;

public class Terminal {
    private TerminalManager terminalManager;

    public Terminal() {
        terminalManager = new TerminalManagerLogin(this);
    }


    public void run(){
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
