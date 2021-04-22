package JavaConcepts;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class HashMaps {
    public static void main(String[] args) {
        HashMaps.runTreeMapDemo();
    }

    // TreeMap Demo
    public static void runTreeMapDemo() {
        Map<String, String> map = new TreeMap<>();
        map.put("z", "z");
        map.put("f", "z");
        map.put("a", "z");

        System.out.println(Arrays.toString(map.keySet().toArray()));
    }
}
