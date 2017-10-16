package week5.gladiarot.controller;

import week5.gladiarot.model.gladiators.Gladiator;
import week5.gladiarot.model.weapons.Weapon;
import week5.gladiarot.model.weapons.WeaponsGroup;

public final class Battle {

    private MyScanner scanner = new IO();
    private Gladiator firstFighter;
    private Gladiator secondFighter;

    public Battle(Gladiator one, Gladiator two) {
        this.firstFighter = one;
        this.secondFighter = two;
    }
    
    public Weapon takeWeapon(Gladiator gladiator) {
        Weapon newWepon = WeaponsGroup.getWeapon();
        Weapon oldWeapon = gladiator.getWeapon();
        gladiator.setWeapon(newWepon);
        return oldWeapon;
    }

    public String fight() {

        int healthOne = firstFighter.getHealth();
        int healthTwo = secondFighter.getHealth();

        while (healthOne > 0 && healthTwo > 0) {

            scanner.write(String.format("Health of the %s - %d      Health of the %s - %d", 
                            firstFighter.getName(), healthOne, secondFighter.getName(), healthTwo ));

            takeWeapon(firstFighter);
            takeWeapon(secondFighter);
            
            int firstDamage = (int) secondFighter.defence(firstFighter.hit(), firstFighter.getStrength(), 
                    firstFighter.getWeapon() != null ? firstFighter.getWeapon().getStrength() : 0);
            int secondDamage = (int) firstFighter.defence(secondFighter.hit(), secondFighter.getStrength(), 
                    secondFighter.getWeapon() != null ? secondFighter.getWeapon().getStrength() : 0);
            
            healthOne -= secondDamage;
            healthTwo -= firstDamage;

            scanner.write(String.format("%s%s%s and causing %d damages to the %s", firstFighter.getName(),
                            firstFighter.getWeapon() != null ? " takes " : "",
                            firstFighter.getWeapon() != null ? firstFighter.getWeapon().getName() : " beats",
                            firstDamage, secondFighter.getName()));

            scanner.write(String.format("%s%s%s and causing %d damages to the %s \n", secondFighter.getName(),
                            secondFighter.getWeapon() != null ? " takes " : "",
                            secondFighter.getWeapon() != null ? secondFighter.getWeapon().getName() : " beats",
                            secondDamage, firstFighter.getName()));

        }
        if (healthOne <= 0 && healthTwo <= 0)
            return "Draw";
        else if (healthOne <= 0)
            return secondFighter.getName() + " is win";
        return firstFighter.getName() + " is win";
    }

}
