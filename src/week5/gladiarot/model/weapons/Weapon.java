package week5.gladiarot.model.weapons;

public final class Weapon {

    private String name;
    private int attack;
    private int strength;
    private int defence;
    private int agility;

    public int getAttack() {
        return attack;
    }

    public Weapon(String name, int attack, int strength, int defence, int agility) {
        this.name = name;
        this.attack = attack;
        this.strength = strength;
        this.defence = defence;
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefence() {
        return defence;
    }

    public int getAgility() {
        return agility;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(", attack=");
        builder.append(attack);
        if (strength != 0) {
            builder.append(", strength=");
            builder.append(strength);
        }
        if (defence != 0) {
            builder.append(", defence=");
            builder.append(defence);
        }
        if (agility != 0) {
            builder.append(", agility=");
            builder.append(agility);
        }
        return builder.toString();
    }

    public static class WeaponBuilder {

        private String name;
        private int attack;
        private int strength;
        private int defence;
        private int agility;

        public WeaponBuilder() {

        }

        public WeaponBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public WeaponBuilder setAttack(int attack) {
            this.attack = attack;
            return this;
        }

        public WeaponBuilder setStrength(int strength) {
            this.strength = strength;
            return this;
        }

        public WeaponBuilder setDefence(int defence) {
            this.defence = defence;
            return this;
        }

        public WeaponBuilder setAgility(int agility) {
            this.agility = agility;
            return this;
        }

        public Weapon build() {
            return new Weapon(name, attack, strength, defence, agility);
        }

    }

}
