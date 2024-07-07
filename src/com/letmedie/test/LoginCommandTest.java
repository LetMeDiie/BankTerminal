package com.letmedie.tests;


import com.letmedie.commandss.Command;
import com.letmedie.commandss.login_commands.LoginCommand;
import com.letmedie.dates.UserManagerSimple;
import com.letmedie.main.Terminal;

public class LoginCommandTest {
    public static void main(String[] args) {
        // Тестируем успешный вход
        testLogin("18062002", "7777");

        // Тестируем неуспешный вход - неверный номер карты
        testLogin("0000000000", "1111" );

        // Тестируем неуспешный вход - неверный пинкод
        testLogin("1234567890", "0000" );
    }

    private static void testLogin(String cardNumber, String pinCode) {
        Terminal terminal = new Terminal();
        System.out.println("__________LOGIN COMMAND TEST_____________");
        Command command = new LoginCommand(terminal.getTerminalManager(),new UserManagerSimple(),cardNumber,pinCode);
        command.execute();
        System.out.println();
        System.out.println();
    }
}