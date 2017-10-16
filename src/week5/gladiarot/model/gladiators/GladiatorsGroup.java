package week5.gladiarot.model.gladiators;

import week5.gladiarot.model.gladiators.Gladiator.GladiatorBuilder;

public final class GladiatorsGroup {
    
    private static Gladiator[] gladiators = new Gladiator[10];
    private static int sizeGladiator = 0;

    public static void initialization() {
        GladiatorBuilder builder = new GladiatorBuilder();
        builder.setName("Veles");
        builder.setStrength(1);
        builder.setAgility(1);
        builder.setDefense(1);
        builder.setDurability(1);
        builder.setRage(1);
        add(builder.build());
        builder.setName("Gallus");
        add(builder.build());
    }

    public static Gladiator getGladiator(int id) {
        for (int i = 0; i <= sizeGladiator; i++) {
            if (gladiators[i].getID() == id) return gladiators[i];
        }
        return null;
    }

    public static void add(Gladiator gladiator) {
        if (gladiators.length <= sizeGladiator) {
            copyGroup();
        }
        gladiators[sizeGladiator++] = gladiator;
    }

    private static void copyGroup() {
        Gladiator[] newGroup = new Gladiator[gladiators.length * 2];
        System.arraycopy(gladiators, 0, newGroup, 0, gladiators.length);
        gladiators = newGroup;
    }



}
