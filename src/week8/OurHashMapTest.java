package week8;

import java.util.HashMap;
import java.util.Iterator;

public class OurHashMapTest {

    public static void main(String[] args) {

        OurHashMap<String, Integer> map = new OurHashMap<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put("" + i, i);
        }
        // System.out.println(map);
        int i = 0;
        Iterator<Entry<String, Integer>> iterator = map.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
//            iterator.next();
            i++;
        }
        System.out.println(i);

        // long startMy = System.nanoTime();
        // for (int i = 0; i < 2_000_000; i++) {
        // map.put("" + i, i);
        // }
        // long endMy = System.nanoTime();
        //
        // long startHash = System.nanoTime();
        // for (int i = 0; i < 2_000_000; i++) {
        // hashMap.put("" + i, i);
        // }
        // long endHash = System.nanoTime();
        //
        // System.out.println("My map - " + (endMy - startMy) / 1_000_000_000.0);
        // System.out.println("HashMap - " + (endHash - startHash) / 1_000_000_000.0);
    }

}