package week5.myLoveGame.model.gladiators;

public final class Gallus extends Gladiator{
    
    public Gallus(int strength, int agility, int defence, int durability, int mentality) {
        this.strength = strength;
        this.agility = agility;
        this.defence = defence * 2;
        this.durability = durability;
        this.mentality = mentality;
    }

}
