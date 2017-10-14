package week5.gladiarot.controller;

public final class Random {

    public static int getRandom(int number) {
        return (int) (Math.random() * number);
    }

    public static boolean chanceRandom(double number) {
        return (Math.random() * 100) > number ? false : true;
    }

//    public static void main(String[] args) {
//
//        for (int i = 0; i < 20; i++) {
//            System.out.print(getRandom(2) + " ");
//        }
//    }

}
