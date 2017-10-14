package week5.gladiarot.view;

import week5.gladiarot.controller.Arena;
import week5.gladiarot.model.gladiators.Gallus;
import week5.gladiarot.model.gladiators.Veles;

public class Run {

    public static void main(String[] args) {

        Arena arena = new Arena(new Veles(2, 1, 1, 1, 1), 
                                new Gallus(1, 1, 1, 1, 1));
        
        System.out.println(arena.fight());
    }

}
