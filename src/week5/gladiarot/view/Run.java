package week5.gladiarot.view;

import week5.gladiarot.controller.Coliseum;
import week5.gladiarot.controller.Menu;

public class Run {

    public static void main(String[] args) {

        Coliseum coliseum = Coliseum.getInstance();

        while (true) {
            
            coliseum.getColiseumManager().showMenu();
            
            Menu menu = Menu.getMenu(coliseum.getScanner().readInt("Choose your act"));

            switch (menu) {
            case START_BATTLE: {
                coliseum.getColiseumManager().startBattle();
                break;
            }
            case ADD_GLADIATOR: {
                break;
            }
            case ADD_WEAPON: {
                coliseum.getColiseumManager().addWeapon();
                break;
            }
            case SHOW_GLADIATORS: {
                break;
            }
            case SHOW_WEAPONS: {
                coliseum.getColiseumManager().showWeapons();
                break;
            }
            case EXIT: {
                coliseum.getScanner().write("Bye");
                return;
            }
            case DEFAULT: {
                coliseum.getScanner().write("Incorrect choose. Try again");
            }
            }
        }

    }

}
