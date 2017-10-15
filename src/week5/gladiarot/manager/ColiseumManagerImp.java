package week5.gladiarot.manager;

import week5.gladiarot.controller.Battle;
import week5.gladiarot.controller.IO;
import week5.gladiarot.controller.MyScanner;
import week5.gladiarot.model.gladiators.Gladiator;

public final class ColiseumManagerImp implements ColiseumManager {

    private Battle battle;
    private MyScanner scanner = new IO();

    public Battle getBattle() {
        return battle;
    }

    @Override
    public void showMenu() {
        // TODO Auto-generated method stub

    }

    @Override
    public void startBattle() {
        battle = new Battle(new Gladiator("Veles", 1, 1, 1, 1, 1, null), new Gladiator("Gallus", 1, 1, 1, 1, 1, null));
        scanner.write(battle.fight());
    }

    @Override
    public void addWeapon() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addGladiator() {
        // TODO Auto-generated method stub

    }

    @Override
    public void showWeapons() {
        // TODO Auto-generated method stub

    }

    @Override
    public void showGladiators() {
        // TODO Auto-generated method stub

    }

}
