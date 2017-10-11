package week5.myLoveGame.controller;

import week5.myLoveGame.model.gladiators.Gladiator;
import week5.myLoveGame.model.weapons.Axic;
import week5.myLoveGame.model.weapons.Dagger;
import week5.myLoveGame.model.weapons.Weapon;

public final class Arena {

    private Gladiator firstFigther;
    private Gladiator secondFigther;

    private Weapon[] equipments = new Weapon[] { new Dagger(7), new Dagger(11), new Axic(17, 4), null };

    public Arena(Gladiator one, Gladiator two) {
        this.firstFigther = one;
        this.secondFigther = two;
    }

    public int hit(Gladiator figther) {
        int figtherDamage = figther.getHandsHit() + Random.getRandom(figther.getStrength() / 20)
                + (figther.getWeapons() != null ? figther.getWeapons().getAttack() : 0);
        return figtherDamage;
    }

    public Weapon takeWeapon() {
        return equipments[Random.getRandom(equipments.length)];
    }

    public String figth() {
        int healthOne = firstFigther.getHealth();
        int healthTwo = secondFigther.getHealth();

        while (healthOne > 0 && healthTwo > 0) {

            firstFigther.setWeapons(takeWeapon());
            secondFigther.setWeapons(takeWeapon());

            healthOne -= hit(secondFigther);
            healthTwo -= hit(firstFigther);

            System.out.println("healthOne " + healthOne + "     healthTwo " + healthTwo);
        }

        System.out.println(firstFigther.getClass().getSimpleName() + " - " + firstFigther);
        System.out.println(secondFigther.getClass().getSimpleName() + " - " + secondFigther);

        if (healthOne <= 0 && healthTwo <= 0)
            return "Draw";
        else if (healthOne <= 0)
            return secondFigther.getClass().getSimpleName() + " is win";
        return firstFigther.getClass().getSimpleName() + " is win";
    }

}
