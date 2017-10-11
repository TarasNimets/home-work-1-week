package week5.myLoveGame.model.weapons;

public final class Dagger extends Weapon {

    public Dagger(int attack) {
        this.attack = attack;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Dagger [attack=");
        builder.append(attack);
        builder.append("]");
        return builder.toString();
    }

    
}
