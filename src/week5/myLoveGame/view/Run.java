package week5.myLoveGame.view;

import week5.myLoveGame.controller.Arena;
import week5.myLoveGame.model.gladiators.Gallus;
import week5.myLoveGame.model.gladiators.Veles;

public class Run {

    public static void main(String[] args) {

        Arena arena = new Arena(new Veles(1, 1, 1, 1, 1), 
                                new Gallus(1, 1, 1, 1, 1));
        
        System.out.println(arena.figth());
    }

}
