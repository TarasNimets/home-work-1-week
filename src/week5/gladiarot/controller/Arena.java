package week5.gladiarot.controller;

import week5.gladiarot.model.gladiators.Gladiator;
import week5.gladiarot.model.weapons.WeaponsGroup;

public final class Arena {

    private Gladiator firstFighter;
    private Gladiator secondFighter;

    public Arena(Gladiator one, Gladiator two) {
        this.firstFighter = one;
        this.secondFighter = two;
    }

    public String fight() {

        WeaponsGroup.initialization();

        int healthOne = firstFighter.getHealth();
        int healthTwo = secondFighter.getHealth();

        while (healthOne > 0 && healthTwo > 0) {
            System.out.println("healthOne " + healthOne + "     healthTwo " + healthTwo);

            firstFighter.takeWeapon();
            secondFighter.takeWeapon();
            
            int firstDamage = (int) secondFighter.defence(firstFighter);
            int secondDamage = (int) firstFighter.defence(secondFighter);
            healthOne -= secondDamage;
            healthTwo -= firstDamage;

            System.out.println("secondDamage - " + secondDamage + "       firstDamage - " + firstDamage);
        }

        System.out.println(firstFighter.getClass().getSimpleName() + " - " + firstFighter);
        System.out.println(secondFighter.getClass().getSimpleName() + " - " + secondFighter);

        if (healthOne <= 0 && healthTwo <= 0)
            return "Draw";
        else if (healthOne <= 0)
            return secondFighter.getClass().getSimpleName() + " is win";
        return firstFighter.getClass().getSimpleName() + " is win";
    }

}
