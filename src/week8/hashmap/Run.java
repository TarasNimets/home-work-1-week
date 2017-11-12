package week8.hashmap;

import java.util.HashMap;
import java.util.Iterator;

public class Run {

    public static void main(String[] args) {

        OurHashMap<String, Integer> map = new OurHashMap<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            map.put("" + i, i);
        }
        map.put("18", 28);
        System.out.println(map);
        System.out.println("size - " + map.size());
        System.out.println("remove - " + map.remove("0"));
        System.out.println("size - " + map.size());
        System.out.println(map);
        System.out.println("get value - " + map.get("11"));
        //
        int i = 0;
        Iterator<Entry<String, Integer>> iterator = map.iterator();
        while (iterator.hasNext()) {
            // System.out.println(iterator.next());
            iterator.next();
            i++;
        }
        System.out.println(i);

        System.out.println("containsKey - " + map.containsKey("8"));
        System.out.println("keySet - " + map.getKeySet());
        System.out.println("valueSet - " + map.getValueSet());
        System.out.println("is empty - " + map.isEmpty());

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