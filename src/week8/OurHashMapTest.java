package week8;

public class OurHashMapTest {

    public static void main(String[] args) {

        OurHashMap<String, Integer> map = new OurHashMap<>();
        map.put("" + 12, 0);
        for (int i = 0; i < 2; i++) {
            map.put("" + 1, i);
        }
        map.put("" + 12, 12);
        map.put("" + 1, 13);
        map.put("" + 12, 14);
        for (int i = 0; i < 1000; i++) {
            map.put("" + i, i);
        }


//        System.out.println("Size - " + map.size());

        System.out.println(map);
        
//        HashMap<String, Integer> hashMap = new HashMap<>();
//
//        hashMap.put("" + 12, 0);
//        for (int i = 0; i < 2; i++) {
//            hashMap.put("" + 1, i);
//        }
//        hashMap.put("" + 12, 12);
//        hashMap.put("" + 1, 13);
//        hashMap.put("" + 12, 14);
//        for (int i = 0; i < 1000; i++) {
//            hashMap.put("" + i, i);
//        }
//        
//        System.out.println(hashMap.size());
//
//        System.out.println(hashMap);
    }

}