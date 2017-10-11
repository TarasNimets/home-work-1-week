package week5.myLoveGame.model.gladiators;

public final class Veles extends Gladiator {

    public Veles(int strength, int agility, int defence, int durability, int mentality) {
        this.strength = strength;
        this.agility = agility * 2; //bonus to type gladiator
        this.defence = defence;
        this.durability = durability;
        this.mentality = mentality;
    }

}
