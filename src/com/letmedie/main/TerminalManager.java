package com.letmedie.main;

import com.letmedie.commandss.Command;
import com.letmedie.input_output.input.ConsoleInput;
import com.letmedie.input_output.input.Input;

public abstract class TerminalManager {
    Terminal terminal;
    protected Input input;

    public TerminalManager(Terminal terminal){
        this.terminal=terminal;
        input=createInput();
    }
    protected Input createInput(){
        return new ConsoleInput();
    }

    public void run() {
        displayCommands();
        String choice = input.requestInput("Enter command: ");
        Command command = createCommand(choice);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Invalid commands. Try Again!");
        }
    }

    protected abstract void displayCommands();
    protected abstract Command createCommand(String commandType);
    public void changeTerminalManager(TerminalManager terminalManager) {
        terminal.setTerminalManager(terminalManager);
    }

    public Terminal getTerminal() {
        return terminal;
    }
}
