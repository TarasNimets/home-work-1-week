package week5.gladiarot.manager;

import week5.gladiarot.controller.Battle;
import week5.gladiarot.controller.IO;
import week5.gladiarot.controller.MyScanner;
import week5.gladiarot.model.gladiators.GladiatorsGroup;
import week5.gladiarot.model.weapons.Weapon.WeaponBuilder;
import week5.gladiarot.model.weapons.WeaponsGroup;

public final class ColiseumManagerImp implements ColiseumManager {

    {
        GladiatorsGroup.initialization();
        WeaponsGroup.initialization();
    }
    
    private Battle battle;
    private MyScanner scanner = new IO();

    public Battle getBattle() {
        return battle;
    }

    @Override
    public void showMenu() {
        scanner.write("\n1) START BATTLE");
        scanner.write("2) ADD GLADIATOR");
        scanner.write("3) ADD WEAPON");
        scanner.write("4) SHOW GLADIATORS");
        scanner.write("5) SHOW WEAPONS");
        scanner.write("6) EXIT");
        scanner.write("7) DEFAULT");
    }

    @Override
    public void startBattle() {
        battle = new Battle(GladiatorsGroup.getGladiator(1), GladiatorsGroup.getGladiator(2));
        scanner.write(battle.fight());
    }

    @Override
    public void addWeapon() {
        WeaponBuilder builder = new WeaponBuilder();
        builder.setName(scanner.readString("Enter weapon name"));
        builder.setAttack(scanner.readInt("Enter weapon attack"));
        builder.setStrength(scanner.readInt("Enter weapon strength"));
        builder.setDefense(scanner.readInt("Enter weapon defense"));
        builder.setAgility(scanner.readInt("Enter weapon agility"));
        WeaponsGroup.add(builder.build());
    }

    @Override
    public void addGladiator() {
        // TODO Auto-generated method stub

    }

    @Override
    public void showWeapons() {
        scanner.write(WeaponsGroup.getAllWeapons());
    }

    @Override
    public void showGladiators() {
        // TODO Auto-generated method stub

    }

}
