package com.letmedie.commandss.user_commands;

import com.letmedie.commandss.Command;
import com.letmedie.models.User;

//Simple class to view balance

public class ViewBalanceCommand implements Command {
    private  User user;

    public ViewBalanceCommand(User user) {
        this.user=user;
    }

    @Override
    public void execute() {
        String balance = "Your balance: "+user.getBalance();
        System.out.println(balance);
        System.out.println();

    }
}
