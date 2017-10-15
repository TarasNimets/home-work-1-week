package week5.gladiarot.controller;

import java.util.Scanner;

public class IO implements MyScanner{
    
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public String readString(String message) {
        System.out.println(message);
        return scanner.next();
    }

    @Override
    public int readInt(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }

}
