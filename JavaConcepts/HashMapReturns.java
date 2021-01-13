package JavaConcepts;

import java.util.HashMap;
import java.util.Map;

public class HashMapReturns {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        System.out.println(map.put("a", "1"));
        System.out.println(map.put("a", "11"));
        System.out.println(map.put("a", "1111"));

    }
}
