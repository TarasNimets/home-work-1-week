package week5.gladiarot.controller;

public enum Menu {

    START_BATTLE,
    ADD_GLADIATOR, 
    ADD_WEAPON, 
    SHOW_GLADIATORS, 
    SHOW_WEAPONS, 
    EXIT, 
    DEFAULT;

    public static Menu getMenu(int number) {
        Menu[] values = Menu.values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].ordinal() == number - 1) {
                return values[i];
            }
        }
        return DEFAULT;
    }

}
