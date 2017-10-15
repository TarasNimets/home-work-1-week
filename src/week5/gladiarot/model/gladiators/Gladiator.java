package week5.gladiarot.model.gladiators;

import week5.gladiarot.controller.Random;
import week5.gladiarot.model.weapons.Weapon;

public final class Gladiator {

    public static final int HANDS_HIT = 5;
    public static final int HEALTH = 100;

    private String name;
    protected int strength;
    protected int defence;
    protected int agility;
    protected int durability;
    protected int rage;
    protected Weapon weapon;

    public Gladiator(String name, int strength, int defence, int agility, int durability, int rage, Weapon weapon) {
        this.name = name;
        this.strength = strength;
        this.defence = defence;
        this.agility = agility;
        this.durability = durability;
        this.rage = rage;
        this.weapon = weapon;
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

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
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

    public int hit() {
        return HANDS_HIT + Random.getRandom((strength + (weapon != null ? weapon.getStrength() : 0)) / 20)
                + (weapon != null ? weapon.getAttack() : 0);
    }

    public double defence(int damage, int fighterStrength, int fighterWeaponStrength) {
        if (sideStep())
            return 0;

        double hitPower;
        double thisDefence = defence + (weapon != null ? weapon.getDefence() : 0);
        double gladiatorStrength = fighterStrength + fighterWeaponStrength;

        if (thisDefence < gladiatorStrength) {
            hitPower = damage * (1.0 + (gladiatorStrength - thisDefence) / 30.0);
        } else {
            hitPower = damage / (1.0 + (thisDefence - gladiatorStrength) / 30.0);
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
        builder.append(", strength=");
        builder.append(strength);
        builder.append(", defence=");
        builder.append(defence);
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
        private int defence;
        private int agility;
        private int durability;
        private int rage;
        private Weapon weapon;

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

        public GladiatorBuilder setDefence(int defence) {
            this.defence = defence;
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

        public GladiatorBuilder setWeapon(Weapon weapon) {
            this.weapon = weapon;
            return this;
        }

        public Gladiator build() {
            return new Gladiator(name, strength, defence, agility, durability, rage, weapon);
        }

    }

}
