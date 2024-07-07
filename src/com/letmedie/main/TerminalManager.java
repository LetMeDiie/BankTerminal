package com.letmedie.main;

import com.letmedie.commandss.Command;
import com.letmedie.input_output.input.ConsoleInput;
import com.letmedie.input_output.input.Input;

//And this is the terminal state
public abstract class TerminalManager {
    Terminal terminal;
    protected Input input;//Something like receiving data from the user

    public TerminalManager(Terminal terminal){
        this.terminal=terminal;
        input=createInput();
    }
    protected Input createInput(){
        return new ConsoleInput();  
        //It may be a very strange decision to create this here. But I can change the behavior in subclasses
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

    protected abstract void displayCommands(); //display the command
    protected abstract Command createCommand(String commandType); //return the selected command
    public void changeTerminalManager(TerminalManager terminalManager) {
        terminal.setTerminalManager(terminalManager);
    }

    public Terminal getTerminal() {
        return terminal;
    }
}
