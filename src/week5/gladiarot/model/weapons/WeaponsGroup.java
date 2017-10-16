package week5.gladiarot.model.weapons;

import week5.gladiarot.controller.Random;
import week5.gladiarot.model.weapons.Weapon.WeaponBuilder;

public final class WeaponsGroup {

    private static Weapon[] weapons = new Weapon[10];
    private static int sizeWeapon = 0;

    public static void initialization() {
        WeaponBuilder builder = new WeaponBuilder();
        builder.setName("Axic");
        builder.setAttack(10);
        add(builder.build());
        add(null);
        builder.setName("Dagger");
        builder.setAttack(4);
        builder.setAgility(1);
        add(builder.build());
        builder.setName("Sword");
        builder.setAttack(7);
        builder.setAgility(2);
        add(builder.build());
    }

    public static Weapon getWeapon() {
        return weapons[Random.getRandom(sizeWeapon)];
    }

    public static void add(Weapon weapon) {
        if (weapons.length <= sizeWeapon) {
            copyGroup();
        }
        weapons[sizeWeapon++] = weapon;
    }

    private static void copyGroup() {
        Weapon[] newGroup = new Weapon[weapons.length * 2];
        System.arraycopy(weapons, 0, newGroup, 0, weapons.length);
        weapons = newGroup;
    }
    
    public static String getAllWeapons() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sizeWeapon; i++) {
            builder.append(weapons[i]);
            builder.append("\n");
        }
        return builder.toString();
    }

}
