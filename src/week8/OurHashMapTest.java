package week8;

import java.util.HashMap;
import java.util.Iterator;

public class OurHashMapTest {

    public static void main(String[] args) {

        OurHashMap<String, Integer> map = new OurHashMap<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 350; i++) {
            map.put("" + i, i);
        }
//        map.put("18", 28);
         System.out.println(map);
         
//         System.out.println(map.remove("8"));
         System.out.println(map);
//         System.out.println(map);

//         System.out.println(map.get("999999"));
         
         
//        int i = 0;
//        Iterator<Entry<String, Integer>> iterator = map.iterator();
//        while (iterator.hasNext()) {
////            System.out.println(iterator.next());
//            iterator.next();
//            i++;
//        }
//        System.out.println(i);
        
//        System.out.println(map.containsKey("98"));
        
//        System.out.println(map.getKeySet());

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