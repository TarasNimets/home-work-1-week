package week5.myLoveGame.model.weapons;

public final class Axic extends Weapon {

    private int strength;

    public Axic(int attack, int strength) {
        this.attack = attack;
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Axic [strength=");
        builder.append(strength);
        builder.append(", attack=");
        builder.append(attack);
        builder.append("]");
        return builder.toString();
    }

}
