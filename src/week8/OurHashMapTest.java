package week8;

public class OurHashMapTest {

    public static void main(String[] args) {

        OurHashMap<String, Integer> map = new OurHashMap<>();
        
        for (int i = 0; i < 20; i++) {
            map.put("" + i, i);
        }


        System.out.println("Size - " + map.size());

        System.out.println(map);

    }

}