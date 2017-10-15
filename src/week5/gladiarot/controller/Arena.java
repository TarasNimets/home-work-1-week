package week5.gladiarot.controller;

import week5.gladiarot.model.gladiators.Gladiator;
import week5.gladiarot.model.weapons.Weapon;
import week5.gladiarot.model.weapons.WeaponsGroup;

public final class Arena {

    private Gladiator firstFighter;
    private Gladiator secondFighter;

    public Arena(Gladiator one, Gladiator two) {
        this.firstFighter = one;
        this.secondFighter = two;
    }
    
    public Weapon takeWeapon(Gladiator gladiator) {
        Weapon newWepon = WeaponsGroup.getWeapon();
        Weapon oldWeapon = gladiator.getWeapons();
        gladiator.setWeapons(newWepon);
        return oldWeapon;
    }

    public String fight() {

        WeaponsGroup.initialization();

        int healthOne = firstFighter.getHealth();
        int healthTwo = secondFighter.getHealth();

        while (healthOne > 0 && healthTwo > 0) {
            System.out.println("healthOne " + healthOne + "     healthTwo " + healthTwo);

            takeWeapon(firstFighter);
            takeWeapon(secondFighter);
            
            int firstDamage = (int) secondFighter.defence(firstFighter.hit(), firstFighter.getStrength(), 
                    firstFighter.getWeapons() != null ? firstFighter.getWeapons().getStrength() : 0);
            int secondDamage = (int) firstFighter.defence(secondFighter.hit(), secondFighter.getStrength(), 
                    secondFighter.getWeapons() != null ? secondFighter.getWeapons().getStrength() : 0);
            
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
