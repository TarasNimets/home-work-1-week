package week5.gladiarot.model.weapons;

public final class Weapon {

    private static int WEAPON_ID = 1;
    
    private String name;
    private int attack;
    private int strength;
    private int defense;
    private int agility;
    private int id;

    public Weapon(String name, int attack, int strength, int defense, int agility) {
        this.name = name;
        this.attack = attack;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.id = WEAPON_ID++;
    }

    public int getAttack() {
        return attack;
    }
    
    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    public int getAgility() {
        return agility;
    }
    
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(" [ attack=");
        builder.append(attack);
        if (strength != 0) {
            builder.append(", strength=");
            builder.append(strength);
        }
        if (defense != 0) {
            builder.append(", defense=");
            builder.append(defense);
        }
        if (agility != 0) {
            builder.append(", agility=");
            builder.append(agility);
        }
        builder.append(" ]");
        return builder.toString();
    }

    public static class WeaponBuilder {

        private String name;
        private int attack;
        private int strength;
        private int defense;
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

        public WeaponBuilder setDefense(int defense) {
            this.defense = defense;
            return this;
        }

        public WeaponBuilder setAgility(int agility) {
            this.agility = agility;
            return this;
        }

        public Weapon build() {
            return new Weapon(name, attack, strength, defense, agility);
        }

    }

}
