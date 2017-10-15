package week5.gladiarot.view;

import week5.gladiarot.controller.Coliseum;

public class Run {

    public static void main(String[] args) {
        
        Coliseum coliseum = Coliseum.getInstance();
    
        coliseum.getColiseumManager().startBattle();

    }

}
