package week8.linkedlist;

public class Run {

    public static void main(String[] args) {

        OurLinkedList<Integer> list = new OurLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list);
        System.out.println("get - " + list.get(2));
        System.out.println("contains - " + list.contains(6));
        System.out.println("size - " + list.size());
        list.prepend(100);
        System.out.println(list);
        System.out.println("get after - " + list.get(2));
        list.add(87);
        System.out.println(list);
        list.remove(7);
        System.out.println(list);

    }

}