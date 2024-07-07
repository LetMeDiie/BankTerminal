package com.letmedie.commandss.login_commands;

import com.letmedie.commandss.Command;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println(("Exiting the system..."));
        System.exit(0);
    }

}
