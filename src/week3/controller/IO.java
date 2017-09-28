package week3.controller;

import java.util.Scanner;

public class IO implements MyScanner{

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public String readString(String message) {
        System.out.print(message + " - ");
        return scanner.next();
    }

    @Override
    public int readInt(String message) {
        System.out.print(message + " - ");
        return scanner.nextInt();
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public void write(Object o) {
        System.out.println(o);
    }

    @Override
    public double readDouble(String message) {
        System.out.print(message + " - ");
        return scanner.nextDouble();
    }
    
}