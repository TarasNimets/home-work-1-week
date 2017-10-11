package week5.myLoveGame.model.gladiators;

import week5.myLoveGame.model.weapons.Weapon;

public abstract class Gladiator {

    private static final int HANDS_HIT = 5;
    private static final int HEALTH = 100;

    protected int strength;
    protected int defence;
    protected int agility;
    protected int durability;
    protected int mentality;
    protected Weapon weapons;

    public Weapon getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon weapons) {
        this.weapons = weapons;
    }

    public int getHandsHit() {
        return HANDS_HIT;
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

    public int getMentality() {
        return mentality;
    }

    public void setMentality(int mentality) {
        this.mentality = mentality;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("strength=");
        builder.append(strength);
        builder.append(", defence=");
        builder.append(defence);
        builder.append(", agility=");
        builder.append(agility);
        builder.append(", durability=");
        builder.append(durability);
        builder.append(", mentality=");
        builder.append(mentality);
        builder.append(", weapons=");
        builder.append(weapons);
        return builder.toString();
    }

}
