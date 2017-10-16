package week5.gladiarot.model.gladiators;

import week5.gladiarot.controller.Random;
import week5.gladiarot.model.weapons.Weapon;

public final class Gladiator {

    public static final int HANDS_HIT = 5;
    public static final int HEALTH = 100;
    public static int GLADIATOR_ID = 1;

    private String name;
    private int strength;
    private int defense;
    private int agility;
    private int durability;
    private int rage;
    private int id;
    private Weapon weapon;

    public Gladiator(String name, int strength, int defense, int agility, int durability, int rage) {
        this.name = name;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.durability = durability;
        this.rage = rage;
        this.id = GLADIATOR_ID++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getHealth() {
        return HEALTH + durability / 10;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getRage() {
        return rage;
    }

    public void setRage(int rage) {
        this.rage = rage;
    }
    
    public int getID() {
        return id;
    }

    public int hit() {
        return HANDS_HIT + Random.getRandom((strength + (weapon != null ? weapon.getStrength() : 0)) / 20)
                + (weapon != null ? weapon.getAttack() : 0);
    }

    public double defence(int damage, int fighterStrength, int fighterWeaponStrength) {
        if (sideStep())
            return 0;

        double hitPower;
        double thisDefense = defense + (weapon != null ? weapon.getDefense() : 0);
        double gladiatorStrength = fighterStrength + fighterWeaponStrength;

        if (thisDefense < gladiatorStrength) {
            hitPower = damage * (1.0 + (gladiatorStrength - thisDefense) / 30.0);
        } else {
            hitPower = damage / (1.0 + (thisDefense - gladiatorStrength) / 30.0);
        }

        return (Random.chanceRandom(agility + (weapon != null ? weapon.getAgility() : 0))) ? hitPower *= 1.5 : hitPower;
    }

    private boolean sideStep() {
        return Random.chanceRandom(agility + (weapon != null ? weapon.getAgility() : 0));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Gladiator ");
        builder.append(name);
        builder.append(", id=");
        builder.append(id);
        builder.append(", strength=");
        builder.append(strength);
        builder.append(", defense=");
        builder.append(defense);
        builder.append(", agility=");
        builder.append(agility);
        builder.append(", durability=");
        builder.append(durability);
        builder.append(", rage=");
        builder.append(rage);
        builder.append(", weapon=");
        builder.append(weapon);
        return builder.toString();
    }

    public static class GladiatorBuilder {

        private String name;
        private int strength;
        private int defense;
        private int agility;
        private int durability;
        private int rage;

        public GladiatorBuilder() {

        }

        public GladiatorBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public GladiatorBuilder setStrength(int strength) {
            this.strength = strength;
            return this;
        }

        public GladiatorBuilder setDefense(int defense) {
            this.defense = defense;
            return this;
        }

        public GladiatorBuilder setAgility(int agility) {
            this.agility = agility;
            return this;
        }

        public GladiatorBuilder setDurability(int durability) {
            this.durability = durability;
            return this;
        }

        public GladiatorBuilder setRage(int rage) {
            this.rage = rage;
            return this;
        }

        public Gladiator build() {
            return new Gladiator(name, strength, defense, agility, durability, rage);
        }

    }

}
