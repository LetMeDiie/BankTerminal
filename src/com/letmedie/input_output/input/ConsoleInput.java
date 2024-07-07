package com.letmedie.input_output.input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String requestInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    public void close(){
        scanner.close();
    }
}
