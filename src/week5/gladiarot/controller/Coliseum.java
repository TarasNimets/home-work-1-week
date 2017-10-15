package week5.gladiarot.controller;

import week5.gladiarot.manager.ColiseumManager;
import week5.gladiarot.manager.ColiseumManagerImp;

public final class Coliseum {
    
    private final static Coliseum COLISEUM = new Coliseum();
    private MyScanner scanner = new IO();
    private ColiseumManager coliseumManager = new ColiseumManagerImp();
    
    private Coliseum() {
    }

    public static Coliseum getInstance() {
        return COLISEUM;
    }
    
    public MyScanner getScanner() {
        return scanner;
    }

    public ColiseumManager getColiseumManager() {
        return coliseumManager;
    }

}
