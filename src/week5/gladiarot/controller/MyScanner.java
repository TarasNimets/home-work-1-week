package week5.gladiarot.controller;

public interface MyScanner {
    
    String readString(String message);
    int readInt(String message);
    void write(String message);
    void write(Object object);

}
