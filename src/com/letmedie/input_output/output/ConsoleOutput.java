package com.letmedie.input_output.output;

public class ConsoleOutput implements Output{
    @Override
    public  void printOutput(String message) {
        System.out.println(message);
    }
}
