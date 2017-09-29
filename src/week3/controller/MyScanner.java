package week3.controller;

import java.util.Scanner;

public interface MyScanner {

    String readString(String message);
    int readInt(String message);
    void write(String message);
    void write(Object o);
    double readDouble(String message);
    Scanner getScanner();
    String readString();
    int readInt();
}